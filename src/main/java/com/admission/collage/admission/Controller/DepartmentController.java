package com.admission.collage.admission.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admission.collage.admission.Entity.Department;
import com.admission.collage.admission.Entity.GenericResponseEntity;
import com.admission.collage.admission.Error.DataValidationException;
import com.admission.collage.admission.Service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/addDepartment")
	public ResponseEntity<GenericResponseEntity> saveDepartment(@RequestBody Department department)
			throws DataValidationException {

		GenericResponseEntity response = departmentService.saveDepartment(department);
		return ResponseEntity.status(response.getCode()).body(response);

	}

	@DeleteMapping("/deleteDepartmentById/{id}")
	public ResponseEntity<GenericResponseEntity> deleteDepartmentById(@PathVariable Long id) {
		GenericResponseEntity response = departmentService.deleteDepartmentById(id);
		return ResponseEntity.status(response.getCode()).body(response);
	}

	@PutMapping("/updateDeptById/{deptId}")
	public ResponseEntity<GenericResponseEntity> updateDepartment(@PathVariable Long deptId,
			@RequestBody Department updatedDept) throws DataValidationException {
		GenericResponseEntity response = departmentService.updateDepartment(deptId, updatedDept);
		// return ResponseEntity.status(response.getCode()).body(response);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

	}

	// get Department By Id

	@GetMapping("/getDeptById/{deptId}")
	public Department getDepartmentById(@PathVariable Long deptId) {
		return departmentService.getDepartmentById(deptId);
	}

	// get All Department

	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments(Department department) {
		return departmentService.getAllDepartments();

	}

	// get All Departments By Pagination

	@GetMapping("/getAllDepartmentsByPage")
	public ResponseEntity<Page<Department>> getAllDepartmentsByPage(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "DESC") Direction direction,
			@RequestParam(required = false) String search) {

		Page<Department> department = departmentService.getAllDepartmentsByPage(page, size, direction, search);
		
		

		return ResponseEntity.ok(department);

	}
}
