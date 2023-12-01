package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.GLConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/aj.class */
final /* synthetic */ class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37120a;
    private final boolean b;

    private aj(f fVar, boolean z) {
        this.f37120a = fVar;
        this.b = z;
    }

    public static Runnable a(f fVar, boolean z) {
        return new aj(fVar, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f fVar = this.f37120a;
        boolean z = this.b;
        fVar.s.d = r4 ? GLConstants.Orientation.PORTRAIT : GLConstants.Orientation.LANDSCAPE;
    }
}
