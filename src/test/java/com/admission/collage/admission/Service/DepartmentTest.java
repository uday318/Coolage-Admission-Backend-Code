package com.admission.collage.admission.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.admission.collage.admission.Entity.Department;
import com.admission.collage.admission.Repository.AdmissionFormRepo;
import com.admission.collage.admission.Repository.DepartmentRepo;

@SpringBootTest
public class DepartmentTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepo departmentRepo;
	
	@BeforeEach
	void setUp() {
	}
	

}
