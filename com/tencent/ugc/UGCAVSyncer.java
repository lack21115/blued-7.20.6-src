package com.tencent.ugc;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav::ugc")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCAVSyncer.class */
public class UGCAVSyncer {
    protected long mNativeUGCAVSyncer;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCAVSyncer$SkipMode.class */
    public enum SkipMode {
        NOOP(0),
        SKIP_CURRENT_FRAME(1);
        
        private final int mNativeValue;

        SkipMode(int i) {
            this.mNativeValue = i;
        }

        public static SkipMode valueOf(int i) {
            return i == 1 ? SKIP_CURRENT_FRAME : NOOP;
        }

        public final int getNativeValue() {
            return this.mNativeValue;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCAVSyncer$SyncMode.class */
    public enum SyncMode {
        OFF(0),
        CLOCK_MASTER(1),
        AUDIO_MASTER(2),
        VIDEO_MASTER(3),
        INTERLEAVE_OUTPUT_WITHOUT_SKIP(4);
        
        private final int mNativeValue;

        SyncMode(int i) {
            this.mNativeValue = i;
        }

        public final int getNativeValue() {
            return this.mNativeValue;
        }
    }

    public UGCAVSyncer() {
        this.mNativeUGCAVSyncer = 0L;
        this.mNativeUGCAVSyncer = nativeCreate();
    }

    private static native long nativeCreate();

    private static native void nativeDestroy(long j);

    private static native void nativeResetClock(long j);

    private static native void nativeSetAudioEos(long j);

    private static native void nativeSetAudioExist(long j, boolean z);

    private static native void nativeSetSyncMode(long j, int i);

    private static native void nativeSetVideoEos(long j);

    private static native void nativeSetVideoExist(long j, boolean z);

    private static native void nativeStart(long j);

    private static native void nativeStop(long j);

    private static native int nativeSyncAudio(long j, long j2);

    private static native int nativeSyncVideo(long j, long j2);

    protected void finalize() throws Throwable {
        long j = this.mNativeUGCAVSyncer;
        if (j != 0) {
            nativeDestroy(j);
            this.mNativeUGCAVSyncer = 0L;
        }
    }

    public void resetClock() {
        long j = this.mNativeUGCAVSyncer;
        if (j != 0) {
            nativeResetClock(j);
        }
    }

    public void setAudioEos() {
        long j = this.mNativeUGCAVSyncer;
        if (j != 0) {
            nativeSetAudioEos(j);
        }
    }

    public void setAudioExist(boolean z) {
        long j = this.mNativeUGCAVSyncer;
        if (j != 0) {
            nativeSetAudioExist(j, z);
        }
    }

    public void setSyncMode(SyncMode syncMode) {
        long j = this.mNativeUGCAVSyncer;
        if (j != 0) {
            nativeSetSyncMode(j, syncMode.getNativeValue());
        }
    }

    public void setVideoEos() {
        long j = this.mNativeUGCAVSyncer;
        if (j != 0) {
            nativeSetVideoEos(j);
        }
    }

    public void setVideoExist(boolean z) {
        long j = this.mNativeUGCAVSyncer;
        if (j != 0) {
            nativeSetVideoExist(j, z);
        }
    }

    public void start() {
        long j = this.mNativeUGCAVSyncer;
        if (j != 0) {
            nativeStart(j);
        }
    }

    public void stop() {
        long j = this.mNativeUGCAVSyncer;
        if (j != 0) {
            nativeStop(j);
        }
    }

    public SkipMode syncAudio(long j) {
        long j2 = this.mNativeUGCAVSyncer;
        return j2 == 0 ? SkipMode.NOOP : SkipMode.valueOf(nativeSyncAudio(j2, j));
    }

    public SkipMode syncVideo(long j) {
        long j2 = this.mNativeUGCAVSyncer;
        return j2 == 0 ? SkipMode.NOOP : SkipMode.valueOf(nativeSyncVideo(j2, j));
    }
}
