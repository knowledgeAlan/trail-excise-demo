package com.zcd.model;

import com.zcd.BaseTest;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 24/4/24 3:27 pm
 */
public class UserTest extends BaseTest {

    @Test
    public void testValidateUser(){
        User user = new User();

        Set<ConstraintViolation<User>> constraintViolations =validate(user);

        constraintViolations.forEach(cv-> System.out.println(cv.getMessage()));
    }
}
