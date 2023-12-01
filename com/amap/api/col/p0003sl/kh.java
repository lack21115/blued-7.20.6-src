package com.amap.api.col.p0003sl;

import android.content.Context;

/* renamed from: com.amap.api.col.3sl.kh  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kh.class */
public final class kh {
    private Context a;
    private ia b;
    private String c;

    public kh(Context context, ia iaVar, String str) {
        this.a = context.getApplicationContext();
        this.b = iaVar;
        this.c = str;
    }

    private static String a(Context context, ia iaVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(iaVar.c());
            sb.append("\",\"product\":\"");
            sb.append(iaVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(hs.d(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] a() {
        return ib.a(a(this.a, this.b, this.c));
    }
}
