package com.tencent.liteav.audio.route;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/f.class */
final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRouteManager f22567a;
    private final String b;

    private f(AudioRouteManager audioRouteManager, String str) {
        this.f22567a = audioRouteManager;
        this.b = str;
    }

    public static Runnable a(AudioRouteManager audioRouteManager, String str) {
        return new f(audioRouteManager, str);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22567a.startInternal(this.b);
    }
}
