package com.tencent.ugc;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/q.class */
final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40441a;
    private final List b;

    private q(TXVideoEditer tXVideoEditer, List list) {
        this.f40441a = tXVideoEditer;
        this.b = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list) {
        return new q(tXVideoEditer, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setSpeedList$23(this.f40441a, this.b);
    }
}
