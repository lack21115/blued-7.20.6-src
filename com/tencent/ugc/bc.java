package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bc.class */
public final /* synthetic */ class bc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26559a;

    private bc(TXVideoEditer tXVideoEditer) {
        this.f26559a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new bc(tXVideoEditer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$onAudioEncodedFrameComplete$57(this.f26559a);
    }
}
