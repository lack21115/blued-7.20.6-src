package com.meizu.cloud.pushsdk.c.e;

import com.meizu.cloud.pushsdk.c.c.e;
import com.meizu.cloud.pushsdk.c.c.i;
import com.meizu.cloud.pushsdk.c.c.k;
import java.io.File;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/e/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f10440a;

    public static k a(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            int d = bVar.d();
            if (d == 0) {
                a2 = a2.a();
            } else if (d == 1) {
                a2 = a2.a(bVar.m());
            } else if (d == 2) {
                a2 = a2.c(bVar.m());
            } else if (d == 3) {
                a2 = a2.b(bVar.m());
            } else if (d == 4) {
                a2 = a2.b();
            } else if (d == 5) {
                a2 = a2.d(bVar.m());
            }
            i c2 = a2.c();
            bVar.a(new e());
            return bVar.l().a(c2);
        } catch (IOException e) {
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.meizu.cloud.pushsdk.c.c.i.a r4, com.meizu.cloud.pushsdk.c.a.b r5) {
        /*
            r0 = r5
            java.lang.String r0 = r0.h()
            if (r0 == 0) goto L17
            r0 = r5
            java.lang.String r0 = r0.h()
            r6 = r0
        Lc:
            r0 = r4
            java.lang.String r1 = "User-Agent"
            r2 = r6
            com.meizu.cloud.pushsdk.c.c.i$a r0 = r0.a(r1, r2)
            goto L2b
        L17:
            java.lang.String r0 = com.meizu.cloud.pushsdk.c.e.a.f10440a
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L2b
            r0 = r5
            r1 = r6
            r0.a(r1)
            java.lang.String r0 = com.meizu.cloud.pushsdk.c.e.a.f10440a
            r6 = r0
            goto Lc
        L2b:
            r0 = r5
            com.meizu.cloud.pushsdk.c.c.c r0 = r0.o()
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L5a
            r0 = r4
            r1 = r6
            com.meizu.cloud.pushsdk.c.c.i$a r0 = r0.a(r1)
            r0 = r5
            java.lang.String r0 = r0.h()
            if (r0 == 0) goto L5a
            r0 = r6
            java.util.Set r0 = r0.b()
            java.lang.String r1 = "User-Agent"
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L5a
            r0 = r4
            java.lang.String r1 = "User-Agent"
            r2 = r5
            java.lang.String r2 = r2.h()
            com.meizu.cloud.pushsdk.c.c.i$a r0 = r0.a(r1, r2)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.e.a.a(com.meizu.cloud.pushsdk.c.c.i$a, com.meizu.cloud.pushsdk.c.a.b):void");
    }

    public static k b(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            i c2 = a2.a().c();
            bVar.a(new e());
            k a3 = bVar.l().a(c2);
            com.meizu.cloud.pushsdk.c.h.b.a(a3, bVar.j(), bVar.k());
            return a3;
        } catch (IOException e) {
            try {
                File file = new File(bVar.j() + File.separator + bVar.k());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }

    public static k c(com.meizu.cloud.pushsdk.c.a.b bVar) throws com.meizu.cloud.pushsdk.c.b.a {
        try {
            i.a a2 = new i.a().a(bVar.e());
            a(a2, bVar);
            i c2 = a2.a(new b(bVar.n(), bVar.i())).c();
            bVar.a(new e());
            return bVar.l().a(c2);
        } catch (IOException e) {
            throw new com.meizu.cloud.pushsdk.c.b.a(e);
        }
    }
}
