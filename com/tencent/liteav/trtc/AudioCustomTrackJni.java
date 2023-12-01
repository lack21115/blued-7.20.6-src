package com.tencent.liteav.trtc;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.trtc.TRTCCloudDef;

@JNINamespace("liteav::trtc")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/AudioCustomTrackJni.class */
public class AudioCustomTrackJni {
    private long mNativeAudioCustomTrackJni;
    private int mPlayoutVolume = 100;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/trtc/AudioCustomTrackJni$AudioFrame.class */
    static class AudioFrame {

        /* renamed from: a  reason: collision with root package name */
        private TRTCCloudDef.TRTCAudioFrame f22749a;

        public AudioFrame(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
            this.f22749a = tRTCAudioFrame;
        }

        public int getChannel() {
            return this.f22749a.channel;
        }

        public byte[] getData() {
            return this.f22749a.data;
        }

        public int getSampleRate() {
            return this.f22749a.sampleRate;
        }

        public long getTimestamp() {
            return this.f22749a.timestamp;
        }
    }

    public AudioCustomTrackJni() {
        this.mNativeAudioCustomTrackJni = 0L;
        this.mNativeAudioCustomTrackJni = nativeCreateAudioCustomTrackJni(this);
    }

    private static native void nativeClean(long j);

    private static native long nativeCreateAudioCustomTrackJni(AudioCustomTrackJni audioCustomTrackJni);

    private static native void nativeEnablePlayout(long j, boolean z);

    private static native void nativePause(long j);

    private static native void nativeResume(long j);

    private static native void nativeSeek(long j);

    private static native void nativeSetPlayoutVolume(long j, int i);

    private static native int nativeWriteData(long j, AudioFrame audioFrame);

    public void clean() {
        synchronized (this) {
            if (this.mNativeAudioCustomTrackJni != 0) {
                nativeClean(this.mNativeAudioCustomTrackJni);
            }
        }
    }

    public void enablePlayout(boolean z) {
        synchronized (this) {
            if (this.mNativeAudioCustomTrackJni != 0) {
                nativeEnablePlayout(this.mNativeAudioCustomTrackJni, z);
                if (z) {
                    nativeSetPlayoutVolume(this.mNativeAudioCustomTrackJni, this.mPlayoutVolume);
                }
            }
        }
    }

    public void pause() {
        synchronized (this) {
            if (this.mNativeAudioCustomTrackJni != 0) {
                nativePause(this.mNativeAudioCustomTrackJni);
            }
        }
    }

    public void resume() {
        synchronized (this) {
            if (this.mNativeAudioCustomTrackJni != 0) {
                nativeResume(this.mNativeAudioCustomTrackJni);
            }
        }
    }

    public void seek() {
        synchronized (this) {
            if (this.mNativeAudioCustomTrackJni != 0) {
                nativeSeek(this.mNativeAudioCustomTrackJni);
            }
        }
    }

    public void setPlayoutVolume(int i) {
        synchronized (this) {
            if (this.mNativeAudioCustomTrackJni != 0) {
                this.mPlayoutVolume = i;
                nativeSetPlayoutVolume(this.mNativeAudioCustomTrackJni, i);
            }
        }
    }

    public int writeData(TRTCCloudDef.TRTCAudioFrame tRTCAudioFrame) {
        synchronized (this) {
            if (this.mNativeAudioCustomTrackJni != 0) {
                return nativeWriteData(this.mNativeAudioCustomTrackJni, new AudioFrame(tRTCAudioFrame));
            }
            return -1;
        }
    }
}
