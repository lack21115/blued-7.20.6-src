package com.tencent.liteav.videoproducer.capture;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/al.class */
final /* synthetic */ class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ah f23183a;

    private al(ah ahVar) {
        this.f23183a = ahVar;
    }

    public static Runnable a(ah ahVar) {
        return new al(ahVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ah.a(this.f23183a);
    }
}
