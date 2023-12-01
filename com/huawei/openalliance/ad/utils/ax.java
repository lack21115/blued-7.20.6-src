package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.ads.du;
import com.huawei.hms.ads.ge;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/ax.class */
public class ax {
    public static int Code(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(Settings.System.NAVIGATION_BAR_HEIGHT, "dimen", "android");
        int i = 0;
        if (identifier > 0) {
            i = 0;
            if (I(context)) {
                i = 0;
                if (Z(context)) {
                    i = resources.getDimensionPixelSize(identifier);
                }
            }
        }
        return i;
    }

    public static int Code(Context context, float f) {
        if (context != null && f > 0.0f) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static int Code(Context context, int i) {
        return i == 0 ? c.B(context) : c.Z(context);
    }

    static String Code(String str, Context context) {
        StringBuilder sb;
        String str2;
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    cls = Class.forName(du.Code(context).C());
                } catch (ClassNotFoundException e) {
                }
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
            }
            cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (RuntimeException e2) {
            e = e2;
            sb = new StringBuilder();
            str2 = "getSystemProperties RuntimeException:";
            sb.append(str2);
            sb.append(e.getClass().getSimpleName());
            ge.I("SysUtil", sb.toString());
            return null;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str2 = "getSystemProperties Exception:";
            sb.append(str2);
            sb.append(e.getClass().getSimpleName());
            ge.I("SysUtil", sb.toString());
            return null;
        }
    }

    private static boolean I(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int b = c.b(context);
            ge.Code("SysUtil", "isGesture: %s", Integer.valueOf(b));
            if (b == 0) {
                return true;
            }
        } else {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            z = identifier > 0 ? resources.getBoolean(identifier) : false;
            String Code = Code("qemu.hw.mainkeys", context);
            if ("1".equals(Code)) {
                return false;
            }
            if ("0".equals(Code)) {
                return true;
            }
        }
        return z;
    }

    public static int V(Context context, int i) {
        return i == 0 ? c.Z(context) : c.B(context);
    }

    public static void V(Context context) {
        if (context == null) {
            return;
        }
        com.huawei.openalliance.ad.ipc.g.V(context).Code("removeExSplashBlock", null, null, null);
    }

    private static boolean Z(Context context) {
        WindowManager windowManager;
        boolean z = false;
        if (context == null || (windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE)) == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i3 = displayMetrics2.heightPixels;
        int i4 = displayMetrics2.widthPixels;
        if (i - i3 > 0 || i2 - i4 > 0) {
            z = true;
        }
        return z;
    }
}
