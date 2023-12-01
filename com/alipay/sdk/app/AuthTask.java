package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.sys.a;
import com.alipay.sdk.util.e;
import com.alipay.sdk.util.l;
import java.util.Map;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/AuthTask.class */
public class AuthTask {

    /* renamed from: a  reason: collision with root package name */
    static final Object f4572a = com.alipay.sdk.util.e.class;
    private Activity b;

    /* renamed from: c  reason: collision with root package name */
    private com.alipay.sdk.widget.a f4573c;

    public AuthTask(Activity activity) {
        this.b = activity;
        com.alipay.sdk.sys.b.a().a(this.b);
        this.f4573c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.f4680c);
    }

    private e.a a() {
        return new a(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001d, code lost:
        if (r0 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(android.app.Activity r7, java.lang.String r8, com.alipay.sdk.sys.a r9) {
        /*
            r6 = this;
            r0 = r9
            r1 = r8
            java.lang.String r0 = r0.a(r1)
            r11 = r0
            com.alipay.sdk.data.a r0 = com.alipay.sdk.data.a.j()
            java.util.List r0 = r0.i()
            r10 = r0
            com.alipay.sdk.data.a r0 = com.alipay.sdk.data.a.j()
            boolean r0 = r0.f4618a
            if (r0 == 0) goto L20
            r0 = r10
            r8 = r0
            r0 = r10
            if (r0 != 0) goto L24
        L20:
            java.util.List<com.alipay.sdk.data.a$a> r0 = com.alipay.sdk.app.i.f4599a
            r8 = r0
        L24:
            r0 = r9
            r1 = r6
            android.app.Activity r1 = r1.b
            r2 = r8
            boolean r0 = com.alipay.sdk.util.n.b(r0, r1, r2)
            if (r0 == 0) goto L76
            com.alipay.sdk.util.e r0 = new com.alipay.sdk.util.e
            r1 = r0
            r2 = r7
            r3 = r9
            r4 = r6
            com.alipay.sdk.util.e$a r4 = r4.a()
            r1.<init>(r2, r3, r4)
            r1 = r11
            java.lang.String r0 = r0.a(r1)
            r8 = r0
            r0 = r8
            java.lang.String r1 = "failed"
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 != 0) goto L65
            r0 = r8
            java.lang.String r1 = "scheme_failed"
            boolean r0 = android.text.TextUtils.equals(r0, r1)
            if (r0 == 0) goto L58
            goto L65
        L58:
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L63
            java.lang.String r0 = com.alipay.sdk.app.j.c()
            return r0
        L63:
            r0 = r8
            return r0
        L65:
            r0 = r9
            java.lang.String r1 = "biz"
            java.lang.String r2 = "LogBindCalledH5"
            com.alipay.sdk.app.statistic.a.a(r0, r1, r2)
            r0 = r6
            r1 = r7
            r2 = r11
            r3 = r9
            java.lang.String r0 = r0.b(r1, r2, r3)
            return r0
        L76:
            r0 = r9
            java.lang.String r1 = "biz"
            java.lang.String r2 = "LogCalledH5"
            com.alipay.sdk.app.statistic.a.a(r0, r1, r2)
            r0 = r6
            r1 = r7
            r2 = r11
            r3 = r9
            java.lang.String r0 = r0.b(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.a(android.app.Activity, java.lang.String, com.alipay.sdk.sys.a):java.lang.String");
    }

    private String a(com.alipay.sdk.sys.a aVar, com.alipay.sdk.protocol.b bVar) {
        String[] c2 = bVar.c();
        Bundle bundle = new Bundle();
        bundle.putString("url", c2[0]);
        Intent intent = new Intent(this.b, H5AuthActivity.class);
        intent.putExtras(bundle);
        a.C0050a.a(aVar, intent);
        this.b.startActivity(intent);
        synchronized (f4572a) {
            try {
                f4572a.wait();
            } catch (InterruptedException e) {
                return j.c();
            }
        }
        String a2 = j.a();
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            str = j.c();
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.app.Activity r6, java.lang.String r7, com.alipay.sdk.sys.a r8) {
        /*
            r5 = this;
            r0 = r5
            r0.b()
            com.alipay.sdk.packet.impl.a r0 = new com.alipay.sdk.packet.impl.a     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            r1 = r8
            r2 = r6
            r3 = r7
            com.alipay.sdk.packet.b r0 = r0.a(r1, r2, r3)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            org.json.JSONObject r0 = r0.c()     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            java.lang.String r1 = "form"
            org.json.JSONObject r0 = r0.optJSONObject(r1)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            java.lang.String r1 = "onload"
            org.json.JSONObject r0 = r0.optJSONObject(r1)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            java.util.List r0 = com.alipay.sdk.protocol.b.a(r0)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            r6 = r0
            r0 = r5
            r0.c()     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            r0 = 0
            r9 = r0
        L29:
            r0 = r9
            r1 = r6
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            if (r0 >= r1) goto L72
            r0 = r6
            r1 = r9
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            com.alipay.sdk.protocol.b r0 = (com.alipay.sdk.protocol.b) r0     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            com.alipay.sdk.protocol.a r0 = r0.b()     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            com.alipay.sdk.protocol.a r1 = com.alipay.sdk.protocol.a.WapPay     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            if (r0 != r1) goto L5f
            r0 = r5
            r1 = r8
            r2 = r6
            r3 = r9
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            com.alipay.sdk.protocol.b r2 = (com.alipay.sdk.protocol.b) r2     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            java.lang.String r0 = r0.a(r1, r2)     // Catch: java.lang.Throwable -> L68 java.io.IOException -> L7b
            r6 = r0
            r0 = r5
            r0.c()
            r0 = r6
            return r0
        L5f:
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L29
        L68:
            r6 = move-exception
            r0 = r8
            java.lang.String r1 = "biz"
            java.lang.String r2 = "H5AuthDataAnalysisError"
            r3 = r6
            com.alipay.sdk.app.statistic.a.a(r0, r1, r2, r3)     // Catch: java.lang.Throwable -> Laf
        L72:
            r0 = r5
            r0.c()
            r0 = 0
            r6 = r0
            goto L91
        L7b:
            r7 = move-exception
            com.alipay.sdk.app.k r0 = com.alipay.sdk.app.k.NETWORK_ERROR     // Catch: java.lang.Throwable -> Laf
            int r0 = r0.a()     // Catch: java.lang.Throwable -> Laf
            com.alipay.sdk.app.k r0 = com.alipay.sdk.app.k.b(r0)     // Catch: java.lang.Throwable -> Laf
            r6 = r0
            r0 = r8
            java.lang.String r1 = "net"
            r2 = r7
            com.alipay.sdk.app.statistic.a.a(r0, r1, r2)     // Catch: java.lang.Throwable -> Laf
            r0 = r5
            r0.c()
        L91:
            r0 = r6
            r7 = r0
            r0 = r6
            if (r0 != 0) goto La1
            com.alipay.sdk.app.k r0 = com.alipay.sdk.app.k.FAILED
            int r0 = r0.a()
            com.alipay.sdk.app.k r0 = com.alipay.sdk.app.k.b(r0)
            r7 = r0
        La1:
            r0 = r7
            int r0 = r0.a()
            r1 = r7
            java.lang.String r1 = r1.b()
            java.lang.String r2 = ""
            java.lang.String r0 = com.alipay.sdk.app.j.a(r0, r1, r2)
            return r0
        Laf:
            r6 = move-exception
            r0 = r5
            r0.c()
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.b(android.app.Activity, java.lang.String, com.alipay.sdk.sys.a):java.lang.String");
    }

    private void b() {
        com.alipay.sdk.widget.a aVar = this.f4573c;
        if (aVar != null) {
            aVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.alipay.sdk.widget.a aVar = this.f4573c;
        if (aVar != null) {
            aVar.c();
        }
    }

    public String auth(String str, boolean z) {
        String innerAuth;
        synchronized (this) {
            innerAuth = innerAuth(new com.alipay.sdk.sys.a(this.b, str, com.alipay.sdk.app.statistic.c.d), str, z);
        }
        return innerAuth;
    }

    public Map<String, String> authV2(String str, boolean z) {
        Map<String, String> a2;
        synchronized (this) {
            com.alipay.sdk.sys.a aVar = new com.alipay.sdk.sys.a(this.b, str, "authV2");
            a2 = l.a(aVar, innerAuth(aVar, str, z));
        }
        return a2;
    }

    public String innerAuth(com.alipay.sdk.sys.a aVar, String str, boolean z) {
        String c2;
        Activity activity;
        String str2;
        synchronized (this) {
            if (z) {
                b();
            }
            com.alipay.sdk.sys.b.a().a(this.b);
            c2 = j.c();
            i.a("");
            try {
                String a2 = a(this.b, str, aVar);
                com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.O, "" + SystemClock.elapsedRealtime());
                com.alipay.sdk.data.a.j().a(aVar, this.b);
                c();
                Activity activity2 = this.b;
                str2 = aVar.p;
                c2 = a2;
                activity = activity2;
            } catch (Exception e) {
                com.alipay.sdk.util.c.a(e);
                com.alipay.sdk.app.statistic.a.b(aVar, com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.O, "" + SystemClock.elapsedRealtime());
                com.alipay.sdk.data.a.j().a(aVar, this.b);
                c();
                activity = this.b;
                str2 = aVar.p;
            }
            com.alipay.sdk.app.statistic.a.b(activity, aVar, str, str2);
        }
        return c2;
    }
}
