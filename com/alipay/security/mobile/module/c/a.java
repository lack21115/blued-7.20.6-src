package com.alipay.security.mobile.module.c;

import android.content.Context;
import java.util.HashMap;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/c/a.class */
public class a {
    public static String a(Context context, String str, String str2) {
        String str3;
        String a2;
        synchronized (a.class) {
            if (context != null) {
                try {
                    if (!com.alipay.security.mobile.module.a.a.a(str) && !com.alipay.security.mobile.module.a.a.a(str2)) {
                        try {
                            a2 = e.a(context, str, str2, "");
                        } catch (Throwable th) {
                            str3 = null;
                        }
                        if (com.alipay.security.mobile.module.a.a.a(a2)) {
                            return null;
                        }
                        str3 = com.alipay.security.mobile.module.a.a.c.b(com.alipay.security.mobile.module.a.a.c.a(), a2);
                        return str3;
                    }
                } finally {
                }
            }
            return null;
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        synchronized (a.class) {
            try {
                if (com.alipay.security.mobile.module.a.a.a(str) || com.alipay.security.mobile.module.a.a.a(str2) || context == null) {
                    return;
                }
                try {
                    String a2 = com.alipay.security.mobile.module.a.a.c.a(com.alipay.security.mobile.module.a.a.c.a(), str3);
                    HashMap hashMap = new HashMap();
                    hashMap.put(str2, a2);
                    e.a(context, str, hashMap);
                } catch (Throwable th) {
                }
            } finally {
            }
        }
    }
}
