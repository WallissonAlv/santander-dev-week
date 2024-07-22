package me.project.santander_dev_week_2024_v20.resources.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import me.project.santander_dev_week_2024_v20.services.exceptions.BusinessException;
import me.project.santander_dev_week_2024_v20.services.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<String> handlerBusinessException(BusinessException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handlerResourceNotFound(){
		return new ResponseEntity<>("Resource not found.", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handlerInternalError(Throwable e){
		String message = "Unexpected server error.";
		LOGGER.error(message, e);
		return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
