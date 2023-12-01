package com.tencent.liteav.txcvodplayer.renderer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/d.class */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f36567a;

    private d(c cVar) {
        this.f36567a = cVar;
    }

    public static Runnable a(c cVar) {
        return new d(cVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.b(this.f36567a);
    }
}
