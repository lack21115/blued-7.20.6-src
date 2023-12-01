package com.qq.e.comm.util;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/util/AdError.class */
public class AdError {

    /* renamed from: a  reason: collision with root package name */
    private int f27929a;
    private String b;

    public AdError() {
    }

    public AdError(int i, String str) {
        this.f27929a = i;
        this.b = str;
    }

    public int getErrorCode() {
        return this.f27929a;
    }

    public String getErrorMsg() {
        return this.b;
    }
}
