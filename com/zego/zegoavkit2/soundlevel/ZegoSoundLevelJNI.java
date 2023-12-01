package com.zego.zegoavkit2.soundlevel;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/soundlevel/ZegoSoundLevelJNI.class */
final class ZegoSoundLevelJNI {
    private IZegoSoundLevelCallback mCallback = null;
    private Handler mHandler = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean enableVAD(boolean z);

    public void onCaptureSoundLevelUpdate(final ZegoSoundLevelInfo zegoSoundLevelInfo) {
        Handler handler = this.mHandler;
        final IZegoSoundLevelCallback iZegoSoundLevelCallback = this.mCallback;
        if (handler == null || iZegoSoundLevelCallback == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.zego.zegoavkit2.soundlevel.ZegoSoundLevelJNI.2
            @Override // java.lang.Runnable
            public void run() {
                iZegoSoundLevelCallback.onCaptureSoundLevelUpdate(zegoSoundLevelInfo);
            }
        });
    }

    public void onSoundLevelUpdate(final ZegoSoundLevelInfo[] zegoSoundLevelInfoArr) {
        Handler handler = this.mHandler;
        final IZegoSoundLevelCallback iZegoSoundLevelCallback = this.mCallback;
        if (handler == null || iZegoSoundLevelCallback == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.zego.zegoavkit2.soundlevel.ZegoSoundLevelJNI.1
            @Override // java.lang.Runnable
            public void run() {
                iZegoSoundLevelCallback.onSoundLevelUpdate(zegoSoundLevelInfoArr);
            }
        });
    }

    public void setCallback(IZegoSoundLevelCallback iZegoSoundLevelCallback) {
        this.mCallback = iZegoSoundLevelCallback;
        if (iZegoSoundLevelCallback != null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
                return;
            }
            return;
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean setCycle(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean start();

    /* JADX INFO: Access modifiers changed from: package-private */
    public native boolean stop();
}
