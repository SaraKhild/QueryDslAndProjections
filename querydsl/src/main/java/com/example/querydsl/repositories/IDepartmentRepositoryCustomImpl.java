package com.example.querydsl.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.querydsl.Projections.DepartmentProjection;
import com.example.querydsl.models.Department;
import com.example.querydsl.models.QDepartment;
import com.example.querydsl.models.QEmployee;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class IDepartmentRepositoryCustomImpl implements IDepartmentRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Department findByName(String departmentName) {

        var entityPath = QDepartment.department;
        var query = new JPAQuery<>(this.entityManager);
        var result = query.select(entityPath).from(entityPath).where(entityPath.departmentName.eq(departmentName))
                .fetchOne();

        return result;

    }

    @Override
    public List<DepartmentProjection> findAllDepartmentsThatIsNotIncludeThisDepartmentNo(int departmentNo) {
        var entityPath = QDepartment.department;
        var query = new JPAQuery<>(this.entityManager);
        var result = query
                .select(Projections.bean(DepartmentProjection.class, entityPath.departmentNo.as("departmentNo"),
                        entityPath.departmentName.as("departmentName")))
                .where(entityPath.departmentNo.notIn(departmentNo)).from(entityPath).fetch();

        return result;

    }

    @Override
    public List<Department> findAllDepartmentsThatEmployeesNotIncluded() {
        var departmentEntityPath = QDepartment.department;
        var employeeEntityPath = QEmployee.employee;
        var query = new JPAQuery<>(this.entityManager);
        var subQuery = query.select(employeeEntityPath.department.departmentNo).from(employeeEntityPath).fetch();
        var result = query.select(departmentEntityPath).from(departmentEntityPath)
                .where(departmentEntityPath.departmentNo.notIn(subQuery)).fetch();

        return result;
    }

    @Override
    public List<DepartmentProjection> findDepartmentsHaveAtLeastTwoEmployees() {
        var entityPath = QDepartment.department;
        var employeeEntityPath = QEmployee.employee;
        var query = new JPAQuery<>(this.entityManager);
        var result = query
                .select(Projections.bean(DepartmentProjection.class, entityPath.departmentName.as("departmentName")))
                .from(entityPath, employeeEntityPath)
                .where(entityPath.departmentNo.eq(employeeEntityPath.department.departmentNo))
                .groupBy(entityPath.departmentName)
                .having(entityPath.count().goe(2))
                .fetch();

        return result;
    }

}
