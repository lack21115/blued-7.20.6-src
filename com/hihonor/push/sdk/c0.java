package com.hihonor.push.sdk;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/c0.class */
public class c0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j0 f8675a;
    public final /* synthetic */ d0 b;

    public c0(d0 d0Var, j0 j0Var) {
        this.b = d0Var;
        this.f8675a = j0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.f8679c) {
            u<TResult> uVar = this.b.f8678a;
            if (uVar != 0) {
                uVar.a(this.f8675a);
            }
        }
    }
}
