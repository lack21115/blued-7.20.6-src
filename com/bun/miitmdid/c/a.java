package com.bun.miitmdid.c;

import com.igexin.assist.util.AssistUtils;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/a.class */
public enum a {
    UNSUPPORT(-1, "unsupport"),
    HUA_WEI(0, "HUAWEI"),
    XIAOMI(1, "Xiaomi"),
    VIVO(2, AssistUtils.BRAND_VIVO),
    OPPO(3, AssistUtils.BRAND_OPPO),
    MOTO(4, "motorola"),
    LENOVO(5, "lenovo"),
    ASUS(6, "asus"),
    SAMSUNG(7, "samsung"),
    MEIZU(8, AssistUtils.BRAND_MZ),
    NUBIA(10, "nubia"),
    ZTE(11, "ZTE"),
    ONEPLUS(12, "OnePlus"),
    BLACKSHARK(13, "blackshark"),
    FREEMEOS(30, "freemeos"),
    SSUIOS(31, "ssui");
    

    /* renamed from: a  reason: collision with root package name */
    private String f21134a;

    a(int i, String str) {
        this.f21134a = str;
    }

    public static native a a(String str);

    public static native a valueOf(String str);

    public static native a[] values();
}
