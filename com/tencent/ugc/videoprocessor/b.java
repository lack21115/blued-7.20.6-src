package com.tencent.ugc.videoprocessor;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/b.class */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f26760a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final TXVideoEditConstants.TXRect f26761c;
    private final long d;
    private final int e;

    private b(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j, int i) {
        this.f26760a = watermarkProcessor;
        this.b = bitmap;
        this.f26761c = tXRect;
        this.d = j;
        this.e = i;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect, long j, int i) {
        return new b(watermarkProcessor, bitmap, tXRect, j, i);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26760a.setTailWaterMarkInternal(this.b, this.f26761c, this.d, this.e);
    }
}
