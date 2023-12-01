package com.alipay.security.mobile.module.c;

import android.content.Context;
import java.util.HashMap;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/c/d.class */
public final class d {
    public static void a(Context context, String str, String str2, String str3) {
        synchronized (d.class) {
            try {
                if (!com.alipay.security.mobile.module.a.a.a(str)) {
                    if (!com.alipay.security.mobile.module.a.a.a(str2) && context != null) {
                        try {
                            String a = com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str3);
                            HashMap hashMap = new HashMap();
                            hashMap.put(str2, a);
                            e.a(context, str, hashMap);
                        } catch (Throwable th) {
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
