package com.omkar.jobtracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.omkar.jobtracker.dto.ApiResponse;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<Map<String, String>>> handleValidationErrors(
	        MethodArgumentNotValidException ex) {

	    Map<String, String> errors = new HashMap<>();

	    ex.getBindingResult()
	      .getFieldErrors()
	      .forEach(error ->
	          errors.put(error.getField(), error.getDefaultMessage())
	      );

	    ApiResponse<Map<String, String>> response = new ApiResponse<>(
	            false,
	            "Validation failed",
	            errors
	    );

	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleGenericException(
            Exception ex) {

        ApiResponse<Object> response = new ApiResponse<>(
                false,
                "Something went wrong",
                null
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
