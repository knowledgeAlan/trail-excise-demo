package com.zcd.controller;

import com.zcd.feigns.UserRegistrationService;
import com.zcd.model.User;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 23/4/24 4:52 pm
 */
@RestController
public class UserRegistrationController {


    private final UserRegistrationService userRegistrationService;

    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }


    @PostMapping(value = "/user/register", produces = "application/json;v=3") // V3
    @ResponseBody
    public Boolean registerUser(@RequestBody @Validated @Valid User user){
        Boolean  res= userRegistrationService.registerUser(user);
        return res ;
    }
}
