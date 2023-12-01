package com.igexin.push.b;

import android.text.TextUtils;
import com.igexin.push.b.b;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/g.class */
public final class g extends h implements i {
    private static g e;

    private g() {
        super(com.igexin.push.core.e.ap, com.igexin.push.core.e.f9888ar);
        this.d.j = false;
    }

    public static g a() {
        g gVar;
        synchronized (g.class) {
            try {
                if (e == null) {
                    e = new g();
                }
                gVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return gVar;
    }

    @Override // com.igexin.push.b.i
    public final void a(int i, d dVar) {
        e a2;
        if (dVar == null || TextUtils.isEmpty(dVar.a()) || (a2 = a(dVar.a())) == null) {
            return;
        }
        a(dVar);
        a2.a();
        m();
        if (i == b.a.f9694a) {
            l();
        }
    }

    @Override // com.igexin.push.b.i
    public final void b() {
    }

    @Override // com.igexin.push.b.h
    public final int c() {
        return b.EnumC0279b.b;
    }

    @Override // com.igexin.push.b.h
    public final i d() {
        return this;
    }
}
