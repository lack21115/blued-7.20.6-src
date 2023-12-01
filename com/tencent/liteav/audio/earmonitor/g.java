package com.tencent.liteav.audio.earmonitor;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/audio/earmonitor/g.class */
final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f36244a;
    private final int b;

    private g(a aVar, int i) {
        this.f36244a = aVar;
        this.b = i;
    }

    public static Runnable a(a aVar, int i) {
        return new g(aVar, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f36244a, this.b);
    }
}
