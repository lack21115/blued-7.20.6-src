package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.col.p0003sl.jr;
import java.io.InputStream;

/* renamed from: com.amap.api.col.3sl.kl  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/kl.class */
public final class kl {
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
        if (r5.get() == null) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.amap.api.col.p0003sl.ke a(java.lang.ref.WeakReference<com.amap.api.col.p0003sl.ke> r5) {
        /*
            r0 = r5
            if (r0 == 0) goto Ld
            r0 = r5
            r6 = r0
            r0 = r5
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L1c
        Ld:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference
            r1 = r0
            com.amap.api.col.3sl.ke r2 = new com.amap.api.col.3sl.ke
            r3 = r2
            r3.<init>()
            r1.<init>(r2)
            r6 = r0
        L1c:
            r0 = r6
            java.lang.Object r0 = r0.get()
            com.amap.api.col.3sl.ke r0 = (com.amap.api.col.p0003sl.ke) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.kl.a(java.lang.ref.WeakReference):com.amap.api.col.3sl.ke");
    }

    public static String a() {
        return ib.a(System.currentTimeMillis());
    }

    public static String a(Context context, ia iaVar) {
        StringBuilder sb = new StringBuilder();
        try {
            String f = hs.f(context);
            sb.append("\"sim\":\"");
            sb.append(f);
            sb.append("\",\"sdkversion\":\"");
            sb.append(iaVar.c());
            sb.append("\",\"product\":\"");
            sb.append(iaVar.a());
            sb.append("\",\"ed\":\"");
            sb.append(iaVar.d());
            sb.append("\",\"nt\":\"");
            sb.append(hs.d(context));
            sb.append("\",\"np\":\"");
            sb.append(hs.b(context));
            sb.append("\",\"mnc\":\"");
            sb.append(hs.c(context));
            sb.append("\",\"ant\":\"");
            sb.append(hs.e(context));
            sb.append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    public static String a(String str, String str2, int i, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(i);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static String a(String str, String str2, String str3, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(",\"timestamp\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\",\"et\":\"");
        stringBuffer.append(1);
        stringBuffer.append("\",\"classname\":\"");
        stringBuffer.append(str3);
        stringBuffer.append("\",");
        stringBuffer.append("\"detail\":\"");
        stringBuffer.append(str4);
        stringBuffer.append("\"");
        return stringBuffer.toString();
    }

    public static void a(Context context, ke keVar, String str, int i, int i2, String str2) {
        keVar.f5266a = iu.c(context, str);
        keVar.d = i;
        keVar.b = i2;
        keVar.f5267c = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(jr jrVar, String str) {
        jr.b bVar;
        InputStream inputStream;
        byte[] bArr = new byte[0];
        try {
            jr.b a2 = jrVar.a(str);
            if (a2 == null) {
                if (a2 != null) {
                    try {
                        a2.close();
                        return bArr;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return bArr;
            }
            byte[] bArr2 = bArr;
            inputStream = null;
            try {
                InputStream a3 = a2.a();
                if (a3 == null) {
                    if (a3 != null) {
                        try {
                            a3.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                    if (a2 != null) {
                        try {
                            a2.close();
                            return bArr;
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                    return bArr;
                }
                byte[] bArr3 = new byte[a3.available()];
                bArr2 = bArr3;
                inputStream = a3;
                a3.read(bArr3);
                if (a3 != null) {
                    try {
                        a3.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                if (a2 != null) {
                    try {
                        a2.close();
                        return bArr3;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                    }
                }
                return bArr3;
            } catch (Throwable th6) {
                bArr = bArr2;
                bVar = a2;
                th = th6;
                try {
                    iw.c(th, "sui", "rdS");
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th7) {
                            th7.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                            return inputStream;
                        } catch (Throwable th8) {
                            th8.printStackTrace();
                            return inputStream;
                        }
                    }
                    return inputStream;
                } finally {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th9) {
                            th9.printStackTrace();
                        }
                    }
                    if (bVar != null) {
                        try {
                            bVar.close();
                        } catch (Throwable th10) {
                            th10.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th11) {
            th = th11;
            bVar = null;
            inputStream = null;
        }
    }
}
