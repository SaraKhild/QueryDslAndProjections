package com.example.querydsl.models;

import com.example.querydsl.dtos.DepartmentPostDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Department {

    @Id
    @Column
    private int departmentNo;
    @Column
    private String departmentName;
    @Column
    private String location;

    public Department(int id) {
        this.departmentNo = id;
    }

    public Department(DepartmentPostDto post) {
        this.departmentNo = post.getDepartmentNo();
        this.departmentName = post.getDepartmentName();
        this.location = post.getLocation();
    }

    public Department() {
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(int departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
