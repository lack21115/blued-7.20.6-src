package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ba.class */
public final /* synthetic */ class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40248a;

    private ba(TXVideoEditer tXVideoEditer) {
        this.f40248a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new ba(tXVideoEditer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$onVideoEncodedFrameComplete$55(this.f40248a);
    }
}
