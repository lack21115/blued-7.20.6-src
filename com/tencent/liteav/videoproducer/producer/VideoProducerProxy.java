package com.tencent.liteav.videoproducer.producer;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.SnapshotSourceType;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.DisplayTarget;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.renderer.VideoRenderListener;
import com.tencent.liteav.videoproducer.capture.CameraCaptureParams;
import com.tencent.liteav.videoproducer.capture.CaptureSourceInterface;
import com.tencent.liteav.videoproducer.capture.ScreenCapturer;
import com.tencent.liteav.videoproducer.capture.VirtualCamera;
import com.tencent.liteav.videoproducer.encoder.VideoEncodeParams;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.preprocessor.BeautyProcessor;
import com.tencent.liteav.videoproducer.preprocessor.VideoPreprocessor;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;

@JNINamespace("liteav::video")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/producer/VideoProducerProxy.class */
public class VideoProducerProxy {
    private final f mProducer;

    public VideoProducerProxy(Context context, boolean z, IVideoReporter iVideoReporter) {
        this.mProducer = new f(context, z, iVideoReporter);
    }

    public VideoProducerProxy(boolean z, IVideoReporter iVideoReporter) {
        this(ContextUtils.getApplicationContext(), z, iVideoReporter);
    }

    public static VideoEncoderDef.EncodeAbility getEncodeAbility() {
        return f.b();
    }

    public void ackRPSRecvFrameIndex(VideoProducerDef.StreamType streamType, int i, int i2) {
        f fVar = this.mProducer;
        fVar.a(v.a(fVar, streamType, i, i2));
    }

    public void appendCustomCaptureFrame(PixelFrame pixelFrame) {
        f fVar = this.mProducer;
        if (pixelFrame == null || !pixelFrame.isFrameDataValid()) {
            LiteavLog.w(fVar.f37155a, "appendCustomCaptureFrame: frame is not valid.");
            return;
        }
        int width = pixelFrame.getWidth();
        int height = pixelFrame.getHeight();
        pixelFrame.retain();
        if (fVar.a(ad.a(fVar, pixelFrame, width, height))) {
            return;
        }
        pixelFrame.release();
    }

    public BeautyProcessor getBeautyProcessor() {
        return this.mProducer.d;
    }

    public VideoPreprocessor getVideoPreprocessor() {
        return this.mProducer.f37156c;
    }

    public void initialize() {
        f fVar = this.mProducer;
        synchronized (fVar) {
            if (fVar.f) {
                LiteavLog.w(fVar.f37155a, "videoproducer already initialized.");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("videoProducer_" + fVar.hashCode());
            handlerThread.start();
            fVar.e = new com.tencent.liteav.base.util.b(handlerThread.getLooper());
            fVar.f = true;
            fVar.e.a(g.a(fVar));
        }
    }

    public void pauseCapture() {
        f fVar = this.mProducer;
        fVar.a(av.a(fVar));
    }

    public void requestKeyFrame(VideoProducerDef.StreamType streamType) {
        f fVar = this.mProducer;
        fVar.a(w.a(fVar, streamType));
    }

    public void resumeCapture() {
        f fVar = this.mProducer;
        fVar.a(aw.a(fVar));
    }

    public int setCameraFocusPosition(int i, int i2) {
        f fVar = this.mProducer;
        fVar.a(o.a(fVar, i, i2));
        return 0;
    }

    public void setCaptureParams(CaptureSourceInterface.SourceType sourceType, VideoProducerDef.ProducerMode producerMode, CaptureSourceInterface.CaptureParams captureParams) {
        f fVar = this.mProducer;
        fVar.a(at.a(fVar, sourceType, producerMode, captureParams));
    }

    public void setCustomRenderListener(GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, VideoRenderListener videoRenderListener) {
        f fVar = this.mProducer;
        fVar.a(af.a(fVar, pixelFormatType, pixelBufferType, videoRenderListener));
    }

    public void setCustomVideoProcessListener(GLConstants.PixelFormatType pixelFormatType, GLConstants.PixelBufferType pixelBufferType, CustomVideoProcessListener customVideoProcessListener) {
        f fVar = this.mProducer;
        fVar.a(ah.a(fVar, pixelFormatType, pixelBufferType, customVideoProcessListener));
    }

    public void setDisplayView(DisplayTarget displayTarget, boolean z) {
        f fVar = this.mProducer;
        fVar.a(h.a(fVar, displayTarget, z));
    }

    public void setEncodeMirrorEnabled(boolean z) {
        f fVar = this.mProducer;
        fVar.a(l.a(fVar, z));
    }

    public void setEncodeParams(VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, GLConstants.Orientation orientation) {
        f fVar = this.mProducer;
        fVar.a(s.a(fVar, streamType, orientation, videoEncodeParams));
    }

    public void setEncodeRotation(Rotation rotation) {
        f fVar = this.mProducer;
        fVar.a(m.a(fVar, rotation));
    }

    public void setEncodeStrategy(VideoProducerDef.StreamType streamType, VideoEncoderDef.EncodeStrategy encodeStrategy) {
        f fVar = this.mProducer;
        fVar.a(k.a(fVar, streamType, encodeStrategy));
    }

    public void setGSensorMode(VideoProducerDef.GSensorMode gSensorMode) {
        f fVar = this.mProducer;
        fVar.a(p.a(fVar, gSensorMode));
    }

    public void setHWEncoderDeviceRelatedParams(String str) {
        f fVar = this.mProducer;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fVar.a(n.a(fVar, str));
    }

    public void setHomeOrientation(VideoProducerDef.HomeOrientation homeOrientation) {
        f fVar = this.mProducer;
        fVar.a(q.a(fVar, homeOrientation));
    }

    public void setPausedImage(Bitmap bitmap, int i) {
        f fVar = this.mProducer;
        fVar.a(au.a(fVar, bitmap, i));
    }

    public void setRPSIFrameFPS(VideoProducerDef.StreamType streamType, int i) {
        f fVar = this.mProducer;
        fVar.a(t.a(fVar, i, streamType));
    }

    public void setRPSNearestREFSize(VideoProducerDef.StreamType streamType, int i) {
        f fVar = this.mProducer;
        fVar.a(u.a(fVar, i, streamType));
    }

    public void setRenderMirrorMode(GLConstants.MirrorMode mirrorMode) {
        f fVar = this.mProducer;
        fVar.a(x.a(fVar, mirrorMode));
    }

    public void setRenderRotation(Rotation rotation) {
        f fVar = this.mProducer;
        fVar.a(z.a(fVar, rotation));
    }

    public void setRenderScaleType(GLConstants.GLScaleType gLScaleType) {
        f fVar = this.mProducer;
        fVar.a(y.a(fVar, gLScaleType));
    }

    public void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig) {
        f fVar = this.mProducer;
        fVar.a(ac.a(fVar, serverVideoProducerConfig));
    }

