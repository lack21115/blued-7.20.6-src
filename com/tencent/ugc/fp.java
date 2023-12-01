package com.tencent.ugc;

import com.tencent.ugc.UGCVideoProcessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fp.class */
public final /* synthetic */ class fp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f40391a;
    private final UGCVideoProcessor.VideoEncodedFrameListener b;

    private fp(UGCVideoProcessor uGCVideoProcessor, UGCVideoProcessor.VideoEncodedFrameListener videoEncodedFrameListener) {
        this.f40391a = uGCVideoProcessor;
        this.b = videoEncodedFrameListener;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, UGCVideoProcessor.VideoEncodedFrameListener videoEncodedFrameListener) {
        return new fp(uGCVideoProcessor, videoEncodedFrameListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40391a.mVideoEncodedFrameListener = this.b;
    }
}
