package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/aa.class */
final /* synthetic */ class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40214a;
    private final TXVideoEditer.TXVideoProcessListener b;

    private aa(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoProcessListener tXVideoProcessListener) {
        this.f40214a = tXVideoEditer;
        this.b = tXVideoProcessListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoProcessListener tXVideoProcessListener) {
        return new aa(tXVideoEditer, tXVideoProcessListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setVideoProcessListener$32(this.f40214a, this.b);
    }
}
