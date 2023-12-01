package com.tencent.ugc;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/cc.class */
final /* synthetic */ class cc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26594a;

    private cc(TXVideoEditer tXVideoEditer) {
        this.f26594a = tXVideoEditer;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer) {
        return new cc(tXVideoEditer);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26594a.resumePlay();
    }
}
