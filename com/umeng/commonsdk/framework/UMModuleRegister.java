package com.umeng.commonsdk.framework;

import android.content.Context;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/framework/UMModuleRegister.class */
public class UMModuleRegister {
    public static final String ANALYTICS = "analytics";
    public static final String APPSTATUS = "appstatus";
    private static final int APPSTATUS_SWITCH_HIGH = 37136;
    private static final int APPSTATUS_SWITCH_LOW = 37121;
    public static final String INNER = "internal";
    private static final int INNER_EVENT_VALUE_HIGH = 36864;
    private static final int INNER_EVENT_VALUE_LOW = 32769;
    public static final String PROCESS = "process";
    private static final int PROCESS_EVENT_VALUE_HIGH = 37120;
    private static final int PROCESS_EVENT_VALUE_LOW = 36945;
    public static final String PUSH = "push";
    private static final int PUSH_EVENT_VALUE_HIGH = 20480;
    private static final int PUSH_EVENT_VALUE_LOW = 16385;
    public static final String SHARE = "share";
    private static final int SHARE_EVENT_VALUE_HIGH = 28672;
    private static final int SHARE_EVENT_VALUE_LOW = 24577;
    private static Context mModuleAppContext;
    private static HashMap<String, UMLogDataProtocol> mModuleMap;

    public static String eventType2ModuleName(int i) {
        String str = (i < 16385 || i > 20480) ? "analytics" : "push";
        String str2 = str;
        if (i >= SHARE_EVENT_VALUE_LOW) {
            str2 = str;
            if (i <= 28672) {
                str2 = "share";
            }
        }
        String str3 = str2;
        if (i >= 32769) {
            str3 = str2;
            if (i <= INNER_EVENT_VALUE_HIGH) {
                str3 = INNER;
            }
        }
        String str4 = str3;
        if (i >= 36945) {
            str4 = str3;
            if (i <= 37120) {
                str4 = PROCESS;
            }
        }
        String str5 = str4;
        if (i >= APPSTATUS_SWITCH_LOW) {
            str5 = str4;
            if (i <= 37136) {
                str5 = APPSTATUS;
            }
        }
        return str5;
    }

    public static Context getAppContext() {
        return mModuleAppContext;
    }

    public static UMLogDataProtocol getCallbackFromModuleName(String str) {
        if (mModuleMap.containsKey(str)) {
            return mModuleMap.get(str);
        }
        return null;
    }

    public static void registerAppContext(Context context) {
        if (mModuleAppContext == null) {
            mModuleAppContext = context.getApplicationContext();
        }
    }

    public static boolean registerCallback(int i, UMLogDataProtocol uMLogDataProtocol) {
        if (mModuleMap == null) {
            mModuleMap = new HashMap<>();
        }
        String eventType2ModuleName = eventType2ModuleName(i);
        if (mModuleMap.containsKey(eventType2ModuleName)) {
            return true;
        }
        mModuleMap.put(eventType2ModuleName, uMLogDataProtocol);
        return true;
    }
}
