package com.tencent.liteav.txcvodplayer.renderer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/g.class */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f36570a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36571c;

    private g(c cVar, int i, int i2) {
        this.f36570a = cVar;
        this.b = i;
        this.f36571c = i2;
    }

    public static Runnable a(c cVar, int i, int i2) {
        return new g(cVar, i, i2);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f36570a, this.b, this.f36571c);
    }
}
