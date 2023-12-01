package com.tencent.txcopyrightedmedia.impl.utils;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/txcopyrightedmedia/impl/utils/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final e f40084a;
    public final c b;

    /* renamed from: c  reason: collision with root package name */
    public final d f40085c;
    public final g d;
    private final f e;
    private z f;

    public b(Context context) {
        int b;
        this.d = new g(context);
        f fVar = new f(context, this);
        this.e = fVar;
        this.f40084a = new e(fVar, this);
        this.b = new c(this.e);
        this.f40085c = new d();
        if (!g.b || (b = this.d.b()) == -1 || b == 1) {
            return;
        }
        this.f40084a.a();
        this.b.b();
        d.a();
    }

    public final z a() {
        if (this.f == null) {
            this.f = new z(this.e);
        }
        return this.f;
    }
}
