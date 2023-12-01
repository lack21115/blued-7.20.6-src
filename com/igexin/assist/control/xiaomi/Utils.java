package com.igexin.assist.control.xiaomi;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.igexin.push.core.b;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/xiaomi/Utils.class */
public class Utils {
    public static String getAppIdByBuildConfig(ApplicationInfo applicationInfo) {
        try {
            String string = applicationInfo.metaData.getString(b.f9818a);
            String str = string;
            if (TextUtils.isEmpty(string)) {
                str = applicationInfo.packageName;
            }
            Class<?> cls = Class.forName(str + ".BuildConfig");
            return (String) cls.getField("XIAOMI_APP_ID").get(cls);
        } catch (Throwable th) {
            return "";
        }
    }

    public static String getAppKeyByBuildConfig(ApplicationInfo applicationInfo) {
        try {
            String string = applicationInfo.metaData.getString(b.f9818a);
            String str = string;
            if (TextUtils.isEmpty(string)) {
                str = applicationInfo.packageName;
            }
            Class<?> cls = Class.forName(str + ".BuildConfig");
            return (String) cls.getField("XIAOMI_APP_KEY").get(cls);
        } catch (Throwable th) {
            return "";
        }
    }
}
