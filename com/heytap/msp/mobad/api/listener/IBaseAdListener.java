package com.heytap.msp.mobad.api.listener;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/msp/mobad/api/listener/IBaseAdListener.class */
public interface IBaseAdListener {
    void onAdClick();

    void onAdFailed(int i, String str);

    @Deprecated
    void onAdFailed(String str);

    void onAdShow();
}
