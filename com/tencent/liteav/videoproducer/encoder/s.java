package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaFormat;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/s.class */
final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final p f23343a;
    private final MediaFormat b;

    private s(p pVar, MediaFormat mediaFormat) {
        this.f23343a = pVar;
        this.b = mediaFormat;
    }

    public static Runnable a(p pVar, MediaFormat mediaFormat) {
        return new s(pVar, mediaFormat);
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.a(this.f23343a, this.b);
    }
}
