package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/renderer/n.class */
final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final g f23145a;
    private final TakeSnapshotListener b;

    private n(g gVar, TakeSnapshotListener takeSnapshotListener) {
        this.f23145a = gVar;
        this.b = takeSnapshotListener;
    }

    public static Runnable a(g gVar, TakeSnapshotListener takeSnapshotListener) {
        return new n(gVar, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        g.a(this.f23145a, this.b);
    }
}
