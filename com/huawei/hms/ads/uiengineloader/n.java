package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/n.class */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8950a = n.class.getSimpleName();
    private static final String b = "presplits";

    /* renamed from: c  reason: collision with root package name */
    private static final String f8951c = ",";

    private static HashMap<String, String> a(Context context, String str) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        HashMap<String, String> hashMap = new HashMap<>();
        if (Build.VERSION.SDK_INT < 21) {
            aa.c(f8950a, "The minSdkVersion for split feature is 21, the current api level is too low.");
            return hashMap;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 128);
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e) {
            String str2 = f8950a;
            aa.c(str2, "getSourceDir:cannot find the package:" + str + " info." + e.getClass().getSimpleName());
        }
        if (packageInfo.splitNames != null && applicationInfo.splitSourceDirs != null) {
            int min = Math.min(packageInfo.splitNames.length, applicationInfo.splitSourceDirs.length);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= min) {
                    break;
                }
                hashMap.put(packageInfo.splitNames[i2], applicationInfo.splitSourceDirs[i2]);
                i = i2 + 1;
            }
            return hashMap;
        }
        aa.c(f8950a, "splitNames or splitSourceDirs is null.");
        return hashMap;
    }

    public static Set<m> a(Context context, ApplicationInfo applicationInfo, String str) {
        HashSet hashSet = new HashSet();
        if (context != null && applicationInfo != null) {
            if (applicationInfo.metaData == null) {
                return hashSet;
            }
            String string = applicationInfo.metaData.getString(b);
            if (TextUtils.isEmpty(string)) {
                aa.b(f8950a, "No metadata: presplits found.");
                return hashSet;
            }
            String[] split = string.split(",");
            HashMap<String, String> a2 = a(context, str);
            if (split.length != 0) {
                if (a2.isEmpty()) {
                    return hashSet;
                }
                int length = split.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    String str2 = split[i2];
                    for (Map.Entry<String, String> entry : a2.entrySet()) {
                        if (str2.equals(entry.getKey())) {
                            hashSet.add(new m(new File(entry.getValue()), entry.getKey()));
                        }
                    }
                    i = i2 + 1;
                }
            }
        }
        return hashSet;
    }

    private static Set<m> b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e) {
            String str2 = f8950a;
            aa.d(str2, "getMetaSplits:cannot find the package:" + str + "info." + e.getClass().getSimpleName());
            applicationInfo = null;
        }
        return a(context, applicationInfo, str);
    }
}
