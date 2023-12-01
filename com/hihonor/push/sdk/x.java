package com.hihonor.push.sdk;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/x.class */
public class x<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final j0<TResult> f8716a = new j0<>();

    public void a(Exception exc) {
        j0<TResult> j0Var = this.f8716a;
        synchronized (j0Var.f8699a) {
            if (!j0Var.b) {
                j0Var.b = true;
                j0Var.d = exc;
                j0Var.f8699a.notifyAll();
                j0Var.a();
            }
        }
    }

    public void a(TResult tresult) {
        j0<TResult> j0Var = this.f8716a;
        synchronized (j0Var.f8699a) {
            if (!j0Var.b) {
                j0Var.b = true;
                j0Var.f8700c = tresult;
                j0Var.f8699a.notifyAll();
                j0Var.a();
            }
        }
    }
}
