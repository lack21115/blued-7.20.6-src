package com.ut.mini.plugin;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/ut/mini/plugin/UTPluginContext.class */
public class UTPluginContext {
    public static final int DEBUG_LOG_SWITCH = 1;
    private Context mContext = null;
    private boolean Q = false;
    private boolean R = false;

    public void enableRealtimeDebug() {
        this.R = true;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean isDebugLogEnable() {
        return this.Q;
    }

    public boolean isRealtimeDebugEnable() {
        return this.R;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setDebugLogFlag(boolean z) {
        this.Q = z;
    }
}
