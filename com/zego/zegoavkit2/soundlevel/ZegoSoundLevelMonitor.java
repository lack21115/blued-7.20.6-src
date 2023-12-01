package com.zego.zegoavkit2.soundlevel;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/soundlevel/ZegoSoundLevelMonitor.class */
public class ZegoSoundLevelMonitor {
    private static ZegoSoundLevelMonitor sInstance;
    private ZegoSoundLevelJNI mJniInstance = new ZegoSoundLevelJNI();

    private ZegoSoundLevelMonitor() {
    }

    public static ZegoSoundLevelMonitor getInstance() {
        if (sInstance == null) {
            synchronized (ZegoSoundLevelMonitor.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ZegoSoundLevelMonitor();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public boolean enableVAD(boolean z) {
        return this.mJniInstance.enableVAD(z);
    }

    public void setCallback(IZegoSoundLevelCallback iZegoSoundLevelCallback) {
        this.mJniInstance.setCallback(iZegoSoundLevelCallback);
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
