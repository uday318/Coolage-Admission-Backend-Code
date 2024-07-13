package com.admission.collage.admission.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admission.collage.admission.Entity.AdmissionForm;
import com.admission.collage.admission.Entity.Student;
import com.admission.collage.admission.Error.StudentNotFoundException;
import com.admission.collage.admission.Service.AdmissionService;

@RestController
public class AdmissionController {
	
	@Autowired
	private AdmissionService admissionService;
	
	
	

	
	@PostMapping("/saveAdmission")
	public AdmissionForm saveAdmissionData(@RequestBody AdmissionForm admissionForm)  {
		return admissionService.saveAdmissionData(admissionForm);
		
	}
	
	
	@GetMapping("/getStudentByID/{id}")
	public Student getStudentData(@PathVariable Long id) throws StudentNotFoundException  {
		return admissionService.getStudentData(id);
	}
	
	@DeleteMapping("/deleteStudentById/{id}")
	public void deleteStudentById(@PathVariable Long id)throws StudentNotFoundException {
		admissionService.deleteStudentById(id);
	}
	

	@GetMapping("/getStudentsByIds/{ids}")
    public Iterable<Student> getStudentsByIds(@PathVariable List<Long> ids) {
        return admissionService.getStudentsByIds(ids);
    }
	
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudent(Student student)  {
		return admissionService.getAllStudent();
		
	}
	
	@GetMapping("/getStudentCount")
	public long getStudentCount() {
		return admissionService.getStudentCount();
		
	}
	
	@GetMapping("/checkStudent/{studentId}")
	public boolean checkIfStudentExists(@PathVariable Long studentId) {
		return admissionService.checkIfStudentExists(studentId);
	}
	
	
	@DeleteMapping("/deleteAll")
    public ResponseEntity<Void> deleteAllStudents() {
		admissionService.deleteAllStudents();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
	
	 
	 

    @GetMapping("/getStudentsByCity")
    public Page<Student> getStudentsByCity(
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
            ) {

        Pageable pageable = PageRequest.of(page, size);

        //Page<Student> students = 
        	return	admissionService.findStudentsByCity(city, pageable);
        
    }
}
