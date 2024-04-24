package com.zcd.commonEnum;

/**
 * @author uniweb
 * @version 1.0
 * @description:
 * @date 19/4/24 5:23 pm
 */
public enum StatusCode {

    OK(0,"ok"){
        @Override
        public String getMessage() {
            return super.getMessage();
        }
    },
    FAILED(-1,"failed"),
    CONTINUE(1,"{status-code.continue}")
    ;

    private final int code;

    private final  String message;

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

class MyEnum{
    public static final  MyEnum ONE = new MyEnum(){
        @Override
        public String getValue(){
            return "ONE";
        }
    };

    public MyEnum() {
    }

    public String getValue(){
        return "";
    }
}
