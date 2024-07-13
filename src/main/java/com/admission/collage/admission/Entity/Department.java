package com.admission.collage.admission.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long deptId;
	private String deptName;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(long deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	
	}

	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}




	
	
}
