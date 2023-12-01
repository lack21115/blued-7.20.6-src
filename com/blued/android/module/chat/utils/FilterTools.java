package com.blued.android.module.chat.utils;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.model.SessionSetting;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/utils/FilterTools.class */
public class FilterTools {
    private static String TAG = "@@@ module_chat_FilterTools";

    public static boolean checkCondition(SessionSetting sessionSetting, boolean z, boolean z2, boolean z3) {
        boolean z4 = false;
        if (sessionSetting != null) {
            if (AppInfo.m()) {
                Logger.b(TAG, sessionSetting.toString());
            }
            boolean z5 = !z || sessionSetting.getInitiator() == 1;
            boolean z6 = !z2 || sessionSetting.getFollower() == 1;
            boolean z7 = !z3 || sessionSetting.getNearby() == 1;
            z4 = false;
            if (z5) {
                z4 = false;
                if (z6) {
                    z4 = false;
                    if (z7) {
                        z4 = true;
                    }
                }
            }
        }
        return z4;
    }
}
