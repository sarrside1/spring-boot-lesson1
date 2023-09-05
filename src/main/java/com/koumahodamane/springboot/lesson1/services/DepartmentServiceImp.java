package com.koumahodamane.springboot.lesson1.services;

import com.koumahodamane.springboot.lesson1.entity.Department;
import com.koumahodamane.springboot.lesson1.errors.DepartmentNotFoundException;
import com.koumahodamane.springboot.lesson1.repository.DepartmentRepository;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }
    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(id);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department with id " + id + " not found");
        }
        return department.get();
    }
    @Override
    public void removeDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }
    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Department departmentFound = departmentRepository.findById(id).get();
        if (Objects.nonNull(departmentFound.getDepartmentAddress()) && !"".equalsIgnoreCase(departmentFound.getDepartmentAddress())) {
            departmentFound.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(departmentFound.getDepartmentCode()) && !"".equalsIgnoreCase(departmentFound.getDepartmentCode())) {
            departmentFound.setDepartmentCode(department.getDepartmentCode());
        }
        if (Objects.nonNull(departmentFound.getDepartmentName()) && !"".equalsIgnoreCase(departmentFound.getDepartmentName())) {
            departmentFound.setDepartmentName(department.getDepartmentName());
        }
        return departmentRepository.save(departmentFound);
    }
    @Override
    public Department fetchDepartmentByName(String name) {
        return departmentRepository.findByDepartmentName(name).get();
    }
    
}
