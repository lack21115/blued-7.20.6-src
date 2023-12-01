package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/x.class */
final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40464a;
    private final TXVideoEditer.TXVideoCustomProcessListener b;

    private x(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        this.f40464a = tXVideoEditer;
        this.b = tXVideoCustomProcessListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        return new x(tXVideoEditer, tXVideoCustomProcessListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setCustomVideoProcessListener$3(this.f40464a, this.b);
    }
}
