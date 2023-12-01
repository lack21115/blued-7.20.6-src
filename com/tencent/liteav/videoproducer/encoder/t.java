package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.common.EncodedVideoFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/t.class */
final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final p f37035a;
    private final EncodedVideoFrame b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f37036c;

    private t(p pVar, EncodedVideoFrame encodedVideoFrame, boolean z) {
        this.f37035a = pVar;
        this.b = encodedVideoFrame;
        this.f37036c = z;
    }

    public static Runnable a(p pVar, EncodedVideoFrame encodedVideoFrame, boolean z) {
        return new t(pVar, encodedVideoFrame, z);
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a(this.f37035a, this.b, this.f37036c);
    }
}
