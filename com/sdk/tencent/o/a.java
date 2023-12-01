package com.sdk.tencent.o;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.sdk.tencent.f.c;
import com.sdk.tencent.o.b;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/o/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28065a = "com.sdk.tencent.o.a";
    public static final Boolean b = Boolean.valueOf(c.b);

    public static b.EnumC0761b a(Context context) {
        b.EnumC0761b enumC0761b;
        b.EnumC0761b enumC0761b2 = b.EnumC0761b.f28068c;
        if (context == null) {
            return enumC0761b2;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                if ("MOBILE".equalsIgnoreCase(typeName)) {
                    enumC0761b = b.EnumC0761b.b;
                } else if ("WIFI".equalsIgnoreCase(typeName)) {
                    enumC0761b = b.EnumC0761b.f28067a;
                }
                return enumC0761b;
            }
        } catch (Throwable th) {
            com.sdk.tencent.n.b.a(f28065a, th.getMessage(), b);
        }
        return enumC0761b2;
    }
}
