package com.tencent.liteav.audio.route;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/c.class */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRouteManager f36255a;

    private c(AudioRouteManager audioRouteManager) {
        this.f36255a = audioRouteManager;
    }

    public static Runnable a(AudioRouteManager audioRouteManager) {
        return new c(audioRouteManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36255a.autoCheckRouteUpdate(true);
    }
}
