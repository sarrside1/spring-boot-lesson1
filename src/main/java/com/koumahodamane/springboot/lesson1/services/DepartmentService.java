package com.koumahodamane.springboot.lesson1.services;

import com.koumahodamane.springboot.lesson1.entity.Department;
import com.koumahodamane.springboot.lesson1.errors.DepartmentNotFoundException;
import java.util.List;


public interface DepartmentService {

    Department saveDepartment(Department department);
    List<Department> getDepartments();
    Department getDepartmentById(Long id) throws DepartmentNotFoundException;
    void removeDepartmentById(Long id);
    Department updateDepartmentById(Long id, Department department);
    Department fetchDepartmentByName(String name);
}
