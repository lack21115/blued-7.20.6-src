package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/ReqFailException.class */
public class ReqFailException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private WeReq.ErrType f22411a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f22412c;

    public ReqFailException(WeReq.ErrType errType, int i, String str, Exception exc) {
        super(str, exc);
        this.f22411a = errType;
        this.b = i;
        this.f22412c = str;
    }

    public int code() {
        return this.b;
    }

    public String msg() {
        return this.f22412c;
    }

    public WeReq.ErrType type() {
        return this.f22411a;
    }
}
