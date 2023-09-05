package com.koumahodamane.springboot.lesson1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.koumahodamane.springboot.lesson1.entity.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
    //@Query(value = "SELECT * FROM departments WHERE DEPARTMENT_NAME = ?1", nativeQuery = true)
    Optional<Department> findByDepartmentName(String departmentName);
}
