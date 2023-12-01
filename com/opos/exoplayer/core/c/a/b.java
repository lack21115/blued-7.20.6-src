package com.opos.exoplayer.core.c.a;

import com.opos.exoplayer.core.c.n;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.o;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/a/b.class */
abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected final n f25083a;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/a/b$a.class */
    public static final class a extends o {
        public a(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(n nVar) {
        this.f25083a = nVar;
    }

    public final void a(m mVar, long j) {
        if (a(mVar)) {
            b(mVar, j);
        }
    }

    protected abstract boolean a(m mVar);

    protected abstract void b(m mVar, long j);
}
