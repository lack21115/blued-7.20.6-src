package com.anythink.core.common.k;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/o.class */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final PackageManager f6819a;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/o$a.class */
    public enum a {
        ENABLED,
        DISABLED,
        NOT_INSTALLED
    }

    public o(Context context) {
        this.f6819a = context.getPackageManager();
    }

    private static boolean a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context != null) {
            try {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                    return false;
                }
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(context.getPackageName()) && runningAppProcessInfo.importance >= 200) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            return new byte[0];
        }
    }

    private int c(String str) {
        try {
            PackageInfo packageInfo = this.f6819a.getPackageInfo(str, 16);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    private String d(String str) {
        try {
            PackageInfo packageInfo = this.f6819a.getPackageInfo(str, 16);
            return (packageInfo == null || packageInfo.versionName == null) ? "" : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    private byte[] e(String str) {
        try {
            PackageInfo packageInfo = this.f6819a.getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e) {
        }
        return new byte[0];
    }

    public final a a(String str) {
        if (TextUtils.isEmpty(str)) {
            return a.NOT_INSTALLED;
        }
        try {
            return this.f6819a.getApplicationInfo(str, 0).enabled ? a.ENABLED : a.DISABLED;
        } catch (PackageManager.NameNotFoundException e) {
            return a.NOT_INSTALLED;
        }
    }

    public final String b(String str) {
        byte[] e = e(str);
        if (e == null || e.length == 0) {
            return null;
        }
        return k.a(a(e));
    }
}
