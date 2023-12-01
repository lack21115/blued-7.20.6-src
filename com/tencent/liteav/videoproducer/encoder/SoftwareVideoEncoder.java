package com.tencent.liteav.videoproducer.encoder;

import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.base.TakeSnapshotListener;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.e;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import com.tencent.liteav.videoproducer.encoder.bf;
import com.tencent.liteav.videoproducer.producer.ServerVideoProducerConfig;
import com.tencent.liteav.videoproducer.producer.VideoProducerDef;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/SoftwareVideoEncoder.class */
public class SoftwareVideoEncoder implements e.a, bf {
    private com.tencent.liteav.videobase.b.e mEGLCore;
    private VideoEncodeParams mEncodeParams;
    private com.tencent.liteav.videobase.videobase.e mFrameConverter;
    private com.tencent.liteav.videobase.frame.e mGLTexturePool;
    private bf.a mListener;
    private com.tencent.liteav.videobase.frame.j mPixelFrameRenderer;
    private final IVideoReporter mReporter;
    private final String mTAG;
    private long mNativeEncodeWrapper = 0;
    private final com.tencent.liteav.videobase.utils.k mSnapshotTaker = new com.tencent.liteav.videobase.utils.k("softenc" + hashCode());

    public SoftwareVideoEncoder(IVideoReporter iVideoReporter, VideoProducerDef.StreamType streamType) {
        this.mReporter = iVideoReporter;
        this.mTAG = "SoftwareVideoEncoder_" + streamType + BridgeUtil.UNDERLINE_STR + hashCode();
    }

    private static EncodedVideoFrame createEncodedVideoFrameCallFromNative(ByteBuffer byteBuffer, int i, int i2, int i3, long j, long j2, long j3, int i4, int i5, long j4, long j5, long j6, boolean z, int i6) {
        EncodedVideoFrame encodedVideoFrame = new EncodedVideoFrame();
        encodedVideoFrame.nalType = com.tencent.liteav.videobase.common.a.a(i);
        encodedVideoFrame.profileType = com.tencent.liteav.videobase.common.b.a(i2);
        encodedVideoFrame.data = byteBuffer;
        encodedVideoFrame.dts = j;
        encodedVideoFrame.pts = j2;
        encodedVideoFrame.rotation = i3;
        encodedVideoFrame.frameIndex = j4;
        encodedVideoFrame.gopFrameIndex = 0L;
        encodedVideoFrame.gopIndex = j5;
        encodedVideoFrame.refFrameIndex = j6;
        encodedVideoFrame.nativePtr = j3;
        encodedVideoFrame.width = i4;
        encodedVideoFrame.height = i5;
        if (z) {
            encodedVideoFrame.svcInfo = Integer.valueOf(i6);
            return encodedVideoFrame;
        }
        encodedVideoFrame.svcInfo = null;
        return encodedVideoFrame;
    }

    private boolean initOpenGLComponents(Object obj) {
        if (this.mEncodeParams == null) {
            return false;
        }
        com.tencent.liteav.videobase.b.e eVar = new com.tencent.liteav.videobase.b.e();
        this.mEGLCore = eVar;
        try {
            eVar.a(obj, null, 128, 128);
            this.mPixelFrameRenderer = new com.tencent.liteav.videobase.frame.j(this.mEncodeParams.getWidth(), this.mEncodeParams.getHeight());
            com.tencent.liteav.videobase.frame.e eVar2 = new com.tencent.liteav.videobase.frame.e();
            this.mGLTexturePool = eVar2;
            this.mSnapshotTaker.a(eVar2);
            this.mSnapshotTaker.a(this.mEncodeParams.getWidth(), this.mEncodeParams.getHeight());
            com.tencent.liteav.videobase.videobase.e eVar3 = new com.tencent.liteav.videobase.videobase.e();
            this.mFrameConverter = eVar3;
            eVar3.a(this.mGLTexturePool);
            this.mFrameConverter.a(new com.tencent.liteav.videobase.videobase.a(this.mEncodeParams.getWidth(), this.mEncodeParams.getHeight()), GLConstants.PixelBufferType.BYTE_ARRAY, GLConstants.PixelFormatType.I420, 0, this);
            return true;
        } catch (com.tencent.liteav.videobase.b.g e) {
            this.mEGLCore = null;
            LiteavLog.e(this.mTAG, "initializeEGL failed.", e);
            return false;
        }
    }

    private static native long nativeCreate(SoftwareVideoEncoder softwareVideoEncoder);

    private static native void nativeDestroy(long j);

    private static native int nativeEncodeFrame(long j, byte[] bArr, int i, int i2, long j2);

    private static native void nativeRestartIDR(long j);

    private static native void nativeSetBitrate(long j, int i);

    private static native void nativeSetFps(long j, int i);

    private static native int nativeSetNearestRPS(long j, int i);

    private static native int nativeSetRPSRefBitmap(long j, int i, int i2);

    private static native void nativeSetRpsIdrFps(long j, int i);

    private static native int nativeStart(long j, VideoEncodeParams videoEncodeParams);

    private static native int nativeStop(long j);

