package com.zcd.handlerResponse;

import com.zcd.common.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Native;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 25/4/24 5:42 pm
 */
public class ApiResponseHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    private MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {

        return (AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ResponseBody.class) || returnType.hasMethodAnnotation(ResponseBody.class)
                && ApiResponse.class.equals(returnType.getParameterType()));

    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        mavContainer.setRequestHandled(true);

        ApiResponse apiResponse = ApiResponse.ok(returnValue);

        HttpServletResponse response = (HttpServletResponse) webRequest.getNativeResponse();

        response.addHeader("v","3");

        ServletServerHttpResponse servletServerHttpResponse =createOutputMessage(webRequest);
        converter.write(apiResponse, MediaType.APPLICATION_JSON,servletServerHttpResponse);

    }

    protected ServletServerHttpResponse createOutputMessage(NativeWebRequest nativeWebRequest){

        HttpServletResponse response = nativeWebRequest.getNativeResponse(HttpServletResponse.class);

        Assert.state(response!=null,"no HttpServletResponse");
        return new ServletServerHttpResponse(response);
    }
}
