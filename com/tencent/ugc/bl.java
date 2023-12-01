package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/bl.class */
final /* synthetic */ class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40261a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f40262c;

    private bl(TXVideoEditer tXVideoEditer, int i, int i2) {
        this.f40261a = tXVideoEditer;
        this.b = i;
        this.f40262c = i2;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i, int i2) {
        return new bl(tXVideoEditer, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setBeautyFilter$8(this.f40261a, this.b, this.f40262c);
    }
}
