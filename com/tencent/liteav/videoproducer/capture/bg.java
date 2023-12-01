package com.tencent.liteav.videoproducer.capture;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/bg.class */
public final /* synthetic */ class bg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final bd f36920a;
    private final Surface b;

    private bg(bd bdVar, Surface surface) {
        this.f36920a = bdVar;
        this.b = surface;
    }

    public static Runnable a(bd bdVar, Surface surface) {
        return new bg(bdVar, surface);
    }

    @Override // java.lang.Runnable
    public final void run() {
        bd.a(this.f36920a, this.b);
    }
}
