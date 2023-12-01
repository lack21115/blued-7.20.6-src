package com.alipay.sdk.sys;

import android.content.Context;
import com.alipay.sdk.data.c;
import com.ta.utdid2.device.UTDevice;
import java.io.File;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/sys/b.class */
public class b {
    private static b a;
    private Context b;

    private b() {
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public static boolean d() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 10) {
                return false;
            }
            if (new File(new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"}[i2]).exists()) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public void a(Context context) {
        c.b();
        this.b = context.getApplicationContext();
    }

    public Context b() {
        return this.b;
    }

    public c c() {
        return c.b();
    }

    public String e() {
        try {
            return UTDevice.getUtdid(this.b);
        } catch (Throwable th) {
            com.alipay.sdk.util.c.a(th);
            return "getUtdidEx";
        }
    }
}
