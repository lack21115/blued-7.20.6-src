package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/ab.class */
public final class ab {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22536a = "_multiKitLoadNative";
    private static final String b = "com.huawei.hms.runtimekit.container.kitsdk.KitContext";

    /* renamed from: c  reason: collision with root package name */
    private static ThreadPoolExecutor f22537c = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue());

    private static String a(Context context) throws IOException {
        Context context2 = context;
        if (Build.VERSION.SDK_INT >= 24) {
            context2 = context.createDeviceProtectedStorageContext();
        }
        return context2.getFilesDir().getCanonicalPath() + File.separator + "modules";
    }

    public static String a(Context context, String str, String str2, PackageInfo packageInfo) {
        aa.b(f22536a, " originNativePath : ".concat(String.valueOf(str2)));
        if (b(context)) {
            if (TextUtils.isEmpty(str2) || !str2.contains(File.separator)) {
                aa.b(f22536a, "nativePath is empty or error");
                return str2;
            }
            return b(context, str, str2, packageInfo);
        }
        return str2;
    }

    private static void a(final String str, final int i, final boolean z) {
        f22537c.execute(new Runnable() { // from class: com.huawei.hms.ads.uiengineloader.ab.1
            @Override // java.lang.Runnable
            public final void run() {
                File file = new File(String.this);
                String num = Integer.toString(i);
                if (!ab.c(file)) {
                    return;
                }
                File[] listFiles = file.listFiles();
                int length = listFiles.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        return;
                    }
                    File file2 = listFiles[i3];
                    if (!z || !file2.getPath().contains(num)) {
                        StringBuilder sb = ab.d(file2) ? new StringBuilder(" delete success : ") : new StringBuilder(" delete failed : ");
                        sb.append(file2.getName());
                        aa.b(ab.f22536a, sb.toString());
                    }
                    i2 = i3 + 1;
                }
            }
        });
    }

    private static void a(ZipFile zipFile, String str, PackageInfo packageInfo, boolean z) {
        ae.a(zipFile);
        try {
            if (TextUtils.isEmpty(str) || packageInfo.versionCode <= 0) {
                return;
            }
            a(str, packageInfo.versionCode, z);
        } catch (Exception e) {
            aa.c(f22536a, "IOException:");
        }
    }

    private static String b(Context context, String str, String str2, PackageInfo packageInfo) {
        String str3;
        ZipFile zipFile;
        String str4;
        ZipFile zipFile2;
        try {
            StringBuilder sb = new StringBuilder();
            Context context2 = context;
            if (Build.VERSION.SDK_INT >= 24) {
                context2 = context.createDeviceProtectedStorageContext();
            }
            sb.append(context2.getFilesDir().getCanonicalPath() + File.separator + "modules");
            sb.append(File.separator);
            sb.append(packageInfo.packageName);
            str4 = sb.toString();
            zipFile = null;
            String str5 = str4;
            try {
                try {
                    String substring = str2.substring(str2.lastIndexOf(File.separator) + 1);
                    zipFile2 = new ZipFile(str);
                    try {
                        Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                        HashSet hashSet = new HashSet();
                        x.a(entries, hashSet, substring);
                        if (hashSet.size() <= 0) {
                            aa.b(f22536a, "native is empty");
                            a(zipFile2, str4, packageInfo, true);
                            return str2;
                        }
                        String str6 = str4 + File.separator + packageInfo.versionCode + File.separator + "lib" + File.separator + substring;
                        if (new File(str6).exists() || x.a(zipFile2, hashSet, str6) == 0) {
                            aa.b(f22536a, "newNativePath : ".concat(String.valueOf(str6)));
                            a(zipFile2, str4, packageInfo, true);
                            return str6;
                        }
                        aa.b(f22536a, "the apk decompress fail, newNativePath : ".concat(String.valueOf(str6)));
                        a(zipFile2, str4, packageInfo, false);
                        return str2;
                    } catch (Exception e) {
                        zipFile = zipFile2;
                        str5 = str4;
                        aa.c(f22536a, "catch IOException");
                        a(zipFile2, str4, packageInfo, true);
                        return str2;
                    } catch (Throwable th) {
                        zipFile = zipFile2;
                        str5 = str4;
                        th = th;
                        str3 = str5;
                        a(zipFile, str3, packageInfo, true);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                zipFile2 = null;
            }
        } catch (Exception e3) {
            str4 = null;
            zipFile2 = null;
        } catch (Throwable th3) {
            th = th3;
            str3 = null;
            zipFile = null;
            a(zipFile, str3, packageInfo, true);
            throw th;
        }
    }

    private static boolean b(Context context) {
        try {
            return context.getClassLoader().loadClass(b) != null;
        } catch (ClassNotFoundException e) {
            aa.b(f22536a, "The cp is not hms kit.");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(File file) {
        return file.exists() && file.isDirectory() && file.listFiles() != null && file.listFiles().length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(File file) {
        boolean z;
        if (c(file)) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            int i = 0;
            boolean z2 = true;
            while (true) {
                z = z2;
                if (i >= length) {
                    break;
                }
                z2 = z2 && d(listFiles[i]);
                i++;
            }
        } else {
            z = true;
        }
        boolean z3 = z;
        if (z) {
            z3 = false;
            if (z) {
                z3 = false;
                if (file.delete()) {
                    z3 = true;
                }
            }
        }
        return z3;
    }
}
