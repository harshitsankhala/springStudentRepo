package com.cts.student;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.cts.student.model.ExceptionResponse;
import com.cts.student.service.exception.StudentNotFoundException;
/**
 * 
 * @author Harshit
 * @see ExceptionResponse
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ExceptionResponse> invalidTokenException(StudentNotFoundException studentNotFoundException) {
		return new ResponseEntity<>(
				new ExceptionResponse(studentNotFoundException.getMessage(), LocalDateTime.now(), HttpStatus.NOT_FOUND),
				HttpStatus.NOT_FOUND);
	}
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());

        // Get all validation errors
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        // Add errors to the response map        
        body.put("errors", errors);

        return new ResponseEntity<>(body, headers, status);

    }

}