package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.SnapshotSourceType;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/aa.class */
final /* synthetic */ class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23415a;
    private final TakeSnapshotListener b;

    /* renamed from: c  reason: collision with root package name */
    private final SnapshotSourceType f23416c;

    private aa(f fVar, TakeSnapshotListener takeSnapshotListener, SnapshotSourceType snapshotSourceType) {
        this.f23415a = fVar;
        this.b = takeSnapshotListener;
        this.f23416c = snapshotSourceType;
    }

    public static Runnable a(f fVar, TakeSnapshotListener takeSnapshotListener, SnapshotSourceType snapshotSourceType) {
        return new aa(fVar, takeSnapshotListener, snapshotSourceType);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23415a, this.b, this.f23416c);
    }
}
