package com.admission.collage.admission.Repository;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.admission.collage.admission.Entity.Student;

public interface StudentRepo extends JpaRepository<Student , Long> {
	
	Page<Student> findAll(Pageable pageable);

	Page<Student> findByCity(String city,Pageable pageable);


	Page<Student> findByCityOrCity(String city, String city2, Pageable pageable);

	
	
	
	List<Student> findByHscMarksLessThan(Long hscMarks);

	List<Student> findByHscMarksLessThanEqual(Long hscMarks);

//	List<Student> findByHscMarksGreatherThan(Long hscMarks);
	
	
	List<Student> findByDOBAfter(Date DOB);

	List<Student> findByhscMarksIn(Collection<Integer> marks);
	
	List<Student> findByhscMarksNotIn(Collection<Integer> marks);


		List<Student> findBystdNameIgnoreCase(String name);
	
	
        List<Student> findByHscMarksOrderByHscMarksAsc(Long hscMark);
    
  
        List<Student> findByHscMarksOrderByHscMarksDesc(Long hscMarks);
        
    	
       List<Student> findByCityAndDistrict(String city,String district);
       
       List<Student> findByCityOrDistrict(String city,String district);
       
       
       List<Student> findByHscMarksBetween(Long min , Long max);
       
       
       List<Student> findDistinctByCityAndDistrict(String city , String district);
       
       
       List<Student> findByStdNameStartingWith(String start);
       
       List<Student> findByStdNameEndingWith(String end);
       
       
       List<Student> findByHscMarksIsNull();
       
       
       List<Student> findByHscMarksIsNotNull();
       
       
       
       List<Student> findByStdNameContaining(String substring);
       
}
