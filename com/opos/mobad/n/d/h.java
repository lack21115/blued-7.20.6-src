package com.opos.mobad.n.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/d/h.class */
public class h {
    int A;
    int B;
    int C;
    int E;
    int F;
    String G;
    String H;
    String I;
    String J;
    g K;
    g L;

    /* renamed from: a  reason: collision with root package name */
    String f12946a;
    String b;
    g g;
    String i;
    g j;
    g k;
    String l;
    String m;
    String n;
    String o;
    int p;
    int q;
    String r;
    com.opos.mobad.n.c t;
    a u;
    long v;
    long w;
    com.opos.mobad.n.d x;
    String y;
    String z;

    /* renamed from: c  reason: collision with root package name */
    List<g> f12947c = new ArrayList();
    List<g> d = new ArrayList();
    List<String> e = new ArrayList();
    boolean f = false;
    String h = "广告";
    boolean s = false;
    int D = 0;
    int M = 0;

    public d a() {
        List<g> list;
        g gVar = this.j;
        if ((gVar == null || TextUtils.isEmpty(gVar.f12945a)) && ((list = this.f12947c) == null || list.size() <= 0)) {
            return null;
        }
        return new d(this);
    }

    public h a(int i) {
        this.E = i;
        return this;
    }

    public h a(long j, long j2) {
        this.v = j;
        this.w = j2;
        return this;
    }

    public h a(com.opos.mobad.n.c cVar) {
        this.t = cVar;
        return this;
    }

    public h a(a aVar) {
        this.u = aVar;
        return this;
    }

    public h a(com.opos.mobad.n.d dVar) {
        this.x = dVar;
        return this;
    }

    public h a(String str) {
        this.f12946a = str;
        return this;
    }

    public h a(String str, String str2) {
        this.f12947c.add(TextUtils.isEmpty(str2) ? new g(str) : new g(str, str2));
        return this;
    }

    public h a(String str, String str2, String str3) {
        this.m = str;
        this.n = str2;
        this.o = str3;
        return this;
    }

    public h a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str2)) {
            this.L = new g(str);
        } else {
            this.L = new g(str, str2);
        }
        this.n = str3;
        this.o = str4;
        return this;
    }

    public h a(boolean z) {
        this.f = z;
        return this;
    }

    public e b() {
        g gVar = this.k;
        if (gVar == null || TextUtils.isEmpty(gVar.f12945a)) {
            return null;
        }
        return new e(this);
    }

    public h b(int i) {
        this.F = i;
        return this;
    }

    public h b(String str) {
        this.b = str;
        return this;
    }

    public h b(String str, String str2) {
        this.d.add(TextUtils.isEmpty(str2) ? new g(str) : new g(str, str2));
        return this;
    }

    public h b(boolean z) {
        this.s = z;
        return this;
    }

    public c c() {
        if (TextUtils.isEmpty(this.m)) {
            return null;
        }
        return new c(this);
    }

    public h c(int i) {
        this.D = i;
        return this;
    }

    public h c(String str) {
        this.h = str;
        return this;
    }

    public h c(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.g = new g(str);
            return this;
        }
        this.g = new g(str, str2);
        return this;
    }

    public b d() {
        if (TextUtils.isEmpty(this.G)) {
            return null;
        }
        return new b(this);
    }

    public h d(int i) {
        this.C = i;
        return this;
    }

    public h d(String str) {
        this.i = str;
        return this;
    }

    public h d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        if (TextUtils.isEmpty(str2)) {
            this.j = new g(str);
            return this;
        }
        this.j = new g(str, str2);
        return this;
    }

    public f e() {
        return new f(this);
    }

    public h e(int i) {
        this.B = i;
        return this;
    }

    public h e(String str) {
        this.r = str;
        return this;
    }

    public h e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return this;
        }
        if (TextUtils.isEmpty(str2)) {
            this.k = new g(str);
            return this;
        }
        this.k = new g(str, str2);
        return this;
    }

    public h f(int i) {
        this.p = i;
        return this;
    }

    public h f(String str) {
        this.l = str;
        return this;
    }

    public h f(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            this.K = new g(str);
            return this;
        }
        this.K = new g(str, str2);
        return this;
    }

    public h g(int i) {
        this.q = i;
        return this;
    }

    public h g(String str) {
        this.y = str;
        return this;
    }

    public h h(int i) {
        this.A = i;
        return this;
    }

    public h h(String str) {
        this.z = str;
        return this;
    }

    public h i(int i) {
        this.M = i;
        return this;
    }

    public h i(String str) {
        this.G = str;
        return this;
    }

    public h j(String str) {
        this.J = str;
        return this;
    }

    public h k(String str) {
        this.I = str;
        return this;
    }

    public h l(String str) {
        this.H = str;
        return this;
    }
}
