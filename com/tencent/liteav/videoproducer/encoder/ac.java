package com.tencent.liteav.videoproducer.encoder;

import android.view.Surface;
import com.tencent.liteav.videoproducer.encoder.bf;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/ac.class */
final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final x f23280a;
    private final bf.a b;

    /* renamed from: c  reason: collision with root package name */
    private final Surface[] f23281c;
    private final VideoEncodeParams d;

    private ac(x xVar, bf.a aVar, Surface[] surfaceArr, VideoEncodeParams videoEncodeParams) {
        this.f23280a = xVar;
        this.b = aVar;
        this.f23281c = surfaceArr;
        this.d = videoEncodeParams;
    }

    public static Runnable a(x xVar, bf.a aVar, Surface[] surfaceArr, VideoEncodeParams videoEncodeParams) {
        return new ac(xVar, aVar, surfaceArr, videoEncodeParams);
    }

    @Override // java.lang.Runnable
    public final void run() {
        x xVar = this.f23280a;
        bf.a aVar = this.b;
        Surface[] surfaceArr = this.f23281c;
        VideoEncodeParams videoEncodeParams = this.d;
        xVar.e = aVar;
        surfaceArr[0] = xVar.a(videoEncodeParams);
    }
}
