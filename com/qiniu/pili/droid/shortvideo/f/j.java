package com.qiniu.pili.droid.shortvideo.f;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/j.class */
public class j {
    public static long a(long j) {
        return j * 1000000;
    }

    public static Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        view.draw(canvas);
        return createBitmap;
    }

    public static String a() {
        return a(("os version:" + Build.VERSION.RELEASE + ", Android SDK_INT:" + Build.VERSION.SDK_INT + ", SoC Hardware:" + Build.HARDWARE).trim());
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return sb.toString();
            }
            char charAt = str.charAt(i2);
            if (charAt > 31 && charAt < 127) {
                sb.append(charAt);
            }
            i = i2 + 1;
        }
    }

    private static String a(String str, String str2) {
        String lowerCase = str.toLowerCase(Locale.getDefault());
        if (lowerCase.startsWith("unknown") || lowerCase.startsWith("alps") || lowerCase.startsWith("android") || lowerCase.startsWith("sprd") || lowerCase.startsWith("spreadtrum") || lowerCase.startsWith("rockchip") || lowerCase.startsWith("wondermedia") || lowerCase.startsWith("mtk") || lowerCase.startsWith("mt65") || lowerCase.startsWith("nvidia") || lowerCase.startsWith("brcm") || lowerCase.startsWith("marvell") || str2.toLowerCase(Locale.getDefault()).contains(lowerCase)) {
            return null;
        }
        return str;
    }

    public static boolean a(double d) {
        int i = (d > 1.0d ? 1 : (d == 1.0d ? 0 : -1));
        if (i <= 0 || d % 2.0d != 0.0d) {
            return (d < 1.0d && (1.0d / d) % 2.0d == 0.0d) || i == 0;
        }
        return true;
    }

    public static boolean a(int i) {
        int abs = Math.abs(i);
        return abs == 0 || abs == 90 || abs == 180 || abs == 270;
    }

    public static boolean a(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    public static int b(int i) {
        int i2 = i % 360;
        int i3 = i2;
        if (i2 < 0) {
            i3 = 360 - Math.abs(i2);
        }
        return i3;
    }

    public static int b(Context context) {
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();
    }

    public static long b(long j) {
        return j / 1000000;
    }

    public static String b() {
        String trim = Build.MODEL.trim();
        String a2 = a(Build.MANUFACTURER.trim(), trim);
        String str = a2;
        if (TextUtils.isEmpty(a2)) {
            str = a(Build.BRAND.trim(), trim);
        }
        StringBuilder sb = new StringBuilder();
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(trim);
        return a(sb.toString()).replace(" ", BridgeUtil.UNDERLINE_STR);
    }

    private static int c(int i) {
        return (i & (-65536)) >> 16;
    }

    public static int c(Context context) {
        int b = b(context);
        if (b != 1) {
            if (b != 2) {
                return b != 3 ? 0 : 270;
            }
            return 180;
        }
        return 90;
    }

    public static long c(long j) {
        return (j / 1000) / 60;
    }

    public static int d(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo.reqGlEsVersion != 0) {
            return c(deviceConfigurationInfo.reqGlEsVersion);
        }
        return 1;
    }

    public static boolean e(Context context) {
        Point f = f(context);
        return f.x > f.y;
    }

    public static Point f(Context context) {
        Point point = new Point();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getSize(point);
        return point;
    }

    public static String g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    public static String h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    public static String i(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
    }

    public static String j(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_model", b());
            jSONObject.put("os_version", a());
            jSONObject.put("sdk_version", "amix-3.0;PLDroidShortVideo-3.1.1");
            jSONObject.put("app_name", g(context));
            jSONObject.put("app_version", h(context));
            jSONObject.put("gl_version", d(context));
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
