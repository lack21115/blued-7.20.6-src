package com.alibaba.mtl.log.a;

import com.alibaba.mtl.log.e.e;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import com.alibaba.mtl.log.e.r;
import com.alibaba.mtl.log.e.t;
import java.util.HashMap;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/a/b.class */
public class b {
    private static b a = new b();
    private static String P = "http://adashx.m.taobao.com/rest/gc2";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/log/a/b$a.class */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!l.isConnected()) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= 8) {
                    return;
                }
                HashMap hashMap = new HashMap();
                String m8605b = com.alibaba.mtl.log.a.a.m8605b("b01n15");
                String m8605b2 = com.alibaba.mtl.log.a.a.m8605b("b01na");
                hashMap.put("_b01n15", m8605b);
                hashMap.put("_b01na", m8605b2);
                try {
                    String b = t.b(b.P, hashMap, null);
                    i.a("ConfigMgr", "config:" + b);
                    e.a a = com.alibaba.mtl.log.e.e.a(1, b, null, false);
                    if (a.e != null) {
                        com.alibaba.mtl.log.a.a.h(new String(a.e, 0, a.e.length));
                        com.alibaba.mtl.log.a.a.q();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(10000L);
                } catch (Exception e2) {
                }
                i = i2 + 1;
            }
        }
    }

    public static b a() {
        return a;
    }

    public void r() {
        r.a().b(new a());
    }
}
