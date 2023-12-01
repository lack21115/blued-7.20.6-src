package com.xiaomi.push;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cz.class */
public class cz {
    public static int a(Context context, int i) {
        int a2 = gz.a(context);
        if (-1 == a2) {
            return -1;
        }
        return (i * (a2 == 0 ? 13 : 11)) / 10;
    }

    public static int a(hg hgVar) {
        return el.a(hgVar.a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0077, code lost:
        if (com.xiaomi.push.ew.a(r3) != (-1)) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a7, code lost:
        if (com.xiaomi.push.ew.a(r3) != (-1)) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(com.xiaomi.push.ir r3, com.xiaomi.push.hg r4) {
        /*
            Method dump skipped, instructions count: 369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.cz.a(com.xiaomi.push.ir, com.xiaomi.push.hg):int");
    }

    public static void a(String str, Context context, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        int a2 = a(context, i2);
        if (i != el.a(hq.UploadTinyData)) {
            em.a(context.getApplicationContext()).a(str, i, 1L, a2);
        }
    }

    public static void a(String str, Context context, ic icVar, int i) {
        hg a2;
        if (context == null || icVar == null || (a2 = icVar.a()) == null) {
            return;
        }
        int a3 = a(a2);
        int i2 = i;
        if (i <= 0) {
            byte[] a4 = iq.a(icVar);
            i2 = a4 != null ? a4.length : 0;
        }
        a(str, context, a3, i2);
    }

    public static void a(String str, Context context, ir irVar, hg hgVar, int i) {
        a(str, context, a(irVar, hgVar), i);
    }

    public static void a(String str, Context context, byte[] bArr) {
        if (context == null || bArr == null || bArr.length <= 0) {
            return;
        }
        ic icVar = new ic();
        try {
            iq.a(icVar, bArr);
            a(str, context, icVar, bArr.length);
        } catch (iw e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("fail to convert bytes to container");
        }
    }
}
