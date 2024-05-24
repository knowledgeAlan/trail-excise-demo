package com.zcd.web.openFeign;

import com.zcd.common.ApiResponse;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 24/5/24 4:57 pm
 */
public class ApiResponseDecoder implements Decoder {

    private final  Decoder decoder;

    public ApiResponseDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
       String contentType = getContentType(response);

       MediaType mediaType = MediaType.parseMediaType(contentType);

       String version = mediaType.getParameter("v");

       if(version == null){

           Object object = decoder.decode(response, ApiResponse.class);

           if(object instanceof ApiResponse){
               return ApiResponse.class.cast(object).getBody();
           }

       }
        return decoder.decode(response,type);
    }

    private String getContentType(Response response){
        Collection<String> types=response.headers().getOrDefault("Content-Type", Arrays.asList(""));
        return types.iterator().next();
    }
}
