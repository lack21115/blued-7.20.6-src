package com.tencent.liteav.videoproducer.encoder;

import android.media.MediaFormat;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import com.tencent.liteav.videobase.videobase.h;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import java.nio.ByteBuffer;

@JNINamespace("liteav::video")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/NativeEncoderDataListener.class */
public class NativeEncoderDataListener implements VideoEncoderDef.VideoEncoderDataListener {
    public static final String TAG = "NativeEncoderDataListener";
    private long mNativeVideoEncodeDataListener;
    private int mStreamType;

    public NativeEncoderDataListener(long j, int i) {
        this.mNativeVideoEncodeDataListener = 0L;
        this.mStreamType = 0;
        this.mNativeVideoEncodeDataListener = j;
        this.mStreamType = i;
    }

    private native void nativeOnEncodedFail(long j, int i, int i2);

    private native void nativeOnEncodedNAL(long j, int i, EncodedVideoFrame encodedVideoFrame, ByteBuffer byteBuffer, int i2, int i3, int i4, int i5, long j2, long j3, long j4, long j5, long j6, long j7, int i6, int i7, boolean z, int i8);

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
    public void onEncodedFail(h.a aVar) {
        synchronized (this) {
            if (this.mNativeVideoEncodeDataListener != 0) {
                nativeOnEncodedFail(this.mNativeVideoEncodeDataListener, this.mStreamType, com.tencent.liteav.videobase.videobase.h.a(aVar));
            } else {
                LiteavLog.i(TAG, "onEncodedFail nativeclient is zero.");
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
    public void onEncodedNAL(EncodedVideoFrame encodedVideoFrame, boolean z) {
        synchronized (this) {
            if (this.mNativeVideoEncodeDataListener != 0) {
                nativeOnEncodedNAL(this.mNativeVideoEncodeDataListener, this.mStreamType, encodedVideoFrame, encodedVideoFrame.data, encodedVideoFrame.nalType.mValue, encodedVideoFrame.profileType.mValue, encodedVideoFrame.codecType.mValue, encodedVideoFrame.rotation, encodedVideoFrame.dts, encodedVideoFrame.pts, encodedVideoFrame.gopIndex, encodedVideoFrame.gopFrameIndex, encodedVideoFrame.frameIndex, encodedVideoFrame.refFrameIndex, encodedVideoFrame.width, encodedVideoFrame.height, encodedVideoFrame.svcInfo != null, encodedVideoFrame.svcInfo == null ? 0 : encodedVideoFrame.svcInfo.intValue());
            } else {
                LiteavLog.d(TAG, "onEncodedNAL nativeclient is zero.");
            }
        }
    }

    @Override // com.tencent.liteav.videoproducer.encoder.VideoEncoderDef.VideoEncoderDataListener
    public void onOutputFormatChanged(MediaFormat mediaFormat) {
        synchronized (this) {
        }
    }

    public void reset() {
        synchronized (this) {
            this.mNativeVideoEncodeDataListener = 0L;
        }
    }
}
