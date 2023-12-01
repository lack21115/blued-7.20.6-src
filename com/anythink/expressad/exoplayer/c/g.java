package com.anythink.expressad.exoplayer.c;

import com.anythink.expressad.exoplayer.c.e;
import com.anythink.expressad.exoplayer.c.f;
import java.lang.Exception;
import java.util.ArrayDeque;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/c/g.class */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {

    /* renamed from: a  reason: collision with root package name */
    private final Thread f7229a;
    private final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayDeque<I> f7230c = new ArrayDeque<>();
    private final ArrayDeque<O> d = new ArrayDeque<>();
    private final I[] e;
    private final O[] f;
    private int g;
    private int h;
    private I i;
    private E j;
    private boolean k;
    private boolean l;
    private int m;

    private g(I[] iArr, O[] oArr) {
        this.e = iArr;
        this.g = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g) {
                break;
            }
            this.e[i2] = h();
            i = i2 + 1;
        }
        this.f = oArr;
        this.h = oArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.h) {
                Thread thread = new Thread() { // from class: com.anythink.expressad.exoplayer.c.g.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        g.a(g.this);
                    }
                };
                this.f7229a = thread;
                thread.start();
                return;
            }
            this.f[i4] = i();
            i3 = i4 + 1;
        }
    }

    private void a(int i) {
        com.anythink.expressad.exoplayer.k.a.b(this.g == this.e.length);
        for (I i2 : this.e) {
            i2.d(i);
        }
    }

    static /* synthetic */ void a(g gVar) {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (gVar.o());
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

    private void l() {
        E e = this.j;
        if (e != null) {
            throw e;
        }
    }

    private void m() {
        if (p()) {
            this.b.notify();
        }
    }

    private void n() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (o());
    }

    private boolean o() {
        synchronized (this.b) {
            while (!this.l && !p()) {
                this.b.wait();
            }
            if (this.l) {
                return false;
            }
            I removeFirst = this.f7230c.removeFirst();
            O[] oArr = this.f;
            int i = this.h - 1;
            this.h = i;
            O o = oArr[i];
            this.k = false;
            if (removeFirst.c()) {
                o.b(4);
            } else {
                if (removeFirst.b()) {
                    o.b(Integer.MIN_VALUE);
                }
                try {
                    this.j = k();
                } catch (OutOfMemoryError e) {
                    this.j = j();
                } catch (RuntimeException e2) {
                    this.j = j();
                }
                if (this.j != null) {
                    synchronized (this.b) {
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                if (this.k) {
                    b((g<I, O, E>) o);
                } else if (o.b()) {
                    this.m++;
                    b((g<I, O, E>) o);
                } else {
                    o.b = this.m;
                    this.m = 0;
                    this.d.addLast(o);
                }
                b((g<I, O, E>) removeFirst);
            }
            return true;
        }
    }

    private boolean p() {
        return !this.f7230c.isEmpty() && this.h > 0;
    }

    public final void a(I i) {
        synchronized (this.b) {
            l();
            com.anythink.expressad.exoplayer.k.a.a(i == this.i);
            this.f7230c.addLast(i);
            m();
            this.i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(O o) {
        synchronized (this.b) {
            b((g<I, O, E>) o);
            m();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.anythink.expressad.exoplayer.c.c
    public final /* bridge */ /* synthetic */ void a(Object obj) {
        a((g<I, O, E>) ((e) obj));
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    public final void d() {
        synchronized (this.b) {
            this.k = true;
            this.m = 0;
            if (this.i != null) {
                b((g<I, O, E>) this.i);
                this.i = null;
            }
            while (!this.f7230c.isEmpty()) {
                b((g<I, O, E>) this.f7230c.removeFirst());
            }
            while (!this.d.isEmpty()) {
                b((g<I, O, E>) this.d.removeFirst());
            }
        }
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    public final void e() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.f7229a.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.anythink.expressad.exoplayer.c.c
    /* renamed from: f */
    public final I b() {
        I i;
        synchronized (this.b) {
            l();
            com.anythink.expressad.exoplayer.k.a.b(this.i == null);
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

    @Override // com.anythink.expressad.exoplayer.c.c
    /* renamed from: g */
    public final O c() {
        synchronized (this.b) {
            l();
            if (this.d.isEmpty()) {
                return null;
            }
            return this.d.removeFirst();
        }
    }

    protected abstract I h();

    protected abstract O i();

    protected abstract E j();

    protected abstract E k();
}
