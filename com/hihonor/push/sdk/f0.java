package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/f0.class */
public final class f0<TResult> implements t<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public v f22291a;
    public Executor b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f22292c = new Object();

    public f0(Executor executor, v vVar) {
        this.f22291a = vVar;
        this.b = executor;
    }

    @Override // com.hihonor.push.sdk.t
    public final void a(j0<TResult> j0Var) {
        if (j0Var.e()) {
            return;
        }
        j0Var.d();
        this.b.execute(new e0(this, j0Var));
    }
}
