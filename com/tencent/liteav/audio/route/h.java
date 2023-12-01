package com.tencent.liteav.audio.route;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/h.class */
final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRouteManager f22569a;
    private final int b;

    private h(AudioRouteManager audioRouteManager, int i) {
        this.f22569a = audioRouteManager;
        this.b = i;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, int i) {
        return new h(audioRouteManager, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        AudioRouteManager.lambda$notifyAudioIOSceneChanged$2(this.f22569a, this.b);
    }
}
