package com.tencent.liteav.audio.earmonitor;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/e.class */
final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f22551a;

    private e(a aVar) {
        this.f22551a = aVar;
    }

    public static Runnable a(a aVar) {
        return new e(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f22551a);
    }
}
