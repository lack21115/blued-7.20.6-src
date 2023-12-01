package com.anythink.network.toutiao;

import com.bytedance.sdk.openadsdk.TTAdSdk;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATConst.class */
public class TTATConst {
    public static final String AD_LOAD_TYPE = "tt_ad_load_type";
    public static final String NATIVE_AD_IMAGE_HEIGHT = "tt_image_height";
    public static final String NATIVE_AD_INTERRUPT_VIDEOPLAY = "tt_can_interrupt_video";
    public static final String NATIVE_AD_VIDEOPLAY_BTN_BITMAP = "tt_video_play_btn_bitmap";
    public static final String NATIVE_AD_VIDEOPLAY_BTN_SIZE = "tt_video_play_btn_SIZE";
    public static final int NETWORK_FIRM_ID = 15;
    public static boolean hasRequestPermission = false;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATConst$DEBUGGER_CONFIG.class */
    public static class DEBUGGER_CONFIG {
        public static final int TT_INTERSTITIAL = 3;
        public static final int TT_NATIVE_DRAW_SELF_RENDER = 202;
        public static final int TT_NATIVE_DRAW_TEMPLATE = 201;
        public static final int TT_NATIVE_SELF_RENDER = 102;
        public static final int TT_NATIVE_TEMPLATE = 101;
        public static final int TT_NETWORK = 15;
    }

    public static String getNetworkVersion() {
        try {
            return TTAdSdk.getAdManager().getSDKVersion();
        } catch (Throwable th) {
            return "";
        }
    }
}
