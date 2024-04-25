package com.zcd.common;

import jakarta.validation.Valid;
import org.springframework.util.MultiValueMap;

import java.util.Map;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 23/4/24 4:04 pm
 */
public abstract  class HttpApi<T> {

    private Map<String,String> headers;


    private MultiValueMap<String,String> metaData;


    @Valid
    private T body;


    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public MultiValueMap<String, String> getMetaData() {
        return metaData;
    }

    public void setMetaData(MultiValueMap<String, String> metaData) {
        this.metaData = metaData;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
