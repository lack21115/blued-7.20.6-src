package com.tencent.liteav.videoproducer.producer;

import com.tencent.liteav.videobase.videobase.DisplayTarget;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/h.class */
final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f23470a;
    private final DisplayTarget b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f23471c;

    private h(f fVar, DisplayTarget displayTarget, boolean z) {
        this.f23470a = fVar;
        this.b = displayTarget;
        this.f23471c = z;
    }

    public static Runnable a(f fVar, DisplayTarget displayTarget, boolean z) {
        return new h(fVar, displayTarget, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        f.a(this.f23470a, this.b, this.f23471c);
    }
}
