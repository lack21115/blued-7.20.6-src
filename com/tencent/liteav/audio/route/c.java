package com.tencent.liteav.audio.route;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/c.class */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRouteManager f22564a;

    private c(AudioRouteManager audioRouteManager) {
        this.f22564a = audioRouteManager;
    }

    public static Runnable a(AudioRouteManager audioRouteManager) {
        return new c(audioRouteManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22564a.autoCheckRouteUpdate(true);
    }
}
