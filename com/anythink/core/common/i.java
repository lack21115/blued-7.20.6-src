package com.anythink.core.common;

import android.text.TextUtils;
import com.anythink.core.common.b.g;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static volatile i f6759a;

    private i() {
    }

    public static i a() {
        if (f6759a == null) {
            synchronized (i.class) {
                try {
                    if (f6759a == null) {
                        f6759a = new i();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f6759a;
    }

    public static String a(com.anythink.core.c.d dVar) {
        String r = dVar.r();
        String str = r;
        if (TextUtils.isEmpty(r)) {
            str = "";
        }
        return str;
    }

    public static String a(com.anythink.core.c.d dVar, boolean z) {
        if (z) {
            String v = dVar.v();
            dVar.an();
            if (!TextUtils.isEmpty(v)) {
                return v;
            }
        }
        com.anythink.core.common.e.n r = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p()).r();
        String str = m() ? g.c.x : g.c.l;
        return r != null ? a(r.c(), str) : str;
    }

    private static String a(String str) {
        return str;
    }

    private static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : str;
    }

    public static String b() {
        return m() ? g.c.s : g.c.g;
    }

    public static String b(com.anythink.core.c.d dVar) {
        return dVar.q();
    }

    public static String c() {
        return m() ? g.c.t : g.c.h;
    }

    public static String d() {
        return m() ? g.c.w : g.c.k;
    }

    public static String e() {
        return m() ? g.c.C : g.c.r;
    }

    public static String f() {
        com.anythink.core.common.e.n r = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p()).r();
        String str = m() ? g.c.y : g.c.m;
        return r != null ? a(r.b(), str) : str;
    }

    public static String g() {
        com.anythink.core.common.e.n r = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p()).r();
        String str = m() ? g.c.z : g.c.n;
        return r != null ? a(r.d(), str) : str;
    }

    public static String h() {
        com.anythink.core.common.e.n r = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p()).r();
        String str = m() ? g.c.A : g.c.o;
        return r != null ? a(r.a(), str) : str;
    }

    public static String i() {
        com.anythink.core.c.a b = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p());
        String str = m() ? g.c.B : g.c.q;
        return b != null ? a(b.o(), str) : str;
    }

    public static String j() {
        com.anythink.core.c.a b = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p());
        String str = m() ? g.c.v : g.c.j;
        return b != null ? a(b.X(), str) : str;
    }

    public static String k() {
        com.anythink.core.c.a b = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p());
        String str = m() ? g.c.u : g.c.i;
        return b != null ? a(b.ac(), str) : str;
    }

    public static String l() {
        com.anythink.core.c.a b = com.anythink.core.c.b.a(com.anythink.core.common.b.n.a().g()).b(com.anythink.core.common.b.n.a().p());
        return b != null ? a(b.T(), g.q.f6524a) : g.q.f6524a;
    }

    private static boolean m() {
        return com.anythink.core.common.b.n.a().D() && com.anythink.core.common.b.n.a().C();
    }
}
