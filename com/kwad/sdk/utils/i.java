package com.kwad.sdk.utils;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/i.class */
public final class i {
    public static void Z(String str, String str2) {
        com.kwad.sdk.core.d.b.d("callbackLog", str + str2);
    }

    public static void e(String str, String str2, String str3, String str4) {
        Z(str, str2 + "_" + str3 + "_" + str4);
    }

    public static void n(String str, int i) {
        com.kwad.sdk.core.d.b.d("audioVideoLog", str + "_type_" + i + "_time_" + System.currentTimeMillis());
    }
}
