package com.oobss.controller.exception.handler;

import com.oobss.common.util.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * Created by clarkzhao on 2018/1/7.
 *
 * @author clarkzhao
 * @date 2018/1/7
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result constraintViolationExceptionHandler(ConstraintViolationException e){
        Result result = new Result();
        result.setRetCode(Result.ERROR);
        StringBuilder sb = new StringBuilder();
        e.getConstraintViolations().forEach(constraintViolation -> {
            sb.append(constraintViolation.getPropertyPath());
            sb.append(constraintViolation.getMessage());
            sb.append(";");
        });
        result.setErrMsg(sb.toString());
        return result;
    }
}
