package com.admission.collage.admission.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.admission.collage.admission.Entity.Department;
import com.admission.collage.admission.Entity.GenericResponseEntity;
import com.admission.collage.admission.Error.DataValidationException;
import com.admission.collage.admission.Repository.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	// Save Department
	public GenericResponseEntity saveDepartment(Department department) {

		// if department name will passed null
		if (department.getDeptName() == null) { 
			throw new DataValidationException("department name cannot be null");
		}
		// if department name will pass empty and white spaces

		if (department.getDeptName().isBlank()) {
			throw new DataValidationException("department name not empty or contain white spaces");
		}

		if (department.getDeptName().isEmpty()) {
			throw new DataValidationException("department name not empty");
		}

		if (department.getDeptName().startsWith(" ")) {
			throw new DataValidationException("department name not starts with white space ");
		}

		if (department.getDeptName().endsWith(" ")) {
			throw new DataValidationException("department name not ends with white space ");
		}

		// if department name already present in table with ignore case
		if (departmentRepo.existsByDeptName(department.getDeptName())) {
			throw new DataValidationException("department name already present ");
		}

		departmentRepo.save(department);

		return new GenericResponseEntity(200, "Department save successfully");
	}

	// delete department by id
	public GenericResponseEntity deleteDepartmentById(Long deptId) {

		Optional<Department> dept = departmentRepo.findById(deptId);

		if (!dept.isPresent()) {
			throw new DataValidationException("Department Not Found");
		}

		Department department = dept.get();
		departmentRepo.delete(department);

		return new GenericResponseEntity(200, "Department Deleted successfully");

	}

	// update department by id
	public GenericResponseEntity updateDepartment(Long deptId, Department updatedDept) {

		Optional<Department> dept = departmentRepo.findById(deptId);

		if (!dept.isPresent()) {
			throw new DataValidationException("Department not Available");
		}
		Department department = dept.get();

		department.setDeptName(updatedDept.getDeptName());

		if (!department.getDeptName().equals(updatedDept.getDeptName())) {

			if (departmentRepo.existsByDeptName(department.getDeptName())) {
				throw new DataValidationException("Department name already exists");
			}

		}
		departmentRepo.save(department);
		return new GenericResponseEntity(202, "Department save successfully");

	}

	// get Department by Id
	public Department getDepartmentById(Long deptId) {

		Optional<Department> department = departmentRepo.findById(deptId);

		if (!department.isPresent()) {
			throw new DataValidationException("Department Not Available");
		}
		return department.get();
	}

	// get All Departments
	public List<Department> getAllDepartments() {
		return departmentRepo.findAll();
	}

	// get all departments by pagination
	public Page<Department> getAllDepartmentsByPage(int page, int size, Direction direction, String search) {

		//Page<Department> departments = null;

		Pageable pageable = PageRequest.of(page, size, direction, "deptId");

		if (search != null && !search.isBlank()) {
			return departmentRepo.findByDeptNameContainingIgnoreCase(search, pageable);
		}
		
		return departmentRepo.findAll(pageable);
	}
}
