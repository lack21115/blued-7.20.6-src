package com.tencent.txcopyrightedmedia.impl.utils;

import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ba.class */
public final class ba {

    /* renamed from: a  reason: collision with root package name */
    public b f26395a;
    public volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    public ax f26396c;
    public boolean d;
    public final ay e;
    public boolean f;
    final j g;

    public ba(b bVar, ay ayVar) {
        this.f26395a = bVar;
        this.e = ayVar;
        j jVar = new j(ayVar.d);
        this.g = jVar;
        String b = jVar.b();
        ax a2 = bVar.b.a(ayVar.f26389a, b);
        this.f26396c = a2;
        if (a2 == null) {
            this.f26396c = new ax(ayVar.f26389a, ayVar.b, b);
        } else if (TextUtils.equals(ayVar.b, this.f26396c.b)) {
        } else {
            this.f26396c.h = true;
            this.f26396c.b = ayVar.b;
        }
    }
}
