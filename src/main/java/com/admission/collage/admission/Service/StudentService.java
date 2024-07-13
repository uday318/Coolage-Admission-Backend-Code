package com.admission.collage.admission.Service;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.admission.collage.admission.Entity.Student;
import com.admission.collage.admission.Repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	public Page<Student> getAllStudentsWithPagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return studentRepo.findAll(pageable);
    }

	 public Page<Student> getAllStudentsSortedById(int page, int size) {
	        Pageable pageable = PageRequest.of(page, size, Sort.by("stdId").descending());           //sort the data in descending order
	        return studentRepo.findAll(pageable);
	    }
	
	
	public List<Student> getByhscMarksLessThan (long hscMarks){
		return studentRepo.findByHscMarksLessThan(hscMarks);
		
	}
	
	public List<Student> getByhscMarksLessThanEqual(long hscMarks){
		return studentRepo.findByHscMarksLessThanEqual(hscMarks);
		
	}
	
//	public List<Student> getByHscMarksGreatherThan(long hscMarks){
//		return studentRepo.findByHscMarksGreatherThan(hscMarks);
//		
//	}
	
	
	
	public List<Student> findStudentsByDOBAfter(Date DOB) {
        return studentRepo.findByDOBAfter(DOB);
    }

	public List<Student> findStudentsByhscMarksIn(Collection<Integer> marks) {
		return studentRepo.findByhscMarksIn(marks);
	}

	public List<Student> findStudentsByhscMarksNotIn(Collection<Integer> marks) {
		return studentRepo.findByhscMarksNotIn(marks);
	}
	
	public List<Student> findStudentsByFirstnameIgnoreCase(String name) {
        return studentRepo.findBystdNameIgnoreCase(name);
    }
	
	 public List<Student> findStudentsByHscMarksOrderByHscMarksAsc(long hscMarks) {
	        return studentRepo.findByHscMarksOrderByHscMarksAsc(hscMarks);
	    }
	
	 public List<Student> findStudentsByHscMarksOrderByHscMarksDesc(long hscMarks) {
	        return studentRepo.findByHscMarksOrderByHscMarksDesc(hscMarks);
	    }
	
	
	public List<Student> findStudentsBycityAnddistrict (String city,String district) {
		return studentRepo.findByCityAndDistrict(city,district);
	}
	
	public List<Student> findStudentsBycityOrdistrict (String city,String district) {
		return studentRepo.findByCityOrDistrict(city,district);
	}

	public List<Student> findStudentsByHscMarksBetween(long min, long max) {
		
		return studentRepo.findByHscMarksBetween(min, max);
	}
	
	
	public List<Student> findDistinctStudentsByCityAndDistrict(String city,String district) {
		return studentRepo.findDistinctByCityAndDistrict(city, district);
	}    

	public List<Student> getStudentsByNameStartingWith(String start) {
		return studentRepo.findByStdNameStartingWith(start);
	}
	
	public List<Student> findStudentsByNameEndingWith(String end) {
		return studentRepo.findByStdNameEndingWith(end);
	}
	
	
	

	    public List<Student> findStudentsWithNullHscMarks() {
	        return studentRepo.findByHscMarksIsNull();
	    }

	   
	    public List<Student> findStudentsWithNonNullHscMarks() {
	        return studentRepo.findByHscMarksIsNotNull();
	    }

		public List<Student> findStudentsByStdNameContaining(String substring) {
			return studentRepo.findByStdNameContaining(substring);
		}

}
