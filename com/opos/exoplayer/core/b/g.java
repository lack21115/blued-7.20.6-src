package com.opos.exoplayer.core.b;

import com.opos.exoplayer.core.b.e;
import com.opos.exoplayer.core.b.f;
import java.lang.Exception;
import java.util.LinkedList;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/b/g.class */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {

    /* renamed from: a  reason: collision with root package name */
    private final Thread f11388a;
    private final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final LinkedList<I> f11389c = new LinkedList<>();
    private final LinkedList<O> d = new LinkedList<>();
    private final I[] e;
    private final O[] f;
    private int g;
    private int h;
    private I i;
    private E j;
    private boolean k;
    private boolean l;
    private int m;

    public g(I[] iArr, O[] oArr) {
        this.e = iArr;
        this.g = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g) {
                break;
            }
            this.e[i2] = g();
            i = i2 + 1;
        }
        this.f = oArr;
        this.h = oArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.h) {
                Thread thread = new Thread() { // from class: com.opos.exoplayer.core.b.g.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        g.this.k();
                    }
                };
                this.f11388a = thread;
                thread.start();
                return;
            }
            this.f[i4] = h();
            i3 = i4 + 1;
        }
    }

    private void b(I i) {
        i.a();
        I[] iArr = this.e;
        int i2 = this.g;
        this.g = i2 + 1;
        iArr[i2] = i;
    }

    private void b(O o) {
        o.a();
        O[] oArr = this.f;
        int i = this.h;
        this.h = i + 1;
        oArr[i] = o;
    }

    private void i() {
        E e = this.j;
        if (e != null) {
            throw e;
        }
    }

    private void j() {
        if (m()) {
            this.b.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (l());
    }

    private boolean l() {
        synchronized (this.b) {
            while (!this.l && !m()) {
                this.b.wait();
            }
            if (this.l) {
                return false;
            }
            I removeFirst = this.f11389c.removeFirst();
            O[] oArr = this.f;
            int i = this.h - 1;
            this.h = i;
            O o = oArr[i];
            boolean z = this.k;
            this.k = false;
            if (removeFirst.c()) {
                o.b(4);
            } else {
                if (removeFirst.d_()) {
                    o.b(Integer.MIN_VALUE);
                }
                try {
                    this.j = a(removeFirst, o, z);
                } catch (OutOfMemoryError | RuntimeException e) {
                    this.j = a(e);
                }
                if (this.j != null) {
                    synchronized (this.b) {
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                if (!this.k) {
                    if (o.d_()) {
                        this.m++;
                    } else {
                        o.b = this.m;
                        this.m = 0;
                        this.d.addLast(o);
                        b((g<I, O, E>) removeFirst);
                    }
                }
                b((g<I, O, E>) o);
                b((g<I, O, E>) removeFirst);
            }
            return true;
        }
    }

    private boolean m() {
        return !this.f11389c.isEmpty() && this.h > 0;
    }

    protected abstract E a(I i, O o, boolean z);

    protected abstract E a(Throwable th);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        com.opos.exoplayer.core.i.a.b(this.g == this.e.length);
        for (I i2 : this.e) {
            i2.e(i);
        }
    }

    public final void a(I i) {
        synchronized (this.b) {
            i();
            com.opos.exoplayer.core.i.a.a(i == this.i);
            this.f11389c.addLast(i);
            j();
            this.i = null;
        }
    }

    public void a(O o) {
        synchronized (this.b) {
            b((g<I, O, E>) o);
            j();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.opos.exoplayer.core.b.c
    public /* bridge */ /* synthetic */ void a(Object obj) {
        a((g<I, O, E>) ((e) obj));
    }

    @Override // com.opos.exoplayer.core.b.c
    public final void c() {
        synchronized (this.b) {
            this.k = true;
            this.m = 0;
            if (this.i != null) {
                b((g<I, O, E>) this.i);
                this.i = null;
            }
            while (!this.f11389c.isEmpty()) {
                b((g<I, O, E>) this.f11389c.removeFirst());
            }
            while (!this.d.isEmpty()) {
                b((g<I, O, E>) this.d.removeFirst());
            }
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    public void d() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.f11388a.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    /* renamed from: e */
    public final I a() {
        I i;
        synchronized (this.b) {
            i();
            com.opos.exoplayer.core.i.a.b(this.i == null);
            if (this.g == 0) {
                i = null;
            } else {
                I[] iArr = this.e;
                int i2 = this.g - 1;
                this.g = i2;
                i = iArr[i2];
            }
            this.i = i;
        }
        return i;
    }

    @Override // com.opos.exoplayer.core.b.c
    /* renamed from: f */
    public final O b() {
        O removeFirst;
        synchronized (this.b) {
            i();
            removeFirst = this.d.isEmpty() ? null : this.d.removeFirst();
        }
        return removeFirst;
    }

    protected abstract I g();

    protected abstract O h();
}
