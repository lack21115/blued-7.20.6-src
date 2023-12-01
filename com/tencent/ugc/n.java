package com.tencent.ugc;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/n.class */
final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26747a;
    private final List b;

    private n(TXVideoEditer tXVideoEditer, List list) {
        this.f26747a = tXVideoEditer;
        this.b = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list) {
        return new n(tXVideoEditer, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setAnimatedPasterList$20(this.f26747a, this.b);
    }
}
