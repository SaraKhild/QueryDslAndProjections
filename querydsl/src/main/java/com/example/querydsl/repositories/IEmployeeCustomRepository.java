package com.example.querydsl.repositories;

import java.util.List;

import com.example.querydsl.Projections.EmployeeProjection;
import com.example.querydsl.models.Employee;

public interface IEmployeeCustomRepository {

    public Employee findByName(String employeeName);

    public List<String> getUniqueJobName();

    public List<EmployeeProjection> getEmployeeNameWithIncreasedSalary();

    public List<Employee> getEmployeeNotBelongToDepartment(int departmentNo);

    public List<Employee> getEmployeeWhoJoinedBefore(int year);

    public List<EmployeeProjection> getEmployeeWithDepartment();

    public List<EmployeeProjection> getEmployeeWhoSalaryIsGreaterThanTheAverageSalaryOfAllEmployees();

    public List<Employee> getEmployeesWhoseUnderManagerName(String managerName);

    public List<EmployeeProjection> countAllEmployeesUnderEachManager();

}
