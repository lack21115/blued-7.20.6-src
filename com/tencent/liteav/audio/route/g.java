package com.tencent.liteav.audio.route;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/g.class */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRouteManager f22568a;

    private g(AudioRouteManager audioRouteManager) {
        this.f22568a = audioRouteManager;
    }

    public static Runnable a(AudioRouteManager audioRouteManager) {
        return new g(audioRouteManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22568a.stopInternal();
    }
}
