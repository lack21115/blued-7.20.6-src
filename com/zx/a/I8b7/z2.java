package com.zx.a.I8b7;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/z2.class */
public class z2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f28544a;
    public final /* synthetic */ a3 b;

    public z2(a3 a3Var, Context context) {
        this.b = a3Var;
        this.f28544a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            t2.a(this.f28544a);
        } catch (Throwable th) {
            n2.a(th, m2.a("ZXCore init failed: "));
            this.b.b.set(false);
        }
    }
}
