package com.zego.zegoavkit2.audioobserver;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioobserver/ZegoAudioObserverJNI.class */
final class ZegoAudioObserverJNI {
    private static volatile IZegoAudioObserverCallback mAudioObserverCallback;

    ZegoAudioObserverJNI() {
    }

    private static native void enableAudioObserverCallback(boolean z);

    public static void onAudioObserverError(final int i) {
        final IZegoAudioObserverCallback iZegoAudioObserverCallback = mAudioObserverCallback;
        if (iZegoAudioObserverCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.audioobserver.ZegoAudioObserverJNI.1
                @Override // java.lang.Runnable
                public void run() {
                    IZegoAudioObserverCallback iZegoAudioObserverCallback2 = IZegoAudioObserverCallback.this;
                    if (iZegoAudioObserverCallback2 != null) {
                        iZegoAudioObserverCallback2.onAudioObserverError(i);
                    }
                }
            });
        }
    }

    public static void onCapturedAudioData(byte[] bArr, int i, int i2, int i3) {
        IZegoAudioObserverCallback iZegoAudioObserverCallback = mAudioObserverCallback;
        if (iZegoAudioObserverCallback != null) {
            iZegoAudioObserverCallback.onCapturedAudioData(bArr, i, i2, i3);
        }
    }

    public static void onMixAudioData(byte[] bArr, int i, int i2, int i3) {
        IZegoAudioObserverCallback iZegoAudioObserverCallback = mAudioObserverCallback;
        if (iZegoAudioObserverCallback != null) {
            iZegoAudioObserverCallback.onMixAudioData(bArr, i, i2, i3);
        }
    }

    public static void onPlaybackAudioData(byte[] bArr, int i, int i2, int i3) {
        IZegoAudioObserverCallback iZegoAudioObserverCallback = mAudioObserverCallback;
        if (iZegoAudioObserverCallback != null) {
            iZegoAudioObserverCallback.onPlaybackAudioData(bArr, i, i2, i3);
        }
    }

    public static void setAudioObserverCallback(IZegoAudioObserverCallback iZegoAudioObserverCallback) {
        mAudioObserverCallback = iZegoAudioObserverCallback;
        enableAudioObserverCallback(iZegoAudioObserverCallback != null);
    }

    public static native boolean startAudioObserver(int i, int i2, int i3);

    public static native void stopAudioObserver();
}
