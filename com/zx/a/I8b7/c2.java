package com.zx.a.I8b7;

import com.zx.a.I8b7.u1;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/c2.class */
public class c2 implements Runnable {
    public c2(e2 e2Var) {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            t2.o = 0;
            u1.a.f42208a.f42207a.c(0);
        } catch (Exception e) {
            StringBuilder a2 = m2.a("卓信ID拒绝授权 error: ");
            a2.append(e.getMessage());
            m.b(a2.toString());
        }
    }
}
