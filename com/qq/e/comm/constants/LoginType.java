package com.qq.e.comm.constants;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/constants/LoginType.class */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);
    
    private int b;

    LoginType(int i) {
        this.b = i;
        ordinal();
    }

    public int getValue() {
        return this.b;
    }
}
