package com.tencent.ugc;

import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/o.class */
final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40439a;
    private final List b;

    private o(TXVideoEditer tXVideoEditer, List list) {
        this.f40439a = tXVideoEditer;
        this.b = list;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, List list) {
        return new o(tXVideoEditer, list);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setPasterList$21(this.f40439a, this.b);
    }
}
