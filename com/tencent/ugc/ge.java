package com.tencent.ugc;

import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ge.class */
public final /* synthetic */ class ge implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40413a;
    private final VideoEncodeParams b;

    private ge(UGCVideoProcessor uGCVideoProcessor, VideoEncodeParams videoEncodeParams) {
        this.f40413a = uGCVideoProcessor;
        this.b = videoEncodeParams;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, VideoEncodeParams videoEncodeParams) {
        return new ge(uGCVideoProcessor, videoEncodeParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40413a.mVideoEncodeParams = this.b;
    }
}
