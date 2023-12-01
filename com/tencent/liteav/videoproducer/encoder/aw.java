package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.videobase.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/aw.class */
public final /* synthetic */ class aw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f36998a;
    private final h.a b;

    private aw(ai aiVar, h.a aVar) {
        this.f36998a = aiVar;
        this.b = aVar;
    }

    public static Runnable a(ai aiVar, h.a aVar) {
        return new aw(aiVar, aVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f36998a, this.b);
    }
}
