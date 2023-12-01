package com.tencent.liteav.videoproducer.capture;

import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.liteav.videoproducer.capture.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/capture/bf.class */
public final /* synthetic */ class bf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final bd f36918a;
    private final Surface b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36919c;
    private final int d;
    private final MediaProjection e;
    private final bd.b f;

    private bf(bd bdVar, Surface surface, int i, int i2, MediaProjection mediaProjection, bd.b bVar) {
        this.f36918a = bdVar;
        this.b = surface;
        this.f36919c = i;
        this.d = i2;
        this.e = mediaProjection;
        this.f = bVar;
    }

    public static Runnable a(bd bdVar, Surface surface, int i, int i2, MediaProjection mediaProjection, bd.b bVar) {
        return new bf(bdVar, surface, i, i2, mediaProjection, bVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        bd.a(this.f36918a, this.b, this.f36919c, this.d, this.e, this.f);
    }
}
