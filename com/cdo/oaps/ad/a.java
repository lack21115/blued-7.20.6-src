package com.cdo.oaps.ad;

import android.util.Base64;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7907a = "Y29tLm9uZXBsdXMubWFya2V0";
    public static final String b = "Y29tLm9wcG8ubWFya2V0";

    /* renamed from: c  reason: collision with root package name */
    public static final String f7908c = "b3Bwbw==";

    public static String a() {
        return b(f7907a);
    }

    public static String a(String str) {
        return new String(Base64.encode(str.getBytes(), 0));
    }

    public static String b() {
        return b(b);
    }

    public static String b(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static String c() {
        return b(f7908c);
    }
}
