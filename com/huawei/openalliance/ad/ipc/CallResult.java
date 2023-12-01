package com.huawei.openalliance.ad.ipc;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/CallResult.class */
public class CallResult<T> {
    private int code = -1;
    private T data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public T getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
