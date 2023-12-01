package com.anythink.core.common.k;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6780a;
    private final com.anythink.core.common.i.a b = com.anythink.core.common.i.c.a();

    /* renamed from: c  reason: collision with root package name */
    private final com.anythink.core.common.i.b f6781c = new com.anythink.core.common.i.b() { // from class: com.anythink.core.common.k.a.1
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this) {
                if (!a.this.f6780a) {
                    a.b(a.this);
                    a.this.b();
                }
            }
        }
    };

    static /* synthetic */ boolean b(a aVar) {
        aVar.f6780a = true;
        return true;
    }

    private boolean c() {
        return this.f6780a;
    }

    public final void a() {
        synchronized (this) {
            this.b.a(this.f6781c);
        }
    }

    public final void a(long j) {
        synchronized (this) {
            this.b.a(this.f6781c, j, false);
        }
    }

    protected abstract void b();
}
