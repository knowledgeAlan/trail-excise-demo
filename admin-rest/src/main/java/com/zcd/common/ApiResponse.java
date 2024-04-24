package com.zcd.common;

import com.zcd.commonEnum.StatusCode;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 18/4/24 6:44 pm
 */


public class ApiResponse<T> {

    private int code;

    private String message;

    private T body;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getBody() {
        return body;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setBody(T body) {
        this.body = body;
    }


    public static <T> ApiResponse<T> ok(T body) {
        return of(body,StatusCode.OK);
    }


    public static <T> ApiResponse<T> failed(T body){
        return of(body,StatusCode.FAILED);
    }

    public static <T> ApiResponse<T> of(T body, StatusCode statusCode){
        ApiResponse<T> response = new ApiResponse();

        response.setBody(body);
        response.setCode(statusCode.getCode());
        response.setMessage(statusCode.getMessage());
        return response;
    }

    public static <T> ApiResponse<T> failed(T body,String errorMessage){

        ApiResponse<T> response = of(body,StatusCode.FAILED);
        response.setMessage(errorMessage);
        return response;
    }

    public static class  Builder<T>{

        private int code;

        private String message;

        public Builder<T> code(int code){

            this.code = code;
            return this;
        }
    }
}
