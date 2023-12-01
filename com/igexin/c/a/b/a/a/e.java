package com.igexin.c.a.b.a.a;

import android.text.TextUtils;
import com.igexin.c.a.b.a.a.a;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/e.class */
public final class e extends a {
    private static final String P = "GS-R";

    /* renamed from: a  reason: collision with root package name */
    public static final int f9623a = -2035;
    private byte[] Q;
    protected h j;
    com.igexin.c.a.b.a.a.a.b k;
    protected com.igexin.c.a.b.d l;

    public e(h hVar, com.igexin.c.a.b.d dVar) {
        super(-2035, dVar);
        this.l = dVar;
        this.j = hVar;
    }

    private void a(com.igexin.c.a.b.a.a.a.b bVar) {
        this.k = bVar;
    }

    @Override // com.igexin.c.a.b.f, com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public final void a() {
        super.a();
        com.igexin.c.a.c.a.a(P, "rt dispose");
        com.igexin.c.a.c.a.a("GS-R|rt dispose", new Object[0]);
        if (this.k != null) {
            if (this.g != a.EnumC0276a.b) {
                this.k.a();
            } else if (!TextUtils.isEmpty(this.h)) {
                this.k.a(new Exception(this.h));
            }
        }
        if (this.Q != null) {
            this.Q = null;
        }
        this.k = null;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws Exception {
        super.b_();
        Thread currentThread = Thread.currentThread();
        com.igexin.c.a.c.a.a("GS-R|" + currentThread + " running", new Object[0]);
        while (this.i && !currentThread.isInterrupted() && !this.f) {
            try {
                com.igexin.c.a.d.a.e b = this.l.b(null, this.j);
                if (b != null) {
                    com.igexin.c.a.b.e.a().a(b);
                    com.igexin.c.a.b.e.a().b();
                } else {
                    com.igexin.c.a.c.a.a(P, "read error data");
                    com.igexin.c.a.c.a.a("GS-R|read error data", new Object[0]);
                }
                this.g = a.EnumC0276a.f9612a;
            } catch (Throwable th) {
                this.i = false;
                if (this.g != a.EnumC0276a.f9613c) {
                    this.g = a.EnumC0276a.b;
                    this.h = (th.getMessage() == null || !th.getMessage().equals("read = -1, end of stream !")) ? th.toString() : "end of stream";
                }
                com.igexin.c.a.c.a.a(th);
            }
        }
        boolean z = this.i;
        currentThread.isInterrupted();
        boolean z2 = this.f;
        this.f = true;
        com.igexin.c.a.c.a.a("GS-R|finish ~~~~~~", new Object[0]);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2035;
    }

    @Override // com.igexin.c.a.b.a.a.a
    public final void c_() {
        boolean z = this.i;
        boolean z2 = this.f;
        this.i = false;
        this.g = a.EnumC0276a.f9613c;
    }
}
