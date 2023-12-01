package com.tencent.open.a;

import com.tencent.open.a.d;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a/i.class */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f38240a;
    private volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    private h f38241c;

    public i() {
        this(c.f38231a, true, h.f38239a);
    }

    public i(int i, boolean z, h hVar) {
        this.f38240a = c.f38231a;
        this.b = true;
        this.f38241c = h.f38239a;
        a(i);
        a(z);
        a(hVar);
    }

    public void a(int i) {
        this.f38240a = i;
    }

    protected abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public void a(h hVar) {
        this.f38241c = hVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f38240a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.b;
    }

    public h e() {
        return this.f38241c;
    }
}
