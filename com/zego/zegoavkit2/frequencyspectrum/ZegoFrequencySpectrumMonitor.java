package com.zego.zegoavkit2.frequencyspectrum;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/frequencyspectrum/ZegoFrequencySpectrumMonitor.class */
public class ZegoFrequencySpectrumMonitor {
    private static ZegoFrequencySpectrumMonitor sInstance;
    private ZegoFrequencySpectrumJNI mJniInstance = new ZegoFrequencySpectrumJNI();

    private ZegoFrequencySpectrumMonitor() {
    }

    public static ZegoFrequencySpectrumMonitor getInstance() {
        if (sInstance == null) {
            synchronized (ZegoFrequencySpectrumMonitor.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ZegoFrequencySpectrumMonitor();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public void setCallback(IZegoFrequencySpectrumCallback iZegoFrequencySpectrumCallback) {
        this.mJniInstance.setCallback(iZegoFrequencySpectrumCallback);
    }

    public boolean setCycle(int i) {
        return this.mJniInstance.setCycle(i);
    }

    public boolean start() {
        boolean start;
        synchronized (this) {
            start = this.mJniInstance.start();
        }
        return start;
    }

    public boolean stop() {
        boolean stop;
        synchronized (this) {
            stop = this.mJniInstance.stop();
        }
        return stop;
    }
}
