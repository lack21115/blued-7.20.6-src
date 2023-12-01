package com.anythink.expressad.atsignalcommon.bridge;

import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/atsignalcommon/bridge/IBannerJSBridge.class */
public interface IBannerJSBridge extends IMraidJSBridge {
    void cai(Object obj, String str);

    void click(Object obj, String str);

    void getFileInfo(Object obj, String str);

    void getNetstat(Object obj, String str);

    void gial(Object obj, String str);

    void handlerH5Exception(Object obj, String str);

    void increaseOfferFrequence(Object obj, String str);

    void init(Object obj, String str);

    void install(Object obj, String str);

    void onJSBridgeConnect(Object obj, String str);

    void openURL(Object obj, String str);

    void readyStatus(Object obj, String str);

    void reportUrls(Object obj, String str);

    void resetCountdown(Object obj, String str);

    void sendImpressions(Object obj, String str);

    void toggleCloseBtn(Object obj, String str);

    void triggerCloseBtn(Object obj, String str);
}
