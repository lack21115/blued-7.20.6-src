package com.qq.e.mediation.interfaces;

import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/mediation/interfaces/IBaseAd.class */
public interface IBaseAd {
    int getECPM();

    Map<String, Object> getExtraInfo();

    String getReqId();

    void sendLossNotification(int i, int i2, String str);

    void sendWinNotification(int i);

    void setBidECPM(int i);

    void setPayload(String str);
}
