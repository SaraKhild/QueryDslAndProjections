package com.example.querydsl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.querydsl.Projections.EmployeeProjection;
import com.example.querydsl.models.Employee;
import com.example.querydsl.repositories.IEmployeeRepository;

@Service
public class IEmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return this.employeeRepository.findById(employeeId).orElse(null);
    }

    @Override
    public Employee findByName(String employeeName) {
        return this.employeeRepository.findByName(employeeName);
    }

    @Override
    public List<String> getUniqueJobName() {
        return this.employeeRepository.getUniqueJobName();
    }

    @Override
    public List<EmployeeProjection> getEmployeeNameWithIncreasedSalary() {
        return this.employeeRepository.getEmployeeNameWithIncreasedSalary();
    }

    @Override
    public List<Employee> getEmployeeNotBelongToDepartment(int departmentNo) {
        return this.employeeRepository.getEmployeeNotBelongToDepartment(departmentNo);
    }

    @Override
    public List<Employee> getEmployeeWhoJoinedBefore(int year) {
        return this.employeeRepository.getEmployeeWhoJoinedBefore(year);
    }

    @Override
    public List<EmployeeProjection> getEmployeeWithDepartment() {
        return this.employeeRepository.getEmployeeWithDepartment();
    }

    @Override
    public List<EmployeeProjection> getEmployeeWhoSalaryIsGreaterThanTheAverageSalaryOfAllEmployees() {
        return this.employeeRepository.getEmployeeWhoSalaryIsGreaterThanTheAverageSalaryOfAllEmployees();
    }

    @Override
    public List<Employee> getEmployeesWhoseUnderManagerName(String managerName) {
        return this.employeeRepository.getEmployeesWhoseUnderManagerName(managerName);
    }

}
