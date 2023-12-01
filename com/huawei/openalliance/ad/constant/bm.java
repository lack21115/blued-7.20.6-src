package com.huawei.openalliance.ad.constant;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/constant/bm.class */
public enum bm {
    HTTP("http://"),
    HTTPS("https://"),
    FILE("file://"),
    CONTENT("content://"),
    ASSET("asset://"),
    RES("res://");
    
    String S;

    bm(String str) {
        this.S = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }
}
