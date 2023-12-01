package com.igexin.push.core.a.a;

import com.igexin.push.c.c.q;
import com.igexin.push.core.d;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/a/e.class */
public final class e extends com.igexin.push.core.a.a {
    private static final String b = com.igexin.push.config.c.f23373a + "_RegisterFailResultAction";

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        if ((obj instanceof q) && ((q) obj).b == 1) {
            com.igexin.c.a.c.a.a(b, "Register failed because of the wrong appid");
            com.igexin.c.a.c.a.a(b + "|Register failed because of the wrong appid", new Object[0]);
            com.igexin.c.a.c.a.d a2 = com.igexin.c.a.c.a.d.a();
            a2.a("Register failed because of the wrong appid = " + com.igexin.push.core.e.f23495a);
            com.igexin.push.core.e.q = true;
            d.a.f23474a.h.b();
            return true;
        }
        return true;
    }

    @Override // com.igexin.push.core.a.a
    public final void b() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean c() {
        return false;
    }
}
