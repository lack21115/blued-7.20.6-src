package com.tencent.liteav.audio.route;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/d.class */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRouteManager f36256a;
    private final boolean b;

    private d(AudioRouteManager audioRouteManager, boolean z) {
        this.f36256a = audioRouteManager;
        this.b = z;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, boolean z) {
        return new d(audioRouteManager, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36256a.handleBluetoothSCOChangedInternal(this.b);
    }
}
