package com.hihonor.push.sdk;

import java.util.concurrent.Executor;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/b0.class */
public final class b0<TResult> implements t<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public l0 f22280a;
    public Executor b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f22281c = new Object();

    public b0(Executor executor, l0 l0Var) {
        this.f22280a = l0Var;
        this.b = executor;
    }

    @Override // com.hihonor.push.sdk.t
    public final void a(j0<TResult> j0Var) {
        j0Var.d();
    }
}
