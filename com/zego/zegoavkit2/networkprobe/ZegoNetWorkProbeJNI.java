package com.zego.zegoavkit2.networkprobe;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/networkprobe/ZegoNetWorkProbeJNI.class */
public final class ZegoNetWorkProbeJNI {
    private static volatile IZegoNetWorkProbeCallback mNetWorkProbeCallback;

    private static native void enableNetWorkProbeCallback(boolean z);

    public static void onConnectResult(final int i, final ZegoNetConnectInfo zegoNetConnectInfo, final int i2) {
        final IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback = mNetWorkProbeCallback;
        if (iZegoNetWorkProbeCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.networkprobe.ZegoNetWorkProbeJNI.1
                @Override // java.lang.Runnable
                public void run() {
                    IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback2 = IZegoNetWorkProbeCallback.this;
                    if (iZegoNetWorkProbeCallback2 != null) {
                        iZegoNetWorkProbeCallback2.onConnectResult(i, zegoNetConnectInfo, i2);
                    }
                }
            });
        }
    }

    public static void onTestStop(final int i, final int i2) {
        final IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback = mNetWorkProbeCallback;
        if (iZegoNetWorkProbeCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.networkprobe.ZegoNetWorkProbeJNI.3
                @Override // java.lang.Runnable
                public void run() {
                    IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback2 = IZegoNetWorkProbeCallback.this;
                    if (iZegoNetWorkProbeCallback2 != null) {
                        iZegoNetWorkProbeCallback2.onTestStop(i, i2);
                    }
                }
            });
        }
    }

    public static void onUpdateSpeed(final ZegoNetQualityInfo zegoNetQualityInfo, final int i) {
        final IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback = mNetWorkProbeCallback;
        if (iZegoNetWorkProbeCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.networkprobe.ZegoNetWorkProbeJNI.2
                @Override // java.lang.Runnable
                public void run() {
                    IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback2 = IZegoNetWorkProbeCallback.this;
                    if (iZegoNetWorkProbeCallback2 != null) {
                        iZegoNetWorkProbeCallback2.onUpdateSpeed(zegoNetQualityInfo, i);
                    }
                }
            });
        }
    }

    public static void setNetWorkProbeCallback(IZegoNetWorkProbeCallback iZegoNetWorkProbeCallback) {
        mNetWorkProbeCallback = iZegoNetWorkProbeCallback;
        enableNetWorkProbeCallback(iZegoNetWorkProbeCallback != null);
    }

    public static native void setQualityCallbackInterval(int i);

    public static native void startConnectivityTest();

    public static native void startDownlinkSpeedTest(int i);

    public static native void startUplinkSpeedTest(int i);

    public static native void stopConnectivityTest();

    public static native void stopDownlinkSpeedTest();

    public static native void stopUplinkSpeedTest();
}
