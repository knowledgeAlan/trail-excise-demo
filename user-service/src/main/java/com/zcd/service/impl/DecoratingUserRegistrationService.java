package com.zcd.service.impl;

import com.zcd.exception.UserException;
import com.zcd.model.User;
import com.zcd.service.UserRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 23/4/24 4:29 pm
 */


public class DecoratingUserRegistrationService implements UserRegistrationService {

    private static final Logger logger = LoggerFactory.getLogger(DecoratingUserRegistrationService.class);


    private final UserRegistrationService delegate;

    public DecoratingUserRegistrationService(UserRegistrationService delegate) {
        this.delegate = delegate;
    }

    @Override
    public Boolean registerUser(User user) {
        logger.info("registerUser====");
        return delegate.registerUser(user);
    }

    @Override
    public Boolean registerUserV31(User user) throws UserException {
        return UserRegistrationService.super.registerUserV31(user);
    }
}
