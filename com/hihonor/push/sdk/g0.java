package com.hihonor.push.sdk;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/g0.class */
public class g0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j0 f22294a;
    public final /* synthetic */ h0 b;

    public g0(h0 h0Var, j0 j0Var) {
        this.b = h0Var;
        this.f22294a = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.f22297c) {
            Object obj = this.b.f22296a;
            if (obj != null) {
                this.f22294a.c();
                ((l0) obj).f22311a.countDown();
            }
        }
    }
}
