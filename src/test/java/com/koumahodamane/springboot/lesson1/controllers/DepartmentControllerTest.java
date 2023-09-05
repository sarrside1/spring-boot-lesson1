package com.koumahodamane.springboot.lesson1.controllers;

import com.koumahodamane.springboot.lesson1.entity.Department;
import com.koumahodamane.springboot.lesson1.services.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;













@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setup(){
        department = Department.builder()
            .departmentId(1L)
            .departmentAddress("Dakar est")
            .departmentCode("RH-09")
            .departmentName("Human resources")
            .build();
    }

    @Test
    void testSaveDepartment() throws Exception {
        Department outputDepartment = Department.builder()
            .departmentId(1L)
            .departmentAddress("Dakar est")
            .departmentCode("RH-09")
            .departmentName("Human resources")
            .build();
        
        Mockito.when(departmentService.saveDepartment(outputDepartment))
            .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
            "\t\"departmentName\": \"Human resources\",\n"+
            "\t\"departmentAddress\": \"Dakar est\",\n"+
            "\t\"departmentCode\": \"HR-09\"\n"+
            "}"
            )
        )
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    
    @Test
    void testGetDepartmentById() throws Exception {
        Mockito.when(departmentService.getDepartmentById(1L))
        .thenReturn(department);


        mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers
                    .jsonPath("$.departmentName")
                    .value(department.getDepartmentName())
        );
    }
}
