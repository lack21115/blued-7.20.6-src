package com.zego.zegoavkit2.networktrace;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/networktrace/ZegoNetworktrace.class */
public class ZegoNetworktrace {
    private static ZegoNetworktrace sInstance;
    private ZegoNetworktraceJNI mJniInstance = new ZegoNetworktraceJNI();

    private ZegoNetworktrace() {
    }

    public static ZegoNetworktrace getInstance() {
        if (sInstance == null) {
            synchronized (ZegoNetworktrace.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ZegoNetworktrace();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public void setNetworkTraceCallback(IZegoNetworkTraceCallback iZegoNetworkTraceCallback) {
        ZegoNetworktraceJNI.setNetworkTraceCallback(iZegoNetworkTraceCallback);
    }

    public void startNetworkTrace(ZegoNetworkTraceConfig zegoNetworkTraceConfig) {
        ZegoNetworktraceJNI.startNetworkTrace(zegoNetworkTraceConfig);
    }

    public void stopNetworkTrace() {
        ZegoNetworktraceJNI.stopNetworkTrace();
    }
}
