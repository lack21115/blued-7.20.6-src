package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/aw.class */
final /* synthetic */ class aw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40241a;
    private final float b;

    private aw(TXVideoEditer tXVideoEditer, float f) {
        this.f40241a = tXVideoEditer;
        this.b = f;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, float f) {
        return new aw(tXVideoEditer, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setVideoVolume$51(this.f40241a, this.b);
    }
}
