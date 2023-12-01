package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.utils.Rotation;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/m.class */
final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23478a;
    private final Rotation b;

    private m(f fVar, Rotation rotation) {
        this.f23478a = fVar;
        this.b = rotation;
    }

    public static Runnable a(f fVar, Rotation rotation) {
        return new m(fVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.b(this.f23478a, this.b);
    }
}
