package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.videobase.utils.Rotation;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ak.class */
public final /* synthetic */ class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final ai f23292a;
    private final Rotation b;

    private ak(ai aiVar, Rotation rotation) {
        this.f23292a = aiVar;
        this.b = rotation;
    }

    public static Runnable a(ai aiVar, Rotation rotation) {
        return new ak(aiVar, rotation);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ai.a(this.f23292a, this.b);
    }
}
