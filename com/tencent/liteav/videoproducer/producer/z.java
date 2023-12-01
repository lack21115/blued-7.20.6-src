package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.utils.Rotation;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/z.class */
final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f37187a;
    private final Rotation b;

    private z(f fVar, Rotation rotation) {
        this.f37187a = fVar;
        this.b = rotation;
    }

    public static Runnable a(f fVar, Rotation rotation) {
        return new z(fVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f37187a, this.b);
    }
}
