package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/e0.class */
public class e0 {

    /* renamed from: c  reason: collision with root package name */
    public static e0 f9130c;

    /* renamed from: a  reason: collision with root package name */
    public String f9131a;
    public String b;

    public static e0 f() {
        if (f9130c == null) {
            g();
        }
        return f9130c;
    }

    public static void g() {
        synchronized (e0.class) {
            try {
                if (f9130c == null) {
                    f9130c = new e0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String a() {
        if (TextUtils.isEmpty(this.f9131a)) {
            this.f9131a = c();
        }
        return this.f9131a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004a, code lost:
        if (e() != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r4
            boolean r0 = r0.e()
            if (r0 == 0) goto L11
            java.lang.String r0 = "analytics_keystore"
            r1 = r5
            java.lang.String r0 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.decrypt(r0, r1)
            r7 = r0
            goto L14
        L11:
            java.lang.String r0 = ""
            r7 = r0
        L14:
            r0 = r7
            r6 = r0
            r0 = r7
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L69
            java.lang.String r0 = "hmsSdk"
            java.lang.String r1 = "deCrypt work key first"
            com.huawei.hms.hatool.z.c(r0, r1)
            r0 = r5
            r1 = r4
            java.lang.String r1 = r1.d()
            java.lang.String r0 = com.huawei.hms.hatool.d.a(r0, r1)
            r5 = r0
            r0 = r5
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L53
            r0 = 16
            java.lang.String r0 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(r0)
            r5 = r0
            r0 = r4
            r1 = r4
            r2 = r5
            java.lang.String r1 = r1.b(r2)
            boolean r0 = r0.c(r1)
            r0 = r5
            r6 = r0
            r0 = r4
            boolean r0 = r0.e()
            if (r0 == 0) goto L69
        L4d:
            boolean r0 = com.huawei.hms.hatool.d0.d()
            r0 = r5
            return r0
        L53:
            r0 = r5
            r6 = r0
            r0 = r4
            boolean r0 = r0.e()
            if (r0 == 0) goto L69
            r0 = r4
            r1 = r4
            r2 = r5
            java.lang.String r1 = r1.b(r2)
            boolean r0 = r0.c(r1)
            goto L4d
        L69:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.e0.a(java.lang.String):java.lang.String");
    }

    public final String b(String str) {
        return e() ? AesGcmKS.encrypt("analytics_keystore", str) : d.b(str, d());
    }

    public void b() {
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        if (c(b(generateSecureRandomStr))) {
            this.f9131a = generateSecureRandomStr;
        }
    }

    public final String c() {
        String a2 = h0.a(b.i(), "Privacy_MY", "PrivacyData", "");
        if (TextUtils.isEmpty(a2)) {
            String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
            c(b(generateSecureRandomStr));
            return generateSecureRandomStr;
        }
        return a(a2);
    }

    public final boolean c(String str) {
        z.c("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            z.c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        h0.b(b.i(), "Privacy_MY", "PrivacyData", str);
        h0.b(b.i(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = new d0().a();
        }
        return this.b;
    }

    public final boolean e() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
