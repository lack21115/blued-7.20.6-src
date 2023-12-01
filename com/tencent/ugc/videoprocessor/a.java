package com.tencent.ugc.videoprocessor;

import android.graphics.Bitmap;
import com.tencent.ugc.TXVideoEditConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/a.class */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final WatermarkProcessor f40449a;
    private final Bitmap b;

    /* renamed from: c  reason: collision with root package name */
    private final TXVideoEditConstants.TXRect f40450c;

    private a(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        this.f40449a = watermarkProcessor;
        this.b = bitmap;
        this.f40450c = tXRect;
    }

    public static Runnable a(WatermarkProcessor watermarkProcessor, Bitmap bitmap, TXVideoEditConstants.TXRect tXRect) {
        return new a(watermarkProcessor, bitmap, tXRect);
    }

    @Override // java.lang.Runnable
    public final void run() {
        WatermarkProcessor.lambda$setWaterMark$0(this.f40449a, this.b, this.f40450c);
    }
}
