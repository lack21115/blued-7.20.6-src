package com.tencent.liteav.videoconsumer.consumer;

import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/consumer/v.class */
final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f36728a;

    private v(j jVar) {
        this.f36728a = jVar;
    }

    public static Runnable a(j jVar) {
        return new v(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f36728a;
        jVar.f = new VideoDecodeController(jVar.f36706c, false);
        jVar.f.a(jVar.t);
        jVar.f.a(jVar.u);
        jVar.f.a();
        if (jVar.d == null) {
            jVar.d = new com.tencent.liteav.videoconsumer.renderer.g(jVar.b.getLooper(), jVar.f36706c);
        }
    }
}
