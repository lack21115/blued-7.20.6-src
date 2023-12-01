package com.igexin.c.a.b.a.a;

import android.text.TextUtils;
import com.igexin.c.a.b.a.a.a;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/g.class */
public final class g extends a {
    private static final String P = "GS-W";

    /* renamed from: a  reason: collision with root package name */
    public static final int f23233a = -2036;
    com.igexin.c.a.b.a.a.a.c j;
    protected com.igexin.c.a.b.d k;
    protected i l;

    public g(i iVar, com.igexin.c.a.b.d dVar) {
        super(-2036, dVar);
        this.k = dVar;
        this.l = iVar;
    }

    private void a(com.igexin.c.a.b.a.a.a.c cVar) {
        this.j = cVar;
    }

    @Override // com.igexin.c.a.b.f, com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public final void a() {
        super.a();
        com.igexin.c.a.c.a.a(P, "wt dispose");
        com.igexin.c.a.c.a.a("GS-W|wt dispose", new Object[0]);
        if (this.j != null) {
            if (this.g != a.EnumC0446a.b) {
                this.j.a();
            } else if (!TextUtils.isEmpty(this.h)) {
                this.j.a(new Exception(this.h));
            }
        }
        this.j = null;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws Exception {
        super.b_();
        Thread currentThread = Thread.currentThread();
        com.igexin.c.a.c.a.a("GS-W|" + currentThread + " running", new Object[0]);
        d a2 = d.a();
        while (this.i && !currentThread.isInterrupted() && !this.f) {
            a2.f.lock();
            if (a2.k.isEmpty() && this.i) {
                a2.g.await();
            }
            f poll = a2.k.poll();
            if (poll != null && this.i && this.l != null && this.i) {
                this.g = a.EnumC0446a.f23220a;
                if (this.j != null && this.i) {
                    this.j.a(poll);
                }
                if (poll.d != null) {
                    i iVar = this.l;
                    byte[] bArr = (byte[]) this.k.a(null, poll.d);
                    iVar.f23235a.write(bArr, 0, bArr.length);
                    iVar.f23235a.flush();
                }
                if (poll.d != null) {
                    com.igexin.c.a.c.a.a("GS-W|" + poll.d.getClass().getName() + " -- send success", new Object[0]);
                }
            }
            try {
                a2.f.unlock();
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
        this.f = true;
        com.igexin.c.a.c.a.a("GS-W|finish ~~~~~~", new Object[0]);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2036;
    }

    @Override // com.igexin.c.a.b.a.a.a
    public final void c_() {
        boolean z = this.i;
        boolean z2 = this.f;
        this.i = false;
        this.g = a.EnumC0446a.f23221c;
        d a2 = d.a();
        try {
            try {
                if (!this.f) {
                    a2.f.lock();
                    a2.g.signalAll();
                }
                try {
                    a2.f.unlock();
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                }
            } catch (Exception e2) {
                com.igexin.c.a.c.a.a(e2);
                com.igexin.c.a.c.a.a(P, e2.toString());
                try {
                    a2.f.unlock();
                } catch (Exception e3) {
                    com.igexin.c.a.c.a.a(e3);
                }
            }
        } catch (Throwable th) {
            try {
                a2.f.unlock();
            } catch (Exception e4) {
                com.igexin.c.a.c.a.a(e4);
            }
            throw th;
        }
    }
}
