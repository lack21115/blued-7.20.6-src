package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/util/BksUtil.class */
public class BksUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9516a = "BksUtil";
    private static final String b = "com.huawei.hwid";

    /* renamed from: c  reason: collision with root package name */
    private static final String f9517c = "com.huawei.hwid";
    private static final String d = "com.huawei.hms";
    private static final String e = "com.huawei.hwid.tv";
    private static final String g = "files/hmsrootcas.bks";
    private static final String h = "4.0.2.300";
    private static final String i = "aegis";
    private static final String j = "hmsrootcas.bks";
    private static final long k = 604800000;
    private static final String l = "last_update_time";
    private static final String m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";
    private static final String n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";
    private static final String q = "";
    private static final String r = "bks_hash";
    private static final Uri f = Uri.parse("content://com.huawei.hwid");
    private static final String o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";
    private static final String[] p = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", o};

    private BksUtil() {
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            g.e(f9516a, "The directory  has already exists");
            return 1;
        } else if (file.mkdirs()) {
            g.a(f9516a, "create directory  success");
            return 0;
        } else {
            g.b(f9516a, "create directory  failed");
            return -1;
        }
    }

    private static String a(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + i;
        }
        return context.getApplicationContext().getFilesDir() + File.separator + i;
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return sb.toString();
            }
            String hexString = Integer.toHexString(bArr[i3] & 255);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
            i2 = i3 + 1;
        }
    }

    private static void a(InputStream inputStream, Context context) {
        FileOutputStream fileOutputStream;
        if (inputStream == null || context == null) {
            return;
        }
        String a2 = a(context);
        if (!new File(a2).exists()) {
            a(a2);
        }
        File file = new File(a2, "hmsrootcas.bks");
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                g.c(f9516a, "write output stream ");
                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            f.a((OutputStream) fileOutputStream3);
                            return;
                        }
                        fileOutputStream3.write(bArr, 0, read);
                    }
                } catch (IOException e2) {
                    fileOutputStream = fileOutputStream3;
                    fileOutputStream2 = fileOutputStream;
                    g.b(f9516a, " IOException");
                    f.a((OutputStream) fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream3;
                    f.a((OutputStream) fileOutputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            fileOutputStream = null;
        }
    }

    private static boolean a(int i2) {
        return i2 >= 40002300;
    }

    private static byte[] a(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str)) {
            Log.e(f9516a, "packageName is null or context is null");
            return new byte[0];
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                return packageInfo.signatures[0].toByteArray();
            }
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(f9516a, "PackageManager.NameNotFoundException : " + e2.getMessage());
        } catch (Exception e3) {
            Log.e(f9516a, "get pm exception : " + e3.getMessage());
        }
        return new byte[0];
    }

    private static String b(Context context) {
        return a(context) + File.separator + "hmsrootcas.bks";
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            g.b(f9516a, "inputstraem exception");
            return "";
        }
    }

    private static boolean b(Context context, String str) {
        return o.equalsIgnoreCase(c(a(context, str)));
    }

    private static boolean b(String str) {
        int parseInt;
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        g.c(f9516a, "hms version code is : " + str);
        String[] split = str.split("\\.");
        String[] split2 = h.split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = Math.max(length, length2);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= max) {
                return true;
            }
            if (i3 < length) {
                try {
                    parseInt = Integer.parseInt(split[i3]);
                } catch (Exception e2) {
                    g.b(f9516a, " exception : " + e2.getMessage());
                    if (i3 >= length2) {
                        z = true;
                    }
                    return z;
                }
            } else {
                parseInt = 0;
            }
            int parseInt2 = i3 < length2 ? Integer.parseInt(split2[i3]) : 0;
            if (parseInt < parseInt2) {
                return false;
            }
            if (parseInt > parseInt2) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    private static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return a(MessageDigest.getInstance("SHA-256").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            Log.e(f9516a, "NoSuchAlgorithmException" + e2.getMessage());
            return "";
        }
    }

    private static boolean c(Context context) {
        return new File(a(context) + File.separator + "hmsrootcas.bks").exists();
    }

    private static boolean c(Context context, String str) {
        byte[] a2 = a(context, str);
        String[] strArr = p;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (strArr[i3].equalsIgnoreCase(c(a2))) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public static InputStream getBksFromTss(Context context) {
        ByteArrayInputStream byteArrayInputStream;
        InputStream inputStream;
        ByteArrayInputStream byteArrayInputStream2;
        Exception e2;
        Throwable th;
        String a2;
        String b2;
        synchronized (BksUtil.class) {
            try {
                g.c(f9516a, "get bks from tss begin");
                if (context != null) {
                    c.a(context);
                }
                Context a3 = c.a();
                InputStream inputStream2 = null;
                if (a3 == null) {
                    g.b(f9516a, com.anythink.expressad.foundation.g.b.b.f4996a);
                    return null;
                } else if (!b(h.a("com.huawei.hwid")) && !b(h.a("com.huawei.hms"))) {
                    g.b(f9516a, "hms version code is too low : " + h.a("com.huawei.hwid"));
                    return null;
                } else if (!c(a3, "com.huawei.hwid") && !b(a3, "com.huawei.hms")) {
                    g.b(f9516a, "hms sign error");
                    return null;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        inputStream = a3.getContentResolver().openInputStream(Uri.withAppendedPath(f, g));
                        byteArrayInputStream = null;
                        inputStream2 = inputStream;
                        try {
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read <= -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                                byteArrayOutputStream.flush();
                                byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                                try {
                                    a2 = i.a(r, "", a3);
                                    b2 = b(byteArrayOutputStream.toByteArray());
                                } catch (Exception e3) {
                                    e2 = e3;
                                    StringBuilder sb = new StringBuilder();
                                    ByteArrayInputStream byteArrayInputStream3 = byteArrayInputStream2;
                                    sb.append("Get bks from HMS_VERSION_CODE exception : No content provider");
                                    ByteArrayInputStream byteArrayInputStream4 = byteArrayInputStream2;
                                    sb.append(e2.getMessage());
                                    byteArrayInputStream = byteArrayInputStream2;
                                    inputStream2 = inputStream;
                                    g.b(f9516a, sb.toString());
                                    f.a(inputStream);
                                    f.a((OutputStream) byteArrayOutputStream);
                                    f.a((InputStream) byteArrayInputStream2);
                                    return getFilesBksIS(a3);
                                } catch (Throwable th2) {
                                    byteArrayInputStream = byteArrayInputStream2;
                                    th = th2;
                                    f.a(inputStream);
                                    f.a((OutputStream) byteArrayOutputStream);
                                    f.a((InputStream) byteArrayInputStream);
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                th = th;
                                inputStream = inputStream2;
                                f.a(inputStream);
                                f.a((OutputStream) byteArrayOutputStream);
                                f.a((InputStream) byteArrayInputStream);
                                throw th;
                            }
                        } catch (Exception e4) {
                            byteArrayInputStream2 = null;
                            e2 = e4;
                        }
                    } catch (Exception e5) {
                        inputStream = null;
                        byteArrayInputStream2 = null;
                        e2 = e5;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayInputStream = null;
                        th = th;
                        inputStream = inputStream2;
                        f.a(inputStream);
                        f.a((OutputStream) byteArrayOutputStream);
                        f.a((InputStream) byteArrayInputStream);
                        throw th;
                    }
                    if (c(a3) && a2.equals(b2)) {
                        g.c(f9516a, "bks not update");
                        f.a(inputStream);
                        f.a((OutputStream) byteArrayOutputStream);
                        f.a((InputStream) byteArrayInputStream2);
                        return getFilesBksIS(a3);
                    }
                    g.c(f9516a, "update bks and sp");
                    a(byteArrayInputStream2, a3);
                    i.b(r, b2, a3);
                    f.a(inputStream);
                    f.a((OutputStream) byteArrayOutputStream);
                    f.a((InputStream) byteArrayInputStream2);
                    return getFilesBksIS(a3);
                }
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    public static InputStream getFilesBksIS(Context context) {
        if (c(context)) {
            g.c(f9516a, "getFilesBksIS ");
            try {
                return new FileInputStream(b(context));
            } catch (FileNotFoundException e2) {
                g.b(f9516a, "FileNotFoundExceptio: ");
                return null;
            }
        }
        return null;
    }
}
