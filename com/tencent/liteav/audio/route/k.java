package com.tencent.liteav.audio.route;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/k.class */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRouteManager f36263a;
    private final boolean b;

    private k(AudioRouteManager audioRouteManager, boolean z) {
        this.f36263a = audioRouteManager;
        this.b = z;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, boolean z) {
        return new k(audioRouteManager, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36263a.handleBluetoothHeadsetChangedInternal(this.b);
    }
}