    public void setWatermark(Bitmap bitmap, float f, float f2, float f3) {
        f fVar = this.mProducer;
        fVar.a(ag.a(fVar, bitmap, f, f2, f3));
    }

    public void startCapture(CaptureSourceInterface.SourceType sourceType, VideoProducerDef.ProducerMode producerMode, CaptureSourceInterface.CaptureParams captureParams) {
        f fVar = this.mProducer;
        if (sourceType != CaptureSourceInterface.SourceType.CAMERA && sourceType != CaptureSourceInterface.SourceType.SCREEN && sourceType != CaptureSourceInterface.SourceType.VIRTUAL_CAMERA) {
            throw new IllegalArgumentException("type: ".concat(String.valueOf(sourceType)));
        }
        if (sourceType == CaptureSourceInterface.SourceType.CAMERA && !(captureParams instanceof CameraCaptureParams)) {
            throw new IllegalArgumentException("CaptureParams is not CameraCaptureParams");
        }
        if (sourceType == CaptureSourceInterface.SourceType.SCREEN) {
            if (!(captureParams instanceof ScreenCapturer.ScreenCaptureParams)) {
                throw new IllegalArgumentException("CaptureParams is not ScreenCaptureParams");
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() < 21) {
                fVar.b.notifyError(h.a.ERR_VIDEO_CAPTURE_SCREEN_UNSUPPORTED, "not support screen capture", new Object[0]);
            }
        }
        if (sourceType == CaptureSourceInterface.SourceType.VIRTUAL_CAMERA && !(captureParams instanceof VirtualCamera.VirtualCameraParams)) {
            throw new IllegalArgumentException("CaptureParams is not VirtualCameraParams");
        }
        fVar.a(an.a(fVar, sourceType, producerMode, captureParams));
    }

    public void startCustomCapture() {
        f fVar = this.mProducer;
        fVar.a(ab.a(fVar));
    }

    public void startEncodeStream(VideoProducerDef.StreamType streamType, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        f fVar = this.mProducer;
        fVar.a(i.a(fVar, streamType, videoEncodeParams, videoEncoderDataListener));
    }

    public void stopCapture() {
        f fVar = this.mProducer;
        fVar.a(as.a(fVar));
    }

    public void stopCustomCapture() {
        f fVar = this.mProducer;
        fVar.a(ae.a(fVar));
    }

    public void stopEncodeStream(VideoProducerDef.StreamType streamType) {
        f fVar = this.mProducer;
        fVar.a(j.a(fVar, streamType));
    }

    public void takeSnapshot(SnapshotSourceType snapshotSourceType, TakeSnapshotListener takeSnapshotListener) {
        f fVar = this.mProducer;
        fVar.a(aa.a(fVar, takeSnapshotListener, snapshotSourceType));
    }

    public void uninitialize() {
        f fVar = this.mProducer;
        fVar.a(r.a(fVar));
    }
}
