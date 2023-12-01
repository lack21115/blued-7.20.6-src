package com.anythink.core.common.k;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/a.class */
public abstract class a {
    private boolean a;
    private final com.anythink.core.common.i.a b = com.anythink.core.common.i.c.a();
    private final com.anythink.core.common.i.b c = new com.anythink.core.common.i.b() { // from class: com.anythink.core.common.k.a.1
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this) {
                if (!a.this.a) {
                    a.b(a.this);
                    a.this.b();
                }
            }
        }
    };

    static /* synthetic */ boolean b(a aVar) {
        aVar.a = true;
        return true;
    }

    private boolean c() {
        return this.a;
    }

    public final void a() {
        synchronized (this) {
            this.b.a(this.c);
        }
    }

    public final void a(long j) {
        synchronized (this) {
            this.b.a(this.c, j, false);
        }
    }

    protected abstract void b();
}
