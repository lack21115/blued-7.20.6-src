package com.tencent.liteav.audio.route;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/j.class */
final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRouteManager f36262a;
    private final boolean b;

    private j(AudioRouteManager audioRouteManager, boolean z) {
        this.f36262a = audioRouteManager;
        this.b = z;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, boolean z) {
        return new j(audioRouteManager, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36262a.handleWiredHeadsetChangedInternal(this.b);
    }
}
