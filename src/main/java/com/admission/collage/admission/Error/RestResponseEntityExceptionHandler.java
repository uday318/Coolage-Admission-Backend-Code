package com.admission.collage.admission.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.admission.collage.admission.Entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(StudentNotFoundException.class)
//	public ResponseEntity<ErrorMessage> StudentNotFoundException(StudentNotFoundException exception,
//			WebRequest request) {
//
//		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
//
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
//	}
	
	
	@ExceptionHandler(DataValidationException.class)
	public ResponseEntity<ErrorMessage> handleDataValidationException(DataValidationException exception,
			WebRequest request)  {
		
		ErrorMessage message = new ErrorMessage(412, exception.getMessage());
		
		//GenericResponseEntity message = new GenericResponseEntity(400, exception.getMessage());
		
		return new  ResponseEntity<ErrorMessage>(message,HttpStatus.PRECONDITION_FAILED);
	}
	
}
