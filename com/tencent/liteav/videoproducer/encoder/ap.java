package com.tencent.liteav.videoproducer.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ap.class */
public final /* synthetic */ class ap implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f36989a;
    private final VideoEncodeParams b;

    private ap(ai aiVar, VideoEncodeParams videoEncodeParams) {
        this.f36989a = aiVar;
        this.b = videoEncodeParams;
    }

    public static Runnable a(ai aiVar, VideoEncodeParams videoEncodeParams) {
        return new ap(aiVar, videoEncodeParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f36989a, this.b);
    }
}
