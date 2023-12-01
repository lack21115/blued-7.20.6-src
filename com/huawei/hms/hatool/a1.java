package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/a1.class */
public class a1 {
    public static a1 b;

    /* renamed from: a  reason: collision with root package name */
    public Context f22733a;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/a1$a.class */
    public static class a extends b1 {

        /* renamed from: a  reason: collision with root package name */
        public String f22734a;
        public String b;

        public a(String str, String str2) {
            this.f22734a = str;
            this.b = str2;
        }

        @Override // com.huawei.hms.hatool.b1
        public String a() {
            return com.huawei.hms.hatool.a.d(this.f22734a, this.b);
        }

        @Override // com.huawei.hms.hatool.b1
        public String a(String str) {
            return SHA.sha256Encrypt(str);
        }

        @Override // com.huawei.hms.hatool.b1
        public String b() {
            return com.huawei.hms.hatool.a.g(this.f22734a, this.b);
        }

        @Override // com.huawei.hms.hatool.b1
        public String c() {
            return com.huawei.hms.hatool.a.j(this.f22734a, this.b);
        }

        @Override // com.huawei.hms.hatool.b1
        public int d() {
            int i = 0;
            int i2 = com.huawei.hms.hatool.a.k(this.f22734a, this.b) ? 4 : 0;
            if (com.huawei.hms.hatool.a.e(this.f22734a, this.b)) {
                i = 2;
            }
            return i2 | 0 | i | (com.huawei.hms.hatool.a.h(this.f22734a, this.b) ? 1 : 0);
        }
    }

    public static a1 a() {
        a1 a1Var;
        synchronized (a1.class) {
            try {
                if (b == null) {
                    b = new a1();
                }
                a1Var = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return a1Var;
    }

    public String a(String str, String str2) {
        return g.a(this.f22733a, str, str2);
    }

    public String a(boolean z) {
        if (z) {
            String e = b.e();
            String str = e;
            if (TextUtils.isEmpty(e)) {
                String a2 = h0.a(this.f22733a, "global_v2", "uuid", "");
                str = a2;
                if (TextUtils.isEmpty(a2)) {
                    str = UUID.randomUUID().toString().replace("-", "");
                    h0.b(this.f22733a, "global_v2", "uuid", str);
                }
                b.h(str);
            }
            return str;
        }
        return "";
    }

    public void a(Context context) {
        if (this.f22733a == null) {
            this.f22733a = context;
        }
    }

    public String b(String str, String str2) {
        return g.b(this.f22733a, str, str2);
    }

    public y0 c(String str, String str2) {
        return new a(str, str2).a(this.f22733a);
    }

    public String d(String str, String str2) {
        return d1.b(str, str2);
    }

    public Pair<String, String> e(String str, String str2) {
        if (com.huawei.hms.hatool.a.f(str, str2)) {
            String p = i.c().b().p();
            String q = i.c().b().q();
            if (TextUtils.isEmpty(p) || TextUtils.isEmpty(q)) {
                Pair<String, String> e = c1.e(this.f22733a);
                i.c().b().k(e.first);
                i.c().b().l(e.second);
                return e;
            }
            return new Pair<>(p, q);
        }
        return new Pair<>("", "");
    }

    public String f(String str, String str2) {
        return d1.a(str, str2);
    }
}
