package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8942a = "ClassLoaderPathManager";
    private static final String b = "com.huawei.hff";

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, ArrayList<String>> f8943c = new HashMap<>();

    public static String a(Context context, String str, PackageInfo packageInfo) {
        String str2;
        if (context == null || TextUtils.isEmpty(str) || packageInfo == null) {
            aa.c(f8942a, "clientContext or dynamicApkPath or dynamicPackageInfo is null.");
            return null;
        }
        c(context, str, packageInfo);
        if (f8943c.containsKey(str)) {
            ArrayList<String> arrayList = f8943c.get(str);
            if (arrayList != null && !arrayList.isEmpty()) {
                StringBuilder sb = new StringBuilder(str);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    sb.append(File.pathSeparator);
                    sb.append(it.next());
                }
                aa.b(f8942a, "final dexPath is:" + sb.toString());
                return sb.toString();
            }
            str2 = "No split apk path has set.";
        } else {
            str2 = "No split apk required, continue.";
        }
        aa.b(f8942a, str2);
        return str;
    }

    private static String a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            aa.b(f8942a, "No split apk path has set.");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (sb.length() != 0) {
                sb.append(File.pathSeparator);
            }
            sb.append(u.b(context, next));
        }
        aa.b(f8942a, "HffSplitNativePath:" + sb.toString());
        return sb.toString();
    }

    public static String b(Context context, String str, PackageInfo packageInfo) {
        String str2;
        if (context == null || TextUtils.isEmpty(str) || packageInfo == null) {
            aa.c(f8942a, "clientContext or dynamicApkPath or dynamicPackageInfo is null.");
            return null;
        }
        c(context, str, packageInfo);
        String a2 = ab.a(context, str, u.a(context, str), packageInfo);
        packageInfo.applicationInfo.nativeLibraryDir = a2;
        if (!f8943c.containsKey(str)) {
            aa.b(f8942a, "No split apk required, continue.");
            return a2;
        }
        ArrayList<String> arrayList = f8943c.get(str);
        if (arrayList == null || arrayList.isEmpty()) {
            aa.b(f8942a, "No split apk path has set.");
            str2 = null;
        } else {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (sb.length() != 0) {
                    sb.append(File.pathSeparator);
                }
                sb.append(u.b(context, next));
            }
            aa.b(f8942a, "HffSplitNativePath:" + sb.toString());
            str2 = sb.toString();
        }
        if (TextUtils.isEmpty(a2)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return a2;
        }
        return a2 + File.pathSeparator + str2;
    }

    private static void c(Context context, String str, PackageInfo packageInfo) {
        if (f8943c.containsKey(str)) {
            aa.b(f8942a, "HFF split info for dynamicApkPath:" + str + " has set.");
            return;
        }
        new n();
        Set<m> a2 = n.a(context, packageInfo.applicationInfo, b);
        if (a2.isEmpty()) {
            aa.b(f8942a, "No HFF split path need to add to classloader.");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (m mVar : a2) {
            arrayList.add(mVar.f8949a.getAbsolutePath());
        }
        f8943c.put(str, arrayList);
    }
}
