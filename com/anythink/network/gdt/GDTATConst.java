package com.anythink.network.gdt;

import com.qq.e.comm.managers.status.SDKStatus;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATConst.class */
public class GDTATConst {
    public static final String AD_HEIGHT = "gdtad_height";
    public static final int NETWORK_FIRM_ID = 8;

    /* renamed from: a  reason: collision with root package name */
    protected static final String f8932a = "299";

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/gdt/GDTATConst$DEBUGGER_CONFIG.class */
    public static class DEBUGGER_CONFIG {
        public static final int GDT_INTERSTITIAL = 1;
        public static final int GDT_INTERSTITIAL_FULL_SCREEN = 2;
        public static final int GDT_NATIVE_DRAW_SELF_RENDER = 4;
        public static final int GDT_NATIVE_DRAW_TEMPLATE = 3;
        public static final int GDT_NATIVE_SELF_RENDER = 2;
        public static final int GDT_NATIVE_TEMPLATE = 1;
        public static final int GDT_NETWORK = 8;
    }

    public static String getNetworkVersion() {
        try {
            return SDKStatus.getIntegrationSDKVersion();
        } catch (Throwable th) {
            return "";
        }
    }
}
