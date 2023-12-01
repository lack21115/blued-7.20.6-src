package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.utils.Rotation;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/ap.class */
final /* synthetic */ class ap implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37129a;
    private final Rotation b;

    /* renamed from: c  reason: collision with root package name */
    private final int f37130c;

    private ap(f fVar, Rotation rotation, int i) {
        this.f37129a = fVar;
        this.b = rotation;
        this.f37130c = i;
    }

    public static Runnable a(f fVar, Rotation rotation, int i) {
        return new ap(fVar, rotation, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37129a, this.b, this.f37130c);
    }
}
