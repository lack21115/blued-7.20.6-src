package com.getui.gtc.h;

import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.e.c;
import com.getui.gtc.entity.a;
import java.io.File;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/h/b.class */
public final class b {
    public static void a(a.C0351a c0351a, String str) throws Exception {
        if (a(c0351a)) {
            throw new RuntimeException("The download request is unusual, too many times in a short time");
        }
        Response execute = d.f22027a.newCall(new Request.Builder().url(c0351a.h).method("GET").logFlags(1).build()).execute();
        if (execute.body() == null) {
            throw new RuntimeException("can not save file, body is null");
        }
        execute.body().file(new File(str));
    }

    private static boolean a(a.C0351a c0351a) {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        boolean z;
        com.getui.gtc.e.c cVar3;
        cVar = c.a.f21997a;
        int c2 = cVar.b.c(c0351a.f22002a);
        cVar2 = c.a.f21997a;
        long b = cVar2.b.b(c0351a.f22002a);
        long currentTimeMillis = System.currentTimeMillis();
        if (c2 >= 10) {
            c2 = -1;
            b = currentTimeMillis;
            z = true;
        } else {
            long j = currentTimeMillis - b;
            if (c2 < 0) {
                z = true;
                if (j > 3600000) {
                    b = currentTimeMillis;
                    c2 = 0;
                    z = true;
                }
            } else {
                if (j > 3600000) {
                    b = currentTimeMillis;
                    c2 = 0;
                } else {
                    c2++;
                }
                z = false;
            }
        }
        cVar3 = c.a.f21997a;
        cVar3.b.a(c0351a.f22002a, b, c2);
        return z;
    }
}
