package com.zcd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * admin rest
 *
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AdminRestApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(AdminRestApplication.class,args);
    }
}
