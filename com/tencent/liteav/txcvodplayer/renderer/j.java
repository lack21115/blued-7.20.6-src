package com.tencent.liteav.txcvodplayer.renderer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/j.class */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f22883a;

    private j(c cVar) {
        this.f22883a = cVar;
    }

    public static Runnable a(c cVar) {
        return new j(cVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f22883a);
    }
}
