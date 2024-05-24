package com.zcd.web.openFeign;

import feign.codec.Decoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 24/5/24 4:59 pm
 */

@Configuration
public class UserServiceFeignClientConfiguration {


    @Autowired
    private  ObjectFactory<HttpMessageConverters> messageConverters;


    @Bean
    public Decoder feignDecoder(){
        return new ApiResponseDecoder(new ResponseEntityDecoder(new SpringDecoder(messageConverters)));
    }

}
