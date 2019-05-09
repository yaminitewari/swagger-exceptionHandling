package com.global.rest.exception;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandling extends ResponseEntityExceptionHandler{
	  
	private final Environment env;
	
	 @Autowired
	    public CustomExceptionHandling(Environment env) {
	        this.env = env;
	    }
	
	@ExceptionHandler(DataNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleEmployeeNotFoundException(DataNotFoundException ex,WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(HttpStatus.NOT_FOUND);
		
		
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<APIEroorResponse> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
		 String errorCode = getErrorCode(ExceptionEnum.DATA_NOT_FOUND.getValue());
	     String errorMessage = getErrorMessage(ExceptionEnum.DATA_NOT_FOUND.getValue());
	     if(ex.getFieldName()==null) 
	     errorMessage = String.format(errorMessage,ex.getFieldName());
	        logger.error(errorMessage, ex);
	        APIEroorResponse response = new APIEroorResponse(errorCode, errorMessage);
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	private String getErrorMessage(final String keyValue) {
		return env.getProperty(keyValue + ".code");
	}

	private String getErrorCode(final String keyValue) {
		return env.getProperty(keyValue + ".message");		
	}

}
