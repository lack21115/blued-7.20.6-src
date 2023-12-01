package com.tencent.ugc;

import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.ugc.AudioFrame;
import com.tencent.ugc.TXVideoEditConstants;
import com.tencent.ugc.UGCAVSyncer;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

@JNINamespace("liteav::ugc")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCAudioProcessor.class */
public class UGCAudioProcessor {
    private static final String TAG = "UGCAudioProcessor";
    private UGCAVSyncer mAVSyncer;
    private long mNativeProcessor;
    private UGCMediaListSource mVideoSource;
    private AudioProgressListener mProgressListener = null;
    private AudioEncodedFrameListener mEncodeListener = null;
    private UGCMediaListSource mBGMSource = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCAudioProcessor$AudioEncodedFrameListener.class */
    public interface AudioEncodedFrameListener {
        void onAudioEncodingCompleted();

        void onAudioEncodingStarted();

        void onAudioFrameEncoded(AudioFrame audioFrame);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCAudioProcessor$AudioProgressListener.class */
    public interface AudioProgressListener {
        void onComplete(TXVideoEditConstants.TXGenerateResult tXGenerateResult);

        void onProgress(long j);
    }

    public UGCAudioProcessor(UGCAVSyncer uGCAVSyncer, UGCMediaListSource uGCMediaListSource) {
        this.mNativeProcessor = 0L;
        this.mVideoSource = null;
        this.mAVSyncer = null;
        this.mVideoSource = uGCMediaListSource;
        this.mAVSyncer = uGCAVSyncer;
        this.mNativeProcessor = nativeCreateProcessor(this);
    }

    private static native long nativeCreateProcessor(UGCAudioProcessor uGCAudioProcessor);

    private static native void nativeDestroyProcessor(long j);

    private static native void nativeEnableBGM(long j, boolean z);

    private static native void nativeInitialize(long j);

    private static native void nativeSetBGMAtVideoTime(long j, long j2);

    private static native void nativeSetBGMLoop(long j, boolean z);

    private static native void nativeSetBGMStartTime(long j, long j2, long j3);

    private static native void nativeSetBGMVolume(long j, float f);

    private static native void nativeSetEncodeParams(long j, int i, int i2, int i3, int i4);

    private static native void nativeSetFadeInOutDuration(long j, long j2, long j3);

    private static native void nativeSetSpeedList(long j, int[] iArr, long[] jArr, long[] jArr2);

    private static native void nativeSetVideoVolume(long j, float f);

    private static native void nativeSetVideoVolumes(long j, float[] fArr);

    private static native void nativeStart(long j, boolean z);

    private static native void nativeStop(long j);

    private static native void nativeUnInitialize(long j);

    private AudioFrame[] readNextAudioFrame(boolean z) {
        UGCMediaListSource uGCMediaListSource = z ? this.mBGMSource : this.mVideoSource;
        if (uGCMediaListSource == null) {
            StringBuilder sb = new StringBuilder("readNextAudioFrame failed for ");
            sb.append(z ? "BGM" : "video");
            Log.w(TAG, sb.toString(), new Object[0]);
            return null;
        }
        List<AudioFrame> readNextAudioFrame = uGCMediaListSource.readNextAudioFrame();
        if (readNextAudioFrame == null || readNextAudioFrame.isEmpty()) {
            StringBuilder sb2 = new StringBuilder("readNextAudioFrame eos for ");
            sb2.append(z ? "BGM" : "video");
            Log.i(TAG, sb2.toString(), new Object[0]);
            return null;
        }
        return (AudioFrame[]) readNextAudioFrame.toArray(new AudioFrame[0]);
    }

    public AudioFrame createAudioFrameFromNative(int i, int i2, long j, int i3, int i4) {
        AudioFrame audioFrame = new AudioFrame();
        audioFrame.setSampleRate(i);
        audioFrame.setChannelCount(i2);
        audioFrame.setData(ByteBuffer.allocateDirect(i4));
        audioFrame.setTimestamp(j);
        audioFrame.setCodecFormat(i3 == AudioFrame.AudioCodecFormat.AAC.getValue() ? AudioFrame.AudioCodecFormat.AAC : AudioFrame.AudioCodecFormat.PCM);
        return audioFrame;
    }

    public void destroy() {
        nativeDestroyProcessor(this.mNativeProcessor);
    }

    public void initialize() {
        nativeInitialize(this.mNativeProcessor);
    }

    public void notifyEncodedDataFromNative(AudioFrame audioFrame) {
        AudioEncodedFrameListener audioEncodedFrameListener = this.mEncodeListener;
        if (audioEncodedFrameListener != null) {
            audioEncodedFrameListener.onAudioFrameEncoded(audioFrame);
        }
    }

    public void notifyEncodingCompletedFromNative() {
        AudioEncodedFrameListener audioEncodedFrameListener = this.mEncodeListener;
        if (audioEncodedFrameListener != null) {
            audioEncodedFrameListener.onAudioEncodingCompleted();
        }
        UGCAVSyncer uGCAVSyncer = this.mAVSyncer;
        if (uGCAVSyncer != null) {
            uGCAVSyncer.setAudioEos();
        }
    }

