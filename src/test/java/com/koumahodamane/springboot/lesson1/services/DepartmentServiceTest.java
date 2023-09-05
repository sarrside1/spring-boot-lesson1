package com.koumahodamane.springboot.lesson1.services;

import static org.junit.jupiter.api.Assertions.*;

import com.koumahodamane.springboot.lesson1.entity.Department;
import com.koumahodamane.springboot.lesson1.repository.DepartmentRepository;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;





@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Dakar vdn")
                .departmentCode("IT-009")
                .build();
        Mockito.when(departmentRepository.findByDepartmentName("IT"))
                .thenReturn(Optional.ofNullable(department));
    }

    @Test
    @DisplayName("Get data based on valid department name")
    @Disabled
    void whenValidDepartmentName_ThenDepartmentShouldFounnd() {
        String departmentName = "IT";
        Department departmentFound = departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, departmentFound.getDepartmentName());
    }
}