package com.tencent.liteav.audio.earmonitor;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/c.class */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f22549a;

    private c(a aVar) {
        this.f22549a = aVar;
    }

    public static Runnable a(a aVar) {
        return new c(aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.c(this.f22549a);
    }
}
