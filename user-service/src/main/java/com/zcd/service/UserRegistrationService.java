package com.zcd.service;

import com.zcd.common.ApiRequest;
import com.zcd.common.ApiResponse;
import com.zcd.exception.UserException;
import com.zcd.model.User;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 23/4/24 4:23 pm
 */
public interface UserRegistrationService {

    Boolean registerUser(@RequestBody @Validated User user);



    default Boolean registerUserV31(@RequestBody @Validated User user ) throws UserException {
        return false;
    }
}
