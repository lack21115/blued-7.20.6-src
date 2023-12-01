package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/x.class */
final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37185a;
    private final GLConstants.MirrorMode b;

    private x(f fVar, GLConstants.MirrorMode mirrorMode) {
        this.f37185a = fVar;
        this.b = mirrorMode;
    }

    public static Runnable a(f fVar, GLConstants.MirrorMode mirrorMode) {
        return new x(fVar, mirrorMode);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37185a, this.b);
    }
}
