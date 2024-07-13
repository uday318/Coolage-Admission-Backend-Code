package com.admission.collage.admission.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admission.collage.admission.Entity.AdmissionForm;

public interface AdmissionFormRepo extends JpaRepository<AdmissionForm, Long>{ 
	
}
