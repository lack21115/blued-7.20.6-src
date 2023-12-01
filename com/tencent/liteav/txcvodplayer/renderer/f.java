package com.tencent.liteav.txcvodplayer.renderer;

import com.tencent.liteav.videobase.videobase.DisplayTarget;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/f.class */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f36569a;
    private final DisplayTarget b;

    private f(c cVar, DisplayTarget displayTarget) {
        this.f36569a = cVar;
        this.b = displayTarget;
    }

    public static Runnable a(c cVar, DisplayTarget displayTarget) {
        return new f(cVar, displayTarget);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f36569a, this.b);
    }
}
