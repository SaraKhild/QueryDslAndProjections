package com.example.querydsl.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.querydsl.Projections.DepartmentProjection;
import com.example.querydsl.models.Department;
import com.example.querydsl.services.IDepartmentSerivce;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private IDepartmentSerivce departmentSerivce;

    @PostMapping("/create-department")
    public void createDepartment(@RequestBody Department department) {
        this.departmentSerivce.createDepartment(department);
    }

    @GetMapping("/all-department")
    public List<Department> getAllDepartment() {
        return this.departmentSerivce.getAllDepartment();
    }

    @GetMapping("/department-by-id/{departmentId}")
    public Department getDepartmentById(@PathVariable int departmentId) {
        return this.departmentSerivce.getDepartmentById(departmentId);
    }

    @GetMapping("/department-by-name/{departmentName}")
    public Department getDepartmentByName(@PathVariable String departmentName) {
        return this.departmentSerivce.findByName(departmentName);
    }

    @GetMapping("/departments-that-is-not-include-this-department-number/{departmentNo}")
    public List<DepartmentProjection> findAllDepartmentsThatIsNotIncludeThisDepartmentNo(
            @PathVariable int departmentNo) {
        return this.departmentSerivce.findAllDepartmentsThatIsNotIncludeThisDepartmentNo(departmentNo);
    }

    @GetMapping("/departments-that-employees-not-included")
    public List<Department> findAllDepartmentsThatEmployeesNotIncluded() {
        return this.departmentSerivce.findAllDepartmentsThatEmployeesNotIncluded();
    }

    @GetMapping("/departments-have-at-least-two-employees")
    public List<DepartmentProjection> findDepartmentsHaveAtLeastTwoEmployees() {
        return this.departmentSerivce.findDepartmentsHaveAtLeastTwoEmployees();
    }

}
