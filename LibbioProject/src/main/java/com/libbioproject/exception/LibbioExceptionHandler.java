package com.libbioproject.exception;

import com.libbioproject.exception.message.ApiResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // with this annotation and the class we extend below we introduce this class to Spring Boot
/**
 *  to create a custom exception handling system
 */
public class LibbioExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiResponseError error){
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex,
                                                                     WebRequest request){
        ApiResponseError error = new ApiResponseError(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                request.getDescription(false));
        return buildResponseEntity(error);
    }


}
