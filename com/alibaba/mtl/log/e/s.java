package com.alibaba.mtl.log.e;

import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/e/s.class */
public class s {
    public static void send(Map<String, String> map) {
        Object a;
        try {
            Object a2 = o.a("com.ut.mini.UTAnalytics", "getInstance");
            if (a2 == null || (a = o.a(a2, "getDefaultTracker")) == null) {
                return;
            }
            o.a(a, "send", new Object[]{map}, Map.class);
        } catch (Exception e) {
        }
    }
}
