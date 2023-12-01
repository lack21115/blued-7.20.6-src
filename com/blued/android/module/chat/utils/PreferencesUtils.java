package com.blued.android.module.chat.utils;

import android.content.SharedPreferences;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.ModuleChatConstant;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/utils/PreferencesUtils.class */
public class PreferencesUtils {
    private static final String MODULE_CHAT_SP = "module_chat_sp";
    private static SharedPreferences module_chat_sp;
    private static String TAG = ModuleChatConstant.TAG + PreferencesUtils.class.getSimpleName();
    private static String NEARBY_SWITCH = "nearby_switch";
    private static String ONLINE_SWITCH = "online_switch";
    private static String FOLLOWER_SWITCH = "follower_switch";
    private static String INITIATOR_SWITCH = "initiator_switch";
    private static String UPDTATE_FINISH = "updtate_finish";

    public static boolean getFollowerSwitch() {
        boolean z = getModuleChatSp().getBoolean(FOLLOWER_SWITCH, false);
        if (AppInfo.m()) {
            String str = TAG;
            Logger.b(str, "获取筛选开关：follower：" + z);
        }
        return z;
    }

    public static boolean getInitiatorSwitch() {
        boolean z = getModuleChatSp().getBoolean(INITIATOR_SWITCH, false);
        if (AppInfo.m()) {
            String str = TAG;
            Logger.b(str, "获取筛选开关：initiator：" + z);
        }
        return z;
    }

    private static SharedPreferences getModuleChatSp() {
        if (module_chat_sp == null) {
            module_chat_sp = AppInfo.d().getSharedPreferences(MODULE_CHAT_SP, 0);
        }
        return module_chat_sp;
    }

    public static boolean getNearbySwitch() {
        boolean z = getModuleChatSp().getBoolean(NEARBY_SWITCH, false);
        if (AppInfo.m()) {
            String str = TAG;
            Logger.b(str, "获取筛选开关：nearby：" + z);
        }
        return z;
    }

    public static boolean getOnlineSwitch() {
        boolean z = getModuleChatSp().getBoolean(ONLINE_SWITCH, false);
        if (AppInfo.m()) {
            String str = TAG;
            Logger.b(str, "获取筛选开关：online：" + z);
        }
        return z;
    }

    public static boolean getUpdateFinish() {
        return getModuleChatSp().getBoolean(UPDTATE_FINISH, false);
    }

    public static void setFollowerSwitch(boolean z) {
        synchronized (PreferencesUtils.class) {
            try {
                getModuleChatSp().edit().putBoolean(FOLLOWER_SWITCH, z).commit();
                if (AppInfo.m()) {
                    String str = TAG;
                    Logger.b(str, "设置筛选开关：follower：" + z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setInitiatorSwitch(boolean z) {
        synchronized (PreferencesUtils.class) {
            try {
                getModuleChatSp().edit().putBoolean(INITIATOR_SWITCH, z).commit();
                if (AppInfo.m()) {
                    String str = TAG;
                    Logger.b(str, "设置筛选开关：initiator：" + z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setNearbySwitch(boolean z) {
        synchronized (PreferencesUtils.class) {
            try {
                getModuleChatSp().edit().putBoolean(NEARBY_SWITCH, z).commit();
                if (AppInfo.m()) {
                    String str = TAG;
                    Logger.b(str, "设置筛选开关：nearby：" + z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setOnlineSwitch(boolean z) {
        synchronized (PreferencesUtils.class) {
            try {
                getModuleChatSp().edit().putBoolean(ONLINE_SWITCH, z).commit();
                if (AppInfo.m()) {
                    String str = TAG;
                    Logger.b(str, "设置筛选开关：online：" + z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void setUpdtateFinish(boolean z) {
        synchronized (PreferencesUtils.class) {
            try {
                getModuleChatSp().edit().putBoolean(UPDTATE_FINISH, z).commit();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
