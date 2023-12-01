package com.tencent.liteav.videoproducer.utils;

import android.graphics.Bitmap;
import android.media.projection.MediaProjection;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.NativeVideoReporter;
import com.tencent.liteav.videoproducer.capture.CameraCaptureParams;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.ScreenCapturer;
import com.tencent.liteav.videoproducer.capture.VirtualCamera;
import com.tencent.liteav.videoproducer.encoder.NativeEncoderDataListener;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

@JNINamespace("liteav::video")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/utils/NativeProducerParamCreator.class */
public class NativeProducerParamCreator {
    private static final String TAG = "CaptureParamsHelper";

    public static Boolean createBooleanWithValue(boolean z) {
        return Boolean.valueOf(z);
    }

    public static CameraCaptureParams createCameraParams(Boolean bool, int i, int i2, int i3) {
        CameraCaptureParams cameraCaptureParams = new CameraCaptureParams();
        cameraCaptureParams.f23151a = bool;
        cameraCaptureParams.b = i;
        cameraCaptureParams.f23155c = i2;
        cameraCaptureParams.d = i3;
        return cameraCaptureParams;
    }

    public static VideoEncoderDef.EncodeStrategy createEncoderStrategy(int i) {
        return VideoEncoderDef.EncodeStrategy.a(i);
    }

    public static VideoProducerDef.GSensorMode createGSensorMode(int i) {
        return VideoProducerDef.GSensorMode.a(i);
    }

    public static VideoProducerDef.HomeOrientation createHomeOrientation(int i) {
        return VideoProducerDef.HomeOrientation.a(i);
    }

    public static GLConstants.MirrorMode createMirrorMode(int i) {
        return GLConstants.MirrorMode.a(i);
    }

    public static NativeEncoderDataListener createNativeEncoderDataListener(long j, int i) {
        return new NativeEncoderDataListener(j, i);
    }

    private static IVideoReporter createNativeReporter(long j) {
        return new NativeVideoReporter(j, false);
    }

    public static GLConstants.Orientation createOrientation(int i) {
        return GLConstants.Orientation.a(i);
    }

    public static GLConstants.PixelBufferType createPixelBufferType(int i) {
        return GLConstants.PixelBufferType.a(i);
    }

    public static GLConstants.PixelFormatType createPixelFormatType(int i) {
        return GLConstants.PixelFormatType.a(i);
    }

    public static VideoProducerDef.ProducerMode createProducerMode(int i) {
        return VideoProducerDef.ProducerMode.a(i);
    }

    public static Rotation createRotation(int i) {
        return Rotation.a(i);
    }

    public static GLConstants.GLScaleType createScaleType(int i) {
        return GLConstants.GLScaleType.a(i);
    }

    public static ScreenCapturer.ScreenCaptureParams createScreenParams(boolean z, int i, int i2, int i3, MediaProjection mediaProjection) {
        ScreenCapturer.ScreenCaptureParams screenCaptureParams = new ScreenCapturer.ScreenCaptureParams();
        screenCaptureParams.f23158a = z;
        screenCaptureParams.b = i;
        screenCaptureParams.f23155c = i2;
        screenCaptureParams.d = i3;
        screenCaptureParams.f = mediaProjection;
        return screenCaptureParams;
    }

    public static SnapshotSourceType createSnapshotSourceType(int i) {
        return SnapshotSourceType.a(i);
    }

    public static CaptureSourceInterface.SourceType createSourceType(int i) {
        return CaptureSourceInterface.SourceType.a(i);
    }

    public static VideoProducerDef.StreamType createStreamType(int i) {
        return VideoProducerDef.StreamType.a(i);
    }

    public static VirtualCamera.VirtualCameraParams createVirtualParams(Bitmap bitmap, int i, int i2, int i3) {
        VirtualCamera.VirtualCameraParams virtualCameraParams = new VirtualCamera.VirtualCameraParams();
        virtualCameraParams.f23160a = bitmap;
        virtualCameraParams.b = i;
        virtualCameraParams.f23155c = i2;
        virtualCameraParams.d = i3;
        return virtualCameraParams;
    }

    private static void resetNativeReporter(NativeVideoReporter nativeVideoReporter) {
        if (nativeVideoReporter != null) {
            nativeVideoReporter.reset();
        }
    }
}
