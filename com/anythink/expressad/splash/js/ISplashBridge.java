package com.anythink.expressad.splash.js;

import com.anythink.expressad.atsignalcommon.mraid.IMraidJSBridge;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/splash/js/ISplashBridge.class */
public interface ISplashBridge extends IMraidJSBridge {
    void cai(Object obj, String str);

    void gial(Object obj, String str);

    void handlerH5Exception(Object obj, String str);

    void init(Object obj, String str);

    void install(Object obj, String str);

    void onJSBridgeConnect(Object obj, String str);

    void openURL(Object obj, String str);

    void pauseCountDown(Object obj, String str);

    void readyStatus(Object obj, String str);

    void reportUrls(Object obj, String str);

    void resetCountdown(Object obj, String str);

    void resumeCountDown(Object obj, String str);

    void sendImpressions(Object obj, String str);

    void toggleCloseBtn(Object obj, String str);

    void triggerCloseBtn(Object obj, String str);
}
