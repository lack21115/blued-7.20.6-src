package com.tencent.tencentmap.lbssdk.service;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tencentmap/lbssdk/service/TxGposListener.class */
public interface TxGposListener {
    void onTxGposLocation(int[] iArr, double[] dArr);

    void onTxGposLocationBDS(int[] iArr, double[] dArr);

    void onTxRtcmReceived(int[] iArr);
}
