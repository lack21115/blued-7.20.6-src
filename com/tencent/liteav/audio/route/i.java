package com.tencent.liteav.audio.route;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/i.class */
final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRouteManager f36261a;
    private final boolean b;

    private i(AudioRouteManager audioRouteManager, boolean z) {
        this.f36261a = audioRouteManager;
        this.b = z;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, boolean z) {
        return new i(audioRouteManager, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36261a.setHandFreeModeEnabledInternal(this.b);
    }
}
