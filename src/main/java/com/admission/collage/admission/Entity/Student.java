package com.admission.collage.admission.Entity;


import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Student {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long stdId;
	private String stdName;
	private Date DOB;
	private String gender;
	private String religion;
	private String nationality;
	private long mobileNo;
	private String address;
	private String district;
	private String state;
	private String city; 
	private long pincode;
	private String email;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long hscMarks;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long stdId, String stdName, long dOB, String gender, String religion, String nationality,
			long mobileNo, String address, String district, String state, String city, long pincode, String email,
			Long hscMarks, Date DOB) {
		super();
		this.stdId = stdId;
		this.stdName = stdName;
		this.DOB = DOB;
		this.gender = gender;
		this.religion = religion;
		this.nationality = nationality;
		this.mobileNo = mobileNo;
		this.address = address;
		this.district = district;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.email = email;
		this.hscMarks = hscMarks;
	}
	public long getStdId() {
		return stdId;
	}
	public void setStdId(long stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getHscMarks() {
		return hscMarks;
	}
	public void setHscMarks(Long hscMarks) {
		this.hscMarks = hscMarks;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", DOB=" + DOB + ", gender=" + gender
				+ ", religion=" + religion + ", nationality=" + nationality + ", mobileNo=" + mobileNo + ", address="
				+ address + ", district=" + district + ", state=" + state + ", city=" + city + ", pincode=" + pincode
				+ ", email=" + email + ", hscMarks=" + hscMarks + "]";
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "fk_dept_id")
	private Department department;
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}
