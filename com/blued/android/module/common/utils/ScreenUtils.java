package com.blued.android.module.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.blued.android.core.ui.StatusBarHelper;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/utils/ScreenUtils.class */
public class ScreenUtils {

    /* renamed from: a  reason: collision with root package name */
    static final String f10912a = ScreenUtils.class.getSimpleName();

    public static int a(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(Settings.System.NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        if (r0.equals(com.igexin.assist.util.AssistUtils.BRAND_XIAOMI) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r3) {
        /*
            r0 = r3
            int r0 = a(r0)
            r5 = r0
            r0 = 0
            r4 = r0
            r0 = r5
            if (r0 != 0) goto Ld
            r0 = 0
            return r0
        Ld:
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r0 = r0.toLowerCase()
            r6 = r0
            r0 = r6
            int r0 = r0.hashCode()
            r5 = r0
            r0 = r5
            r1 = -1206476313(0xffffffffb816a1e7, float:-3.591357E-5)
            if (r0 == r1) goto L48
            r0 = r5
            r1 = -759499589(0xffffffffd2baf4bb, float:-4.01484906E11)
            if (r0 == r1) goto L3c
            r0 = r5
            r1 = 3620012(0x373cac, float:5.072717E-39)
            if (r0 == r1) goto L2e
            goto L56
        L2e:
            r0 = r6
            java.lang.String r1 = "vivo"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L56
            r0 = 2
            r4 = r0
            goto L58
        L3c:
            r0 = r6
            java.lang.String r1 = "xiaomi"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L56
            goto L58
        L48:
            r0 = r6
            java.lang.String r1 = "huawei"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L56
            r0 = 1
            r4 = r0
            goto L58
        L56:
            r0 = -1
            r4 = r0
        L58:
            r0 = r4
            if (r0 == 0) goto L79
            r0 = r4
            r1 = 1
            if (r0 == r1) goto L72
            r0 = r4
            r1 = 2
            if (r0 == r1) goto L6b
            r0 = r3
            boolean r0 = f(r0)
            return r0
        L6b:
            r0 = r3
            boolean r0 = c(r0)
            r1 = 1
            r0 = r0 ^ r1
            return r0
        L72:
            r0 = r3
            boolean r0 = e(r0)
            r1 = 1
            r0 = r0 ^ r1
            return r0
        L79:
            r0 = r3
            boolean r0 = d(r0)
            r1 = 1
            r0 = r0 ^ r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.utils.ScreenUtils.b(android.content.Context):boolean");
    }

    private static boolean c(Context context) {
        boolean z = false;
        if (Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0) {
            z = true;
        }
        return z;
    }

    private static boolean d(Context context) {
        boolean z = false;
        if (Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
            z = true;
        }
        return z;
    }

    private static boolean e(Context context) {
        boolean z = false;
        if ((Build.VERSION.SDK_INT < 21 ? Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0) : Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0)) != 0) {
            z = true;
        }
        return z;
    }

    private static boolean f(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        }
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i3 = displayMetrics2.heightPixels;
        int i4 = displayMetrics2.widthPixels;
        boolean z = false;
        if (i3 > i4) {
            if (StatusBarHelper.b((Activity) context) + i3 > i) {
                return false;
            }
        } else if (StatusBarHelper.b((Activity) context) + i4 > i2) {
            return false;
        }
        if (i2 - i4 > 0 || i - i3 > 0) {
            z = true;
        }
        return z;
    }
}
