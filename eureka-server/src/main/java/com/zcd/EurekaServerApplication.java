package com.zcd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka server
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication
{
    public static void main( String[] args ) {

        SpringApplication.run(EurekaServerApplication.class,args);

    }
}
