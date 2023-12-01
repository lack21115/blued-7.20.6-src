package com.vivo.push.util;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/util/w.class */
public final class w extends b {
    private static w b;

    public static w b() {
        w wVar;
        synchronized (w.class) {
            try {
                if (b == null) {
                    b = new w();
                }
                wVar = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    private static byte[] c(String str) {
        int i;
        byte[] bArr;
        byte[] bArr2 = null;
        try {
            String[] split = str.split(",");
            int i2 = 0;
            if (split.length > 0) {
                bArr = new byte[split.length];
                i = split.length;
            } else {
                i = 0;
                bArr = null;
            }
            while (true) {
                bArr2 = bArr;
                if (i2 >= i) {
                    break;
                }
                bArr2 = bArr;
                bArr[i2] = Byte.parseByte(split[i2].trim());
                i2++;
            }
        } catch (Exception e) {
            p.a("SharePreferenceManager", "getCodeBytes error:" + e.getMessage());
        }
        return bArr2;
    }

    public final void a(Context context) {
        synchronized (this) {
            if (this.f41131a == null) {
                this.f41131a = context;
                a(context, "com.vivo.push_preferences");
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (r0.length <= 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] c() {
        /*
            r5 = this;
            r0 = r5
            java.lang.String r1 = "com.vivo.push.secure_cache_iv"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.b(r1, r2)
            byte[] r0 = c(r0)
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L17
            r0 = r7
            r6 = r0
            r0 = r7
            int r0 = r0.length
            if (r0 > 0) goto L78
        L17:
            r0 = 16
            byte[] r0 = new byte[r0]
            r6 = r0
            r0 = r6
            r1 = r0
            r2 = 0
            r3 = 34
            r1[r2] = r3
            r1 = r0
            r2 = 1
            r3 = 32
            r1[r2] = r3
            r1 = r0
            r2 = 2
            r3 = 33
            r1[r2] = r3
            r1 = r0
            r2 = 3
            r3 = 37
            r1[r2] = r3
            r1 = r0
            r2 = 4
            r3 = 33
            r1[r2] = r3
            r1 = r0
            r2 = 5
            r3 = 34
            r1[r2] = r3
            r1 = r0
            r2 = 6
            r3 = 32
            r1[r2] = r3
            r1 = r0
            r2 = 7
            r3 = 33
            r1[r2] = r3
            r1 = r0
            r2 = 8
            r3 = 33
            r1[r2] = r3
            r1 = r0
            r2 = 9
            r3 = 33
            r1[r2] = r3
            r1 = r0
            r2 = 10
            r3 = 34
            r1[r2] = r3
            r1 = r0
            r2 = 11
            r3 = 41
            r1[r2] = r3
            r1 = r0
            r2 = 12
            r3 = 35
            r1[r2] = r3
            r1 = r0
            r2 = 13
            r3 = 32
            r1[r2] = r3
            r1 = r0
            r2 = 14
            r3 = 32
            r1[r2] = r3
            r1 = r0
            r2 = 15
            r3 = 32
            r1[r2] = r3
        L78:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.w.c():byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (r0.length <= 0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] d() {
        /*
            r5 = this;
            r0 = r5
            java.lang.String r1 = "com.vivo.push.secure_cache_key"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.b(r1, r2)
            byte[] r0 = c(r0)
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L17
            r0 = r7
            r6 = r0
            r0 = r7
            int r0 = r0.length
            if (r0 > 0) goto L78
        L17:
            r0 = 16
            byte[] r0 = new byte[r0]
            r6 = r0
            r0 = r6
            r1 = r0
            r2 = 0
            r3 = 33
            r1[r2] = r3
            r1 = r0
            r2 = 1
            r3 = 34
            r1[r2] = r3
            r1 = r0
            r2 = 2
            r3 = 35
            r1[r2] = r3
            r1 = r0
            r2 = 3
            r3 = 36
            r1[r2] = r3
            r1 = r0
            r2 = 4
            r3 = 37
            r1[r2] = r3
            r1 = r0
            r2 = 5
            r3 = 38
            r1[r2] = r3
            r1 = r0
            r2 = 6
            r3 = 39
            r1[r2] = r3
            r1 = r0
            r2 = 7
            r3 = 40
            r1[r2] = r3
            r1 = r0
            r2 = 8
            r3 = 41
            r1[r2] = r3
            r1 = r0
            r2 = 9
            r3 = 32
            r1[r2] = r3
            r1 = r0
            r2 = 10
            r3 = 38
            r1[r2] = r3
            r1 = r0
            r2 = 11
            r3 = 37
            r1[r2] = r3
            r1 = r0
            r2 = 12
            r3 = 36
            r1[r2] = r3
            r1 = r0
            r2 = 13
            r3 = 35
            r1[r2] = r3
            r1 = r0
            r2 = 14
            r3 = 34
            r1[r2] = r3
            r1 = r0
            r2 = 15
            r3 = 33
            r1[r2] = r3
        L78:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.w.d():byte[]");
    }
}
