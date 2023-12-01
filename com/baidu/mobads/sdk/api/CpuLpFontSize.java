package com.baidu.mobads.sdk.api;

/* loaded from: source-8756600-dex2jar.jar:com/baidu/mobads/sdk/api/CpuLpFontSize.class */
public enum CpuLpFontSize {
    SMALL("sml"),
    REGULAR("reg"),
    LARGE("lrg"),
    EXTRA_LARGE("xlg"),
    XX_LARGE("xxl");
    
    String mValue;

    CpuLpFontSize(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }
}
