package com.hihonor.push.sdk;

import java.util.concurrent.Callable;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/i0.class */
public class i0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x f22299a;
    public final /* synthetic */ Callable b;

    public i0(x xVar, Callable callable) {
        this.f22299a = xVar;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f22299a.a((x) this.b.call());
        } catch (Exception e) {
            this.f22299a.a(e);
        }
    }
}
