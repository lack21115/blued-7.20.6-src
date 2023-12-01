package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.WindowManager;
import com.hihonor.android.os.Build;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/c.class */
public abstract class c {
    private static final int B = 81;
    private static final int C = 90;
    private static final int Code = 32;
    private static final int D = 655;
    private static final int F = 720;
    private static final int I = 68;
    private static final int L = 632;
    private static final int S = 400;
    private static final int V = 50;
    private static final int Z = 60;

    /* renamed from: a  reason: collision with root package name */
    private static final int f22994a = 526;
    private static final int b = 432;

    /* renamed from: c  reason: collision with root package name */
    private static final int f22995c = 320;
    private static final int d = 468;
    private static final int e = 728;
    private static final float f = 0.15f;
    private static final float g = 0.12362637f;
    private static final float h = 0.12820514f;
    private static final float i = 0.15625f;
    private static final String j = "ex_splash_func_status";
    private static final String k = "ex_splash_list";
    private static final String l = "ex_splash_block_list";
    private static final String m = c.class.getSimpleName();

    public static int B(Context context) {
        if (context == null) {
            return 0;
        }
        int Code2 = Code(context);
        int V2 = V(context);
        return Code2 > V2 ? Code2 : V2;
    }

    public static int B(Context context, int i2) {
        return i2 == 0 ? B(context) : Z(context);
    }

    public static int C(Context context, int i2) {
        return i2 == 0 ? Z(context) : B(context);
    }

