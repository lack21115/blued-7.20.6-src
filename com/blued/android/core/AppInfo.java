package com.blued.android.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.android.internal.R;
import com.android.internal.telephony.PhoneConstants;
import com.anythink.core.api.ATAdConst;
import com.blued.android.core.ui.AppLifecycleCallbacks;
import com.blued.android.core.ui.UIPageCallback;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.toast.ToastUtils;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/AppInfo.class */
public class AppInfo {
    private static String G;
    private static List<String> H = new CopyOnWriteArrayList();
    public static String a = "";
    public static String b;
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static String g = "";
    public static int h = 0;
    public static String i = "";
    public static float j = 0.0f;
    public static int k = 0;
    public static int l = 0;
    public static int m = 0;
    public static String n = "";
    public static boolean o = false;
    public static int p = 17170445;
    public static int q = 17170445;
    public static int r = 17170445;
    public static float s = 0.4f;
    public static float t = 0.4f;
    public static long u = 524288000;
    public static boolean v = false;
    private static AppInfo w;
    private boolean B;
    private Handler C;
    private Gson F;
    private Application x;
    private AppLifecycleCallbacks y;
    private String z;
    private boolean A = true;
    private Set<AppHandoverListener> D = null;
    private UIPageCallback E = null;

    private AppInfo(Application application, boolean z) {
        this.B = false;
        this.C = null;
        this.F = null;
        this.x = application;
        this.y = new AppLifecycleCallbacks(application);
        this.B = z;
        this.C = new Handler(Looper.getMainLooper());
        a = application.getPackageName();
        this.F = new Gson();
        if (z) {
            try {
                if (!z) {
                    Log.a((Context) application, false, (File) null);
                    return;
                }
                File u2 = u();
                if (u2 == null) {
                    Log.a((Context) application, false, (File) null);
                    return;
                }
                Log.a((Context) application, true, u2);
                G = u2.getAbsolutePath();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static File a(Context context) {
        File file = new File(context.getFilesDir(), "blued_debug_log");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static void a() {
        b = AppMethods.b(AppMethods.g(), null);
        Log.a("AppInfo", "useragent:" + b);
    }

    public static void a(Activity activity) {
        if (c()) {
            AppInfo appInfo = w;
            appInfo.A = false;
            Set<AppHandoverListener> set = appInfo.D;
            if (set != null) {
                for (AppHandoverListener appHandoverListener : set) {
                    appHandoverListener.onAppFore(activity);
                }
            }
        }
    }

    private void a(Application application) {
        ToastUtils.a(application);
    }

    public static void a(Application application, String str, boolean z) {
        synchronized (AppInfo.class) {
            try {
                a(application, str, z, true);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void a(Application application, String str, boolean z, boolean z2) {
        synchronized (AppInfo.class) {
            try {
                if (w == null) {
                    AppInfo appInfo = new AppInfo(application, z);
                    w = appInfo;
                    appInfo.z = str;
                    appInfo.a(application, z2);
                    w.a(application);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a(Application application, boolean z) {
        if (z) {
            f = ((TelephonyManager) application.getSystemService(PhoneConstants.PHONE_KEY)).getSimOperator();
        }
    }

    public static void a(AppHandoverListener appHandoverListener) {
        if (c() && appHandoverListener != null) {
            AppInfo appInfo = w;
            if (appInfo.D == null) {
                appInfo.D = new HashSet();
            }
            w.D.add(appHandoverListener);
        }
    }

    public static void a(UIPageCallback uIPageCallback) {
        if (c()) {
            w.E = uIPageCallback;
        }
    }

    public static void a(String str) {
        c = str;
    }

    public static void a(boolean z, int i2, int i3) {
        a(z, i2, (int) R.color.transparent, i3);
    }

    public static void a(boolean z, int i2, int i3, int i4) {
        if (c()) {
            o = z;
            p = i2;
            q = i3;
            r = i4;
        }
    }

    public static UIPageCallback b() {
        if (c()) {
            return w.E;
        }
        return null;
    }

    public static void b(Activity activity) {
        if (j != 0.0f) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        j = displayMetrics.density;
        i = "" + displayMetrics.widthPixels + PhoneConstants.APN_TYPE_ALL + displayMetrics.heightPixels;
        k = displayMetrics.widthPixels * displayMetrics.heightPixels;
        if (displayMetrics.heightPixels >= displayMetrics.widthPixels) {
            l = displayMetrics.widthPixels;
            m = displayMetrics.heightPixels;
        } else {
            l = displayMetrics.heightPixels;
            m = displayMetrics.widthPixels;
        }
        a();
    }

    public static void b(String str) {
        AppLifecycleCallbacks.a(str);
    }

    public static void c(String str) {
        if (c()) {
            d = str;
        }
    }

    public static boolean c() {
        return w != null;
    }

    public static Context d() {
        if (c()) {
            return w.x;
        }
        return null;
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        H.add(str);
        while (H.size() > 10) {
            H.remove(0);
        }
        if (m()) {
            Log.c("AppInfo", r());
        }
    }

    public static String e() {
        if (c()) {
            return w.z;
        }
        return null;
    }

    public static Gson f() {
        if (c()) {
            return w.F;
        }
        return null;
    }

    public static boolean g() {
        return w.A;
    }

    public static void h() {
        if (c()) {
            AppInfo appInfo = w;
            appInfo.A = true;
            Set<AppHandoverListener> set = appInfo.D;
            if (set != null) {
                for (AppHandoverListener appHandoverListener : set) {
                    appHandoverListener.onAppBack();
                }
            }
        }
    }

    public static boolean i() {
        if (c()) {
            return o;
        }
        return false;
    }

    public static int j() {
        return !c() ? R.color.transparent : r;
    }

    public static int k() {
        return !c() ? R.color.transparent : p;
    }

    public static int l() {
        return !c() ? R.color.transparent : q;
    }

    public static boolean m() {
        if (c()) {
            return w.B;
        }
        return false;
    }

    public static Handler n() {
        if (c()) {
            return w.C;
        }
        return null;
    }

    public static boolean o() {
        return TextUtils.equals("2", w.z) || TextUtils.equals("4", w.z);
    }

    public static boolean p() {
        return TextUtils.equals("1", w.z) || TextUtils.equals(ATAdConst.ATDevFrameworkType.FLUTTER, w.z) || TextUtils.equals(ATAdConst.ATDevFrameworkType.ADOBIE_AIR, w.z);
    }

    public static void q() {
        if (TextUtils.isEmpty(e)) {
            e = AppMethods.e();
        }
        if (AppMethods.d(e)) {
            return;
        }
        e = "";
    }

    public static String r() {
        StringBuilder sb = new StringBuilder();
        for (String str : H) {
            sb.append(str);
            sb.append(", ");
        }
        return sb.toString();
    }

    public static void s() {
        try {
            f = ((TelephonyManager) w.x.getSystemService(PhoneConstants.PHONE_KEY)).getSimOperator();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void t() {
        try {
            PackageInfo packageInfo = w.x.getPackageManager().getPackageInfo(w.x.getPackageName(), 0);
            g = packageInfo.versionName;
            h = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        a();
    }

    private File u() {
        File file = new File(a((Context) this.x), "blued_core.txt");
        if (file.exists() && file.length() > 1024000 && !file.delete()) {
            Log.e("AppInfo", "文件大小超过限制, 但删除失败");
            return null;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
