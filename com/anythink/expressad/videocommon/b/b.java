package com.anythink.expressad.videocommon.b;

import com.anythink.core.common.res.a.a;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f8725a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f8726c;
    private com.anythink.core.common.res.a.a d;

    public b(String str, int i, int i2) {
        this.f8725a = str;
        this.b = i;
        this.f8726c = i2;
        com.anythink.core.common.res.a.a a2 = com.anythink.core.common.res.a.c.a().a(this.f8725a);
        this.d = a2;
        a2.a(new com.anythink.core.common.res.a.b(i, i2));
    }

    public final void a() {
        this.d.e();
    }

    public final void a(a.AbstractC0108a abstractC0108a) {
        this.d.a(abstractC0108a);
    }

    public final void b() {
        this.d.f();
    }
}
