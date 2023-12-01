package com.anythink.expressad.mbbanner.a.b;

import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.k;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/mbbanner/a/b/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8009a = "2000067";
    public static final String b = "2000068";

    /* renamed from: c  reason: collision with root package name */
    public static final String f8010c = "2000069";
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private int l;
    private boolean m;

    private c() {
    }

    private static c a() {
        return new c();
    }

    private c a(int i) {
        this.l = i;
        return this;
    }

    private c a(String str) {
        this.d = str;
        return this;
    }

    private c a(boolean z) {
        this.m = z;
        return this;
    }

    private c b(String str) {
        this.e = str;
        return this;
    }

    private String b() {
        return this.d;
    }

    private c c(String str) {
        this.f = str;
        return this;
    }

    private String c() {
        return this.e;
    }

    private c d(String str) {
        this.g = str;
        return this;
    }

    private String d() {
        return this.f;
    }

    private c e(String str) {
        this.h = str;
        return this;
    }

    private String e() {
        return this.g;
    }

    private c f(String str) {
        this.i = str;
        return this;
    }

    private String f() {
        return this.h;
    }

    private c g(String str) {
        this.j = str;
        return this;
    }

    private String g() {
        return this.i;
    }

    private c h(String str) {
        this.k = str;
        return this;
    }

    private String h() {
        return this.j;
    }

    private String i() {
        return this.k;
    }

    private int j() {
        return this.l;
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.e)) {
            sb.append("unit_id=");
            sb.append(this.e);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.g)) {
            sb.append("cid=");
            sb.append(this.g);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.h)) {
            sb.append("rid=");
            sb.append(this.h);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.i)) {
            sb.append("rid_n=");
            sb.append(this.i);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.j)) {
            sb.append("creative_id=");
            sb.append(this.j);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.k)) {
            sb.append("reason=");
            sb.append(this.k);
            sb.append("&");
        }
        if (this.l != 0) {
            sb.append("result=");
            sb.append(this.l);
            sb.append("&");
        }
        if (this.m) {
            sb.append("hb=1&");
        }
        sb.append("network_type=");
        n.a().g();
        sb.append(k.a());
        sb.append("&");
        if (!TextUtils.isEmpty(this.d)) {
            sb.append("key=");
            sb.append(this.d);
        }
        return sb.toString();
    }
}
