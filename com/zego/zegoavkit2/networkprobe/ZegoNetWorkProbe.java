package com.zego.zegoavkit2.networkprobe;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/networkprobe/ZegoNetWorkProbe.class */
public class ZegoNetWorkProbe {
    private static ZegoNetWorkProbe sInstance;
    private ZegoNetWorkProbeJNI mJniInstance = new ZegoNetWorkProbeJNI();

    private ZegoNetWorkProbe() {
    }

    public static ZegoNetWorkProbe getInstance() {
        if (sInstance == null) {
            synchronized (ZegoNetWorkProbe.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ZegoNetWorkProbe();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public void setNetWorkProbeCallback(IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback) {
        ZegoNetWorkProbeJNI.setNetWorkProbeCallback(iZegoNetWorkProbeCallback);
    }

    public void setQualityCallbackInterval(int i) {
        ZegoNetWorkProbeJNI.setQualityCallbackInterval(i);
    }

    public void startConnectivityTest() {
        ZegoNetWorkProbeJNI.startConnectivityTest();
    }

    public void startDownlinkSpeedTest(int i) {
        ZegoNetWorkProbeJNI.startDownlinkSpeedTest(i);
    }

    public void startUplinkSpeedTest(int i) {
        ZegoNetWorkProbeJNI.startUplinkSpeedTest(i);
    }

    public void stopConnectivityTest() {
        ZegoNetWorkProbeJNI.stopConnectivityTest();
    }

    public void stopDownlinkSpeedTest() {
        ZegoNetWorkProbeJNI.stopDownlinkSpeedTest();
    }

    public void stopUplinkSpeedTest() {
        ZegoNetWorkProbeJNI.stopUplinkSpeedTest();
    }
}
