package com.alipay.sdk.util;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/d.class */
public enum d {
    WIFI(0, "WIFI"),
    NETWORK_TYPE_1(1, "unicom2G"),
    NETWORK_TYPE_2(2, "mobile2G"),
    NETWORK_TYPE_4(4, "telecom2G"),
    NETWORK_TYPE_5(5, "telecom3G"),
    NETWORK_TYPE_6(6, "telecom3G"),
    NETWORK_TYPE_12(12, "telecom3G"),
    NETWORK_TYPE_8(8, "unicom3G"),
    NETWORK_TYPE_3(3, "unicom3G"),
    NETWORK_TYPE_13(13, "LTE"),
    NETWORK_TYPE_11(11, "IDEN"),
    NETWORK_TYPE_9(9, "HSUPA"),
    NETWORK_TYPE_10(10, "HSPA"),
    NETWORK_TYPE_15(15, "HSPAP"),
    NONE(-1, "none");
    
    private int p;
    private String q;

    d(int i, String str) {
        this.p = i;
        this.q = str;
    }

    public static d a(int i) {
        d[] values = values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return NONE;
            }
            d dVar = values[i3];
            if (dVar.a() == i) {
                return dVar;
            }
            i2 = i3 + 1;
        }
    }

    public final int a() {
        return this.p;
    }

    public final String b() {
        return this.q;
    }
}
