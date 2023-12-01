package com.tencent.liteav.audio.route;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/d.class */
final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRouteManager f22565a;
    private final boolean b;

    private d(AudioRouteManager audioRouteManager, boolean z) {
        this.f22565a = audioRouteManager;
        this.b = z;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, boolean z) {
        return new d(audioRouteManager, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22565a.handleBluetoothSCOChangedInternal(this.b);
    }
}
