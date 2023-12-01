package com.huawei.openalliance.ad.utils;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import com.huawei.android.app.ActivityManagerEx;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.dt;
import com.huawei.hms.ads.du;
import com.huawei.hms.ads.ef;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.hi;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/ay.class */
public abstract class ay {
    private static final int B = 33;
    public static final String Code = "zh-CN";
    private static final String I = "display_notch_status";
    private static final String V = ay.class.getSimpleName();
    private static final int Z = 0;

    public static boolean B() {
        String Code2 = Code("ro.product.locale.region");
        if (TextUtils.isEmpty(Code2)) {
            String Code3 = Code("ro.product.locale");
            if (TextUtils.isEmpty(Code3)) {
                String Z2 = Z();
                if (TextUtils.isEmpty(Z2)) {
                    return false;
                }
                return AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(Z2);
            }
            return Code3.toLowerCase(Locale.ENGLISH).contains(AdvanceSetting.CLEAR_NOTIFICATION);
        }
        return AdvanceSetting.CLEAR_NOTIFICATION.equalsIgnoreCase(Code2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean B(android.content.Context r3) {
        /*
            r0 = 0
            r5 = r0
            r0 = r3
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> Lf android.provider.Settings.SettingNotFoundException -> L24
            java.lang.String r1 = "display_notch_status"
            int r0 = android.provider.Settings.Secure.getInt(r0, r1)     // Catch: java.lang.Throwable -> Lf android.provider.Settings.SettingNotFoundException -> L24
            r4 = r0
            goto L54
        Lf:
            r8 = move-exception
            java.lang.String r0 = com.huawei.openalliance.ad.utils.ay.V
            r3 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            java.lang.String r0 = "isNotchEnable Throwable:"
            r7 = r0
            goto L36
        L24:
            r8 = move-exception
            java.lang.String r0 = com.huawei.openalliance.ad.utils.ay.V
            r3 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            java.lang.String r0 = "isNotchEnable error:"
            r7 = r0
        L36:
            r0 = r6
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r8
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r3
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.huawei.hms.ads.ge.V(r0, r1)
            r0 = 0
            r4 = r0
        L54:
            r0 = r4
            if (r0 != 0) goto L5a
            r0 = 1
            r5 = r0
        L5a:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.utils.ay.B(android.content.Context):boolean");
    }

    public static int C(Context context) {
        int S = S(context);
        if (S > 0) {
            return S / 2;
        }
        return 36;
    }

    public static boolean C() {
        return I() && !com.huawei.openalliance.ad.constant.t.cE.equalsIgnoreCase(Locale.getDefault().getLanguage());
    }

    public static int Code(boolean z) {
        return z ? R.drawable.hiad_video_mute : R.drawable.hiad_video_unmute;
    }

    public static String Code(Context context, String str) {
        PackageManager packageManager;
        String str2;
        StringBuilder sb;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            Bundle bundle = packageManager.getApplicationInfo(context.getPackageName(), 128).metaData;
            return bundle != null ? bundle.getString(str) : "";
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            str2 = V;
            sb = new StringBuilder();
            sb.append("getMetaDataInfo ");
            sb.append(e.getClass().getSimpleName());
            ge.I(str2, sb.toString());
            return "";
        } catch (Throwable th) {
            e = th;
            str2 = V;
            sb = new StringBuilder();
            sb.append("getMetaDataInfo ");
            sb.append(e.getClass().getSimpleName());
            ge.I(str2, sb.toString());
            return "";
        }
    }

    public static String Code(String str) {
        String str2;
        StringBuilder sb;
        String str3;
        Class<?> cls;
        try {
            if (Build.VERSION.SDK_INT >= 27) {
                try {
                    cls = Class.forName(c.I() ? "com.hihonor.android.os.SystemPropertiesEx" : "com.huawei.android.os.SystemPropertiesEx");
                } catch (ClassNotFoundException e) {
                }
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
            }
            cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (RuntimeException e2) {
            e = e2;
            str2 = V;
            sb = new StringBuilder();
            str3 = "getSystemProperties RuntimeException:";
            sb.append(str3);
            sb.append(e.getClass().getSimpleName());
            ge.I(str2, sb.toString());
            return null;
        } catch (Throwable th) {
            e = th;
            str2 = V;
            sb = new StringBuilder();
            str3 = "getSystemProperties Exception:";
            sb.append(str3);
            sb.append(e.getClass().getSimpleName());
            ge.I(str2, sb.toString());
            return null;
        }
    }

    public static void Code(Activity activity, final com.huawei.openalliance.ad.views.i iVar) {
        if (activity == null || Build.VERSION.SDK_INT < 20 || !dt.B(activity)) {
            return;
        }
        Window window = activity.getWindow();
        if (window == null) {
            ge.I(V, "get safe padding, window is null");
            return;
        }
        try {
            final ef Code2 = du.Code(activity);
            Code2.Code(window.getAttributes());
            window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.huawei.openalliance.ad.utils.ay.2
                @Override // android.view.View.OnApplyWindowInsetsListener
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    try {
                        Rect Code3 = ef.this.Code(windowInsets);
                        if (ge.Code()) {
                            ge.Code(ay.V, "got safe padding: %s", Integer.valueOf(Code3 == null ? 0 : Code3.right));
                        }
                        if (Code3 != null && iVar != null) {
                            iVar.Code(Code3.right);
                            return windowInsets;
                        }
                    } catch (NoSuchMethodError e) {
                        ge.I(ay.V, "getRingScreenSafePadding NoSuchMethodError getDisplaySideRegion");
                    } catch (Throwable th) {
                        String str = ay.V;
                        ge.I(str, "getRingScreenSafePadding error:" + th.getClass().getSimpleName());
                        return windowInsets;
                    }
                    return windowInsets;
                }
            });
        } catch (Throwable th) {
            ge.I(V, "getSafePadding ex: %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        try {
            intent.setClipData(com.huawei.openalliance.ad.constant.t.cF);
            context.startActivity(intent);
        } catch (Throwable th) {
            ge.I(V, "start activity error");
        }
    }

    public static void Code(final View view, Activity activity) {
        String str;
        String str2;
        if (activity == null) {
            str = V;
            str2 = "has no activity";
        } else if (!dt.B(activity)) {
            str = V;
            str2 = "not huawei phone";
        } else if (view == null) {
            str = V;
            str2 = "has no rootview";
        } else {
            Window window = activity.getWindow();
            if (window != null) {
                if (Build.VERSION.SDK_INT >= 20) {
                    try {
                        final ef Code2 = du.Code(activity);
                        Code2.Code(window.getAttributes());
                        window.getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.huawei.openalliance.ad.utils.ay.1
                            @Override // android.view.View.OnApplyWindowInsetsListener
                            public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                                try {
                                    Rect Code3 = ef.this.Code(windowInsets);
                                    if (Code3 != null && view != null) {
                                        view.setPadding(Code3.left, 0, Code3.right, 0);
                                        return windowInsets;
                                    }
                                } catch (NoSuchMethodError e) {
                                    ge.I(ay.V, "initOnApplyWindowInsets NoSuchMethodError getDisplaySideRegion");
                                } catch (Throwable th) {
                                    String str3 = ay.V;
                                    ge.I(str3, "initOnApplyWindowInsets error:" + th.getClass().getSimpleName());
                                    return windowInsets;
                                }
                                return windowInsets;
                            }
                        });
                        return;
                    } catch (NoSuchMethodError e) {
                        ge.I(V, "adaptRingScreen NoSuchMethodError setDisplaySideMode");
                        return;
                    } catch (Throwable th) {
                        String str3 = V;
                        ge.I(str3, "adaptRingScreen error:" + th.getClass().getSimpleName());
                        return;
                    }
                }
                return;
            }
            str = V;
            str2 = "has no window";
        }
        ge.I(str, str2);
    }

    public static void Code(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        imageView.setScaleX(I() ? -1.0f : 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean Code() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static boolean Code(Activity activity) {
        if (activity == null) {
            return false;
        }
        try {
            return ActivityManagerEx.getActivityWindowMode(activity) == 102;
        } catch (Throwable th) {
            ge.I(V, "isFreedomWindowMode error");
            return false;
        }
    }

    public static boolean Code(Context context) {
        PowerManager powerManager;
        if (context == null || (powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE)) == null) {
            return true;
        }
        try {
            return Build.VERSION.SDK_INT < 20 ? powerManager.isScreenOn() : powerManager.isInteractive();
        } catch (Exception e) {
            ge.I(V, "isScreenInteractive has exception");
            return true;
        }
    }

    public static int[] Code(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    public static int[] Code(hi hiVar) {
        if (!(hiVar instanceof View)) {
            hiVar = null;
        }
        return Code((View) hiVar);
    }

    public static boolean D(Context context) {
        boolean z = true;
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            z = true;
            if (!activity.isFinishing()) {
                if (activity.isDestroyed()) {
                    return true;
                }
                z = false;
            }
        }
        return z;
    }

    public static boolean F(Context context) {
        try {
            return du.Code(context).Code();
        } catch (Throwable th) {
            String str = V;
            ge.I(str, "isInMultiWindowMode " + th.getClass().getSimpleName());
            return false;
        }
    }

    public static int I(Context context) {
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(Settings.System.NAVIGATION_BAR_HEIGHT, "dimen", "android");
        int i = 0;
        if (identifier > 0) {
            i = 0;
            if (f(context)) {
                i = 0;
                if (g(context)) {
                    i = resources.getDimensionPixelSize(identifier);
                }
            }
        }
        return i;
    }

    public static boolean I() {
        return TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }

    public static int[] I(View view) {
        if (V(view)) {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            return iArr;
        }
        return new int[0];
    }

    public static int L(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 1;
        }
        return configuration.orientation;
    }

    public static int S(Context context) {
        int i = 0;
        if (context == null) {
            return 0;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(Settings.System.NAVIGATION_BAR_HEIGHT, "dimen", "android");
        if (identifier > 0) {
            i = resources.getDimensionPixelSize(identifier);
        }
        return i;
    }

    public static boolean V() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean V(Context context) {
        KeyguardManager keyguardManager;
        if (context == null || (keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE)) == null) {
            return false;
        }
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean V(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static int Z(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static String Z() {
        Locale locale = Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    public static int[] Z(View view) {
        return !V(view) ? new int[0] : new int[]{view.getMeasuredWidth(), view.getMeasuredHeight()};
    }

    public static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                return context.getPackageManager().canRequestPackageInstalls();
            }
            return true;
        } catch (Throwable th) {
            ge.I(V, "canInstallPackage exception %s", th.getClass().getSimpleName());
            return true;
        }
    }

    public static int b(Context context) {
        String str;
        String str2;
        if (dt.Code(context).S()) {
            try {
                return 1 - Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state");
            } catch (Settings.SettingNotFoundException e) {
                str = V;
                str2 = "get pureModeState error, setting not found.";
                ge.Z(str, str2);
                return 0;
            } catch (Throwable th) {
                str = V;
                str2 = "get pureModeState error.";
                ge.Z(str, str2);
                return 0;
            }
        }
        return 0;
    }

    public static int c(Context context) {
        Display defaultDisplay;
        int i = 1;
        if (context == null) {
            return 1;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            ge.Z(V, "Failed to get display orientation info.");
            int i2 = 1;
            if (context.getResources().getConfiguration().orientation == 2) {
                i2 = 0;
            }
            return i2;
        }
        int rotation = defaultDisplay.getRotation();
        if (rotation == 1) {
            return 0;
        }
        if (rotation == 2) {
            return 9;
        }
        if (rotation == 3) {
            i = 8;
        }
        return i;
    }

    public static boolean d(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            return al.Code(context, com.huawei.openalliance.ad.constant.t.cv);
        }
        return true;
    }

    public static int e(Context context) {
        try {
            int identifier = context.getResources().getIdentifier("hw_multiwindow_height_of_drag_bar", "dimen", "androidhwext");
            if (identifier > 0) {
                return context.getResources().getDimensionPixelSize(identifier);
            }
            return 0;
        } catch (Throwable th) {
            String str = V;
            ge.I(str, "getMultiWindowDragBarHeight " + th.getClass().getSimpleName());
            return 0;
        }
    }

    private static boolean f(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int b = c.b(context);
            ge.Code(V, "isGesture: %s", Integer.valueOf(b));
            if (b == 0) {
                return true;
            }
        } else {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            z = identifier > 0 ? resources.getBoolean(identifier) : false;
            String Code2 = Code("qemu.hw.mainkeys");
            if ("1".equals(Code2)) {
                return false;
            }
            if ("0".equals(Code2)) {
                return true;
            }
        }
        return z;
    }

    private static boolean g(Context context) {
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
        if (i2 - displayMetrics2.widthPixels > 0 || i - i3 > 0) {
            z = true;
        }
        return z;
    }
}
