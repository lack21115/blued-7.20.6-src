package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/m1.class */
public abstract class m1 {

    /* renamed from: a  reason: collision with root package name */
    public static k1 f22772a;

    public static k1 a() {
        k1 k1Var;
        synchronized (m1.class) {
            try {
                if (f22772a == null) {
                    f22772a = p1.c().b();
                }
                k1Var = f22772a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return k1Var;
    }

    public static void a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !x0.b().a()) {
            return;
        }
        if (i == 1 || i == 0) {
            f22772a.a(i, str, linkedHashMap);
            return;
        }
        z.d("hmsSdk", "Data type no longer collects range.type: " + i);
    }

    @Deprecated
    public static void a(Context context, String str, String str2) {
        if (a() != null) {
            f22772a.a(context, str, str2);
        }
    }

    public static void b(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !x0.b().a()) {
            return;
        }
        if (i == 1 || i == 0) {
            f22772a.b(i, str, linkedHashMap);
            return;
        }
        z.d("hmsSdk", "Data type no longer collects range.type: " + i);
    }

    public static boolean b() {
        return p1.c().a();
    }

    public static void c() {
        if (a() == null || !x0.b().a()) {
            return;
        }
        f22772a.a(-1);
    }
}
