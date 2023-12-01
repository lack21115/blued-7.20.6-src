package com.tencent.mapsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.android.internal.telephony.PhoneConstants;
import com.tencent.map.tools.Util;
import java.net.URLEncoder;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/g7.class */
public class g7 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f37484a = 65537;
    public static final int b = 400;

    /* renamed from: c  reason: collision with root package name */
    public static final String f37485c = "TencentMapSDK";
    private static String d;
    private static String e;
    private static String f;

    public static Rect a(View view) {
        if (view == null) {
            return new Rect();
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getMeasuredWidth() + i, view.getMeasuredHeight() + i2);
    }

    public static String a() {
        if (e == null) {
            e = Build.MODEL;
        }
        return e;
    }

    public static String a(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        try {
            return URLEncoder.encode((applicationInfo != null ? applicationInfo.loadLabel(packageManager) : "can't find app name").toString(), "utf-8");
        } catch (Exception e3) {
            return "";
        }
    }

    public static String a(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (context == null) {
            return "";
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            applicationInfo = null;
        }
        return (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? "" : bundle.getString(str);
    }

    public static boolean a(View view, float f2, float f3) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z = false;
        if (f3 >= i2) {
            z = false;
            if (f3 <= measuredHeight + i2) {
                z = false;
                if (f2 >= i) {
                    z = false;
                    if (f2 <= measuredWidth + i) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static String b() {
        if (f == null) {
            f = Util.getMD5String(Util.getUUID());
        }
        return f;
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            return str + i;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c() {
        if (d == null) {
            d = "undefined";
        }
        return d;
    }

    public static int[] c(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return new int[]{point.x, point.y};
    }

    public static float d(Context context) {
        if (context == null) {
            return 1.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static String e(Context context) {
        return Util.getMD5String(Util.getDuid(context));
    }

    public static int f(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        return deviceConfigurationInfo != null ? deviceConfigurationInfo.reqGlEsVersion : f37484a;
    }

    public static String g(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return displayMetrics.widthPixels + PhoneConstants.APN_TYPE_ALL + displayMetrics.heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String h(Context context) {
        return Util.getMD5String(Util.getSuid(context));
    }

    public static int i(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int j(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
