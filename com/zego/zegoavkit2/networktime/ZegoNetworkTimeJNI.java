package com.zego.zegoavkit2.networktime;

import android.os.Handler;
import android.os.Looper;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/networktime/ZegoNetworkTimeJNI.class */
public final class ZegoNetworkTimeJNI {
    private static volatile IZegoNetworkTimeCallback mNetWorkTimeCallback;

    private static native void enableNetworkTimeCallback(boolean z);

    public static native void getNetworkTimeInfo(ZegoNetworkTimeInfo zegoNetworkTimeInfo);

    public static void onNetworkTimeSynchronized() {
        final IZegoNetworkTimeCallback iZegoNetworkTimeCallback = mNetWorkTimeCallback;
        if (iZegoNetworkTimeCallback != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zego.zegoavkit2.networktime.ZegoNetworkTimeJNI.1
                @Override // java.lang.Runnable
                public void run() {
                    IZegoNetworkTimeCallback iZegoNetworkTimeCallback2 = IZegoNetworkTimeCallback.this;
                    if (iZegoNetworkTimeCallback2 != null) {
                        iZegoNetworkTimeCallback2.onNetworkTimeSynchronized();
                    }
                }
            });
        }
    }

    public static void setNetworkTimeCallback(IZegoNetworkTimeCallback iZegoNetworkTimeCallback) {
        mNetWorkTimeCallback = iZegoNetworkTimeCallback;
        enableNetworkTimeCallback(iZegoNetworkTimeCallback != null);
    }
}
