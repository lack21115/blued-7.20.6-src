package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bl.class */
final /* synthetic */ class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26570a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f26571c;

    private bl(TXVideoEditer tXVideoEditer, int i, int i2) {
        this.f26570a = tXVideoEditer;
        this.b = i;
        this.f26571c = i2;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, int i2) {
        return new bl(tXVideoEditer, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setBeautyFilter$8(this.f26570a, this.b, this.f26571c);
    }
}
