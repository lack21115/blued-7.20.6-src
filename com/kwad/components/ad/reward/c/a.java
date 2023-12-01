package com.kwad.components.ad.reward.c;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.y;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/reward/c/a.class */
public final class a {
    public static void P(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = new b();
        String bU = y.bU(context);
        int i = 0;
        if (!TextUtils.isEmpty(bU)) {
            try {
                bVar.parseJson(new JSONObject(bU));
                i = 0;
                if (b(bVar.gq, currentTimeMillis)) {
                    i = bVar.rx;
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e);
                i = 0;
            }
        }
        bVar.gq = currentTimeMillis;
        bVar.rx = i + 1;
        y.T(context, bVar.toJson().toString());
    }

    private static boolean b(long j, long j2) {
        return j > 0 && j2 > 0 && j / 2460601000L == j2 / 2460601000L;
    }

    public static boolean b(Context context, AdInfo adInfo) {
        if (com.kwad.sdk.core.response.a.a.ay(adInfo)) {
            int max = Math.max(com.kwad.sdk.core.response.a.a.az(adInfo) + 1, 1);
            boolean d = d(context, max);
            c(context, max);
            return d && e(context, com.kwad.sdk.core.response.a.a.aA(adInfo));
        }
        return false;
    }

    private static void c(Context context, int i) {
        int bT = y.bT(context);
        if (bT % i == 0) {
            y.k(context, 1);
        } else {
            y.k(context, bT + 1);
        }
    }

    private static boolean d(Context context, int i) {
        return i != 0 && y.bT(context) % i == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean e(android.content.Context r5, int r6) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r8 = r0
            com.kwad.components.ad.reward.c.b r0 = new com.kwad.components.ad.reward.c.b
            r1 = r0
            r1.<init>()
            r10 = r0
            r0 = r5
            java.lang.String r0 = com.kwad.sdk.utils.y.bU(r0)
            r5 = r0
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L40
            r0 = r10
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3b
            r2 = r1
            r3 = r5
            r2.<init>(r3)     // Catch: java.lang.Exception -> L3b
            r0.parseJson(r1)     // Catch: java.lang.Exception -> L3b
            r0 = r10
            long r0 = r0.gq     // Catch: java.lang.Exception -> L3b
            r1 = r8
            boolean r0 = b(r0, r1)     // Catch: java.lang.Exception -> L3b
            if (r0 == 0) goto L40
            r0 = r10
            int r0 = r0.rx     // Catch: java.lang.Exception -> L3b
            r7 = r0
            goto L42
        L3b:
            r5 = move-exception
            r0 = r5
            com.kwad.sdk.core.d.b.printStackTraceOnly(r0)
        L40:
            r0 = 0
            r7 = r0
        L42:
            r0 = r7
            r1 = r6
            if (r0 >= r1) goto L49
            r0 = 1
            return r0
        L49:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.reward.c.a.e(android.content.Context, int):boolean");
    }
}
