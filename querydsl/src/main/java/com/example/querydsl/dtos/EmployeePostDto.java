package com.example.querydsl.dtos;

import java.sql.Date;

public class EmployeePostDto {

    private Integer department;

    private Integer employeeNo;

    private String employeeName;

    private String jopName;

    private Integer managerId;

    private Date hireDate;

    private Double salary;

    private String city;

    public EmployeePostDto() {
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(Integer employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getJopName() {
        return jopName;
    }

    public void setJopName(String jopName) {
        this.jopName = jopName;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
