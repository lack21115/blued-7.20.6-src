package com.sdk.tencent.l;

import com.sdk.tencent.f.c;
import com.sdk.tencent.n.b;
import java.net.HttpURLConnection;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/l/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14372a = "com.sdk.tencent.l.a";
    public static final Boolean b = Boolean.valueOf(c.b);

    /* JADX WARN: Removed duplicated region for block: B:16:0x0049 A[Catch: all -> 0x00a1, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00a1, blocks: (B:6:0x001c, B:9:0x0026, B:11:0x0034, B:11:0x0034, B:12:0x0037, B:16:0x0049, B:22:0x005e, B:23:0x0068, B:24:0x0081, B:10:0x002e), top: B:35:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0081 A[EDGE_INSN: B:39:0x0081->B:24:0x0081 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r7) {
        /*
            java.lang.String r0 = com.sdk.tencent.base.module.manager.SDKManager.getUserAgent()
            r13 = r0
            r0 = r13
            r12 = r0
            r0 = r13
            java.lang.Boolean r0 = com.sdk.tencent.n.b.a(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L9e
            r0 = r13
            r11 = r0
            r0 = r7
            if (r0 == 0) goto L8b
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> La1
            r9 = r0
            r0 = r9
            r1 = 17
            if (r0 < r1) goto L2e
            r0 = r7
            java.lang.String r0 = android.webkit.WebSettings.getDefaultUserAgent(r0)     // Catch: java.lang.Throwable -> La1 java.lang.Exception -> La9
            r7 = r0
            goto L34
        L2e:
            java.lang.String r0 = "http.agent"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch: java.lang.Throwable -> La1
            r7 = r0
        L34:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La1 java.lang.Throwable -> La1
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> La1
            r11 = r0
            r0 = r7
            int r0 = r0.length()     // Catch: java.lang.Throwable -> La1
            r10 = r0
            r0 = 0
            r9 = r0
        L44:
            r0 = r9
            r1 = r10
            if (r0 >= r1) goto L81
            r0 = r7
            r1 = r9
            char r0 = r0.charAt(r1)     // Catch: java.lang.Throwable -> La1
            r8 = r0
            r0 = r8
            r1 = 31
            if (r0 <= r1) goto L68
            r0 = r8
            r1 = 127(0x7f, float:1.78E-43)
            if (r0 < r1) goto L5e
            goto L68
        L5e:
            r0 = r11
            r1 = r8
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> La1
            goto Lad
        L68:
            r0 = r11
            java.lang.String r1 = "\\u%04x"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> La1
            r3 = r2
            r4 = 0
            r5 = r8
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> La1
            r3[r4] = r5     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch: java.lang.Throwable -> La1
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> La1
            goto Lad
        L81:
            r0 = r11
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> La1
            r11 = r0
            goto L8b
        L8b:
            r0 = r11
            r12 = r0
            r0 = r11
            java.lang.Boolean r0 = com.sdk.tencent.n.b.a(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L9e
            java.lang.String r0 = "Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 %sSafari/533.1"
            r12 = r0
        L9e:
            r0 = r12
            return r0
        La1:
            r7 = move-exception
            r0 = r13
            r11 = r0
            goto L8b
        La9:
            r7 = move-exception
            goto L2e
        Lad:
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L44
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.tencent.l.a.a(android.content.Context):java.lang.String");
    }

    public static String a(HttpURLConnection httpURLConnection) {
        try {
            String headerField = httpURLConnection.getHeaderField("Content-Disposition");
            if (b.b(headerField).booleanValue()) {
                String str = new String(headerField.getBytes("ISO-8859-1"), "GBK");
                if (b.b(str).booleanValue()) {
                    return str.substring(str.indexOf(34) + 1, str.lastIndexOf("\""));
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            b.a(f14372a, th.getMessage(), b);
            return null;
        }
    }
}
