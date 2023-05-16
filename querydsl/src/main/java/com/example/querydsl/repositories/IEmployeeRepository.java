package com.example.querydsl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.querydsl.models.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>, IEmployeeCustomRepository {

}
