package com.tencent.open.a;

import com.tencent.open.a.d;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/a/i.class */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private volatile int f24549a;
    private volatile boolean b;

    /* renamed from: c  reason: collision with root package name */
    private h f24550c;

    public i() {
        this(c.f24540a, true, h.f24548a);
    }

    public i(int i, boolean z, h hVar) {
        this.f24549a = c.f24540a;
        this.b = true;
        this.f24550c = h.f24548a;
        a(i);
        a(z);
        a(hVar);
    }

    public void a(int i) {
        this.f24549a = i;
    }

    protected abstract void a(int i, Thread thread, long j, String str, String str2, Throwable th);

    public void a(h hVar) {
        this.f24550c = hVar;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b(int i, Thread thread, long j, String str, String str2, Throwable th) {
        if (d() && d.a.a(this.f24549a, i)) {
            a(i, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        return this.b;
    }

    public h e() {
        return this.f24550c;
    }
}
