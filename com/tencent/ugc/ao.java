package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ao.class */
final /* synthetic */ class ao implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40231a;

    private ao(TXVideoEditer tXVideoEditer) {
        this.f40231a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new ao(tXVideoEditer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$previewAtTime$44(this.f40231a);
    }
}
