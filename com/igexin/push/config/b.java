package com.igexin.push.config;

import android.os.Bundle;
import com.igexin.push.f.n;
import java.util.Iterator;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f23372a;

    private b() {
    }

    public static b a() {
        b bVar;
        synchronized (b.class) {
            try {
                if (f23372a == null) {
                    f23372a = new b();
                }
                bVar = f23372a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public static boolean b() {
        String next;
        try {
            Bundle bundle = n.b(com.igexin.push.core.e.l).metaData;
            if (bundle != null) {
                Iterator<String> it = bundle.keySet().iterator();
                do {
                    if (!it.hasNext()) {
                        return true;
                    }
                    next = it.next();
                } while (!"PUSH_DOMAIN".equals(next));
                com.igexin.c.a.c.a.b(g.f23379a, "PUSH_DOMAIN:" + bundle.getString(next));
                String string = bundle.getString(next);
                SDKUrlConfig.setXfrAddressIps(new String[]{"socket://xfr." + string + ":5224"});
                StringBuilder sb = new StringBuilder("XFR_ADDRESS_IPS:");
                sb.append(SDKUrlConfig.getXfrAddress()[0]);
                com.igexin.c.a.c.a.b(g.f23379a, sb.toString());
                SDKUrlConfig.XFR_ADDRESS_BAK = new String[]{"socket://xfr_bak." + string + ":5224"};
                StringBuilder sb2 = new StringBuilder("XFR_ADDRESS_IPS_BAK:");
                sb2.append(SDKUrlConfig.XFR_ADDRESS_BAK[0]);
                com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
                SDKUrlConfig.BI_ADDRESS_IPS = new String[]{"http://bi." + string + "/api.php"};
                StringBuilder sb3 = new StringBuilder("BI_ADDRESS_IPS:");
                sb3.append(SDKUrlConfig.BI_ADDRESS_IPS[0]);
                com.igexin.c.a.c.a.b(g.f23379a, sb3.toString());
                SDKUrlConfig.CONFIG_ADDRESS_IPS = new String[]{"http://config." + string + "/api.php"};
                StringBuilder sb4 = new StringBuilder("CONFIG_ADDRESS_IPS:");
                sb4.append(SDKUrlConfig.CONFIG_ADDRESS_IPS[0]);
                com.igexin.c.a.c.a.b(g.f23379a, sb4.toString());
                return true;
            }
            return true;
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(e.toString(), new Object[0]);
            return true;
        }
    }

    private static String c() {
        return null;
    }

    private static int d() {
        return 0;
    }
}
