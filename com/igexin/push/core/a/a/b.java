package com.igexin.push.core.a.a;

import com.igexin.push.c.c.h;
import com.igexin.push.core.k;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/push/core/a/a/b.class */
public final class b extends com.igexin.push.core.a.a {
    private static final String b = "KeyNegotiateResultAction";

    @Override // com.igexin.push.core.a.a
    public final void a() {
    }

    @Override // com.igexin.push.core.a.a
    public final boolean a(Object obj) {
        if (obj instanceof h) {
            h hVar = (h) obj;
            boolean z = hVar.b == 0;
            com.igexin.c.a.c.a.a("KeyNegotiateResultAction|KeyNego result = " + ((int) hVar.b), new Object[0]);
            if (z) {
                com.igexin.c.a.c.a.a("KeyNegotiateResultAction|KeyNego success and login", new Object[0]);
                k.a();
                k.c();
                return true;
            }
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
