package com.zcd.feigns;

import com.zcd.exception.UserException;
import com.zcd.model.User;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 23/4/24 4:23 pm
 */
@FeignClient(name = "user-service")
public interface UserRegistrationService {

    @PostMapping(value = "/user/register", produces = "application/json;v=3") // V3
    Boolean registerUser(@RequestBody @Validated @Valid User user);




}
