package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/u.class */
public class u {
    private static final String b = "lib";

    /* renamed from: c  reason: collision with root package name */
    private static final String f8966c = "!";
    private static final String d = "armeabi-v7a";
    private static final String e = "armeabi";

    /* renamed from: a  reason: collision with root package name */
    private static final String f8965a = u.class.getSimpleName();
    private static final Pattern f = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    public static String a(Context context, String str) {
        Iterator<String> it = b(context).iterator();
        while (it.hasNext()) {
            String next = it.next();
            String str2 = str.substring(0, str.lastIndexOf(File.separator)) + File.separator + next;
            if (new File(str2).exists()) {
                aa.b(f8965a, "The so has been unzipped, abi:".concat(String.valueOf(next)));
                return str2;
            }
        }
        return b(context, str);
    }

    private static boolean a(Context context) {
        if (context == null) {
            aa.d(f8965a, "Null context, please check it.");
            return false;
        }
        Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 23) {
            return Process.is64Bit();
        }
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128).nativeLibraryDir.contains("64");
            } catch (PackageManager.NameNotFoundException e2) {
                aa.d(f8965a, "Get application info failed: name not found, try to get baseContext.");
                z = false;
                if (context instanceof ContextWrapper) {
                    Context baseContext = ((ContextWrapper) context).getBaseContext();
                    if (baseContext == null) {
                        aa.c(f8965a, "Get baseContext failed: null. Return default: is64-bit.");
                        return true;
                    }
                    try {
                        return baseContext.getPackageManager().getApplicationInfo(baseContext.getPackageName(), 128).nativeLibraryDir.contains("64");
                    } catch (PackageManager.NameNotFoundException e3) {
                        aa.d(f8965a, "Get baseContext application info failed: name not found");
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private static boolean a(File file, String str) {
        try {
            Enumeration<? extends ZipEntry> entries = new ZipFile(file).entries();
            while (entries.hasMoreElements()) {
                String name = entries.nextElement().getName();
                if (name.contains("../")) {
                    aa.c(f8965a, "Unsafe zip name!");
                    return false;
                }
                Matcher matcher = f.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if (TextUtils.equals(str, group)) {
                        String str2 = f8965a;
                        aa.b(str2, "abiName:" + group + " matched.");
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            String str3 = f8965a;
            aa.c(str3, "isApkContainPrefAbi exception:" + e2.getClass().getSimpleName());
            return false;
        }
    }

    public static String b(Context context, String str) {
        if (Build.VERSION.SDK_INT > 23) {
            Iterator<String> it = b(context).iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (a(new File(str), next)) {
                    aa.b(f8965a, "use the preferred abi:".concat(String.valueOf(next)));
                    return str + f8966c + File.separator + "lib" + File.separator + next;
                }
            }
        }
        aa.c(f8965a, "cannot get a valid native path, return null.");
        return null;
    }

    private static ArrayList<String> b(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 21) {
            Collections.addAll(arrayList, a(context) ? Build.SUPPORTED_64_BIT_ABIS : Build.SUPPORTED_32_BIT_ABIS);
            return arrayList;
        }
        arrayList.add(d);
        arrayList.add(e);
        return arrayList;
    }
}
