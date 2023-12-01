package com.tencent.ugc;

import com.tencent.ugc.UGCVideoProcessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fp.class */
public final /* synthetic */ class fp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f26700a;
    private final UGCVideoProcessor.VideoEncodedFrameListener b;

    private fp(UGCVideoProcessor uGCVideoProcessor, UGCVideoProcessor.VideoEncodedFrameListener videoEncodedFrameListener) {
        this.f26700a = uGCVideoProcessor;
        this.b = videoEncodedFrameListener;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, UGCVideoProcessor.VideoEncodedFrameListener videoEncodedFrameListener) {
        return new fp(uGCVideoProcessor, videoEncodedFrameListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26700a.mVideoEncodedFrameListener = this.b;
    }
}
