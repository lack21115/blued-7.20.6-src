package com.alipay.security.mobile.module.c;

import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/security/mobile/module/c/b.class */
public final class b {
    public static String a(String str) {
        String str2;
        try {
            str2 = f.a(str);
        } catch (Throwable th) {
            str2 = "";
        }
        String str3 = str2;
        if (com.alipay.security.mobile.module.a.a.a(str2)) {
            str3 = c.a(".SystemConfig" + File.separator + str);
        }
        return str3;
    }
}
