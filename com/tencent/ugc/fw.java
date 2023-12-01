package com.tencent.ugc;

import com.tencent.ugc.UGCVideoProcessor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/fw.class */
public final /* synthetic */ class fw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f26709a;
    private final UGCVideoProcessor.VideoProcessListener b;

    private fw(UGCVideoProcessor uGCVideoProcessor, UGCVideoProcessor.VideoProcessListener videoProcessListener) {
        this.f26709a = uGCVideoProcessor;
        this.b = videoProcessListener;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, UGCVideoProcessor.VideoProcessListener videoProcessListener) {
        return new fw(uGCVideoProcessor, videoProcessListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26709a.mVideoProcessListener = this.b;
    }
}
