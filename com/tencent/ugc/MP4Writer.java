package com.tencent.ugc;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.common.EncodedVideoFrame;
import java.nio.ByteBuffer;

@JNINamespace("liteav::ugc")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/MP4Writer.class */
public class MP4Writer {
    private static final String TAG = "MP4Writer";
    private volatile long mNativePtr = 0;
    private MP4WriterListener mListener = null;
    private boolean mHasVideo = false;
    private boolean mHasAudio = false;
    private String mPath = "";

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/MP4Writer$MP4WriterListener.class */
    public interface MP4WriterListener {
        void onComplete(long j);

        void onError(String str);
    }

    private static native long nativeCreate(MP4Writer mP4Writer);

    private static native void nativeDestroy(long j);

    private static native void nativeSetHasAudio(long j, boolean z);

    private static native void nativeSetHasVideo(long j, boolean z);

    private static native void nativeStart(long j, String str);

    private static native void nativeStop(long j);

    private static native void nativeWriteAudioFrame(long j, int i, int i2, long j2, int i3, ByteBuffer byteBuffer);

    private static native void nativeWriteVideoFrame(long j, int i, int i2, int i3, int i4, long j2, long j3, ByteBuffer byteBuffer);

    protected void finalize() {
        LiteavLog.i(TAG, "finalize");
        stop();
    }

    public void onComplete(long j) {
        LiteavLog.i(TAG, "onComplete,durationMs=".concat(String.valueOf(j)));
        MP4WriterListener mP4WriterListener = this.mListener;
        if (mP4WriterListener == null) {
            return;
        }
        mP4WriterListener.onComplete(j);
    }

    public void onError(String str) {
        LiteavLog.i(TAG, "onError,info=".concat(String.valueOf(str)));
        MP4WriterListener mP4WriterListener = this.mListener;
        if (mP4WriterListener == null) {
            return;
        }
        mP4WriterListener.onError(str);
    }

    public void setHasAudio(boolean z) {
        LiteavLog.i(TAG, "setHasAudio,hasAudio=".concat(String.valueOf(z)));
        this.mHasAudio = z;
    }

    public void setHasVideo(boolean z) {
        LiteavLog.i(TAG, "setHasVideo,hasVideo=".concat(String.valueOf(z)));
        this.mHasVideo = z;
    }

    public void setListener(MP4WriterListener mP4WriterListener) {
        this.mListener = mP4WriterListener;
    }

    public void setPath(String str) {
        LiteavLog.i(TAG, "path=".concat(String.valueOf(str)));
        this.mPath = str;
    }

    public void start() {
        LiteavLog.i(TAG, "start");
        if (this.mNativePtr != 0) {
            LiteavLog.w(TAG, "it is already started.");
            return;
        }
        this.mNativePtr = nativeCreate(this);
        if (this.mNativePtr == 0) {
            LiteavLog.i(TAG, "create native mp4 writer fail.");
            return;
        }
        nativeSetHasVideo(this.mNativePtr, this.mHasVideo);
        nativeSetHasAudio(this.mNativePtr, this.mHasAudio);
        nativeStart(this.mNativePtr, this.mPath);
    }

    public void stop() {
        LiteavLog.i(TAG, "stop");
        if (this.mNativePtr == 0) {
            return;
        }
        nativeStop(this.mNativePtr);
        nativeDestroy(this.mNativePtr);
        this.mNativePtr = 0L;
    }

    public void writeAudioFrame(AudioFrame audioFrame) {
        if (this.mNativePtr == 0 || audioFrame == null) {
            LiteavLog.w(TAG, "writeAudioFrame, mNativePtr or frame is null.");
        } else {
            nativeWriteAudioFrame(this.mNativePtr, audioFrame.getSampleRate(), audioFrame.getChannelCount(), audioFrame.getTimestamp(), audioFrame.getCodecFormat().getValue(), audioFrame.getData());
        }
    }

    public void writeVideoFrame(EncodedVideoFrame encodedVideoFrame) {
        if (this.mNativePtr == 0 || encodedVideoFrame == null) {
            LiteavLog.w(TAG, "writeVideoFrame, mNativePtr or frame is null.");
        } else {
            nativeWriteVideoFrame(this.mNativePtr, encodedVideoFrame.width, encodedVideoFrame.height, encodedVideoFrame.nalType.mValue, encodedVideoFrame.codecType.mValue, encodedVideoFrame.pts, encodedVideoFrame.dts, encodedVideoFrame.data);
        }
    }
}
