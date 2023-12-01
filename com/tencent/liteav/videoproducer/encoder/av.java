package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.common.EncodedVideoFrame;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/av.class */
final /* synthetic */ class av implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f36996a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final EncodedVideoFrame f36997c;

    private av(ai aiVar, boolean z, EncodedVideoFrame encodedVideoFrame) {
        this.f36996a = aiVar;
        this.b = z;
        this.f36997c = encodedVideoFrame;
    }

    public static Runnable a(ai aiVar, boolean z, EncodedVideoFrame encodedVideoFrame) {
        return new av(aiVar, z, encodedVideoFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f36996a, this.b, this.f36997c);
    }
}
