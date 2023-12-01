package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/e1.class */
public class e1 extends v {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/e1$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f22740a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[z0.values().length];
            f22740a = iArr;
            try {
                iArr[z0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22740a[z0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22740a[z0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static f1 a(String str, String str2) {
        f1 a2 = v.a(str, str2);
        y0 c2 = a1.a().c(str, str2);
        a2.g(a1.a().a(c.c(str, str2)));
        a2.f(c.o(str, str2));
        a2.c(a1.a().f(str, str2));
        int i = a.f22740a[c2.a().ordinal()];
        if (i == 1) {
            a2.d(c2.b());
            return a2;
        } else if (i == 2) {
            a2.b(c2.b());
            return a2;
        } else if (i != 3) {
            return a2;
        } else {
            a2.e(c2.b());
            return a2;
        }
    }

    public static g1 a(String str, String str2, String str3, String str4) {
        g1 a2 = v.a(str, str2, str3, str4);
        String a3 = a1.a().a(c.c(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String sha256Encrypt = SHA.sha256Encrypt(b.f() + a3 + currentTimeMillis);
        a2.f(String.valueOf(currentTimeMillis));
        a2.g(sha256Encrypt);
        return a2;
    }

    public static h1 a(String str, String str2, String str3) {
        h1 a2 = v.a(str, str2, str3);
        Pair<String, String> e = a1.a().e(str2, str);
        a2.f(e.first);
        a2.g(e.second);
        a2.h(f.b());
        a2.d(a1.a().d(str2, str));
        return a2;
    }

    public static C1138r a(List<q> list, String str, String str2, String str3, String str4) {
        z.c("hmsSdk", "generate UploadData");
        C1138r b = v.b(str, str2);
        if (b == null) {
            return null;
        }
        b.a(a(y.d().a(), str, str2, str3));
        b.a(a(str, str2));
        b.a(a(str2, str, str4));
        b.a(c.g(str, str2));
        b.a(list);
        return b;
    }

    public static Map<String, String> b(String str, String str2, String str3) {
        Map<String, String> c2 = v.c(str, str3);
        Map<String, String> i = c.i(str, str2);
        if (i == null) {
            return c2;
        }
        c2.putAll(i);
        return c2;
    }
}
