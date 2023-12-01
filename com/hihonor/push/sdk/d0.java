package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/d0.class */
public final class d0<TResult> implements t<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public u<TResult> f22286a;
    public Executor b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f22287c = new Object();

    public d0(Executor executor, u<TResult> uVar) {
        this.f22286a = uVar;
        this.b = executor;
    }

    @Override // com.hihonor.push.sdk.t
    public final void a(j0<TResult> j0Var) {
        this.b.execute(new c0(this, j0Var));
    }
}
