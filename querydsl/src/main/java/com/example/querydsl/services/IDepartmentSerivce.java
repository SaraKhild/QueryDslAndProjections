package com.example.querydsl.services;

import java.util.List;

import com.example.querydsl.Projections.DepartmentProjection;
import com.example.querydsl.models.Department;

public interface IDepartmentSerivce {

    public void createDepartment(Department department);

    public List<Department> getAllDepartment();

    public Department getDepartmentById(int departmentId);

    public Department findByName(String departmentName);

    public List<DepartmentProjection> findAllDepartmentsThatIsNotIncludeThisDepartmentNo(int departmentNo);

    public List<Department> findAllDepartmentsThatEmployeesNotIncluded();

    public List<DepartmentProjection> findDepartmentsHaveAtLeastTwoEmployees();

}
