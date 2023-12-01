package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/at.class */
final /* synthetic */ class at implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40237a;
    private final float b;

    private at(TXVideoEditer tXVideoEditer, float f) {
        this.f40237a = tXVideoEditer;
        this.b = f;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, float f) {
        return new at(tXVideoEditer, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setSpecialRatio$5(this.f40237a, this.b);
    }
}