    public static DisplayMetrics C(Context context) {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null && (windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE)) != null) {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics;
        }
        return displayMetrics;
    }

    public static int Code(int i2, int i3) {
        float f2;
        float f3;
        int i4;
        int min = Math.min(90, Math.round(i3 * f));
        if (i2 > 432) {
            if (i2 <= 526) {
                i4 = 68;
            } else if (i2 <= 632) {
                f2 = i2;
                f3 = 0.12820514f;
            } else if (i2 <= 655) {
                i4 = 81;
            } else {
                f2 = i2;
                f3 = 0.12362637f;
            }
            return Math.max(Math.min(i4, min), 50);
        }
        f2 = i2;
        f3 = 0.15625f;
        i4 = Math.round(f2 * f3);
        return Math.max(Math.min(i4, min), 50);
    }

    public static int Code(Context context) {
        if (context == null) {
            return 0;
        }
        return C(context).heightPixels;
    }

    public static int Code(Context context, int i2) {
        int I2 = v.I(context, i2);
        if (I2 == 0) {
            return 0;
        }
        return v.V(context, I2 <= 432 ? 50 : I2 <= 632 ? 60 : 90);
    }

    private static int Code(DisplayMetrics displayMetrics, Configuration configuration, int i2, int i3) {
        int i4 = i2;
        if (i2 == 0) {
            i4 = configuration.orientation;
        }
        return i4 == 1 ? (displayMetrics.heightPixels > displayMetrics.widthPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels) - i3 : displayMetrics.heightPixels < displayMetrics.widthPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels;
    }

    public static String Code() {
        return Locale.getDefault().getLanguage();
    }

    private static void Code(final am amVar, final Context context) {
        f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.huawei.openalliance.ad.ipc.g.V(Context.this).Code(com.huawei.openalliance.ad.constant.p.p, "", new RemoteCallResultCallback<String>() { // from class: com.huawei.openalliance.ad.utils.c.1.1
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, CallResult<String> callResult) {
                        if (callResult.getCode() != 200) {
                            ge.V(c.m, "requestUuid failed");
                            return;
                        }
                        ge.V(c.m, "requestUuid success");
                        amVar.Code(callResult.getData());
                    }
                }, String.class);
            }
        });
    }

    public static boolean Code(Context context, com.huawei.openalliance.ad.inter.data.d dVar) {
        if (dVar == null) {
            return false;
        }
        String h2 = dVar.h();
        String str = h2;
        if (TextUtils.isEmpty(h2)) {
            str = dVar.g();
        }
        return v.Code(context, str);
    }

    public static int D(Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics C2 = C(context);
        if (C2.density == 0.0f) {
            return 0;
        }
        int I2 = v.I(context, C2.widthPixels);
        int Z2 = Z(context, 0);
        if (I2 == 0 || Z2 == 0) {
            return 0;
        }
        return Code(I2, Z2);
    }

    public static int F(Context context) {
        if (context == null) {
            return 0;
        }
        return v.V(context, D(context));
    }

    public static int I(Context context) {
        if (context == null) {
            return 0;
        }
        return v.I(context, Z(context));
    }

    public static int I(Context context, int i2) {
        return (int) TypedValue.applyDimension(1, i2, C(context));
    }

    public static boolean I() {
        try {
            if (!Build.MANUFACTURER.equalsIgnoreCase("HONOR") || Build.VERSION.SDK_INT < 31) {
                return false;
            }
            return Build.VERSION.MAGIC_SDK_INT >= 33;
        } catch (Throwable th) {
            String str = m;
            Log.e(str, "isHonor6UpPhone Error:" + th.getClass().getSimpleName());
            return false;
        }
    }

    public static boolean L(Context context) {
        if (context != null) {
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return false;
            }
            try {
                String string = Settings.Global.getString(context.getContentResolver(), l);
                if ((TextUtils.isEmpty(string) || !Arrays.asList(string.split(";")).contains(packageName)) && Settings.Global.getInt(context.getContentResolver(), j, 0) != 0) {
                    String string2 = Settings.Global.getString(context.getContentResolver(), k);
                    if (TextUtils.isEmpty(string2)) {
                        return false;
                    }
                    return Arrays.asList(string2.split(";")).contains(packageName);
                }
                return false;
            } catch (Throwable th) {
                String str = m;
                ge.I(str, "exception happen: " + th.getClass().getSimpleName());
                return false;
            }
        }
        return false;
    }

    public static int S(Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i2 = (int) (displayMetrics.heightPixels / displayMetrics.density);
        return (int) ((i2 > 720 ? 90 : i2 > 400 ? 50 : 32) * displayMetrics.density);
    }

    public static int V(Context context) {
        if (context == null) {
            return 0;
        }
        return C(context).widthPixels;
    }

    public static int V(Context context, int i2) {
        int I2 = v.I(context, i2);
        if (I2 == 0) {
            return 0;
        }
        return v.V(context, I2 <= 432 ? 320 : I2 <= 632 ? 468 : e);
    }

    public static String V() {
        return Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry();
    }

    public static int Z(Context context) {
        if (context == null) {
            return 0;
        }
        int Code2 = Code(context);
        int V2 = V(context);
        int i2 = Code2;
        if (Code2 > V2) {
            i2 = V2;
        }
        return i2;
    }

    public static int Z(Context context, int i2) {
        Configuration configuration;
        if (context == null) {
            return 0;
        }
        DisplayMetrics C2 = C(context);
        Resources resources = context.getResources();
        if (resources == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return Math.round(Code(C2, configuration, i2, ay.I(context)) / C2.density);
    }

    public static float a(Context context) {
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        } catch (RuntimeException | Exception e2) {
            ge.I(m, "getDensity fail");
            return 0.0f;
        }
    }

    public static int b(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "secure_gesture_navigation", 0);
        } catch (Throwable th) {
            String str = m;
            ge.I(str, "exception happen: " + th.getClass().getSimpleName());
            return 0;
        }
    }

    public static String c(Context context) {
        am Code2 = am.Code(context);
        Code(Code2, context.getApplicationContext());
        return Code2.I();
    }

    public static Integer d(final Context context) {
        Integer b2 = am.Code(context).b();
        final Integer num = b2;
        if (b2 == null) {
            num = v.a(context);
            f.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.c.2
                @Override // java.lang.Runnable
                public void run() {
                    am.Code(Context.this).Code(num);
                }
            });
        }
        return num;
    }
}
