package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ap.class */
public final /* synthetic */ class ap implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26541a;
    private final TXVideoEditer.TXVideoGenerateListener b;

    private ap(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener) {
        this.f26541a = tXVideoEditer;
        this.b = tXVideoGenerateListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener) {
        return new ap(tXVideoEditer, tXVideoGenerateListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setVideoGenerateListener$45(this.f26541a, this.b);
    }
}
