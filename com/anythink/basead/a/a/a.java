package com.anythink.basead.a.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/a/a.class */
public abstract class a<R, E> implements c<R, E> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f5828a = new AtomicBoolean(false);
    private final AtomicInteger b = new AtomicInteger(1);

    /* renamed from: c  reason: collision with root package name */
    private b<R, E> f5829c;

    @Override // com.anythink.basead.a.a.c
    public final void a() {
        if (!this.f5828a.get() && this.b.decrementAndGet() == 0) {
            this.f5828a.set(true);
            b<R, E> bVar = this.f5829c;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // com.anythink.basead.a.a.c
    public final void a(int i) {
        this.b.set(i);
    }

    @Override // com.anythink.basead.a.a.c
    public final void a(b<R, E> bVar) {
        this.f5829c = bVar;
    }

    @Override // com.anythink.basead.a.a.c
    public final void a(E e) {
        if (this.f5828a.get()) {
            return;
        }
        this.f5828a.set(true);
        b<R, E> bVar = this.f5829c;
        if (bVar != null) {
            bVar.a(e);
        }
    }
}
