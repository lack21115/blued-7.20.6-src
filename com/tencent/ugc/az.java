package com.tencent.ugc;

import com.tencent.liteav.videobase.common.EncodedVideoFrame;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/az.class */
public final /* synthetic */ class az implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f26555a;
    private final EncodedVideoFrame b;

    private az(TXVideoEditer tXVideoEditer, EncodedVideoFrame encodedVideoFrame) {
        this.f26555a = tXVideoEditer;
        this.b = encodedVideoFrame;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, EncodedVideoFrame encodedVideoFrame) {
        return new az(tXVideoEditer, encodedVideoFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        TXVideoEditer.lambda$onVideoEncodedFrame$54(this.f26555a, this.b);
    }
}
