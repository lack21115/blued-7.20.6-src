package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.base.TakeSnapshotListener;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/at.class */
public final /* synthetic */ class at implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f36993a;
    private final TakeSnapshotListener b;

    private at(ai aiVar, TakeSnapshotListener takeSnapshotListener) {
        this.f36993a = aiVar;
        this.b = takeSnapshotListener;
    }

    public static Runnable a(ai aiVar, TakeSnapshotListener takeSnapshotListener) {
        return new at(aiVar, takeSnapshotListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f36993a, this.b);
    }
}
