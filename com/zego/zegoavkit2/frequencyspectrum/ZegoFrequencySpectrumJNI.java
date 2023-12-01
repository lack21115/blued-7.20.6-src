package com.zego.zegoavkit2.frequencyspectrum;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/frequencyspectrum/ZegoFrequencySpectrumJNI.class */
final class ZegoFrequencySpectrumJNI {
    private IZegoFrequencySpectrumCallback mCallback = null;
    private Handler mHandler = null;

    public void onCaptureFrequencySpectrumUpdate(final ZegoFrequencySpectrumInfo zegoFrequencySpectrumInfo) {
        Handler handler = this.mHandler;
        final IZegoFrequencySpectrumCallback iZegoFrequencySpectrumCallback = this.mCallback;
        if (handler == null || iZegoFrequencySpectrumCallback == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.zego.zegoavkit2.frequencyspectrum.ZegoFrequencySpectrumJNI.2
            @Override // java.lang.Runnable
            public void run() {
                iZegoFrequencySpectrumCallback.onCaptureFrequencySpectrumUpdate(zegoFrequencySpectrumInfo);
            }
        });
    }

    public void onFrequencySpectrumUpdate(final ZegoFrequencySpectrumInfo[] zegoFrequencySpectrumInfoArr) {
        Handler handler = this.mHandler;
        final IZegoFrequencySpectrumCallback iZegoFrequencySpectrumCallback = this.mCallback;
        if (handler == null || iZegoFrequencySpectrumCallback == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.zego.zegoavkit2.frequencyspectrum.ZegoFrequencySpectrumJNI.1
            @Override // java.lang.Runnable
            public void run() {
                iZegoFrequencySpectrumCallback.onFrequencySpectrumUpdate(zegoFrequencySpectrumInfoArr);
            }
        });
    }

    public void setCallback(IZegoFrequencySpectrumCallback iZegoFrequencySpectrumCallback) {
        this.mCallback = iZegoFrequencySpectrumCallback;
        if (iZegoFrequencySpectrumCallback != null) {
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

    public native boolean setCycle(int i);

    public native boolean start();

    public native boolean stop();
}
