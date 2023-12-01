package com.tencent.ugc;

import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.ugc.UGCVideoProcessor;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/gh.class */
final /* synthetic */ class gh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor.AnonymousClass3 f26726a;
    private final EncodedVideoFrame b;

    private gh(UGCVideoProcessor.AnonymousClass3 anonymousClass3, EncodedVideoFrame encodedVideoFrame) {
        this.f26726a = anonymousClass3;
        this.b = encodedVideoFrame;
    }

    public static Runnable a(UGCVideoProcessor.AnonymousClass3 anonymousClass3, EncodedVideoFrame encodedVideoFrame) {
        return new gh(anonymousClass3, encodedVideoFrame);
    }

    @Override // java.lang.Runnable
    public final void run() {
        UGCVideoProcessor.AnonymousClass3.a(this.f26726a, this.b);
    }
}
