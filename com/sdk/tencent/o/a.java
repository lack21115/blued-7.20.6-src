package com.sdk.tencent.o;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.sdk.tencent.f.c;
import com.sdk.tencent.o.b;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14377a = "com.sdk.tencent.o.a";
    public static final Boolean b = Boolean.valueOf(c.b);

    public static b.EnumC0591b a(Context context) {
        b.EnumC0591b enumC0591b;
        b.EnumC0591b enumC0591b2 = b.EnumC0591b.f14380c;
        if (context == null) {
            return enumC0591b2;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                if ("MOBILE".equalsIgnoreCase(typeName)) {
                    enumC0591b = b.EnumC0591b.b;
                } else if ("WIFI".equalsIgnoreCase(typeName)) {
                    enumC0591b = b.EnumC0591b.f14379a;
                }
                return enumC0591b;
            }
        } catch (Throwable th) {
            com.sdk.tencent.n.b.a(f14377a, th.getMessage(), b);
        }
        return enumC0591b2;
    }
}
