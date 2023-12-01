package com.huawei.secure.android.common.sign;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.util.LogsUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/sign/HiPkgSignManager.class */
public class HiPkgSignManager {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9486a = "HiPkgSignManager";

    private static PackageInfo a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageArchiveInfo(str, 64);
            }
            return null;
        } catch (Exception e) {
            LogsUtil.e(f9486a, "Exception : " + e.getMessage(), true);
            return null;
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
            }
            if ((bArr[i2] & 255) < 16) {
                stringBuffer.append("0" + Integer.toHexString(bArr[i2] & 255));
            } else {
                stringBuffer.append(Integer.toHexString(bArr[i2] & 255));
            }
            i = i2 + 1;
        }
    }

    private static List<String> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        if (signatureArr != null) {
            if (signatureArr.length != 0) {
                int length = signatureArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    arrayList.add(b(signatureArr[i2].toByteArray()));
                    i = i2 + 1;
                }
            } else {
                return arrayList;
            }
        }
        return arrayList;
    }

    private static String b(byte[] bArr) {
        try {
            return a(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e) {
            LogsUtil.e(f9486a, "NoSuchAlgorithmException" + e.getMessage());
            return "";
        }
    }

    public static boolean doCheckArchiveApk(Context context, String str, String str2, String str3) {
        boolean z = false;
        if (!TextUtils.isEmpty(str2)) {
            z = false;
            if (!TextUtils.isEmpty(str)) {
                z = false;
                if (context != null) {
                    if (TextUtils.isEmpty(str3)) {
                        return false;
                    }
                    PackageInfo a2 = a(context, str2);
                    z = false;
                    if (a2 != null) {
                        String b = b(a2.signatures[0].toByteArray());
                        String str4 = a2.packageName;
                        z = false;
                        if (str.equalsIgnoreCase(b)) {
                            z = false;
                            if (str3.equals(str4)) {
                                z = true;
                            }
                        }
                    }
                }
            }
        }
        return z;
    }

    public static boolean doCheckInstalled(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return str.equalsIgnoreCase(getInstalledAppHash(context, str2));
    }

    public static boolean doCheckInstalledV2V3(Context context, List<String> list, String str) {
        List<String> installedAppHashV2V3;
        if (TextUtils.isEmpty(str) || list == null || context == null || (installedAppHashV2V3 = getInstalledAppHashV2V3(context, str)) == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            arrayList.add(str2.toUpperCase(Locale.ENGLISH));
        }
        for (String str3 : installedAppHashV2V3) {
            if (!arrayList.contains(str3)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] getInstalledAPPSignature(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            LogsUtil.e(f9486a, "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e) {
            LogsUtil.e(f9486a, "PackageManager.NameNotFoundException : " + e.getMessage(), true);
        } catch (Exception e2) {
            LogsUtil.e(f9486a, "Exception : " + e2.getMessage(), true);
        }
        return new byte[0];
    }

    public static String getInstalledAppHash(Context context, String str) {
        byte[] installedAPPSignature = getInstalledAPPSignature(context, str);
        return (installedAPPSignature == null || installedAPPSignature.length <= 0) ? "" : b(installedAPPSignature);
    }

    public static List<String> getInstalledAppHashV2V3(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        if (Build.VERSION.SDK_INT >= 28) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
            if (packageInfo == null || packageInfo.signingInfo == null) {
                return null;
            }
            return packageInfo.signingInfo.hasMultipleSigners() ? a(packageInfo.signingInfo.getApkContentsSigners()) : a(packageInfo.signingInfo.getSigningCertificateHistory());
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, 64);
        if (packageInfo2 != null) {
            try {
                if (packageInfo2.signatures == null || packageInfo2.signatures.length == 0) {
                    return null;
                }
                if (packageInfo2.signatures[0] == null) {
                    return null;
                }
                return a(packageInfo2.signatures);
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }

    public static String getUnInstalledAPPPackageName(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            LogsUtil.e(f9486a, "archiveFilePath is null or context is null");
            return "";
        }
        PackageInfo a2 = a(context, str);
        return a2 != null ? a2.packageName : "";
    }

    public static byte[] getUnInstalledAPPSignature(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            LogsUtil.e(f9486a, "archiveFilePath is null or context is null");
            return new byte[0];
        }
        PackageInfo a2 = a(context, str);
        if (a2 != null) {
            Signature signature = a2.signatures[0];
            if (signature != null) {
                return signature.toByteArray();
            }
        } else {
            LogsUtil.e(f9486a, "PackageInfo is null ");
        }
        return new byte[0];
    }

    public static String getUnInstalledAppHash(Context context, String str) {
        byte[] unInstalledAPPSignature = getUnInstalledAPPSignature(context, str);
        return (unInstalledAPPSignature == null || unInstalledAPPSignature.length <= 0) ? "" : b(unInstalledAPPSignature);
    }
}
