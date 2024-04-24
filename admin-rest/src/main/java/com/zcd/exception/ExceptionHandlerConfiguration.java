package com.zcd.exception;

import com.zcd.common.ApiResponse;
import io.micrometer.core.instrument.config.validate.ValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 23/4/24 4:09 pm
 */

@RestControllerAdvice
public class ExceptionHandlerConfiguration {

    @ExceptionHandler(ValidationException.class)
    public ApiResponse<Void> onValidationException(ValidationException e){
        return ApiResponse.failed(null,e.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Void> onMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return ApiResponse.failed(null,e.getMessage());
    }
}
