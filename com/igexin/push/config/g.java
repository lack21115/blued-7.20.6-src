package com.igexin.push.config;

import android.os.Bundle;
import com.igexin.push.f.n;
import java.util.Iterator;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/config/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f23379a = "MetaDataConfig";

    private static void a() {
        String next;
        try {
            Bundle bundle = n.b(com.igexin.push.core.e.l).metaData;
            if (bundle != null) {
                Iterator<String> it = bundle.keySet().iterator();
                do {
                    if (!it.hasNext()) {
                        return;
                    }
                    next = it.next();
                } while (!"PUSH_DOMAIN".equals(next));
                com.igexin.c.a.c.a.b(f23379a, "PUSH_DOMAIN:" + bundle.getString(next));
                String string = bundle.getString(next);
                SDKUrlConfig.setXfrAddressIps(new String[]{"socket://xfr." + string + ":5224"});
                StringBuilder sb = new StringBuilder("XFR_ADDRESS_IPS:");
                sb.append(SDKUrlConfig.getXfrAddress()[0]);
                com.igexin.c.a.c.a.b(f23379a, sb.toString());
                SDKUrlConfig.XFR_ADDRESS_BAK = new String[]{"socket://xfr_bak." + string + ":5224"};
                StringBuilder sb2 = new StringBuilder("XFR_ADDRESS_IPS_BAK:");
                sb2.append(SDKUrlConfig.XFR_ADDRESS_BAK[0]);
                com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
                SDKUrlConfig.BI_ADDRESS_IPS = new String[]{"http://bi." + string + "/api.php"};
                StringBuilder sb3 = new StringBuilder("BI_ADDRESS_IPS:");
                sb3.append(SDKUrlConfig.BI_ADDRESS_IPS[0]);
                com.igexin.c.a.c.a.b(f23379a, sb3.toString());
                SDKUrlConfig.CONFIG_ADDRESS_IPS = new String[]{"http://config." + string + "/api.php"};
                StringBuilder sb4 = new StringBuilder("CONFIG_ADDRESS_IPS:");
                sb4.append(SDKUrlConfig.CONFIG_ADDRESS_IPS[0]);
                com.igexin.c.a.c.a.b(f23379a, sb4.toString());
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
            com.igexin.c.a.c.a.a(e.toString(), new Object[0]);
        }
    }

    private static void a(String str) {
        SDKUrlConfig.setXfrAddressIps(new String[]{"socket://xfr." + str + ":5224"});
        StringBuilder sb = new StringBuilder("XFR_ADDRESS_IPS:");
        sb.append(SDKUrlConfig.getXfrAddress()[0]);
        com.igexin.c.a.c.a.b(f23379a, sb.toString());
        SDKUrlConfig.XFR_ADDRESS_BAK = new String[]{"socket://xfr_bak." + str + ":5224"};
        StringBuilder sb2 = new StringBuilder("XFR_ADDRESS_IPS_BAK:");
        sb2.append(SDKUrlConfig.XFR_ADDRESS_BAK[0]);
        com.igexin.c.a.c.a.a(sb2.toString(), new Object[0]);
        SDKUrlConfig.BI_ADDRESS_IPS = new String[]{"http://bi." + str + "/api.php"};
        StringBuilder sb3 = new StringBuilder("BI_ADDRESS_IPS:");
        sb3.append(SDKUrlConfig.BI_ADDRESS_IPS[0]);
        com.igexin.c.a.c.a.b(f23379a, sb3.toString());
        SDKUrlConfig.CONFIG_ADDRESS_IPS = new String[]{"http://config." + str + "/api.php"};
        StringBuilder sb4 = new StringBuilder("CONFIG_ADDRESS_IPS:");
        sb4.append(SDKUrlConfig.CONFIG_ADDRESS_IPS[0]);
        com.igexin.c.a.c.a.b(f23379a, sb4.toString());
    }
}
