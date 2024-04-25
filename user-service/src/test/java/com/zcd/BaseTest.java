package com.zcd;

import jakarta.validation.*;
import jakarta.validation.bootstrap.GenericBootstrap;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.validation.beanvalidation.LocaleContextMessageInterpolator;

import java.util.Set;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 24/4/24 3:15 pm
 */
public abstract class BaseTest {

    private Validator validator;


    @BeforeEach
    public void init(){
        GenericBootstrap bootstrap = Validation.byDefaultProvider();

        Configuration<?>  configuration = bootstrap.configure();

        MessageInterpolator   targetInterpolator = configuration.getDefaultMessageInterpolator();

        configuration.messageInterpolator(new LocaleContextMessageInterpolator(targetInterpolator));

        ValidatorFactory validatorFactory = configuration.buildValidatorFactory();
        this.validator = validatorFactory.getValidator();
    }

    protected  <T>Set<ConstraintViolation<T>> validate(T object,Class<?>... groups){
        return validator.validate(object,groups);
    }
}
