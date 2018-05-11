package com.cjs.boot.request.custom;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckValidityModeValidator implements ConstraintValidator<CheckValidityMode, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (null == value) {
            return true;
        }

        BeanWrapper beanWrapper = new BeanWrapperImpl(value);
        Object validityMode = beanWrapper.getPropertyValue("validityMode");
        Object days = beanWrapper.getPropertyValue("days");

        if (null == validityMode) {
            return true;
        }

        if (((Integer)validityMode) == 1 && null == days) {
            return false;
        }

        return true;
    }
}
