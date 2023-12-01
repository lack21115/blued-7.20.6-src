package com.zego.zegoavkit2.peertopeerlatencyprobe;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/peertopeerlatencyprobe/ZegoPeerToPeerLatencyProbe.class */
public class ZegoPeerToPeerLatencyProbe {
    private static volatile ZegoPeerToPeerLatencyProbe sInstance;
    private volatile IZegoPeerToPeerLatencyProbeCallback mZegoPeerToPeerLatencyProbeCallback;

    public static ZegoPeerToPeerLatencyProbe getInstance() {
        if (sInstance == null) {
            synchronized (ZegoPeerToPeerLatencyProbe.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new ZegoPeerToPeerLatencyProbe();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sInstance;
    }

    public void enablePeerToPeerLatencyProbe(boolean z, int i) {
        ZegoPeerToPeerLatencyProbeJNI.enablePeerToPeerLatencyProbe(z, i);
    }

    public void setPeerToPeerLatencyProbeInterval(int i, int i2) {
        ZegoPeerToPeerLatencyProbeJNI.setPeerToPeerLatencyProbeInterval(i, i2);
    }

    public void setZegoPeerToPeerLatencyProbeCallback(IZegoPeerToPeerLatencyProbeCallback iZegoPeerToPeerLatencyProbeCallback) {
        this.mZegoPeerToPeerLatencyProbeCallback = iZegoPeerToPeerLatencyProbeCallback;
        if (iZegoPeerToPeerLatencyProbeCallback != null) {
            ZegoPeerToPeerLatencyProbeJNI.setCallback(new IZegoPeerToPeerLatencyProbeCallback() { // from class: com.zego.zegoavkit2.peertopeerlatencyprobe.ZegoPeerToPeerLatencyProbe.1
                @Override // com.zego.zegoavkit2.peertopeerlatencyprobe.IZegoPeerToPeerLatencyProbeCallback
                public void onPeerToPeerLatencyProbeResult(final String str, final int i) {
                    final IZegoPeerToPeerLatencyProbeCallback iZegoPeerToPeerLatencyProbeCallback2 = ZegoPeerToPeerLatencyProbe.this.mZegoPeerToPeerLatencyProbeCallback;
                    if (iZegoPeerToPeerLatencyProbeCallback2 != null) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.peertopeerlatencyprobe.ZegoPeerToPeerLatencyProbe.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                iZegoPeerToPeerLatencyProbeCallback2.onPeerToPeerLatencyProbeResult(str, i);
                            }
                        });
                    }
                }
            });
        } else {
            ZegoPeerToPeerLatencyProbeJNI.setCallback(null);
        }
    }
}
