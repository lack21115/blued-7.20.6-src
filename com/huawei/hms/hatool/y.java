package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/y.class */
public class y {
    public static y b = new y();

    /* renamed from: a  reason: collision with root package name */
    public a f22801a = new a();

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/y$a.class */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f22802a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public long f22803c = 0;

        public a() {
        }

        public void a(long j) {
            y.this.f22801a.f22803c = j;
        }

        public void a(String str) {
            y.this.f22801a.b = str;
        }

        public void b(String str) {
            y.this.f22801a.f22802a = str;
        }
    }

    public static y d() {
        return b;
    }

    public String a() {
        return this.f22801a.b;
    }

    public void a(String str, String str2) {
        long b2 = b();
        String b3 = s0.b(str, str2);
        if (b3 == null || b3.isEmpty()) {
            z.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (b2 == 0) {
            b2 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - b2 <= 43200000) {
            return;
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String a2 = e.a(b3, generateSecureRandomStr);
        this.f22801a.a(b2);
        this.f22801a.b(generateSecureRandomStr);
        this.f22801a.a(a2);
    }

    public long b() {
        return this.f22801a.f22803c;
    }

    public String c() {
        return this.f22801a.f22802a;
    }
}
