package com.benidevo.bookwise.common.aspect;

import com.benidevo.bookwise.common.exception.ErrorDetail;
import com.benidevo.bookwise.common.exception.ValidationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class ValidationAspect {

    @Before("@annotation(com.benidevo.bookwise.common.annotation.HandleValidationErrors)")
    public void handleValidationErrors(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult bindingResult = (BindingResult) arg;
                if (bindingResult.hasErrors()) {
                    List<ErrorDetail> errorDetails = new ArrayList<>();
                    for (FieldError error : bindingResult.getFieldErrors()) {
                        ErrorDetail errorDetail = new ErrorDetail();
                        errorDetail.setField(error.getField());
                        errorDetail.setMessage(error.getDefaultMessage());
                        errorDetails.add(errorDetail);
                    }
                    throw new ValidationException(errorDetails);
                }
            }
        }
    }
}
