package com.tencent.liteav.audio.route;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/route/e.class */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final AudioRouteManager f22566a;

    private e(AudioRouteManager audioRouteManager) {
        this.f22566a = audioRouteManager;
    }

    public static Runnable a(AudioRouteManager audioRouteManager) {
        return new e(audioRouteManager);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22566a.notifyAudioIOSceneChangedInternal();
    }
}