    public void notifyEncodingStartedFromNative() {
        AudioEncodedFrameListener audioEncodedFrameListener = this.mEncodeListener;
        if (audioEncodedFrameListener != null) {
            audioEncodedFrameListener.onAudioEncodingStarted();
        }
    }

    public void notifyPlayoutCompletedFromNative(int i, String str) {
        if (this.mProgressListener != null) {
            TXVideoEditConstants.TXGenerateResult tXGenerateResult = new TXVideoEditConstants.TXGenerateResult();
            tXGenerateResult.retCode = i;
            tXGenerateResult.descMsg = str;
            this.mProgressListener.onComplete(tXGenerateResult);
        }
        UGCAVSyncer uGCAVSyncer = this.mAVSyncer;
        if (uGCAVSyncer != null) {
            uGCAVSyncer.setAudioEos();
        }
    }

    public void notifyProgressFromNative(long j) {
        AudioProgressListener audioProgressListener = this.mProgressListener;
        if (audioProgressListener != null) {
            audioProgressListener.onProgress(j);
        }
    }

    public AudioFrame[] requestAudioDataFromNative() {
        return readNextAudioFrame(false);
    }

    public AudioFrame[] requestBGMDataFromNative() {
        return readNextAudioFrame(true);
    }

    public boolean requestBGMSeekFromNative(long j) {
        UGCMediaListSource uGCMediaListSource = this.mBGMSource;
        if (uGCMediaListSource == null || !uGCMediaListSource.hasAudioData() || this.mBGMSource.getDuration() < j) {
            return false;
        }
        this.mBGMSource.seekTo(j);
        return true;
    }

    public void setAudioEncodedFrameListener(AudioEncodedFrameListener audioEncodedFrameListener) {
        this.mEncodeListener = audioEncodedFrameListener;
    }

    public void setBGM(String str) {
        if (str == null) {
            nativeEnableBGM(this.mNativeProcessor, false);
            return;
        }
        UGCMediaListSource uGCMediaListSource = new UGCMediaListSource();
        this.mBGMSource = uGCMediaListSource;
        uGCMediaListSource.initialize();
        this.mBGMSource.setVideoSources(Collections.singletonList(str));
        nativeEnableBGM(this.mNativeProcessor, true);
        long duration = this.mBGMSource.getDuration();
        if (duration > 0) {
            setBGMStartTime(0L, duration);
        }
    }

    public void setBGMAtVideoTime(long j) {
        nativeSetBGMAtVideoTime(this.mNativeProcessor, j);
    }

    public void setBGMLoop(boolean z) {
        nativeSetBGMLoop(this.mNativeProcessor, z);
    }

    public void setBGMStartTime(long j, long j2) {
        nativeSetBGMStartTime(this.mNativeProcessor, j, j2);
    }

    public void setBGMVolume(float f) {
        nativeSetBGMVolume(this.mNativeProcessor, f);
    }

    public void setEncodeParams(AudioEncodeParams audioEncodeParams) {
        nativeSetEncodeParams(this.mNativeProcessor, audioEncodeParams.getSampleRate(), audioEncodeParams.getChannels(), audioEncodeParams.getBitsPerChannel(), audioEncodeParams.getBitrate());
    }

    public void setFadeInOutDuration(long j, long j2) {
        nativeSetFadeInOutDuration(this.mNativeProcessor, j, j2);
    }

    public void setMediaListSource(UGCMediaListSource uGCMediaListSource) {
        this.mVideoSource = uGCMediaListSource;
    }

    public void setProgressListener(AudioProgressListener audioProgressListener) {
        this.mProgressListener = audioProgressListener;
    }

    public void setSpeedList(List<TXVideoEditConstants.TXSpeed> list) {
        long[] jArr;
        long[] jArr2;
        int[] iArr = null;
        if (list != null && !list.isEmpty()) {
            int[] iArr2 = new int[list.size()];
            long[] jArr3 = new long[list.size()];
            long[] jArr4 = new long[list.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                iArr = iArr2;
                jArr = jArr3;
                jArr2 = jArr4;
                if (i2 >= list.size()) {
                    break;
                }
                TXVideoEditConstants.TXSpeed tXSpeed = list.get(i2);
                iArr2[i2] = tXSpeed.speedLevel;
                jArr3[i2] = tXSpeed.startTime;
                jArr4[i2] = tXSpeed.endTime;
                i = i2 + 1;
            }
        } else {
            jArr = null;
            jArr2 = null;
        }
        nativeSetSpeedList(this.mNativeProcessor, iArr, jArr, jArr2);
    }

    public void setVideoVolume(float f) {
        nativeSetVideoVolume(this.mNativeProcessor, f);
    }

    public void setVideoVolumes(float[] fArr) {
        nativeSetVideoVolumes(this.mNativeProcessor, fArr);
    }

    public void start(boolean z) {
        nativeStart(this.mNativeProcessor, z);
    }

    public void stop() {
        nativeStop(this.mNativeProcessor);
    }

    public int syncAudioFromNative(long j) {
        UGCAVSyncer uGCAVSyncer = this.mAVSyncer;
        return uGCAVSyncer != null ? uGCAVSyncer.syncAudio(j).getNativeValue() : UGCAVSyncer.SkipMode.NOOP.getNativeValue();
    }

    public void unInitialize() {
        nativeUnInitialize(this.mNativeProcessor);
    }
}
