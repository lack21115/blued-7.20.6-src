package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fv.class */
public final /* synthetic */ class fv implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40399a;
    private final TXVideoEditer.TXVideoCustomProcessListener b;

    private fv(UGCVideoProcessor uGCVideoProcessor, TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        this.f40399a = uGCVideoProcessor;
        this.b = tXVideoCustomProcessListener;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, TXVideoEditer.TXVideoCustomProcessListener tXVideoCustomProcessListener) {
        return new fv(uGCVideoProcessor, tXVideoCustomProcessListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40399a.mTXVideoCustomProcessListener = this.b;
    }
}
