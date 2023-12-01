package com.kwad.sdk;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/a.class */
public final class a {
    public static final a Yi = new a(10000, "其他异常");
    public static final a Yj = new a(10001, "初始化参数异常");
    public int code;
    public String msg;

    public a(int i, String str) {
        this.code = i;
        this.msg = str;
    }
}
