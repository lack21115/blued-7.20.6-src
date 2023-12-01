package com.zego.zegoavkit2.networkprobe;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/networkprobe/IZegoNetWorkProbeCallback.class */
public interface IZegoNetWorkProbeCallback {
    void onConnectResult(int i, ZegoNetConnectInfo zegoNetConnectInfo, int i2);

    void onTestStop(int i, int i2);

    void onUpdateSpeed(ZegoNetQualityInfo zegoNetQualityInfo, int i);
}
