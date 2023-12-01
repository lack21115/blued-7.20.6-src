package com.hihonor.push.sdk;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/g0.class */
public class g0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j0 f8686a;
    public final /* synthetic */ h0 b;

    public g0(h0 h0Var, j0 j0Var) {
        this.b = h0Var;
        this.f8686a = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.f8689c) {
            Object obj = this.b.f8688a;
            if (obj != null) {
                this.f8686a.c();
                ((l0) obj).f8703a.countDown();
            }
        }
    }
}
