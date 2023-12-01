package com.tencent.txcopyrightedmedia.impl.utils;

import android.text.TextUtils;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/ba.class */
public final class ba {

    /* renamed from: a  reason: collision with root package name */
    public b f40086a;
    public volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    public ax f40087c;
    public boolean d;
    public final ay e;
    public boolean f;
    final j g;

    public ba(b bVar, ay ayVar) {
        this.f40086a = bVar;
        this.e = ayVar;
        j jVar = new j(ayVar.d);
        this.g = jVar;
        String b = jVar.b();
        ax a2 = bVar.b.a(ayVar.f40080a, b);
        this.f40087c = a2;
        if (a2 == null) {
            this.f40087c = new ax(ayVar.f40080a, ayVar.b, b);
        } else if (TextUtils.equals(ayVar.b, this.f40087c.b)) {
        } else {
            this.f40087c.h = true;
            this.f40087c.b = ayVar.b;
        }
    }
}
