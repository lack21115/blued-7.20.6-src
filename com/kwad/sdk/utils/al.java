package com.kwad.sdk.utils;

import android.Manifest;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import com.igexin.assist.sdk.AssistPushConsts;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/al.class */
public final class al {
    private static Map<String, Integer> aAb;
    private static Set<String> aAc;
    private static Method aAd;

    static {
        HashSet hashSet = new HashSet();
        aAc = hashSet;
        hashSet.add("android.permission.REQUEST_INSTALL_PACKAGES");
        aAc.add(Manifest.permission.WRITE_SETTINGS);
        aAc.add(Manifest.permission.SYSTEM_ALERT_WINDOW);
    }

    public static int al(Context context, String str) {
        int am;
        if (aAb == null) {
            h(aj.cg(context));
        }
        if (!aAc.contains(str) || (am = am(context, str)) == -2) {
            int an = an(context, str);
            if (an != -2) {
                return an;
            }
            try {
                return context.checkPermission(str, Process.myPid(), Process.myUid());
            } catch (Throwable th) {
                return an;
            }
        }
        return am;
    }

    private static int am(Context context, String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode == -2078357533) {
            if (str.equals(Manifest.permission.WRITE_SETTINGS)) {
                z = true;
            }
            z = true;
        } else if (hashCode != -1561629405) {
            if (hashCode == 1777263169 && str.equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                z = false;
            }
            z = true;
        } else {
            if (str.equals(Manifest.permission.SYSTEM_ALERT_WINDOW)) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            if (Build.VERSION.SDK_INT >= 26) {
                return aj.cf(context) ? 0 : -1;
            }
            return -2;
        } else if (z) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    return Settings.System.canWrite(context) ? 0 : -1;
                } catch (Throwable th) {
                    return -2;
                }
            }
            return -2;
        } else if (z && Build.VERSION.SDK_INT >= 23) {
            try {
                return Settings.canDrawOverlays(context) ? 0 : -1;
            } catch (Throwable th2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th2);
                return -2;
            }
        } else {
            return -2;
        }
    }

    private static int an(Context context, String str) {
        if (aAb == null || str == null) {
            return -2;
        }
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        if (aAb.containsKey(str)) {
            try {
                Integer num = aAb.get(str);
                if (num == null) {
                    return -2;
                }
                if (aAd == null) {
                    Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOp", Integer.TYPE, Integer.TYPE, String.class);
                    aAd = declaredMethod;
                    declaredMethod.setAccessible(true);
                }
                return ((Integer) aAd.invoke((AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE), num, Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0 ? 0 : -1;
            } catch (Exception e) {
                com.kwad.sdk.core.d.b.printStackTrace(e);
                return 0;
            }
        }
        return -2;
    }

    public static boolean ch(Context context) {
        int i;
        try {
            i = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.ACCESSIBILITY_ENABLED);
        } catch (Throwable th) {
            i = 0;
        }
        return i == 1;
    }

    private static String eJ(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return str;
        }
        try {
            return str.substring(lastIndexOf + 1);
        } catch (Exception e) {
            return str;
        }
    }

    private static void h(String[] strArr) {
        if (Build.VERSION.SDK_INT < 19 || strArr == null) {
            return;
        }
        aAb = new HashMap();
        int length = strArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            String str = strArr[i2];
            String eJ = eJ(str);
            try {
                int intValue = ((Integer) s.c(AppOpsManager.class, AssistPushConsts.OPPO_PREFIX + eJ)).intValue();
                if (intValue >= 0) {
                    aAb.put(str, Integer.valueOf(intValue));
                }
            } catch (Throwable th) {
            }
            i = i2 + 1;
        }
    }
}
