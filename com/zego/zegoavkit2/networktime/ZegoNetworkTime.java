package com.zego.zegoavkit2.networktime;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/networktime/ZegoNetworkTime.class */
public class ZegoNetworkTime {
    public static ZegoNetworkTimeInfo getNetworkTimeInfo() {
        ZegoNetworkTimeInfo zegoNetworkTimeInfo = new ZegoNetworkTimeInfo();
        ZegoNetworkTimeJNI.getNetworkTimeInfo(zegoNetworkTimeInfo);
        return zegoNetworkTimeInfo;
    }

    public static void setNetworkTimeCallback(IZegoNetworkTimeCallback iZegoNetworkTimeCallback) {
        ZegoNetworkTimeJNI.setNetworkTimeCallback(iZegoNetworkTimeCallback);
    }
}
