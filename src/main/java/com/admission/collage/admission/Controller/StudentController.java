package com.admission.collage.admission.Controller;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admission.collage.admission.Entity.Student;
import com.admission.collage.admission.Service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	  @GetMapping("/all")
	    public ResponseEntity<Page<Student>> getAllStudents(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "50") int size) {

	        Page<Student> students = studentService.getAllStudentsWithPagination(page, size);

	        return ResponseEntity.ok(students);
	    }
	  
	  
	  @GetMapping("/allById")
	    public ResponseEntity<Page<Student>> getAllStudentsById  (
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size) {

	        Page<Student> students = studentService.getAllStudentsSortedById(page, size);

	        return ResponseEntity.ok(students);
	    }
	  
	  @GetMapping("/marksLessThan")
	    public ResponseEntity<List<Student>> getStudentsByMarksLessThan(@RequestParam long hscMarks) {
	        List<Student> students = studentService.getByhscMarksLessThan(hscMarks);
	        return ResponseEntity.ok(students);
	    }
	  
	  

//	  @GetMapping("/marksGreatherThan")
//	    public ResponseEntity<List<Student>> getStudentsByMarksGreatherThan(@RequestParam long hscMarks) {
//	        List<Student> students = studentService.getByHscMarksGreatherThan(hscMarks);
//	        return ResponseEntity.ok(students);
//	    }

	  
	  
	  @GetMapping("/marksLessThanEqual")
	    public ResponseEntity<List<Student>> getStudentsByMarksLessThanEqual(@RequestParam long hscMarks) {
	        List<Student> students = studentService.getByhscMarksLessThan(hscMarks);
	        return ResponseEntity.ok(students);
	    }
	  
	  @GetMapping("/DOBAfter")
	    public ResponseEntity<List<Student>> getEventsByStartDateAfter(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date DOB) {
	        List<Student> events = studentService.findStudentsByDOBAfter(DOB);
	        return ResponseEntity.ok(events);
	    }
	 
	  @GetMapping("/byMarksIn")
	    public ResponseEntity<List<Student>> getStudentsByMarksIn(@RequestParam Collection<Integer> marks) {
	        List<Student> students = studentService.findStudentsByhscMarksIn(marks);
	        return ResponseEntity.ok(students);
	    }
	  
	  @GetMapping("/byMarksNotIn")
	    public ResponseEntity<List<Student>> getStudentsByMarksNotIn(@RequestParam Collection<Integer> marks) {
	        List<Student> students = studentService.findStudentsByhscMarksNotIn(marks);
	        return ResponseEntity.ok(students);
	    }
	  
	  
	  @GetMapping("/bystdNameIgnoreCase")
	    public ResponseEntity<List<Student>> getStudentsBystdNameIgnoreCase(@RequestParam String name) {
	        List<Student> students = studentService.findStudentsByFirstnameIgnoreCase(name);
	        return ResponseEntity.ok(students);
	    }
	  
	  

	    @GetMapping("/byHscMarksOrderByHscMarksAsc")
	    public ResponseEntity<List<Student>> getStudentsByHscMarksOrderByHscMarksAsc(@RequestParam long hscMarks) {
	        List<Student> students = studentService.findStudentsByHscMarksOrderByHscMarksAsc(hscMarks);
	        return ResponseEntity.ok(students);
	    }

	  
	  

	    @GetMapping("/byHscMarksOrderByHscMarksDesc")
	    public ResponseEntity<List<Student>> getStudentsByHscMarksOrderByHscMarksDesc(@RequestParam long hscMarks) {
	        List<Student> students = studentService.findStudentsByHscMarksOrderByHscMarksDesc(hscMarks);
	        return ResponseEntity.ok(students);
	    }

	  
	  @GetMapping("/BycityAndDistrict")
	  public ResponseEntity<List<Student>> findStudentsBycityAnddistrict(@RequestParam String city , @RequestParam String district) {
			List<Student> students = studentService.findStudentsBycityAnddistrict(city, district);
			return  ResponseEntity.ok(students);
	  }
	  
	  
	  @GetMapping("/BycityOrDistrict")
	  public ResponseEntity<List<Student>> findStudentsBycityOrdistrict(@RequestParam String city , @RequestParam String district) {
			List<Student> students = studentService.findStudentsBycityOrdistrict(city, district);
			return  ResponseEntity.ok(students);
	  }
	  
	  
	  @GetMapping("/ByHscMarksBetween")
	  public ResponseEntity<List<Student>> findStudentsByHscMarksBetween(@RequestParam long min, @RequestParam long max){
		  
		  List<Student> students = studentService.findStudentsByHscMarksBetween(min,max);
		  return ResponseEntity.ok(students);
	  }
	  
	  
	  @GetMapping("/DistinctByCityAndDistrict")
	  public ResponseEntity<List<Student>>  findDistinctStudentsByCityAndDistrict (@RequestParam String city , @RequestParam String district)  {
		  List<Student> students = studentService.findDistinctStudentsByCityAndDistrict(city, district);
		  
		  return ResponseEntity.ok(students);
	  }
	  
	  
	  //name start with
	  
	   @GetMapping("/bynameStartingWith")
	    public ResponseEntity<List<Student>> getStudentsByNameStartingWith(@RequestParam String start) {
	        List<Student> students = studentService.getStudentsByNameStartingWith(start);
	        return ResponseEntity.ok(students);
	    }
	   
	   //name end with 
	   
	   @GetMapping("/bynameEndingWith")
	    public ResponseEntity<List<Student>> getStudentsByNameEndingWith(@RequestParam String end) {
	        List<Student> students = studentService.findStudentsByNameEndingWith(end);
	        return ResponseEntity.ok(students);
	    }
	   
	   

	    @GetMapping("/nullMarks")
	    public ResponseEntity<List<Student>> getStudentsWithNullHscMarks() {
	        List<Student> students = studentService.findStudentsWithNullHscMarks();
	        return ResponseEntity.ok(students);
	    }

	    @GetMapping("/nonNullMarks")
	    public ResponseEntity<List<Student>> getStudentsWithNonNullHscMarks() {
	        List<Student> students = studentService.findStudentsWithNonNullHscMarks();
	        return ResponseEntity.ok(students);
	    }
	    
	    
	    @GetMapping("/byStdNameContaining")
	    public ResponseEntity<List<Student>> getStudentsByStdNameContaining(@RequestParam String substring) {
	        List<Student> students = studentService.findStudentsByStdNameContaining(substring);
	        return ResponseEntity.ok(students);
	    }
	  
}
