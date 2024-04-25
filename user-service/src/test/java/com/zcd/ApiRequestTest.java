package com.zcd;

import com.zcd.common.ApiRequest;
import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;

import java.util.Set;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 24/4/24 3:24 pm
 */
public class ApiRequestTest extends BaseTest{

    @Test
    public void testValidateBody(){
        ApiRequest request = new ApiRequest();

        Set< ConstraintViolation<ApiRequest>> constraintViolations = validate(request);

        constraintViolations.forEach(cv-> System.out.println(cv.getMessage()));
    }
}
