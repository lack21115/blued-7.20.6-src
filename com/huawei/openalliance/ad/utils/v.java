package com.huawei.openalliance.ad.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.fk;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.constant.cj;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/v.class */
public abstract class v {
    private static final String Code = "HiAdTools";
    private static final byte[] I = new byte[0];
    private static String V;

    public static String B() {
        return UUID.randomUUID().toString();
    }

    public static boolean B(Context context) {
        return TextUtils.equals(e.I(context), Z(context));
    }

    public static boolean C() {
        return an.I(com.huawei.openalliance.ad.constant.t.bz) && an.Code(com.huawei.openalliance.ad.constant.t.bz, com.huawei.openalliance.ad.constant.t.bA, null);
    }

    public static boolean C(Context context) {
        boolean z = false;
        if (context != null) {
            if (Build.VERSION.SDK_INT < 29) {
                return false;
            }
            Object systemService = context.getSystemService(Context.UI_MODE_SERVICE);
            if (!(systemService instanceof UiModeManager)) {
                return false;
            }
            z = false;
            if (((UiModeManager) systemService).getNightMode() == 2) {
                z = true;
            }
        }
        return z;
    }

    public static int Code(Context context, float f) {
        if (context == null || f <= 0.0f) {
            return 0;
        }
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static long Code() {
        return System.currentTimeMillis();
    }

    public static SimpleDateFormat Code(String str) {
        try {
            return new SimpleDateFormat(str, Locale.ENGLISH);
        } catch (Throwable th) {
            return new SimpleDateFormat(str);
        }
    }

    public static boolean Code(Context context) {
        return S() && g(context);
    }

    public static boolean Code(Context context, Uri uri) {
        if (context == null || uri == null) {
            return false;
        }
        if (dt.B(context)) {
            PackageManager packageManager = context.getPackageManager();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
            if (resolveContentProvider == null) {
                ge.Z(Code, "Invalid param");
                return false;
            }
            ApplicationInfo applicationInfo = resolveContentProvider.applicationInfo;
            if (applicationInfo != null) {
                String str = applicationInfo.packageName;
                ge.V(Code, "Target provider service's package name is : " + str);
                if (str != null) {
                    boolean z = packageManager.checkSignatures(context.getPackageName(), str) == 0 || (applicationInfo.flags & 1) == 1;
                    if (!z && !dt.B(context)) {
                        String B = e.B(context, str);
                        boolean isEmpty = TextUtils.isEmpty(B);
                        ge.V(Code, "is sign empty: %s", Boolean.valueOf(isEmpty));
                        if (!isEmpty) {
                            return cj.Code(context, str, B);
                        }
                    }
                    return z;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public static boolean Code(Context context, String str) {
        if (context == null) {
            ge.I(Code, "processWhyEvent context is null, return");
            return false;
        }
        String str2 = str;
        if (com.huawei.openalliance.ad.constant.t.al.equalsIgnoreCase(str)) {
            str2 = str;
            if (!B(context)) {
                str2 = com.huawei.openalliance.ad.constant.t.am + context.getPackageName();
            }
        }
        if (!au.Code(str2)) {
            ge.Code(Code, "processWhyEvent url = %s", bc.Code(str2));
            return au.B(str2) ? V(context, str2) : I(context, str2);
        }
        String str3 = com.huawei.openalliance.ad.constant.t.al;
        if (!B(context)) {
            str3 = com.huawei.openalliance.ad.constant.t.am + context.getPackageName();
        }
        ge.Code(Code, "processWhyEvent cloud download url is empty, use default!");
        return I(context, str3);
    }

    public static boolean Code(int[] iArr, int i) {
        return iArr != null && iArr.length == i;
    }

    public static boolean D(Context context) {
        if (context == null) {
            return false;
        }
        Integer L = L(context);
        if (L == null || L.intValue() < 30457100) {
            ge.V(Code, "hms version is too low to support v3.");
            return false;
        }
        return true;
    }

    public static boolean F(Context context) {
        if (context == null) {
            return false;
        }
        Integer L = L(context);
        if (L == null || L.intValue() < 30456100) {
            ge.V(Code, "hms version is too low to support sdkType.");
            return false;
        }
        return true;
    }

    public static int I(Context context, float f) {
        if (context == null || f <= 0.0f) {
            return 0;
        }
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean I() {
        try {
            Class.forName(com.huawei.openalliance.ad.constant.t.aA);
            return true;
        } catch (Throwable th) {
            ge.I(Code, "inner pps core service not available");
            return false;
        }
    }

    public static boolean I(Context context) {
        if (I()) {
            return true;
        }
        int Z = e.Z(context, e.I(context));
        ge.V(Code, "isSupportSetAppInfo hms ver: " + Z);
        if (Z < 40004300) {
            ge.V(Code, "hms is not installed or hms version is too low, version is: " + Z);
            return false;
        }
        return true;
    }

    private static boolean I(Context context, String str) {
        String str2;
        if (au.Code(str)) {
            str2 = "openLinkByDeepLink deepLinkUrl is null, return";
        } else {
            try {
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.setPackage(B(context) ? e.I(context) : context.getPackageName());
                intent.setData(Uri.parse(str));
                intent.setClipData(com.huawei.openalliance.ad.constant.t.cF);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                str2 = "openLinkByDeepLink " + th.getClass().getSimpleName();
            }
        }
        ge.I(Code, str2);
        return false;
    }

    public static Integer L(Context context) {
        Integer Code2 = ah.Code(context, e.I(context.getApplicationContext()), "ppskit_ver_code");
        if (ge.Code()) {
            ge.Code(Code, "ppsKitVerCode:%s", Code2);
        }
        return Code2;
    }

    private static boolean S() {
        int i = Build.VERSION.SDK_INT;
        boolean z = i >= 19;
        if (!z) {
            Log.e(Code, "no support api: " + String.valueOf(i));
        }
        return z;
    }

    public static boolean S(Context context) {
        if (context == null) {
            return false;
        }
        Integer L = L(context);
        if (L == null || L.intValue() < 30445100) {
            ge.V(Code, "hms version is too low to support switch next install way.");
            return false;
        }
        return true;
    }

    public static int V(Context context, float f) {
        if (context != null && f > 0.0f) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static long V() {
        long maxMemory = Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
        if (ge.Code()) {
            ge.Code(Code, "unUsedMemory is: %s", String.valueOf(maxMemory));
        }
        return maxMemory;
    }

    public static void V(String str) {
        synchronized (I) {
            V = str;
        }
    }

    public static boolean V(Context context) {
        int Z = e.Z(context, e.I(context));
        ge.V(Code, "isSupportHmsAdsService hms ver: " + Z);
        if (Z < 40000300) {
            ge.V(Code, "hms is not installed or hms version is too low, version is: " + Z);
            return false;
        }
        return true;
    }

    private static boolean V(Context context, String str) {
        String str2;
        if (au.Code(str)) {
            str2 = "openLinkInBrowser url is null, return";
        } else {
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(268468224);
                intent.setClipData(com.huawei.openalliance.ad.constant.t.cF);
                context.startActivity(intent);
                return true;
            } catch (Throwable th) {
                str2 = "openLinkInBrowser " + th.getClass().getSimpleName();
            }
        }
        ge.I(Code, str2);
        return false;
    }

    public static int Z(Context context, float f) {
        if (context != null && f > 0.0f) {
            return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        }
        return 0;
    }

    public static String Z() {
        String str;
        synchronized (I) {
            str = V;
        }
        return str;
    }

    public static String Z(Context context) {
        String Z = Z();
        ge.V(Code, "current connected service pkg: " + Z);
        if (TextUtils.isEmpty(Z)) {
            int t = fk.Code(context).t();
            if (((t != 0 && t != 2) || !V(context)) && I()) {
                return context.getPackageName();
            }
            return e.I(context);
        }
        return Z;
    }

    public static Integer a(Context context) {
        Integer Code2 = ah.Code(context, context.getApplicationContext().getPackageName(), "hw_ads_sdk_type");
        if (ge.Code()) {
            ge.Code(Code, "sdkType:%s", Code2);
        }
        return Code2;
    }

    public static float b(Context context) {
        Configuration configuration;
        if (context == null) {
            return -1.0f;
        }
        float h = h(context);
        if (h > 0.0f) {
            return h;
        }
        Resources resources = context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return -1.0f;
        }
        return configuration.fontScale;
    }

    public static boolean c(Context context) {
        return b(context) >= 1.75f;
    }

    public static boolean d(Context context) {
        return b(context) >= 1.3f;
    }

    public static int e(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Throwable th) {
            ge.I(Code, "getStatusBarHeight err: %s", th.getClass().getSimpleName());
            return 0;
        }
    }

    public static boolean f(Context context) {
        return c.I(context) >= 600;
    }

    private static boolean g(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.huawei.openalliance.ad.constant.t.ap);
        String str = "ads-base";
        sb.append("ads-base");
        String Code2 = ay.Code(context, sb.toString());
        String str2 = Code2;
        if (TextUtils.isEmpty(Code2)) {
            str = "ads-base-inner";
            str2 = ay.Code(context, com.huawei.openalliance.ad.constant.t.ap + "ads-base-inner");
        }
        String str3 = str2;
        if (!TextUtils.isEmpty(str2)) {
            str3 = str2.replaceAll(str + ":", "");
        }
        if (TextUtils.equals(str3, "13.4.61.304")) {
            return true;
        }
        if (TextUtils.isEmpty(str3)) {
            Log.w(Code, "unknown base sdk version");
            return true;
        }
        Log.e(Code, "current sdk module version 13.4.61.304 is not compatible with base sdk version(" + str3 + "), please update to base version " + str3);
        return false;
    }

    private static float h(Context context) {
        try {
            return Settings.System.getFloat(context.getContentResolver(), Settings.System.FONT_SCALE, -1.0f);
        } catch (Throwable th) {
            ge.I(Code, "get font err: %s", th.getClass().getSimpleName());
            return -1.0f;
        }
    }
}
