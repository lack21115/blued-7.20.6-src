package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/c.class */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f36698a;
    private final VideoRenderListener b;

    private c(a aVar, VideoRenderListener videoRenderListener) {
        this.f36698a = aVar;
        this.b = videoRenderListener;
    }

    public static Runnable a(a aVar, VideoRenderListener videoRenderListener) {
        return new c(aVar, videoRenderListener);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a.a(this.f36698a, this.b);
    }
}
