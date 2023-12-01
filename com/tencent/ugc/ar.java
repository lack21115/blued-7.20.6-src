package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ar.class */
final /* synthetic */ class ar implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26544a;
    private final int b;

    private ar(TXVideoEditer tXVideoEditer, int i) {
        this.f26544a = tXVideoEditer;
        this.b = i;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i) {
        return new ar(tXVideoEditer, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setVideoBitrate$47(this.f26544a, this.b);
    }
}
