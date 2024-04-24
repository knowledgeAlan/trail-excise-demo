package com.zcd.controller;

import com.zcd.model.User;
import com.zcd.service.UserRegistrationService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 23/4/24 4:40 pm
 */

@RestController
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping(value = "/user/register", produces = "application/json;v=3") // V3
    public Boolean registerUser(@RequestBody @Validated @Valid User user){
        return userRegistrationService.registerUser(user);
    }
}
