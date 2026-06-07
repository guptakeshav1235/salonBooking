package com.keshav.config;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.keshav.payload.response.exceptionResponse;

@ControllerAdvice
public class globalExceptionHandler {

        @ExceptionHandler(Exception.class)
        public ResponseEntity<exceptionResponse> exceptionHandler(Exception ex,WebRequest req) {
            exceptionResponse response = new exceptionResponse(
                ex.getMessage(),
                req.getDescription(false),LocalDateTime.now()
            );
            return ResponseEntity.ok(response);
        }

}