    private void onEncodedError(int i) {
        bf.a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(String.valueOf(i));
        }
    }

    private void onEncodedNAL(EncodedVideoFrame encodedVideoFrame) {
        bf.a aVar = this.mListener;
        if (aVar != null) {
            aVar.onEncodedNAL(encodedVideoFrame, false);
        }
    }

    private void onRpsFrameRateChanged(boolean z, int i) {
        bf.a aVar = this.mListener;
        if (aVar != null) {
            aVar.a(z, i);
        }
    }

    private void uninitializeOpenGLComponents() {
        if (this.mEGLCore == null) {
            return;
        }
        LiteavLog.i(this.mTAG, "uninitializeOpenGLComponents");
        try {
            this.mEGLCore.a();
            this.mFrameConverter.a(0, this);
            this.mFrameConverter.a();
            this.mSnapshotTaker.a();
            if (this.mPixelFrameRenderer != null) {
                this.mPixelFrameRenderer.a();
                this.mPixelFrameRenderer = null;
            }
            if (this.mGLTexturePool != null) {
                this.mGLTexturePool.a();
                this.mGLTexturePool.b();
                this.mGLTexturePool = null;
            }
        } catch (com.tencent.liteav.videobase.b.g e) {
            LiteavLog.e(this.mTAG, "makeCurrent failed.", e);
        }
        com.tencent.liteav.videobase.b.e.a(this.mEGLCore);
        this.mEGLCore = null;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void ackRPSRecvFrameIndex(int i, int i2) {
        nativeSetRPSRefBitmap(this.mNativeEncodeWrapper, i, i2);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void encodeFrame(PixelFrame pixelFrame) {
        if (pixelFrame == null) {
            return;
        }
        if (this.mEGLCore != null || initOpenGLComponents(pixelFrame.getGLContext())) {
            try {
                this.mEGLCore.a();
                com.tencent.liteav.videobase.frame.d a2 = this.mGLTexturePool.a(this.mEncodeParams.getWidth(), this.mEncodeParams.getHeight());
                OpenGlUtils.glViewport(0, 0, a2.b(), a2.c());
                this.mSnapshotTaker.a(pixelFrame);
                this.mPixelFrameRenderer.a(pixelFrame, GLConstants.GLScaleType.CENTER_CROP, a2);
                this.mFrameConverter.a(pixelFrame.getTimestamp(), a2);
                a2.release();
            } catch (com.tencent.liteav.videobase.b.g e) {
                LiteavLog.e(this.mTAG, "makeCurrent failed.", e);
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public VideoEncodeParams getEncodeParams() {
        return new VideoEncodeParams(this.mEncodeParams);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public VideoEncoderDef.a getEncoderType() {
        return VideoEncoderDef.a.SOFTWARE;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void initialize() {
        this.mNativeEncodeWrapper = nativeCreate(this);
        String str = this.mTAG;
        LiteavLog.i(str, "initialize " + this.mNativeEncodeWrapper);
    }

    @Override // com.tencent.liteav.videobase.videobase.e.a
    public void onFrameConverted(int i, PixelFrame pixelFrame) {
        if (pixelFrame.getPixelFormatType() != GLConstants.PixelFormatType.I420 && pixelFrame.getPixelBufferType() != GLConstants.PixelBufferType.TEXTURE_2D) {
            LiteavLog.i(this.mTAG, "pixelFrame pixelFormat not I420 ");
            return;
        }
        long j = this.mNativeEncodeWrapper;
        if (j != 0) {
            nativeEncodeFrame(j, pixelFrame.getData(), pixelFrame.getWidth(), pixelFrame.getHeight(), pixelFrame.getTimestamp());
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void restartIDRFrame() {
        LiteavLog.i(this.mTAG, "restartIDRFrame");
        nativeRestartIDR(this.mNativeEncodeWrapper);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void setBitrate(int i) {
        LiteavLog.i(this.mTAG, "SetBitrate: ".concat(String.valueOf(i)));
        nativeSetBitrate(this.mNativeEncodeWrapper, i);
        this.mEncodeParams.setBitrate(i);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void setFps(int i) {
        LiteavLog.i(this.mTAG, "setFps: ".concat(String.valueOf(i)));
        nativeSetFps(this.mNativeEncodeWrapper, i);
        this.mEncodeParams.setFps(i);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void setRPSIFrameFPS(int i) {
        LiteavLog.i(this.mTAG, "setRPSIFrameFPS：fps= %d", Integer.valueOf(i));
        nativeSetRpsIdrFps(this.mNativeEncodeWrapper, i);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void setRPSNearestREFSize(int i) {
        LiteavLog.i(this.mTAG, "setRPSNearestREFSize ".concat(String.valueOf(i)));
        nativeSetNearestRPS(this.mNativeEncodeWrapper, i);
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void setServerConfig(ServerVideoProducerConfig serverVideoProducerConfig) {
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void signalEndOfStream() {
        LiteavLog.i(this.mTAG, "signalEndOfStream");
        if (this.mListener != null) {
            this.mListener.onEncodedNAL(new EncodedVideoFrame(), true);
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public boolean start(VideoEncodeParams videoEncodeParams, bf.a aVar) {
        LiteavLog.i(this.mTAG, "Start: ".concat(String.valueOf(videoEncodeParams)));
        VideoEncodeParams videoEncodeParams2 = new VideoEncodeParams(videoEncodeParams);
        this.mEncodeParams = videoEncodeParams2;
        this.mListener = aVar;
        nativeStart(this.mNativeEncodeWrapper, videoEncodeParams2);
        return true;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void stop() {
        LiteavLog.i(this.mTAG, "Stop");
        this.mEncodeParams = null;
        nativeStop(this.mNativeEncodeWrapper);
        uninitializeOpenGLComponents();
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void takeSnapshot(TakeSnapshotListener takeSnapshotListener) {
        this.mSnapshotTaker.f36662a = takeSnapshotListener;
    }

    @Override // com.tencent.liteav.videoproducer.encoder.bf
    public void uninitialize() {
        LiteavLog.i(this.mTAG, "uninitialize ");
        nativeDestroy(this.mNativeEncodeWrapper);
    }
}
