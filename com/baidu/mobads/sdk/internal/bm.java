package com.baidu.mobads.sdk.internal;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/internal/bm.class */
public enum bm {
    INTERFACE_USE_PROBLEM(1010001, "接口使用问题"),
    SHOW_STANDARD_UNFIT(3040001, "容器大小不达标");
    

    /* renamed from: c  reason: collision with root package name */
    public static final String f6507c = "msg";
    private int d;
    private String e;

    bm(int i, String str) {
        this.d = i;
        this.e = str;
    }

    public int b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }
}
