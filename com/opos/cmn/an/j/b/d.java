package com.opos.cmn.an.j.b;

import java.util.concurrent.Executor;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/j/b/d.class */
public final class d<T, K> implements com.opos.cmn.an.j.a.b, com.opos.cmn.an.j.a.c<K>, com.opos.cmn.an.j.a.d<T> {

    /* renamed from: a  reason: collision with root package name */
    private com.opos.cmn.an.j.a.b f10902a;
    private com.opos.cmn.an.j.a.d<T> b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.cmn.an.j.a.c<K> f10903c;
    private Executor d;

    public d(Executor executor, com.opos.cmn.an.j.a.b bVar, com.opos.cmn.an.j.a.d<T> dVar, com.opos.cmn.an.j.a.c<K> cVar) {
        this.d = executor;
        this.f10902a = bVar;
        this.b = dVar;
        this.f10903c = cVar;
    }

    @Override // com.opos.cmn.an.j.a.b
    public void a() {
        if (this.f10902a != null) {
            this.d.execute(new Runnable() { // from class: com.opos.cmn.an.j.b.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.f10902a.a();
                }
            });
        }
    }

    @Override // com.opos.cmn.an.j.a.c
    public void a(final K k) {
        if (this.f10903c != null) {
            this.d.execute(new Runnable() { // from class: com.opos.cmn.an.j.b.d.2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    d.this.f10903c.a(k);
                }
            });
        }
    }

    @Override // com.opos.cmn.an.j.a.d
    public void b(final T t) {
        if (this.b != null) {
            this.d.execute(new Runnable() { // from class: com.opos.cmn.an.j.b.d.3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.lang.Runnable
                public void run() {
                    d.this.b.b(t);
                }
            });
        }
    }
}
