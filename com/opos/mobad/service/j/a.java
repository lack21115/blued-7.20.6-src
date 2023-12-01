package com.opos.mobad.service.j;

import com.opos.mobad.service.j.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/j/a.class */
public class a<T, F extends c<T>> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private F f27389a;
    private d<F> b;

    /* renamed from: c  reason: collision with root package name */
    private b<F> f27390c;

    public a(F f, d<F> dVar, b<F> bVar) {
        this.f27389a = f;
        this.b = dVar;
        this.f27390c = bVar;
    }

    private void a(F f) {
        this.f27390c.a(f);
        f.a();
    }

    @Override // com.opos.mobad.service.j.b
    public void a(T t) {
        this.f27389a.a(t);
        if (this.b.a(this.f27389a)) {
            a((a<T, F>) this.f27389a);
        }
    }
}
