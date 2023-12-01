package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    static int f25153a = 0;
    static boolean b = false;
    private static f e;
    private static int h = 0;
    private static int i = 3;
    private static String k;

    /* renamed from: c  reason: collision with root package name */
    private u f25154c = null;
    private u d = null;
    private boolean f = false;
    private boolean g = false;
    private File j = null;

    private f() {
    }

    public static f a(boolean z) {
        if (e == null && z) {
            synchronized (f.class) {
                try {
                    if (e == null) {
                        e = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(int i2) {
        h = i2;
    }

    private void b(int i2) {
        Properties properties = new Properties();
        properties.setProperty(k, String.valueOf(i2));
        try {
            properties.store(new FileOutputStream(new File(this.j, "count.prop")), (String) null);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static int d() {
        return h;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int i() {
        /*
            r6 = this;
            r0 = 0
            r10 = r0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L69
            r1 = r0
            r2 = r6
            java.io.File r2 = r2.j     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L69
            java.lang.String r3 = "count.prop"
            r1.<init>(r2, r3)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L69
            r8 = r0
            r0 = r8
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L69
            if (r0 != 0) goto L1a
            r0 = 0
            return r0
        L1a:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L69
            r1 = r0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L69
            r3 = r2
            r4 = r8
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L69
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L69
            r9 = r0
            r0 = r9
            r8 = r0
            java.util.Properties r0 = new java.util.Properties     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L85
            r1 = r0
            r1.<init>()     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L85
            r10 = r0
            r0 = r9
            r8 = r0
            r0 = r10
            r1 = r9
            r0.load(r1)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L85
            r0 = r9
            r8 = r0
            r0 = r10
            java.lang.String r1 = com.tencent.smtt.sdk.f.k     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L85
            java.lang.String r2 = "1"
            java.lang.String r0 = r0.getProperty(r1, r2)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L85
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L85
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> L5d java.lang.Throwable -> L85
            r7 = r0
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> L56
            r0 = r7
            return r0
        L56:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()
            r0 = r7
            return r0
        L5d:
            r10 = move-exception
            goto L6d
        L62:
            r8 = move-exception
            r0 = r10
            r9 = r0
            goto L8c
        L69:
            r10 = move-exception
            r0 = 0
            r9 = r0
        L6d:
            r0 = r9
            r8 = r0
            r0 = r10
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L85
            r0 = r9
            if (r0 == 0) goto L83
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> L7e
            r0 = 0
            return r0
        L7e:
            r8 = move-exception
            r0 = r8
            r0.printStackTrace()
        L83:
            r0 = 0
            return r0
        L85:
            r10 = move-exception
            r0 = r8
            r9 = r0
            r0 = r10
            r8 = r0
        L8c:
            r0 = r9
            if (r0 == 0) goto L9c
            r0 = r9
            r0.close()     // Catch: java.io.IOException -> L97
            goto L9c
        L97:
            r9 = move-exception
            r0 = r9
            r0.printStackTrace()
        L9c:
            r0 = r8
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.f.i():int");
    }

    public u a() {
        if (this.f) {
            return this.f25154c;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0173 A[Catch: all -> 0x0239, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0002, B:8:0x0062, B:14:0x0092, B:17:0x00df, B:74:0x0313, B:75:0x0316, B:77:0x031f, B:79:0x032d, B:68:0x0296, B:70:0x02f1, B:73:0x02fb, B:22:0x00eb, B:24:0x00f2, B:26:0x0104, B:29:0x0129, B:49:0x0193, B:51:0x01a3, B:55:0x01b4, B:57:0x01ba, B:59:0x01c9, B:60:0x01cc, B:62:0x01f4, B:65:0x0232, B:63:0x0217, B:58:0x01c2, B:32:0x0137, B:35:0x0145, B:37:0x0162, B:42:0x0173, B:45:0x0181), top: B:98:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0181 A[Catch: all -> 0x0239, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0002, B:8:0x0062, B:14:0x0092, B:17:0x00df, B:74:0x0313, B:75:0x0316, B:77:0x031f, B:79:0x032d, B:68:0x0296, B:70:0x02f1, B:73:0x02fb, B:22:0x00eb, B:24:0x00f2, B:26:0x0104, B:29:0x0129, B:49:0x0193, B:51:0x01a3, B:55:0x01b4, B:57:0x01ba, B:59:0x01c9, B:60:0x01cc, B:62:0x01f4, B:65:0x0232, B:63:0x0217, B:58:0x01c2, B:32:0x0137, B:35:0x0145, B:37:0x0162, B:42:0x0173, B:45:0x0181), top: B:98:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x036d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.content.Context r11, boolean r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 883
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.f.a(android.content.Context, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        k = str;
    }

    public boolean b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(boolean z) {
        b = z;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u c() {
        return this.f25154c;
    }

    public String e() {
        return (this.f25154c == null || QbSdk.f25023a) ? "system webview get nothing..." : this.f25154c.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f() {
        if (b) {
            if (k == null) {
                return false;
            }
            int i2 = i();
            if (i2 == 0) {
                b(1);
            } else {
                int i3 = i2 + 1;
                if (i3 > i) {
                    return false;
                }
                b(i3);
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.g;
    }

    public boolean h() {
        return QbSdk.useSoftWare();
    }
}
