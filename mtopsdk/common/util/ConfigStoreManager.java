package mtopsdk.common.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/common/util/ConfigStoreManager.class */
public class ConfigStoreManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ConfigStoreManager f43679a;

    private ConfigStoreManager() {
    }

    public static ConfigStoreManager a() {
        if (f43679a == null) {
            synchronized (ConfigStoreManager.class) {
                try {
                    if (f43679a == null) {
                        f43679a = new ConfigStoreManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f43679a;
    }

    public String a(Context context, String str, String str2, String str3) {
        if (context == null || StringUtils.b(str) || StringUtils.b(str3)) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (StringUtils.a(str2)) {
                return sharedPreferences.getString(str2 + str3, null);
            }
            return sharedPreferences.getString(str3, null);
        } catch (Exception e) {
            if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.c("mtopsdk.ConfigStoreManager", "[getConfigItem] getConfigItem error,store=" + str + ",keyprefix=" + str2 + ",key=" + str3);
                return null;
            }
            return null;
        }
    }

    public boolean a(Context context, String str, String str2, String str3, String str4) {
        if (context == null || StringUtils.b(str) || StringUtils.b(str3)) {
            return false;
        }
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            if (StringUtils.a(str2)) {
                edit.putString(str2 + str3, str4);
            } else {
                edit.putString(str3, str4);
            }
            if (Build.VERSION.SDK_INT >= 9) {
                edit.apply();
                return true;
            }
            edit.commit();
            return true;
        } catch (Exception e) {
            if (TBSdkLog.a(TBSdkLog.LogEnable.WarnEnable)) {
                TBSdkLog.c("mtopsdk.ConfigStoreManager", "[saveConfigItem] saveConfigItem error,store=" + str + ",keyprefix=" + str2 + ",key=" + str3);
                return false;
            }
            return false;
        }
    }
}
