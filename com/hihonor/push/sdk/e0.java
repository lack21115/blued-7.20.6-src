package com.hihonor.push.sdk;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/e0.class */
public class e0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j0 f8681a;
    public final /* synthetic */ f0 b;

    public e0(f0 f0Var, j0 j0Var) {
        this.b = f0Var;
        this.f8681a = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.f8684c) {
            v vVar = this.b.f8683a;
            if (vVar != null) {
                this.f8681a.b();
                ((l0) vVar).f8703a.countDown();
            }
        }
    }
}
