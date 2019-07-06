package com.sxh.user.common.filter;

import com.sxh.user.model.base.ResponseJson;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author WIKI
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 参数异常
     *
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseJson> notFount(ConstraintViolationException e) {
        String msg="";
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            msg+=constraintViolation.getMessage()+" ";
        }
        return ResponseEntity.ok(new ResponseJson(2001, msg));
    }

    /**
     * 参数异常
     *
     */
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<ResponseJson> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String msg="";
        BindingResult result = e.getBindingResult();
        for (FieldError fieldError : result.getFieldErrors()) {
            msg+=fieldError.getDefaultMessage()+"";
        }
        return ResponseEntity.ok(new ResponseJson(2001, msg));
    }
}
