package com.usuarios.error;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex){
        Map<String,String> errormap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->{
            errormap.put(error.getField(),error.getDefaultMessage());
        });
        return errormap;
    }
}
