package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/c.class */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40282a;
    private final int b;

    private c(TXVideoEditer tXVideoEditer, int i) {
        this.f40282a = tXVideoEditer;
        this.b = i;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i) {
        return new c(tXVideoEditer, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$setPictureTransition$10(this.f40282a, this.b);
    }
}
