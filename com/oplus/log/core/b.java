package com.oplus.log.core;

import com.oplus.log.core.e;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/core/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    static boolean f10642a = false;
    public d b;

    public final void a(c cVar) {
        this.b = new d(cVar);
    }

    public final void a(e.b bVar) {
        d dVar = this.b;
        if (dVar == null) {
            throw new RuntimeException("Please initialize Logan first");
        }
        dVar.a(bVar);
    }

    public final void a(i iVar) {
        this.b.a(iVar);
    }
}
