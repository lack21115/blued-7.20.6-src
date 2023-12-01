package com.igexin.push.e.b;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/e/b/a.class */
public class a extends f {
    private static volatile a b;

    /* renamed from: a  reason: collision with root package name */
    private List<c> f9998a;

    private a() {
        super(60000L, (byte) 0);
        this.p = true;
        this.f9998a = new ArrayList();
    }

    public static a g() {
        if (b == null) {
            synchronized (a.class) {
                try {
                    if (b == null) {
                        b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private void h() {
        a(360000L, TimeUnit.MILLISECONDS);
    }

    public final boolean a(c cVar) {
        List<c> list = this.f9998a;
        return (list == null || list.contains(cVar) || !this.f9998a.add(cVar)) ? false : true;
    }

    @Override // com.igexin.push.e.b.f
    protected final void b() {
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.k();
        for (c cVar : this.f9998a) {
            if (cVar.b()) {
                cVar.a();
                cVar.a(System.currentTimeMillis());
            }
        }
        a(360000L, TimeUnit.MILLISECONDS);
        com.igexin.c.a.b.e.a().a((Object) this);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return 0;
    }
}
