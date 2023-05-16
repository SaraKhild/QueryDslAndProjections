package com.example.querydsl.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.querydsl.Projections.EmployeeProjection;
import com.example.querydsl.models.Employee;
import com.example.querydsl.models.QDepartment;
import com.example.querydsl.models.QEmployee;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class IEmployeeCustomRepositoryImpl implements IEmployeeCustomRepository {

        @PersistenceContext
        private EntityManager entityManager;

        @Override
        public Employee findByName(String employeeName) {
                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var result = query.select(entityPath).from(entityPath).where(entityPath.employeeName.eq(employeeName))
                                .fetchOne();
                return result;
        }

        @Override
        public List<String> getUniqueJobName() {
                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var result = query.select(entityPath.jopName).distinct().from(entityPath).fetch();
                return result;

        }

        @Override
        public List<EmployeeProjection> getEmployeeNameWithIncreasedSalary() {
                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var result = query
                                .select(Projections.bean(EmployeeProjection.class,
                                                entityPath.employeeName.as("employeeName"),
                                                entityPath.salary.multiply(Expressions.ONE.multiply(1.350))
                                                                .as("salary"))) // Increase 15%
                                .from(entityPath).fetch();
                // --------------------------another way----------------------------
                // var result = query.select(entityPath.employeeName,
                // entityPath.salary).from(entityPath)
                // .fetch().stream()
                // .map(x -> new EmployeeProjection(x.get(entityPath.employeeName),
                // x.get(entityPath.salary)))
                // .collect(Collectors.toList());

                return result;
        }

        @Override
        public List<Employee> getEmployeeNotBelongToDepartment(int departmentNo) {
                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var result = query.select(entityPath).from(entityPath)
                                .where(entityPath.department.departmentNo.notIn(departmentNo)).fetch();
                return result;
        }

        @Override
        public List<Employee> getEmployeeWhoJoinedBefore(int year) {

                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var result = query.select(entityPath).from(entityPath)
                                .where(entityPath.hireDate.year().lt(year)).fetch();
                return result;

        }

        @Override
        public List<EmployeeProjection> getEmployeeWithDepartment() {
                var employeeEntityPath = QEmployee.employee;
                var departmentEntityPath = QDepartment.department;
                var query = new JPAQuery<>(this.entityManager);

                var result = query
                                .select(Projections.bean(EmployeeProjection.class,
                                                employeeEntityPath.employeeNo.as("employeeNo"),
                                                employeeEntityPath.employeeName.as("employeeName"),
                                                departmentEntityPath.departmentNo.as("departmentNo"),
                                                departmentEntityPath.departmentName.as("departmentName")))
                                .innerJoin(departmentEntityPath)
                                .on(employeeEntityPath.department.departmentNo.eq(departmentEntityPath.departmentNo));

                return result.fetch();
        }

        @Override
        public List<EmployeeProjection> getEmployeeWhoSalaryIsGreaterThanTheAverageSalaryOfAllEmployees() {
                var entityPath = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);
                var subQuery = query.select(entityPath.salary.avg()).from(entityPath).fetchOne();
                System.out.println("+++++++++++++++++++++++++++++++++" + subQuery);
                var result = query
                                .select(Projections.bean(EmployeeProjection.class,
                                                entityPath.employeeName.as("employeeName"),
                                                entityPath.jopName.as("jopName"), entityPath.salary.as("salary")))
                                .from(entityPath).where(entityPath.salary.gt(subQuery)).fetch();

                return result;
        }

        @Override
        public List<Employee> getEmployeesWhoseUnderManagerName(String managerName) {
                var entityPathManager = QEmployee.employee;
                var entityPathEmployee = QEmployee.employee;
                var query = new JPAQuery<>(this.entityManager);

                var subQuery = query.select(entityPathManager.employeeNo).from(entityPathManager)
                                .where(entityPathManager.employeeName.like("%" + managerName + "%")).fetchOne();

                var result = query.select(entityPathEmployee).from(entityPathEmployee)
                                .where(entityPathEmployee.managerId.eq(subQuery));

                // --------------------------another way----------------------------
                // var result = query.select(entityPathEmployee)
                // .from(entityPathEmployee,entityPathManager)
                // .where(entityPathEmployee.managerId.eq(entityPathManager.employeeNo)
                // .and(entityPathManager.employeeName.eq(managerName)));

                return result.fetch();
        }

}
