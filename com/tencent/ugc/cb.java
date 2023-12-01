package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cb.class */
final /* synthetic */ class cb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f40284a;

    private cb(TXVideoEditer tXVideoEditer) {
        this.f40284a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new cb(tXVideoEditer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40284a.pausePlay();
    }
}
