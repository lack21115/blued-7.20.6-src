package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/apmobilesecuritysdk/d/a.class */
public final class a {
    public static Map<String, String> a(Context context, Map<String, String> map) {
        HashMap hashMap;
        synchronized (a.class) {
            try {
                String a2 = com.alipay.security.mobile.module.a.a.a(map, "appchannel", "");
                hashMap = new HashMap();
                hashMap.put("AA1", context.getPackageName());
                com.alipay.security.mobile.module.b.a.a();
                hashMap.put("AA2", com.alipay.security.mobile.module.b.a.a(context));
                hashMap.put("AA3", "APPSecuritySDK-ALIPAYSDK");
                hashMap.put("AA4", "3.4.0.201910161639");
                hashMap.put("AA6", a2);
            } catch (Throwable th) {
                throw th;
            }
        }
        return hashMap;
    }
}
