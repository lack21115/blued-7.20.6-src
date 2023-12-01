package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.utils.Rotation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/bd.class */
public final /* synthetic */ class bd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f23316a;
    private final Rotation b;

    private bd(ai aiVar, Rotation rotation) {
        this.f23316a = aiVar;
        this.b = rotation;
    }

    public static Runnable a(ai aiVar, Rotation rotation) {
        return new bd(aiVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.b(this.f23316a, this.b);
    }
}
