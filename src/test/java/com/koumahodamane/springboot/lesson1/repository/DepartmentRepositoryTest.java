package com.koumahodamane.springboot.lesson1.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.koumahodamane.springboot.lesson1.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;



@DataJpaTest
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp(){
        Department department = Department.builder()
            .departmentAddress("Dakar est")
            .departmentCode("RH-09")
            .departmentName("Human resources")
            .build();
        entityManager.persist(department);
    }
    @Test
    void whenFindById_thenReturnDepartment() {
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Human resources");
    }
}
