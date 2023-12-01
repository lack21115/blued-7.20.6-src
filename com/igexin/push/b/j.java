package com.igexin.push.b;

import android.text.TextUtils;
import com.igexin.push.b.b;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/b/j.class */
public final class j extends h implements i {
    private static j e;

    private j() {
        super(com.igexin.push.core.e.aq, com.igexin.push.core.e.as);
        this.d.j = true;
    }

    public static j a() {
        j jVar;
        synchronized (j.class) {
            try {
                if (e == null) {
                    e = new j();
                }
                jVar = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jVar;
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
        return b.EnumC0279b.f9696a;
    }

    @Override // com.igexin.push.b.h
    public final i d() {
        return this;
    }
}
