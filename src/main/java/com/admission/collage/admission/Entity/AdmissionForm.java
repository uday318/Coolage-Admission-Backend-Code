package com.admission.collage.admission.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "admission_form")
public class AdmissionForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long admId;

	public AdmissionForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdmissionForm(long admId) {
		super();
		this.admId = admId;
	}

	public long getAdmId() {
		return admId;
	}

	public void setAdmId(long admId) {
		this.admId = admId;
	}

	@Override
	public String toString() {
		return "AdmissionForm [admId=" + admId + "]";
	}
	
	@OneToOne()
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	@ManyToOne()
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	

}
