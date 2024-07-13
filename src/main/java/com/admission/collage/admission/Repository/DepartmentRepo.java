package com.admission.collage.admission.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Query;

import com.admission.collage.admission.Entity.Department;

public interface DepartmentRepo extends JpaRepository<Department , Long> {
	
	
	@Meta(comment = "select department using department name")
	@Query("select d from Department d where d.deptName = ?1 ")
	Department getDepartmentByName(String deptName);
	
	Boolean existsByDeptName(String deptName);

	Boolean existsByDeptId(Long deptId);
	
	Page<Department> findByDeptNameContainingIgnoreCase(String search,Pageable pageable);
}
