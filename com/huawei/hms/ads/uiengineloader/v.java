package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/v.class */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22575a = "ApkUtil";
    private static final Map<String, List<String>> b;

    static {
        HashMap hashMap = new HashMap();
        b = hashMap;
        hashMap.put("com.huawei.hwid", Arrays.asList("b92825c2bd5d6d6d1e7f39eecd17843b7d9016f611136b75441bc6f4d3f00f05"));
        b.put("com.huawei.hms", Arrays.asList("e49d5c2c0e11b3b1b96ca56c6de2a14ec7dab5ccc3b5f300d03e5b4dba44f539"));
        b.put("com.huawei.hwid.tv", Arrays.asList("3517262215d8d3008cbf888750b6418edc4d562ac33ed6874e0d73aba667bc3c"));
    }

    public static String a(Context context, String str) {
        byte[] b2 = b(context, str);
        if (b2 == null || b2.length == 0) {
            return null;
        }
        return z.a(ad.a(b2));
    }

    public static boolean a(Context context) {
        String str = "com.huawei.hwid";
        if (!c(context, "com.huawei.hwid")) {
            if (c(context, "com.huawei.hms")) {
                str = "com.huawei.hms";
            } else {
                str = "com.huawei.hwid";
                if (c(context, "com.huawei.hwid.tv")) {
                    str = "com.huawei.hwid.tv";
                }
            }
        }
        byte[] f = f(context, str);
        return a(b.get(str), (f == null || f.length == 0) ? null : z.a(ad.a(f)));
    }

    public static boolean a(List<String> list, String str) {
        if (list == null || TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : list) {
            if (str.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    private static byte[] a(PackageInfo packageInfo) {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        if (packageInfo != null) {
            byteArrayInputStream2 = null;
            try {
                if (packageInfo.signatures.length > 0) {
                    byteArrayInputStream = new ByteArrayInputStream(packageInfo.signatures[0].toByteArray());
                    try {
                        byte[] encoded = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream).getEncoded();
                        ae.a(byteArrayInputStream);
                        return encoded;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            aa.d(f22575a, "getPackageSignatureBytes Exception:" + th.getClass().getSimpleName());
                            byteArrayInputStream2 = byteArrayInputStream;
                            ae.a(byteArrayInputStream2);
                            aa.b(f22575a, "Failed to get application signature certificate fingerprint.");
                            return new byte[0];
                        } catch (Throwable th2) {
                            ae.a(byteArrayInputStream);
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                byteArrayInputStream = null;
            }
        }
        ae.a(byteArrayInputStream2);
        aa.b(f22575a, "Failed to get application signature certificate fingerprint.");
        return new byte[0];
    }

    private static String b(Context context) {
        return c(context, "com.huawei.hwid") ? "com.huawei.hwid" : c(context, "com.huawei.hms") ? "com.huawei.hms" : c(context, "com.huawei.hwid.tv") ? "com.huawei.hwid.tv" : "com.huawei.hwid";
    }

    private static byte[] b(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return a(packageManager.getPackageArchiveInfo(str, 64));
            }
        } catch (Throwable th) {
            aa.d(f22575a, "getPackageSignatureBytesByPath RuntimeException:" + th.getClass().getSimpleName());
        }
        return new byte[0];
    }

    private static boolean c(Context context, String str) {
        return d(context, str) != null;
    }

    private static PackageInfo d(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (Throwable th) {
            aa.c(f22575a, "getPackageInfo Exception");
            return null;
        }
    }

    private static String e(Context context, String str) {
        byte[] f = f(context, str);
        if (f == null || f.length == 0) {
            return null;
        }
        return z.a(ad.a(f));
    }

    private static byte[] f(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return a(packageManager.getPackageInfo(str, 64));
            }
        } catch (Throwable th) {
            aa.d(f22575a, "getPackageSignatureBytes RuntimeException:" + th.getClass().getSimpleName());
        }
        return new byte[0];
    }
}
