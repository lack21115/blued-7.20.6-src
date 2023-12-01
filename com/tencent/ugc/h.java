package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/h.class */
final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26738a;
    private final float b;

    private h(TXVideoEditer tXVideoEditer, float f) {
        this.f26738a = tXVideoEditer;
        this.b = f;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, float f) {
        return new h(tXVideoEditer, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setBGMVolume$15(this.f26738a, this.b);
    }
}
