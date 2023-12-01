package com.tencent.liteav.txcvodplayer.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/e.class */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f36568a;
    private final boolean b;

    private e(c cVar, boolean z) {
        this.f36568a = cVar;
        this.b = z;
    }

    public static Runnable a(c cVar, boolean z) {
        return new e(cVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f36568a, this.b);
    }
}
