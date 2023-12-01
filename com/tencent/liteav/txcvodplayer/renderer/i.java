package com.tencent.liteav.txcvodplayer.renderer;

import com.tencent.liteav.videobase.utils.Rotation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/i.class */
public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f22882a;
    private final Rotation b;

    private i(c cVar, Rotation rotation) {
        this.f22882a = cVar;
        this.b = rotation;
    }

    public static Runnable a(c cVar, Rotation rotation) {
        return new i(cVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f22882a, this.b);
    }
}
