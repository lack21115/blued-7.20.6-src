package com.ut.mini.plugin;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/plugin/UTPlugin.class */
public abstract class UTPlugin {
    public static final int MSG_ID_IN_DISPATCH_AGGREGATION_LOG_MAP = 5;
    public static final int MSG_ID_IN_DISPATCH_LOG_STRING_4_UTPERF_PLUGIN = 9;
    public static final int MSG_ID_IN_NOMATCH_ONLINE_CONF = 7;
    public static final int MSG_ID_IN_SWITCH_BACKGROUND = 2;
    public static final int MSG_ID_IN_SWITCH_FOREGROUND = 8;
    public static final int MSG_ID_OUT_AGGREGATED_LOG_MAP = 65536;

    /* renamed from: a  reason: collision with root package name */
    private UTPluginContext f27336a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(UTPluginContext uTPluginContext) {
        this.f27336a = uTPluginContext;
    }

    public final void deliverMsgToSDK(int i, Object obj) {
        UTPluginMgr.getInstance().dispatchPluginMsg(i, obj);
    }

    public final UTPluginContext getPluginContext() {
        return this.f27336a;
    }

    public void onPluginContextValueUpdate(int i) {
    }

    public abstract void onPluginMsgArrivedFromSDK(int i, Object obj);

    public void onRegistered() {
    }

    public void onUnRegistered() {
    }

    public abstract int[] returnRequiredMsgIds();

    public String[] returnRequiredOnlineConfNames() {
        return null;
    }
}
