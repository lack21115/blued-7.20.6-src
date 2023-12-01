package com.sobot.network.apiUtils;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/apiUtils/SobotBaseCode.class */
public class SobotBaseCode<T> {
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
}
