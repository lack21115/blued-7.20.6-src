package com.anythink.expressad.videocommon.b;

import com.anythink.core.common.res.a.a;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/videocommon/b/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private String f5885a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f5886c;
    private com.anythink.core.common.res.a.a d;

    public b(String str, int i, int i2) {
        this.f5885a = str;
        this.b = i;
        this.f5886c = i2;
        com.anythink.core.common.res.a.a a2 = com.anythink.core.common.res.a.c.a().a(this.f5885a);
        this.d = a2;
        a2.a(new com.anythink.core.common.res.a.b(i, i2));
    }

    public final void a() {
        this.d.e();
    }

    public final void a(a.a aVar) {
        this.d.a(aVar);
    }

    public final void b() {
        this.d.f();
    }
}
