package com.zcd.service.impl;

import com.zcd.exception.UserException;
import com.zcd.model.User;
import com.zcd.service.UserRegistrationService;
import org.springframework.stereotype.Service;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 23/4/24 5:16 pm
 */

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
    @Override
    public Boolean registerUser(User user) {
        return true;
    }

    @Override
    public Boolean registerUserV31(User user) throws UserException {
        return UserRegistrationService.super.registerUserV31(user);
    }
}
