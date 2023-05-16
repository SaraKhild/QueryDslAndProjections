package com.example.querydsl.repositories;

import java.util.List;

import com.example.querydsl.Projections.DepartmentProjection;
import com.example.querydsl.models.Department;

public interface IDepartmentRepositoryCustom {

    public Department findByName(String departmentName);

    public List<DepartmentProjection> findAllDepartmentsThatIsNotIncludeThisDepartmentNo(int departmentNo);

    public List<Department> findAllDepartmentsThatEmployeesNotIncluded();

    public List<DepartmentProjection> findDepartmentsHaveAtLeastTwoEmployees();

}
