package com.tencent.ugc;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/t.class */
public final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40444a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final long f40445c;
    private final long d;
    private final AtomicBoolean e;

    private t(TXVideoEditer tXVideoEditer, int i, long j, long j2, AtomicBoolean atomicBoolean) {
        this.f40444a = tXVideoEditer;
        this.b = i;
        this.f40445c = j;
        this.d = j2;
        this.e = atomicBoolean;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, long j, long j2, AtomicBoolean atomicBoolean) {
        return new t(tXVideoEditer, i, j, j2, atomicBoolean);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setTransitionEffect$26(this.f40444a, this.b, this.f40445c, this.d, this.e);
    }
}
