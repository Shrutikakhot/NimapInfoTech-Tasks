package com.example.demo.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleExceptions(UserNotFoundException unfe)
	{
		UserErrorResponse uer=new UserErrorResponse();
		uer.setStatus(HttpStatus.NOT_FOUND.value());
		uer.setMessage(unfe.getMessage());
		uer.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(uer,HttpStatus.NOT_FOUND);
		
		
	}
	
}
