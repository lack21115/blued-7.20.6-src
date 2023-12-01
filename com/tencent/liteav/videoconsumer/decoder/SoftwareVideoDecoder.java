package com.tencent.liteav.videoconsumer.decoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.frame.PixelFrame;
import com.tencent.liteav.videobase.utils.Rotation;
import com.tencent.liteav.videobase.videobase.IVideoReporter;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoconsumer.consumer.ServerVideoConsumerConfig;
import com.tencent.liteav.videoconsumer.decoder.VideoDecoderDef;
import com.tencent.liteav.videoconsumer.decoder.ay;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videoconsumer/decoder/SoftwareVideoDecoder.class */
public class SoftwareVideoDecoder implements ay {
    private static final String TAG = "SoftwareVideoDecoder";
    private az mListener;
    private long mNativeVideoDecoderWrapper = 0;
    private com.tencent.liteav.videobase.frame.i mPixelFramePool;
    private final IVideoReporter mReporter;

    public SoftwareVideoDecoder(IVideoReporter iVideoReporter) {
        this.mReporter = iVideoReporter;
    }

    private ByteBuffer getByteBufferFromPixelFrame(PixelFrame pixelFrame) {
        return pixelFrame.getBuffer();
    }

    private void handleDecoderError(h.c cVar, String str, Object... objArr) {
        this.mReporter.notifyWarning(cVar, str, objArr);
        az azVar = this.mListener;
        if (azVar != null) {
            azVar.onDecodeFailed();
        }
    }

    private static native void nativeAbandonDecodingFrames(long j);

    private static native long nativeCreate(SoftwareVideoDecoder softwareVideoDecoder);

    private static native int nativeDecodeFrame(long j, EncodedVideoFrame encodedVideoFrame, ByteBuffer byteBuffer, int i, int i2, int i3, long j2, long j3);

    private static native void nativeDestroy(long j);

    private static native int nativeStart(long j);

    private static native int nativeStop(long j);

    private PixelFrame obtainPixelFrame(int i, int i2, int i3, int i4, long j) {
        GLConstants.PixelFormatType a2 = GLConstants.PixelFormatType.a(i);
        if (a2 == null) {
            handleDecoderError(h.c.WARNING_VIDEO_DECODE_ERROR_NOT_SUPPORT_PIXEL_FORMAT_TYPE, "unknown format:".concat(String.valueOf(i)), new Object[0]);
            LiteavLog.e(TAG, "obtainPixelFrame formatType: ".concat(String.valueOf(i)));
            return null;
        }
        com.tencent.liteav.videobase.frame.i iVar = this.mPixelFramePool;
        if (iVar == null) {
            LiteavLog.i(TAG, "obtainPixelFrame mPixelFramePool is null.");
            return null;
        }
        PixelFrame a3 = iVar.a(i2, i3, GLConstants.PixelBufferType.BYTE_BUFFER, a2);
        a3.setRotation(Rotation.a(i4));
        a3.setTimestamp(j);
        return a3;
    }

    private void onDecodedFrame(PixelFrame pixelFrame, long j) {
        if (j != 0) {
            handleDecoderError(h.c.WARNING_VIDEO_DECODE_RESTART_WHEN_DECODE_ERROR, "VideoDecode: decode error, errCode:".concat(String.valueOf(j)), new Object[0]);
            LiteavLog.e(TAG, "decode failed.".concat(String.valueOf(j)));
            if (pixelFrame != null) {
                pixelFrame.release();
            }
        } else if (pixelFrame != null) {
            az azVar = this.mListener;
            if (azVar != null) {
                azVar.onDecodeFrame(pixelFrame, pixelFrame.getTimestamp());
            }
            pixelFrame.release();
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public void abandonDecodingFrames() {
        long j = this.mNativeVideoDecoderWrapper;
        if (j == 0) {
            LiteavLog.w(TAG, "decoder has already stopped");
            return;
        }
        nativeAbandonDecodingFrames(j);
        az azVar = this.mListener;
        if (azVar != null) {
            azVar.onAbandonDecodingFramesCompleted();
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public boolean decode(EncodedVideoFrame encodedVideoFrame) {
        az azVar;
        if (encodedVideoFrame == null || encodedVideoFrame.data == null || encodedVideoFrame.data.remaining() == 0) {
            return false;
        }
        if (encodedVideoFrame.isEosFrame && (azVar = this.mListener) != null) {
            azVar.onDecodeCompleted();
            return true;
        }
        nativeDecodeFrame(this.mNativeVideoDecoderWrapper, encodedVideoFrame, encodedVideoFrame.data, encodedVideoFrame.nalType.mValue, encodedVideoFrame.codecType.mValue, encodedVideoFrame.rotation, encodedVideoFrame.pts, encodedVideoFrame.dts);
        encodedVideoFrame.release();
        az azVar2 = this.mListener;
        if (azVar2 != null) {
            azVar2.onFrameEnqueuedToDecoder();
            return true;
        }
        return true;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public ay.a getDecoderType() {
        return ay.a.SOFTWARE;
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public void initialize() {
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public void setScene(VideoDecoderDef.ConsumerScene consumerScene) {
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public void setServerConfig(ServerVideoConsumerConfig serverVideoConsumerConfig) {
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public void start(Object obj, az azVar) {
        if (this.mNativeVideoDecoderWrapper != 0) {
            LiteavLog.w(TAG, "decoder is already started!");
            return;
        }
        this.mPixelFramePool = new com.tencent.liteav.videobase.frame.i();
        this.mListener = azVar;
        long nativeCreate = nativeCreate(this);
        this.mNativeVideoDecoderWrapper = nativeCreate;
        if (nativeCreate == 0) {
            handleDecoderError(h.c.WARNING_VIDEO_DECODE_START_FAILED_OUT_OF_MEMORY, "VideoDecode: out of memory, Start decoder failed", new Object[0]);
            LiteavLog.e(TAG, "create native instance failed.");
        } else if (nativeStart(nativeCreate) != 0) {
            handleDecoderError(h.c.WARNING_VIDEO_DECODE_START_FAILED, "VideoDecode: Start decoder failed", new Object[0]);
            LiteavLog.e(TAG, "Start software decoder failed.");
        } else {
            this.mReporter.notifyEvent(h.b.EVT_VIDEO_DECODE_START_SUCCESS, "Start decoder success", new Object[0]);
            LiteavLog.i(TAG, "decoder Start success.");
        }
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public void stop() {
        if (this.mNativeVideoDecoderWrapper == 0) {
            LiteavLog.w(TAG, "decoder has already stopped");
            return;
        }
        com.tencent.liteav.videobase.frame.i iVar = this.mPixelFramePool;
        if (iVar != null) {
            iVar.b();
        }
        nativeStop(this.mNativeVideoDecoderWrapper);
        nativeDestroy(this.mNativeVideoDecoderWrapper);
        this.mNativeVideoDecoderWrapper = 0L;
        LiteavLog.i(TAG, "decoder stop.");
    }

    @Override // com.tencent.liteav.videoconsumer.decoder.ay
    public void uninitialize() {
    }
}
