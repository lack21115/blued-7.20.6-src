package com.tencent.liteav.videoproducer.capture;

import android.media.projection.MediaProjection;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/bh.class */
public final /* synthetic */ class bh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final bd f36921a;
    private final MediaProjection b;

    private bh(bd bdVar, MediaProjection mediaProjection) {
        this.f36921a = bdVar;
        this.b = mediaProjection;
    }

    public static Runnable a(bd bdVar, MediaProjection mediaProjection) {
        return new bh(bdVar, mediaProjection);
    }

    @Override // java.lang.Runnable
    public final void run() {
        bd.a(this.f36921a, this.b);
    }
}
