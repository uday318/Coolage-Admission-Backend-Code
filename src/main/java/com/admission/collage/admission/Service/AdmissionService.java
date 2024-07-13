package com.admission.collage.admission.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.admission.collage.admission.Entity.AdmissionForm;
import com.admission.collage.admission.Entity.Student;
import com.admission.collage.admission.Error.StudentNotFoundException;
import com.admission.collage.admission.Repository.AdmissionFormRepo;
import com.admission.collage.admission.Repository.StudentRepo;

@Service
public class AdmissionService   {
	
	@Autowired
	private AdmissionFormRepo admissionFromRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	//Save student data by admission form
	public AdmissionForm saveAdmissionData(AdmissionForm admissionForm) {
		
	 Student studentDb =studentRepo.save(admissionForm.getStudent());
	 admissionForm.setStudent(studentDb);
	 
	  return admissionFromRepo.save(admissionForm);
	}
	
	
	//get student data by its id
	public Student getStudentData(Long id) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Student> student = studentRepo.findById(id);
		
		if(!student.isPresent()) {
			throw new StudentNotFoundException("student Not Available");
		}
		return student.get();
	}
	
	
	//delete student by its id
	public void deleteStudentById(Long id) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		
          Optional<Student> student = studentRepo.findById(id);
		
		if(!student.isPresent()) {
			throw new StudentNotFoundException("student Not Available");
		}
		
		//First Delete admissionForm table because it is parent table of student table
		admissionFromRepo.deleteById(id);
		//then delete using studentRepo object then student record will be deleted
		studentRepo.deleteById(id);
	}

	
	//get all students from database 
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}
	
	
	//get Student count from database
	public long getStudentCount() {
		// TODO Auto-generated method stub
	 return studentRepo.count();
	}

	//check the student is exists or not
    public boolean checkIfStudentExists(Long studentId) {
        return studentRepo.existsById(studentId);
    
    }
    

	//delete all students from database
	 public void deleteAllStudents() {
	
	//First Delete admissionForm table because it is parent table of student table
		 admissionFromRepo.deleteAll();
	//then delete using studentRepo object then student record will be deleted
		 studentRepo.deleteAll();
	    }


	//get multiple students by Ids
        public Iterable<Student> getStudentsByIds(List<Long> studentsIds) {
            return studentRepo.findAllById(studentsIds);
        }




		public Page<Student> findStudentsByCity(String city, Pageable pageable) {
			// TODO Auto-generated method stub
			  return studentRepo.findByCityOrCity(city,city,pageable);
		}

	
}
