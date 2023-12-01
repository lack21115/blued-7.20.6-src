package com.tencent.ugc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/al.class */
public final /* synthetic */ class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40228a;

    private al(TXVideoEditer tXVideoEditer) {
        this.f40228a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new al(tXVideoEditer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$pausePlay$41(this.f40228a);
    }
}
