package com.libbioproject.exception;

import com.libbioproject.exception.message.ApiResponseError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.naming.AuthenticationException;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;

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
    @ExceptionHandler(ConflictException.class)
    protected ResponseEntity<Object> handleConflictException(ConflictException ex,
                                                             WebRequest request){
        ApiResponseError err = new ApiResponseError(
                HttpStatus.CONFLICT, ex.getMessage(), request.getDescription(false)
        );

        return buildResponseEntity(err);
    }

    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex,
                                                             WebRequest request){
        ApiResponseError err = new ApiResponseError(
                HttpStatus.FORBIDDEN, ex.getMessage(), request.getDescription(false)
        );

        return buildResponseEntity(err);
    }

    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex,
                                                                 WebRequest request){
        ApiResponseError err = new ApiResponseError(
                HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false)
        );

        return buildResponseEntity(err);
    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        List<String> errors = ex.getBindingResult().getFieldErrors()
//                .stream().map(e->e.getDefaultMessage()).collect(Collectors.toList());
//
//        ApiResponseError err = new ApiResponseError(
//                HttpStatus.BAD_REQUEST, errors.get(0).toString(), );
//    }
    // handleMethodArgumentNotValid Bad req list.stream
    // handleTypeMismatch bad req
    // handleConversionNotSupported int serv err
    // handleHttpMessageNotReadable ``





















    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<Object> handleRunTimeException(RuntimeException ex, WebRequest request){

        ApiResponseError error = new ApiResponseError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                request.getDescription(false)
        );

        return buildResponseEntity(error);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleGeneralException(Exception ex, WebRequest request){

        ApiResponseError error = new ApiResponseError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                request.getDescription(false)
        );

        return buildResponseEntity(error);
    }


}
