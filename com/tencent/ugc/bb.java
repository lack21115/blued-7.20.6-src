package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bb.class */
public final /* synthetic */ class bb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26558a;
    private final AudioFrame b;

    private bb(TXVideoEditer tXVideoEditer, AudioFrame audioFrame) {
        this.f26558a = tXVideoEditer;
        this.b = audioFrame;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, AudioFrame audioFrame) {
        return new bb(tXVideoEditer, audioFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$onAudioEncodedFrame$56(this.f26558a, this.b);
    }
}
