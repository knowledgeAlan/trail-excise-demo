package com.zcd.web.openFeign;

import com.zcd.feigns.UserRegistrationService;
import com.zcd.loadbalance.UserServiceLoadBalanceConfiguration;
import com.zcd.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 24/5/24 4:33 pm
 */
@EnableAutoConfiguration
@EnableFeignClients(clients = UserRegistrationService.class )
@LoadBalancerClient(name = "user-service",configuration = UserServiceLoadBalanceConfiguration.class)
public class FeignClientSpringBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context
                = new SpringApplicationBuilder(FeignClientSpringBootstrap.class).web(WebApplicationType.NONE)
                .build().
                run(args);


        UserRegistrationService userRegistrationService = context.getBean(UserRegistrationService.class);

        User user = new User();
        user.setId(2L);
        user.setName("test");
        Boolean res = userRegistrationService.registerUser(user);

        System.out.println("res==="+res);
        context.close();
    }
}
