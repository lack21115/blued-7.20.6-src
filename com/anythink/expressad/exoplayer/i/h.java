package com.anythink.expressad.exoplayer.i;

import com.anythink.expressad.exoplayer.h.af;
import com.anythink.expressad.exoplayer.z;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/h.class */
public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private a f4707a;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/h$a.class */
    public interface a {
        void c();
    }

    public abstract i a(z[] zVarArr, af afVar);

    public final void a(a aVar) {
        this.f4707a = aVar;
    }

    public abstract void a(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        a aVar = this.f4707a;
        if (aVar != null) {
            aVar.c();
        }
    }
}
