package com.example.querydsl.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.querydsl.Projections.EmployeeProjection;
import com.example.querydsl.models.Employee;
import com.example.querydsl.services.IEmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeServcie;

    @PostMapping("/create-employee")
    public void createEmployee(@RequestBody Employee employee) {
        this.employeeServcie.createEmployee(employee);
    }

    @GetMapping("/all-employee")
    public List<Employee> getAllEmployee() {
        return this.employeeServcie.getAllEmployee();
    }

    @GetMapping("/employee-by-id/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return this.employeeServcie.getEmployeeById(employeeId);
    }

    @GetMapping("/employee-by-name/{employeeName}")
    public Employee getEmployeeByName(@PathVariable String employeeName) {
        return this.employeeServcie.findByName(employeeName);
    }

    @GetMapping("/unique-jop-name")
    public List<String> getUniqueJobName() {
        return this.employeeServcie.getUniqueJobName();
    }

    @GetMapping("/employee-name-with-increased-salary")
    public List<EmployeeProjection> getEmployeeNameWithIncreasedSalary() {
        return this.employeeServcie.getEmployeeNameWithIncreasedSalary();

    }

    @GetMapping("/employee-not-belong-to-department/{departmentNo}")
    public List<Employee> getEmployeeNotBelongToDepartment(@PathVariable int departmentNo) {
        return this.employeeServcie.getEmployeeNotBelongToDepartment(departmentNo);
    }

    @GetMapping("/employee-who-joined-before/{year}")
    public List<Employee> getEmployeeWhoJoinedBefore(@PathVariable int year) {
        return this.employeeServcie.getEmployeeWhoJoinedBefore(year);
    }

    @GetMapping("/employee-with-department")
    public List<EmployeeProjection> getEmployeeWithDepartment() {
        return this.employeeServcie.getEmployeeWithDepartment();
    }

    @GetMapping("/employee-who-salary-is-greater-than-the-average-salary-of-all-employees")
    public List<EmployeeProjection> getEmployeeWhoSalaryIsGreaterThanTheAverageSalaryOfAllEmployees() {
        return this.employeeServcie.getEmployeeWhoSalaryIsGreaterThanTheAverageSalaryOfAllEmployees();
    }

    @GetMapping("employees-whose-under-manager-name/{managerName}")
    public List<Employee> getEmployeesWhoseUnderManagerName(@PathVariable String managerName) {
        return this.employeeServcie.getEmployeesWhoseUnderManagerName(managerName);
    }

}