package com.example.querydsl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.querydsl.Projections.DepartmentProjection;
import com.example.querydsl.models.Department;
import com.example.querydsl.repositories.IDepartmentRepository;

@Service
public class IDepartmentSerivceImpl implements IDepartmentSerivce {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public void createDepartment(Department department) {
        this.departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return this.departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        return this.departmentRepository.findById(departmentId).orElse(null);
    }

    @Override
    public Department findByName(String departmentName) {
        return this.departmentRepository.findByName(departmentName);
    }

    @Override
    public List<DepartmentProjection> findAllDepartmentsThatIsNotIncludeThisDepartmentNo(int departmentNo) {
        return this.departmentRepository.findAllDepartmentsThatIsNotIncludeThisDepartmentNo(departmentNo);
    }

    @Override
    public List<Department> findAllDepartmentsThatEmployeesNotIncluded() {
        return this.departmentRepository.findAllDepartmentsThatEmployeesNotIncluded();
    }

    @Override
    public List<DepartmentProjection> findDepartmentsHaveAtLeastTwoEmployees() {
        return this.departmentRepository.findDepartmentsHaveAtLeastTwoEmployees();
    }

}
