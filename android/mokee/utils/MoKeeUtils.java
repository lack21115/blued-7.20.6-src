package android.mokee.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/mokee/utils/MoKeeUtils.class */
public class MoKeeUtils {
    public static boolean isApkInstalled(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isApkInstalledAndEnabled(String str, Context context) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting(str);
            boolean z = false;
            if (applicationEnabledSetting != 2) {
                z = false;
                if (applicationEnabledSetting != 3) {
                    z = true;
                }
            }
            return z;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isChineseLetter(char c2) {
        return String.valueOf(c2).matches("[\\u4E00-\\u9FA5]+");
    }

    public static boolean isOnline(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isSupportLanguage(boolean z) {
        Locale locale = Resources.getSystem().getConfiguration().locale;
        return z ? locale.getLanguage().startsWith(Locale.CHINESE.getLanguage()) && !locale.getCountry().equals("TW") : locale.getLanguage().startsWith(Locale.CHINESE.getLanguage());
    }

    public static boolean isSystemApp(String str, Context context) {
        boolean z = false;
        try {
            if ((context.getPackageManager().getPackageInfo(str, 0).applicationInfo.flags & 1) != 0) {
                z = true;
            }
            return z;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
