package com.zx.a.I8b7;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/k2.class */
public class k2 implements Runnable {
    public k2(e2 e2Var, boolean z) {
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            e2.a().a(false);
        } catch (Throwable th) {
            m.b(th.getMessage());
        }
    }
}
