package com.igexin.assist.control.oppo;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.igexin.push.core.b;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/assist/control/oppo/Utils.class */
public class Utils {
    public static String getAppKeyByBuildConfig(ApplicationInfo applicationInfo) {
        try {
            String string = applicationInfo.metaData.getString(b.f23426a);
            String str = string;
            if (TextUtils.isEmpty(string)) {
                str = applicationInfo.packageName;
            }
            Class<?> cls = Class.forName(str + ".BuildConfig");
            return (String) cls.getField("OPPO_APP_KEY").get(cls);
        } catch (Throwable th) {
            return "";
        }
    }

    public static String getAppSecretByBuildConfig(ApplicationInfo applicationInfo) {
        try {
            String string = applicationInfo.metaData.getString(b.f23426a);
            String str = string;
            if (TextUtils.isEmpty(string)) {
                str = applicationInfo.packageName;
            }
            Class<?> cls = Class.forName(str + ".BuildConfig");
            return (String) cls.getField("OPPO_APP_SECRET").get(cls);
        } catch (Throwable th) {
            return "";
        }
    }
}
