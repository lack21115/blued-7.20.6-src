package com.anythink.network.ks;

import com.kwad.sdk.api.KsAdSDK;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATConst.class */
public class KSATConst {
    public static final int NETWORK_FIRM_ID = 28;
    public static final String REWARDEDVIDEO_SKIP_AFTER_THIRTY_SECOND = "KS_RV_SKIP_AFTER_THIRTY_SECOND";

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/ks/KSATConst$DEBUGGER_CONFIG.class */
    public static class DEBUGGER_CONFIG {
        public static final int KS_NATIVE_DRAW = 200;
        public static final int KS_NATIVE_SELF_RENDER = 101;
        public static final int KS_NATIVE_TEMPLATE = 102;
        public static final int KS_NETWORK = 28;
    }

    public static String getNetworkVersion() {
        try {
            return KsAdSDK.getSDKVersion();
        } catch (Throwable th) {
            return "";
        }
    }
}
