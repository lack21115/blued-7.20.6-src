package com.igexin.push.core.a.a;

import com.igexin.push.c.c;
import com.igexin.push.core.j;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/a/a.class */
public final class a extends com.igexin.push.core.a.a {
    private static final String b = "HeartbeatAction";

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        if (obj instanceof com.igexin.push.c.c.f) {
            c.b.f9727a.d();
            com.igexin.c.a.c.a.a("heartbeatRsp", new Object[0]);
            j.a().a(j.a.f9958a);
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
