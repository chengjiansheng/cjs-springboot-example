package com.cjs.boot.advice;

import com.cjs.boot.response.RespResult;
import com.cjs.boot.util.WebUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@ControllerAdvice
@Component
public class GlobalExceptionHandlerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    public RespResult handler(HttpServletRequest request, ConstraintViolationException ex) {
        if (WebUtils.isAjax(request)) {
            StringBuffer sb = new StringBuffer();
            for (ConstraintViolation violation : ex.getConstraintViolations()) {
                sb.append(violation.getMessage());
            }
            return RespResult.failure(sb.toString());
        }
        throw ex;
    }

}
