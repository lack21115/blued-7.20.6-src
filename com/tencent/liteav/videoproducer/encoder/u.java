package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.videobase.h;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/u.class */
final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final p f37037a;
    private final h.a b;

    private u(p pVar, h.a aVar) {
        this.f37037a = pVar;
        this.b = aVar;
    }

    public static Runnable a(p pVar, h.a aVar) {
        return new u(pVar, aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a(this.f37037a, this.b);
    }
}
