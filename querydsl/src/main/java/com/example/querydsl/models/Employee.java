package com.example.querydsl.models;

import java.sql.Date;

import com.example.querydsl.dtos.EmployeePostDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {

    @ManyToOne
    private Department department;
    @Id
    @Column
    private int employeeNo;
    @Column
    private String employeeName;
    @Column
    private String jopName;
    @Column
    private int managerId;
    @Column
    private Date hireDate;
    @Column
    private double salary;
    @Column
    private String city;

    public Employee() {
    }

    public Employee(EmployeePostDto post) {
        this.department = post.getDepartment() == null ? null : new Department(post.getDepartment());
        this.employeeName = post.getEmployeeName();
        this.employeeNo = post.getEmployeeNo();
        this.jopName = post.getJopName();
        this.managerId = post.getManagerId();
        this.hireDate = post.getHireDate();
        this.salary = post.getSalary();
        this.city = post.getCity();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(int employeeNo) {
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

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
