package com.sobot.chat.api.model;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/BaseCode.class */
public class BaseCode<T> {
    private String code;
    private T data;
    private String msg;

    public String getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "BaseCode{code='" + this.code + "', data=" + this.data + ", msg='" + this.msg + "'}";
    }
}
