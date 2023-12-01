package com.getui.gtc.h;

import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.Response;
import com.getui.gtc.e.c;
import com.getui.gtc.entity.a;
import java.io.File;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/h/b.class */
public final class b {
    public static void a(a.C0181a c0181a, String str) throws Exception {
        if (a(c0181a)) {
            throw new RuntimeException("The download request is unusual, too many times in a short time");
        }
        Response execute = d.f8420a.newCall(new Request.Builder().url(c0181a.h).method("GET").logFlags(1).build()).execute();
        if (execute.body() == null) {
            throw new RuntimeException("can not save file, body is null");
        }
        execute.body().file(new File(str));
    }

    private static boolean a(a.C0181a c0181a) {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        boolean z;
        com.getui.gtc.e.c cVar3;
        cVar = c.a.f8390a;
        int c2 = cVar.b.c(c0181a.f8395a);
        cVar2 = c.a.f8390a;
        long b = cVar2.b.b(c0181a.f8395a);
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
        cVar3 = c.a.f8390a;
        cVar3.b.a(c0181a.f8395a, b, c2);
        return z;
    }
}
