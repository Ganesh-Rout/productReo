package com.restDemo.restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restDemo.restdemo.entity.Employee;

public interface RestDemoRepository extends JpaRepository<Employee, Long>{

}
