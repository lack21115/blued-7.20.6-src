package com.tencent.cloud.huiyansdkface.wehttp2;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/Resp.class */
public class Resp<T> {

    /* renamed from: a  reason: collision with root package name */
    private int f22413a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private T f22414c;

    public int getCode() {
        return this.f22413a;
    }

    public String getMsg() {
        return this.b;
    }

    public T getResult() {
        return this.f22414c;
    }

    public void setCode(int i) {
        this.f22413a = i;
    }

    public void setMsg(String str) {
        this.b = str;
    }

    public void setResult(T t) {
        this.f22414c = t;
    }
}
