package com.tacoloco.controller.error;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 * @author Heikel Khaldi
 */
@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MenuListServiceItemNotFoundException.class)
   
    public ResponseEntity<ErrorDetails> customHandleNotFound(Exception ex, WebRequest request) {

        ErrorDetails errors = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),HttpStatus.NOT_FOUND.value());
   
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

    }
}
