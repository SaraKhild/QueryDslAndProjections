package com.example.querydsl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.querydsl.models.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer>, IDepartmentRepositoryCustom {

}
