package com.sdk.tencent.base.framework.utils.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import com.sdk.tencent.f.c;
import com.sdk.tencent.i.a;
import com.sdk.tencent.n.b;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/base/framework/utils/app/AppUtils.class */
public class AppUtils extends a {
    private static final String TAG = "com.sdk.tencent.base.framework.utils.app.AppUtils";
    private static boolean isDebug = c.b;
    private static Stack<Activity> activityStack = new Stack<>();
    private static int targetSdkVersion = -1;

    private static String doFingerprint(byte[] bArr, String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(bArr);
        byte[] digest = messageDigest.digest();
        String str2 = "";
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= digest.length) {
                return str2;
            }
            String str3 = str2;
            if (i2 != 0) {
                str3 = str2 + ":";
            }
            String hexString = Integer.toHexString(digest[i2] & 255);
            String str4 = str3;
            if (hexString.length() == 1) {
                str4 = str3 + "0";
            }
            str2 = str4 + hexString;
            i = i2 + 1;
        }
    }

    public static int getAndroidSDKVersion(Context context) {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e) {
            b.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            return -1;
        }
    }

    public static String getApiKey(Context context, String str) {
        String str2 = (String) getMetaData(context, str);
        String str3 = str2;
        if (b.a(str2).booleanValue()) {
            str3 = com.sdk.tencent.t.a.f28079c;
        }
        return str3;
    }

    public static Drawable getAppIcon(Context context) {
        if (context == null) {
            a.logError(TAG, "getAppIcon", "mContext 为空", isDebug);
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return context.getResources().getDrawable(packageInfo.applicationInfo.icon);
            }
            return null;
        } catch (Exception e) {
            b.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            return null;
        }
    }

    public static String getAppLable(Context context) {
        if (context == null) {
            a.logError(TAG, "getAppLable", "mContext 为空", isDebug);
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 128)).toString();
        } catch (Exception e) {
            b.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            return null;
        }
    }

    public static String getAppMd5(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException e) {
            b.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            packageInfo = null;
        }
        if (packageInfo != null) {
            int i = packageInfo.applicationInfo.flags;
            try {
                return doFingerprint(packageInfo.signatures[0].toByteArray(), "MD5");
            } catch (Exception e2) {
                b.a(TAG, e2.getMessage(), Boolean.valueOf(isDebug));
                return null;
            }
        }
        return null;
    }

    public static long getInstallDate(Context context) {
        Long b = com.sdk.tencent.j.a.b(context, c.f28049a);
        Long l = b;
        if (b.longValue() == 0) {
            l = Long.valueOf(System.currentTimeMillis());
            com.sdk.tencent.j.a.a(context, c.f28049a, l);
        }
        return l.longValue();
    }

    public static String getLocalIPAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        return nextElement.getHostAddress().toString();
                    }
                }
            }
            return com.igexin.push.core.b.l;
        } catch (SocketException e) {
            return com.igexin.push.core.b.l;
        }
    }

    public static <T> T getMetaData(Context context, String str) {
        Bundle bundle;
        if (context == null || b.a(str).booleanValue()) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(getPackageName(context), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return null;
            }
            return (T) bundle.get(str);
        } catch (Exception e) {
            b.b(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            return null;
        }
    }

    public static String getPackageName() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentPackageName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Exception e) {
            b.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            return null;
        }
    }

    public static String getPackageName(Context context) {
        if (context == null) {
            b.c(TAG, "mContext 为空", Boolean.valueOf(isDebug));
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Exception e) {
            b.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            return null;
        }
    }

    public static int getTargetSdkVersion(Context context) {
        if (context == null) {
            return targetSdkVersion;
        }
        if (targetSdkVersion == -1) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(getPackageName(context), 1);
                if (packageInfo != null) {
                    targetSdkVersion = packageInfo.applicationInfo.targetSdkVersion;
                }
            } catch (Exception e) {
                b.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            }
        }
        return targetSdkVersion;
    }

    public static int getVersionCode(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(getPackageName(context), 1);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (Exception e) {
            b.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            return -1;
        }
    }

    public static String getVersionName(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e) {
            b.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            return null;
        }
    }

    public static boolean isFirstLogin(Context context) {
        return false;
    }

    public static boolean isServiceRunning(Context context, String str) {
        boolean z = false;
        boolean z2 = false;
        if (context == null) {
            b.c(TAG, "isServiceRunning: mContext 为空", Boolean.valueOf(isDebug));
            return false;
        }
        try {
            Iterator<ActivityManager.RunningServiceInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
            while (true) {
                z = z2;
                if (!it.hasNext()) {
                    return z2;
                }
                boolean z3 = z2;
                if (str.equals(it.next().service.getClassName())) {
                    z2 = true;
                }
            }
        } catch (Exception e) {
            b.a(TAG, e.getMessage(), Boolean.valueOf(isDebug));
            return z;
        }
    }

    public void addActivity(Activity activity) {
        activityStack.add(activity);
    }

    public Activity currentActivity() {
        return activityStack.lastElement();
    }

    public void finishActivity() {
        finishActivity(activityStack.lastElement());
    }

    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    public void finishActivity(Class<?> cls) {
        Iterator<Activity> it = activityStack.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next.getClass().equals(cls)) {
                finishActivity(next);
            }
        }
    }

    public void finishAllActivity() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= activityStack.size()) {
                activityStack.clear();
                return;
            }
            if (activityStack.get(i2) != null) {
                activityStack.get(i2).finish();
            }
            i = i2 + 1;
        }
    }
}
