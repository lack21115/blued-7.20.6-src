package com.tencent.smtt.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.bun.miitmdid.core.Utils;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f25241a = "";
    public static String b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f25242c = "";
    public static String d = "";
    public static String e = "";

    public static String a() {
        try {
            return new String(Build.MODEL.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e2) {
            return Build.MODEL;
        }
    }

    public static String a(Context context) {
        try {
            return context.getPackageName();
        } catch (Exception e2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0039 A[Catch: Exception -> 0x0067, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x0067, blocks: (B:2:0x0000, B:4:0x0012, B:6:0x0019, B:8:0x0021, B:12:0x0039, B:9:0x002b), top: B:20:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r4, java.io.File r5) {
        /*
            r0 = r4
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> L67
            r1 = r5
            java.lang.String r1 = r1.getAbsolutePath()     // Catch: java.lang.Exception -> L67
            r2 = 65
            android.content.pm.PackageInfo r0 = r0.getPackageArchiveInfo(r1, r2)     // Catch: java.lang.Exception -> L67
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L6b
            r0 = r4
            android.content.pm.Signature[] r0 = r0.signatures     // Catch: java.lang.Exception -> L67
            if (r0 == 0) goto L2b
            r0 = r4
            android.content.pm.Signature[] r0 = r0.signatures     // Catch: java.lang.Exception -> L67
            int r0 = r0.length     // Catch: java.lang.Exception -> L67
            if (r0 <= 0) goto L2b
            r0 = r4
            android.content.pm.Signature[] r0 = r0.signatures     // Catch: java.lang.Exception -> L67
            r1 = 0
            r0 = r0[r1]     // Catch: java.lang.Exception -> L67
            r4 = r0
            goto L35
        L2b:
            java.lang.String r0 = "AppUtil"
            java.lang.String r1 = "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!"
            com.tencent.smtt.utils.TbsLog.w(r0, r1)     // Catch: java.lang.Exception -> L67
            goto L6b
        L35:
            r0 = r4
            if (r0 == 0) goto L65
            r0 = r4
            java.lang.String r0 = r0.toCharsString()     // Catch: java.lang.Exception -> L67
            r4 = r0
            r0 = r4
            return r0
        L40:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "getSign "
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r1 = "failed"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "AppUtil"
            r1 = r4
            java.lang.String r1 = r1.toString()
            com.tencent.smtt.utils.TbsLog.i(r0, r1)
        L65:
            r0 = 0
            return r0
        L67:
            r4 = move-exception
            goto L40
        L6b:
            r0 = 0
            r4 = r0
            goto L35
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.a(android.content.Context, java.io.File):java.lang.String");
    }

    public static String a(Context context, String str) {
        try {
            String valueOf = String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str));
            try {
                return String.valueOf(Integer.toHexString(Integer.parseInt(valueOf)));
            } catch (Exception e2) {
                return valueOf;
            }
        } catch (Exception e3) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a6 A[Catch: all -> 0x011f, TRY_LEAVE, TryCatch #7 {all -> 0x011f, blocks: (B:42:0x0097, B:44:0x00a6, B:46:0x00b6), top: B:68:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r5, boolean r6, java.io.File r7) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.a(android.content.Context, boolean, java.io.File):java.lang.String");
    }

    private static String a(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            JarEntry jarEntry = jarFile.getJarEntry(ShareConstants.RES_MANIFEST);
            byte[] bArr = new byte[8192];
            String a2 = a(a(jarFile, jarEntry, bArr)[0].getEncoded());
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (name != null) {
                    Certificate[] a3 = a(jarFile, nextElement, bArr);
                    String a4 = a3 != null ? a(a3[0].getEncoded()) : null;
                    if (a4 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!a4.equals(a2)) {
                        return null;
                    }
                }
            }
            return a2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    private static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return new String(cArr);
            }
            byte b2 = bArr[i2];
            int i3 = (b2 >> 4) & 15;
            int i4 = i2 * 2;
            cArr[i4] = (char) (i3 >= 10 ? (i3 + 97) - 10 : i3 + 48);
            int i5 = b2 & 15;
            cArr[i4 + 1] = (char) (i5 >= 10 ? (i5 + 97) - 10 : i5 + 48);
            i = i2 + 1;
        }
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) throws Exception {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, bArr.length) != -1);
        inputStream.close();
        if (jarEntry != null) {
            return jarEntry.getCertificates();
        }
        return null;
    }

    public static int b(Context context) {
        return Build.VERSION.SDK_INT;
    }

    public static String b() {
        InputStreamReader inputStreamReader;
        String str;
        String str2;
        if (TextUtils.isEmpty(f25242c)) {
            try {
                inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
                try {
                    str = new BufferedReader(inputStreamReader);
                } catch (Throwable th) {
                    th = th;
                    str = null;
                }
                try {
                    str2 = a(str.readLine().contains(Utils.CPU_ABI_X86) ? "i686" : System.getProperty("os.arch"));
                    try {
                        str.close();
                    } catch (IOException e2) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        String a2 = a(System.getProperty("os.arch"));
                        th.printStackTrace();
                        if (str != null) {
                            try {
                                str.close();
                            } catch (IOException e3) {
                            }
                        }
                        if (inputStreamReader != null) {
                            str2 = a2;
                            inputStreamReader.close();
                            return str;
                        }
                        return a2;
                    } finally {
                        if (str != null) {
                            try {
                                str.close();
                            } catch (IOException e4) {
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e5) {
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                inputStreamReader = null;
                str = null;
            }
            try {
                inputStreamReader.close();
                return str;
            } catch (IOException e6) {
                return str;
            }
        }
        return f25242c;
    }

    public static void b(Context context, String str) {
        Log.d("0816", "saveGuid guid is " + str);
        try {
            TbsDownloadConfig tbsDownloadConfig = TbsDownloadConfig.getInstance(context);
            tbsDownloadConfig.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_GUID, str);
            tbsDownloadConfig.commit();
        } catch (Exception e2) {
        }
    }

    public static String c() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        }
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i2])));
                        i = i2 + 1;
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e2) {
            return "02:00:00:00:00:00";
        }
    }

    public static String c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            return null;
        }
    }

    public static int d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e2) {
            return 0;
        }
    }

    public static boolean d() {
        Class<?> cls;
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
            if (Build.VERSION.SDK_INT < 21 || (cls = Class.forName("dalvik.system.VMRuntime")) == null || (declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0])) == null || (invoke = declaredMethod.invoke(null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0])) == null) {
                return false;
            }
            Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
            if (invoke2 instanceof Boolean) {
                return ((Boolean) invoke2).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0039 -> B:4:0x0015). Please submit an issue!!! */
    public static String e(Context context) {
        String str;
        try {
            str = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_GUID, "");
        } catch (Exception e2) {
            str = "";
        }
        Log.d("0816", "getGuid guid is " + str);
        return str;
    }

    public static String f(Context context) {
        if (TextUtils.isEmpty(f25241a)) {
            try {
                return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Exception e2) {
                TbsLog.i(e2);
                return "";
            }
        }
        return f25241a;
    }

    public static String g(Context context) {
        if (TextUtils.isEmpty(b)) {
            try {
                return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            } catch (Exception e2) {
                TbsLog.i(e2);
                return "";
            }
        }
        return b;
    }

    public static String h(Context context) {
        if (TextUtils.isEmpty(d)) {
            if (Build.VERSION.SDK_INT < 23) {
                try {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
                    d = connectionInfo == null ? "" : connectionInfo.getMacAddress();
                } catch (Exception e2) {
                    TbsLog.i(e2);
                }
            } else {
                d = c();
            }
        }
        return d;
    }

    public static String i(Context context) {
        if (TextUtils.isEmpty(e)) {
            try {
                e = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return e;
        }
        return e;
    }
}
