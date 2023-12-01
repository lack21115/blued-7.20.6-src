package com.sobot.network.apiUtils;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/apiUtils/SobotHttpGlobalContext.class */
public class SobotHttpGlobalContext {
    private Context mApplicationContext;

    /* loaded from: source-8303388-dex2jar.jar:com/sobot/network/apiUtils/SobotHttpGlobalContext$GlobalContext.class */
    static class GlobalContext {
        private static final SobotHttpGlobalContext globalContext = new SobotHttpGlobalContext();

        private GlobalContext() {
        }
    }

    private SobotHttpGlobalContext() {
    }

    public static Context getAppContext() {
        return GlobalContext.globalContext.mApplicationContext;
    }

    public static Context getAppContext(Context context) {
        if (GlobalContext.globalContext.mApplicationContext == null && context != null) {
            GlobalContext.globalContext.mApplicationContext = context.getApplicationContext();
        }
        return GlobalContext.globalContext.mApplicationContext;
    }

    public static SobotHttpGlobalContext getInstance(Context context) {
        if (GlobalContext.globalContext.mApplicationContext == null && context != null) {
            GlobalContext.globalContext.mApplicationContext = context;
        }
        return GlobalContext.globalContext;
    }
}
