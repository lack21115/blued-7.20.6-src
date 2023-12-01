package com.youzan.spiderman.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/c/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f28051a;
    private static String b;

    /* renamed from: c  reason: collision with root package name */
    private static String f28052c;

    public static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("package_name", f28051a);
        hashMap.put("app_version", b);
        hashMap.put("cache_version", f28052c);
        hashMap.put("platform", "android");
        return hashMap;
    }

    public static void a(Context context) {
        PackageInfo packageInfo;
        if (context != null) {
            f28052c = "2.3.6";
            f28051a = context.getPackageName();
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (packageInfo = packageManager.getPackageInfo(f28051a, 128)) == null) {
                    return;
                }
                b = packageInfo.versionName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
