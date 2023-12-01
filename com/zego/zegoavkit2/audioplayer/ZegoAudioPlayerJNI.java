package com.zego.zegoavkit2.audioplayer;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioplayer/ZegoAudioPlayerJNI.class */
final class ZegoAudioPlayerJNI {
    private static Lock mCallbackLock = new ReentrantLock();
    private static volatile IZegoAudioPlayerCallback mCallback = null;

    ZegoAudioPlayerJNI() {
    }

    public static native void createAudioPlayer();

    public static native void destroyAudioPlayer();

    public static native long getCurrentDuration(int i);

    public static native long getDuration(int i);

    public static void onPlayEffect(final int i, final int i2) {
        mCallbackLock.lock();
        if (mCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.audioplayer.ZegoAudioPlayerJNI.1
                @Override // java.lang.Runnable
                public void run() {
                    ZegoAudioPlayerJNI.mCallbackLock.lock();
                    if (ZegoAudioPlayerJNI.mCallback != null) {
                        ZegoAudioPlayerJNI.mCallback.onPlayEffect(i, i2);
                    }
                    ZegoAudioPlayerJNI.mCallbackLock.unlock();
                }
            });
        }
        mCallbackLock.unlock();
    }

    public static void onPlayEnd(final int i) {
        mCallbackLock.lock();
        if (mCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.audioplayer.ZegoAudioPlayerJNI.3
                @Override // java.lang.Runnable
                public void run() {
                    ZegoAudioPlayerJNI.mCallbackLock.lock();
                    if (ZegoAudioPlayerJNI.mCallback != null) {
                        ZegoAudioPlayerJNI.mCallback.onPlayEnd(i);
                    }
                    ZegoAudioPlayerJNI.mCallbackLock.unlock();
                }
            });
        }
        mCallbackLock.unlock();
    }

    public static void onPreloadComplete(final int i) {
        mCallbackLock.lock();
        if (mCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.audioplayer.ZegoAudioPlayerJNI.4
                @Override // java.lang.Runnable
                public void run() {
                    ZegoAudioPlayerJNI.mCallbackLock.lock();
                    if (ZegoAudioPlayerJNI.mCallback != null) {
                        ZegoAudioPlayerJNI.mCallback.onPreloadComplete(i);
                    }
                    ZegoAudioPlayerJNI.mCallbackLock.unlock();
                }
            });
        }
        mCallbackLock.unlock();
    }

    public static void onPreloadEffect(final int i, final int i2) {
        mCallbackLock.lock();
        if (mCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.audioplayer.ZegoAudioPlayerJNI.2
                @Override // java.lang.Runnable
                public void run() {
                    ZegoAudioPlayerJNI.mCallbackLock.lock();
                    if (ZegoAudioPlayerJNI.mCallback != null) {
                        ZegoAudioPlayerJNI.mCallback.onPreloadEffect(i, i2);
                    }
                    ZegoAudioPlayerJNI.mCallbackLock.unlock();
                }
            });
        }
        mCallbackLock.unlock();
    }

    public static native void pauseAll();

    public static native void pauseEffect(int i);

    public static native void playEffect(String str, int i, int i2, boolean z);

    public static native void preloadEffect(String str, int i);

    public static native void resumeAll();

    public static native void resumeEffect(int i);

    public static native int seekTo(int i, long j);

    public static void setCallback(IZegoAudioPlayerCallback iZegoAudioPlayerCallback) {
        mCallbackLock.lock();
        mCallback = iZegoAudioPlayerCallback;
        mCallbackLock.unlock();
    }

    public static native void setPlaySpeed(int i, float f);

    public static native void setVolume(int i, int i2);

    public static native void setVolumeAll(int i);

    public static native void stopAll();

    public static native void stopEffect(int i);

    public static native void unloadEffect(int i);
}
