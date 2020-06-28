package br.edu.logatti.projetoP2.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity resourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        return handleExceptionInternal(exception, exception.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
