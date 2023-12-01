package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/bj.class */
final /* synthetic */ class bj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final bd f36923a;

    private bj(bd bdVar) {
        this.f36923a = bdVar;
    }

    public static Runnable a(bd bdVar) {
        return new bj(bdVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        bd.d(this.f36923a);
    }
}
