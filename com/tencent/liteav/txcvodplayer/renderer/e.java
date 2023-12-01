package com.tencent.liteav.txcvodplayer.renderer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/e.class */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f22877a;
    private final boolean b;

    private e(c cVar, boolean z) {
        this.f22877a = cVar;
        this.b = z;
    }

    public static Runnable a(c cVar, boolean z) {
        return new e(cVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f22877a, this.b);
    }
}
