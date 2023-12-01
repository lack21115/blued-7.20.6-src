package com.anythink.expressad.d;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/d/b.class */
public class b {
    public static final int b = 500;

    /* renamed from: c  reason: collision with root package name */
    public static final String f7136c = "anythink";

    /* renamed from: a  reason: collision with root package name */
    public static final String f7135a = b.class.getSimpleName();
    private static volatile b d = null;
    private static HashMap<String, c> e = new HashMap<>();
    private static a f = null;

    private b() {
    }

    public static b a() {
        if (d == null) {
            synchronized (b.class) {
                try {
                    if (d == null) {
                        d = new b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return d;
    }

    public static c a(String str, String str2) {
        c c2 = c(str, str2);
        c cVar = c2;
        if (c2 == null) {
            cVar = new c();
        }
        return cVar;
    }

    public static String a(String str) {
        return str == null ? "" : b().R();
    }

    private static void a(Context context, String str) {
        try {
            Map<String, ?> all = context.getSharedPreferences(com.anythink.expressad.foundation.g.a.o, 0).getAll();
            for (String str2 : all.keySet()) {
                if (str2.startsWith(str + BridgeUtil.UNDERLINE_STR)) {
                    e.put(str2, c.b((String) all.get(str2)));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(String str, String str2, String str3) {
        String str4 = str + BridgeUtil.UNDERLINE_STR + str2;
        com.anythink.expressad.foundation.a.a.a.a().a(str4, str3);
        e.put(str4, c.b(str3));
    }

    public static a b() {
        if (f == null) {
            f = c();
        }
        return f;
    }

    public static c b(String str, String str2) {
        c g = g(str, str2);
        c cVar = g;
        if (g == null) {
            cVar = new c();
        }
        return cVar;
    }

    public static String b(String str) {
        return com.anythink.expressad.foundation.a.a.a.a().a("ivreward_".concat(String.valueOf(str)));
    }

    public static a c() {
        a aVar = new a();
        aVar.A();
        aVar.B();
        aVar.y();
        aVar.z();
        aVar.w();
        aVar.u();
        aVar.m();
        aVar.a("anythink");
        aVar.j();
        aVar.p();
        aVar.o();
        aVar.s();
        aVar.e();
        aVar.d();
        aVar.f();
        aVar.g();
        aVar.h();
        aVar.i();
        aVar.c();
        aVar.c(com.anythink.expressad.d.a.b.df);
        aVar.a(120);
        aVar.O();
        aVar.N();
        aVar.a(100);
        aVar.Q();
        aVar.e(com.anythink.expressad.foundation.g.a.cH);
        aVar.d(com.anythink.expressad.foundation.g.a.cJ);
        aVar.c(com.anythink.expressad.foundation.g.a.cI);
        aVar.a();
        aVar.f(com.anythink.expressad.foundation.g.a.cO);
        aVar.b(10);
        return aVar;
    }

    public static c c(String str, String str2) {
        c g = g(str, str2);
        if (g != null && g.k() == 0) {
            g.l();
        }
        return g;
    }

    public static void c(String str) {
        com.anythink.expressad.foundation.a.a.a.a().b("ivreward_".concat(String.valueOf(str)));
    }

    private static c d(String str) {
        c cVar = new c();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        cVar.v();
        cVar.u();
        cVar.a(str);
        cVar.a(arrayList);
        cVar.b(arrayList2);
        cVar.p();
        cVar.r();
        cVar.q();
        cVar.o();
        cVar.n();
        cVar.j();
        cVar.l();
        cVar.c(100);
        cVar.d(0);
        cVar.h();
        cVar.e();
        cVar.c();
        cVar.w();
        cVar.x();
        return cVar;
    }

    public static c d(String str, String str2) {
        return g(str, str2);
    }

    public static void e(String str, String str2) {
        com.anythink.expressad.foundation.a.a.a.a().a("ivreward_".concat(String.valueOf(str)), str2);
    }

    private static void f(String str, String str2) {
        com.anythink.expressad.foundation.a.a.a.a().a(str, str2);
        a b2 = a.b(str2);
        f = b2;
        if (b2 != null) {
            b2.G();
        }
    }

    private static c g(String str, String str2) {
        String str3 = str;
        if (TextUtils.isEmpty(str)) {
            str3 = com.anythink.expressad.foundation.b.a.b().e();
        }
        String str4 = str3 + BridgeUtil.UNDERLINE_STR + str2;
        c cVar = null;
        if (e.containsKey(str4)) {
            return e.get(str4);
        }
        try {
            c b2 = c.b(com.anythink.expressad.foundation.a.a.a.a().a(str4));
            cVar = b2;
            e.put(str4, b2);
            cVar = b2;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return cVar;
    }
}
