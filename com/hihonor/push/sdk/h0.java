package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/h0.class */
public final class h0<TResult> implements t<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public w<TResult> f22296a;
    public Executor b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f22297c = new Object();

    public h0(Executor executor, w<TResult> wVar) {
        this.f22296a = wVar;
        this.b = executor;
    }

    @Override // com.hihonor.push.sdk.t
    public final void a(j0<TResult> j0Var) {
        if (j0Var.e()) {
            j0Var.d();
            this.b.execute(new g0(this, j0Var));
        }
    }
}
