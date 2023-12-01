package com.tencent.liteav.videoconsumer.utils;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.NativeVideoReporter;
import com.tencent.liteav.videoconsumer.decoder.VideoDecodeController;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/utils/NativeConsumerParamCreator.class */
public class NativeConsumerParamCreator {
    public static VideoDecoderDef.ConsumerScene createConsumerScene(int i) {
        return VideoDecoderDef.ConsumerScene.a(i);
    }

    private static VideoDecodeController.DecodeStrategy createDecodeStrategy(int i) {
        return VideoDecodeController.DecodeStrategy.a(i);
    }

    private static IVideoReporter createNativeReporter(long j) {
        return new NativeVideoReporter(j, true);
    }

    public static GLConstants.PixelBufferType createPixelBufferType(int i) {
        return GLConstants.PixelBufferType.a(i);
    }

    public static GLConstants.PixelFormatType createPixelFormatType(int i) {
        return GLConstants.PixelFormatType.a(i);
    }

    private static GLConstants.GLScaleType createScaleType(int i) {
        return GLConstants.GLScaleType.a(i);
    }

    public static SnapshotSourceType createSnapshotSourceType(int i) {
        return SnapshotSourceType.a(i);
    }

    public static Rotation fromInt(int i) {
        Rotation[] values = Rotation.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return Rotation.NORMAL;
            }
            Rotation rotation = values[i3];
            if (rotation.mValue == i) {
                return rotation;
            }
            i2 = i3 + 1;
        }
    }

    private static void resetNativeReporter(NativeVideoReporter nativeVideoReporter) {
        if (nativeVideoReporter != null) {
            nativeVideoReporter.reset();
        }
    }
}
