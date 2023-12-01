package com.zego.zegoavkit2.peertopeerlatencyprobe;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/peertopeerlatencyprobe/ZegoPeerToPeerLatencyProbeJNI.class */
final class ZegoPeerToPeerLatencyProbeJNI {
    private static volatile IZegoPeerToPeerLatencyProbeCallback sCallback;

    ZegoPeerToPeerLatencyProbeJNI() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void enablePeerToPeerLatencyProbe(boolean z, int i);

    public static void onPeerToPeerLatencyProbeResult(String str, int i) {
        IZegoPeerToPeerLatencyProbeCallback iZegoPeerToPeerLatencyProbeCallback = sCallback;
        if (iZegoPeerToPeerLatencyProbeCallback != null) {
            iZegoPeerToPeerLatencyProbeCallback.onPeerToPeerLatencyProbeResult(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCallback(IZegoPeerToPeerLatencyProbeCallback iZegoPeerToPeerLatencyProbeCallback) {
        sCallback = iZegoPeerToPeerLatencyProbeCallback;
        if (iZegoPeerToPeerLatencyProbeCallback != null) {
            setPeerToPeerLatencyProbeCallback(true);
        } else {
            setPeerToPeerLatencyProbeCallback(false);
        }
    }

    private static native void setPeerToPeerLatencyProbeCallback(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static native void setPeerToPeerLatencyProbeInterval(int i, int i2);
}
