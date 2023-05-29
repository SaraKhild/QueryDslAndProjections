package com.example.querydsl.services;

import java.util.List;

import com.example.querydsl.Projections.EmployeeProjection;
import com.example.querydsl.models.Employee;

public interface IEmployeeService {

    public void createEmployee(Employee employee);

    public List<Employee> getAllEmployee();

    public Employee getEmployeeById(int employeeId);

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
