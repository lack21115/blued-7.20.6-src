package com.tencent.liteav.txcvodplayer.renderer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/g.class */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f22879a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22880c;

    private g(c cVar, int i, int i2) {
        this.f22879a = cVar;
        this.b = i;
        this.f22880c = i2;
    }

    public static Runnable a(c cVar, int i, int i2) {
        return new g(cVar, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f22879a, this.b, this.f22880c);
    }
}
