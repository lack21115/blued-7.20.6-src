package com.tencent.thumbplayer.g.b;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.thumbplayer.g.f.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/b/d.class */
public final class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicInteger f25634a = new AtomicInteger(0);
    private final MediaCodec b;

    public d(MediaCodec mediaCodec) {
        this.b = mediaCodec;
        com.tencent.thumbplayer.g.h.b.c("DirectCodecWrapper", "DirectCodecWrapper sCodecNum:" + f25634a.incrementAndGet());
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final int a(long j) {
        return this.b.dequeueInputBuffer(j);
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final int a(MediaCodec.BufferInfo bufferInfo, long j) {
        return this.b.dequeueOutputBuffer(bufferInfo, j);
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final MediaCodec a() {
        return this.b;
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final void a(int i, int i2, int i3, long j, int i4) {
        this.b.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final void a(int i, boolean z) {
        this.b.releaseOutputBuffer(i, z);
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final void a(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        this.b.configure(mediaFormat, surface, mediaCrypto, i);
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final void a(Surface surface) {
        com.tencent.thumbplayer.g.h.b.c("DirectCodecWrapper", "DirectCodecWrapper setOutputSurface start, surface:".concat(String.valueOf(surface)));
        this.b.setOutputSurface(surface);
        com.tencent.thumbplayer.g.h.b.c("DirectCodecWrapper", "DirectCodecWrapper setOutputSurface end ...");
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final void a(com.tencent.thumbplayer.g.a.a aVar) {
        com.tencent.thumbplayer.g.h.b.d("DirectCodecWrapper", "DirectCodecWrapper setCodecCallback ignore...");
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final a.b b(e eVar) {
        com.tencent.thumbplayer.g.h.b.d("DirectCodecWrapper", "setCanReuseType setCodecCallback ignore...");
        return a.b.KEEP_CODEC_RESULT_NO;
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final void b() {
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final void c() {
        com.tencent.thumbplayer.g.h.b.d("DirectCodecWrapper", "DirectCodecWrapper prepareToReUse ignore...");
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final void d() {
        com.tencent.thumbplayer.g.h.b.c("DirectCodecWrapper", "DirectCodecWrapper start ...");
        this.b.start();
        com.tencent.thumbplayer.g.h.b.c("DirectCodecWrapper", "DirectCodecWrapper start end...");
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final void e() {
        com.tencent.thumbplayer.g.h.b.c("DirectCodecWrapper", "DirectCodecWrapper flush start ...");
        this.b.flush();
        com.tencent.thumbplayer.g.h.b.c("DirectCodecWrapper", "DirectCodecWrapper flush end ...");
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final void f() {
        com.tencent.thumbplayer.g.h.b.c("DirectCodecWrapper", "DirectCodecWrapper stop before ...");
        this.b.stop();
        com.tencent.thumbplayer.g.h.b.c("DirectCodecWrapper", "DirectCodecWrapper stop end ...");
    }

    @Override // com.tencent.thumbplayer.g.b.c
    public final void g() {
        com.tencent.thumbplayer.g.h.b.c("DirectCodecWrapper", "DirectCodecWrapper release start ...");
        this.b.release();
        com.tencent.thumbplayer.g.h.b.c("DirectCodecWrapper", "DirectCodecWrapper release end ... sCodecNum:" + f25634a.decrementAndGet());
    }
}
