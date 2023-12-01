package com.tencent.tmsqmsp.sdk.a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.tmsqmsp.sdk.app.QmspSDK;
import java.io.File;
import java.security.MessageDigest;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/a/c.class */
public class c {
    public static int a() {
        try {
            String str = QmspSDK.getContext().getPackageManager().getPackageInfo(QmspSDK.getContext().getPackageName(), 0).packageName;
            ApplicationInfo applicationInfo = QmspSDK.getContext().getApplicationInfo();
            if (applicationInfo.packageName.equals(str)) {
                return Integer.valueOf((int) new File(applicationInfo.publicSourceDir).length()).intValue();
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String a(int i) {
        return String.format("%d.%d.%d", Integer.valueOf(i >> 24), Integer.valueOf((16711680 & i) >> 16), Integer.valueOf((i & 65280) >> 8));
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return com.tencent.tmsqmsp.sdk.f.e.a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String b() {
        try {
            String packageName = QmspSDK.getContext().getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return null;
            }
            return packageName;
        } catch (Exception e) {
            return null;
        }
    }

    public static String c() {
        try {
            PackageInfo packageInfo = QmspSDK.getContext().getPackageManager().getPackageInfo(QmspSDK.getContext().getPackageName(), 0);
            if (TextUtils.isEmpty(packageInfo.versionName)) {
                return null;
            }
            return packageInfo.versionName.replaceAll("[^0-9.]", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String d() {
        return a(512);
    }

    public static String e() {
        try {
            return com.tencent.tmsqmsp.sdk.c.b.f39706c;
        } catch (Throwable th) {
            return "";
        }
    }

    public static String f() {
        PackageInfo packageInfo;
        try {
            packageInfo = QmspSDK.getContext().getPackageManager().getPackageInfo(QmspSDK.getContext().getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr.length <= 0) {
            return "";
        }
        try {
            return com.tencent.tmsqmsp.sdk.f.e.a(MessageDigest.getInstance("MD5").digest(signatureArr[0].toByteArray()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int g() {
        int parseInt;
        String str;
        try {
            String[] split = c().split("\\.");
            if (split.length == 2) {
                parseInt = (Integer.parseInt(split[0]) << 16) | 0;
                str = split[1];
            } else if (split.length != 3) {
                return 0;
            } else {
                parseInt = (Integer.parseInt(split[0]) << 24) | 0 | (Integer.parseInt(split[1]) << 16);
                str = split[2];
            }
            return (Integer.parseInt(str) << 8) | parseInt;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean h() {
        String property = System.getProperty("os.arch");
        return property != null && property.contains("64");
    }
}
