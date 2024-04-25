package com.zcd.config;

import com.zcd.handlerResponse.ApiResponseHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 25/4/24 5:52 pm
 */
@Configuration
public class WebMvcConfiguration {


    @Autowired
    public void resetRequestMappingHandlerAdapter(RequestMappingHandlerAdapter requestMappingHandlerAdapter){
        List<HandlerMethodReturnValueHandler> handlerMethodReturnValueHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newHandlerMethodReturnValueHandlers =  new ArrayList(handlerMethodReturnValueHandlers);

        newHandlerMethodReturnValueHandlers.add(0,new ApiResponseHandlerMethodReturnValueHandler());
        requestMappingHandlerAdapter.setReturnValueHandlers(newHandlerMethodReturnValueHandlers);
    }
}
