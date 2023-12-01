package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/y.class */
public class y {
    public static y b = new y();

    /* renamed from: a  reason: collision with root package name */
    public a f9193a = new a();

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/y$a.class */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f9194a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public long f9195c = 0;

        public a() {
        }

        public void a(long j) {
            y.this.f9193a.f9195c = j;
        }

        public void a(String str) {
            y.this.f9193a.b = str;
        }

        public void b(String str) {
            y.this.f9193a.f9194a = str;
        }
    }

    public static y d() {
        return b;
    }

    public String a() {
        return this.f9193a.b;
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
        this.f9193a.a(b2);
        this.f9193a.b(generateSecureRandomStr);
        this.f9193a.a(a2);
    }

    public long b() {
        return this.f9193a.f9195c;
    }

    public String c() {
        return this.f9193a.f9194a;
    }
}
