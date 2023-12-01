package com.tencent.ugc.videoprocessor;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/b.class */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f40451a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final TXVideoEditConstants.TXRect f40452c;
    private final long d;
    private final int e;

    private b(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j, int i) {
        this.f40451a = watermarkProcessor;
        this.b = bitmap;
        this.f40452c = tXRect;
        this.d = j;
        this.e = i;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j, int i) {
        return new b(watermarkProcessor, bitmap, tXRect, j, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f40451a.setTailWaterMarkInternal(this.b, this.f40452c, this.d, this.e);
    }
}
