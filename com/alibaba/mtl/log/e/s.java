package com.alibaba.mtl.log.e;

import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/s.class */
public class s {
    public static void send(Map<String, String> map) {
        Object a2;
        try {
            Object a3 = o.a("com.ut.mini.UTAnalytics", "getInstance");
            if (a3 == null || (a2 = o.a(a3, "getDefaultTracker")) == null) {
                return;
            }
            o.a(a2, "send", new Object[]{map}, Map.class);
        } catch (Exception e) {
        }
    }
}
