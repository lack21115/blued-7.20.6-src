package com.anythink.basead;

import android.os.SystemClock;
import com.anythink.core.common.b.n;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    long f5910a;
    long b;

    /* renamed from: c  reason: collision with root package name */
    Runnable f5911c;
    boolean d = false;
    private final com.anythink.core.common.i.a f = com.anythink.core.common.i.c.a();
    com.anythink.core.common.i.b e = new com.anythink.core.common.i.b() { // from class: com.anythink.basead.d.1
        @Override // java.lang.Runnable
        public final void run() {
            d.this.d = false;
            d.this.b = -1L;
            n.a().a(d.this.f5911c);
        }
    };

    public d(long j, Runnable runnable) {
        this.b = j;
        this.f5911c = runnable;
    }

    public final void a() {
        synchronized (this) {
            if (this.b >= 0 && !this.d) {
                this.d = true;
                this.f5910a = SystemClock.elapsedRealtime();
                this.f.a(this.e, this.b);
            }
        }
    }

    public final void b() {
        synchronized (this) {
            if (this.d) {
                this.d = false;
                this.b -= SystemClock.elapsedRealtime() - this.f5910a;
                this.f.a(this.e);
            }
        }
    }

    public final void c() {
        synchronized (this) {
            this.d = false;
            this.f.a(this.e);
            this.b = -1L;
        }
    }
}
