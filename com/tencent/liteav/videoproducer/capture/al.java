package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/al.class */
final /* synthetic */ class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah f36874a;

    private al(ah ahVar) {
        this.f36874a = ahVar;
    }

    public static Runnable a(ah ahVar) {
        return new al(ahVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah.a(this.f36874a);
    }
}
