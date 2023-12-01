package com.qiniu.pili.droid.streaming.processing.image;

import a.a.a.a.a.e.e;
import com.qiniu.pili.droid.streaming.SharedLibraryNameHelper;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/processing/image/ImageProcessor.class */
public final class ImageProcessor {
    public static final boolean b = SharedLibraryNameHelper.getInstance().d();

    /* renamed from: a  reason: collision with root package name */
    public int f27846a;

    public void a() {
        releaseYUVProcessor();
        e.h.c("ImageProcessor", "release");
    }

    public void a(int i) {
        if (this.f27846a != i) {
            setFilterMode(i);
            this.f27846a = i;
        }
    }

    public native int convertYUV(ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, boolean z);

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x000f -> B:3:0x0004). Please submit an issue!!! */
    public void finalize() {
        try {
            super.finalize();
        } catch (Throwable th) {
        }
        e.h.c("ImageProcessor", "finalize");
    }

    public native void initYUVProcessor(WatermarkSetting watermarkSetting, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z2);

    public native void releaseYUVProcessor();

    public final native void setFilterMode(int i);

    public native void updateWatermarkSetting(WatermarkSetting watermarkSetting);
}
