package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/as.class */
final /* synthetic */ class as implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40236a;
    private final int b;

    private as(TXVideoEditer tXVideoEditer, int i) {
        this.f40236a = tXVideoEditer;
        this.b = i;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i) {
        return new as(tXVideoEditer, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setAudioBitrate$48(this.f40236a, this.b);
    }
}
