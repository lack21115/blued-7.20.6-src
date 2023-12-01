package com.amap.api.col.p0003sl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.umeng.analytics.pro.bl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* renamed from: com.amap.api.col.3sl.ho  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/ho.class */
public final class ho {

    /* renamed from: a  reason: collision with root package name */
    static String f5077a;
    static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f5078c = "";
    private static String d = "";
    private static String e = "";
    private static String f = "";

    public static String a(Context context) {
        try {
            return h(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f = str;
        if (context != null) {
            lb.a().a(new lc() { // from class: com.amap.api.col.3sl.ho.1
                @Override // com.amap.api.col.p0003sl.lc
                public final void runTask() {
                    FileOutputStream fileOutputStream;
                    FileOutputStream fileOutputStream2 = null;
                    try {
                        File file = new File(iu.c(Context.this, "k.store"));
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        fileOutputStream = new FileOutputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        fileOutputStream.write(ib.a(str));
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream2 = fileOutputStream;
                        try {
                            it.a(th, "AI", bl.f40666c);
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable th4) {
                                    th4.printStackTrace();
                                }
                            }
                        } catch (Throwable th5) {
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (Throwable th6) {
                                    th6.printStackTrace();
                                }
                            }
                            throw th5;
                        }
                    }
                }
            });
        }
    }

    public static void a(String str) {
        d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        try {
            if (b) {
                return true;
            }
            if (c(f5077a)) {
                b = true;
                return true;
            } else if (!TextUtils.isEmpty(f5077a)) {
                b = false;
                f5077a = null;
                return false;
            } else if (c(d)) {
                b = true;
                return true;
            } else if (TextUtils.isEmpty(d)) {
                return true;
            } else {
                b = false;
                d = null;
                return false;
            }
        } catch (Throwable th) {
            return true;
        }
    }

    public static String b(Context context) {
        try {
        } catch (Throwable th) {
            it.a(th, "AI", "gAN");
        }
        if ("".equals(f5078c)) {
            PackageManager packageManager = context.getPackageManager();
            f5078c = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            return f5078c;
        }
        return f5078c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f = str;
    }

    public static String c(Context context) {
        try {
        } catch (Throwable th) {
            it.a(th, "AI", "gpck");
        }
        if (d == null || "".equals(d)) {
            String packageName = context.getPackageName();
            d = packageName;
            if (!c(packageName)) {
                d = context.getPackageName();
            }
            return d;
        }
        return d;
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            char c2 = charArray[i2];
            if (('A' > c2 || c2 > 'z') && (('0' > c2 || c2 > ':') && c2 != '.')) {
                try {
                    iw.b(ib.a(), str, "errorPackage");
                    return false;
                } catch (Throwable th) {
                    return false;
                }
            }
            i = i2 + 1;
        }
    }

    public static String d(Context context) {
        try {
        } catch (Throwable th) {
            it.a(th, "AI", "gAV");
        }
        if ("".equals(e)) {
            e = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            String str = e;
            return str == null ? "" : str;
        }
        return e;
    }

    public static String e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(ib.c("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                String upperCase = Integer.toHexString(b2 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            String str2 = str;
            if (c(str)) {
                str2 = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(d)) {
                str2 = c(context);
            }
            stringBuffer.append(str2);
            String stringBuffer2 = stringBuffer.toString();
            f5077a = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            it.a(th, "AI", "gsp");
            return f5077a;
        }
    }

    public static String f(Context context) {
        try {
            hp.a(context);
        } catch (Throwable th) {
        }
        try {
            return h(context);
        } catch (Throwable th2) {
            it.a(th2, "AI", "gKy");
            return f;
        }
    }

    private static String g(Context context) {
        String str;
        File file = new File(iu.c(context, "k.store"));
        if (!file.exists()) {
            return "";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String a2 = ib.a(bArr);
                str = a2.length() == 32 ? a2 : "";
                try {
                    fileInputStream.close();
                    return str;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return str;
                }
            } catch (Throwable th2) {
                str = fileInputStream;
                th = th2;
                try {
                    it.a(th, "AI", "gKe");
                    if (file.exists()) {
                        file.delete();
                    }
                    if (str != null) {
                        try {
                            str.close();
                            return "";
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                            return "";
                        }
                    }
                    return "";
                } finally {
                    if (str != null) {
                        try {
                            str.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            th = th5;
            str = null;
        }
    }

    private static String h(Context context) throws PackageManager.NameNotFoundException {
        String str = f;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return f;
            }
            String string = applicationInfo.metaData.getString("com.amap.api.v2.apikey");
            f = string;
            if (string == null) {
                f = g(context);
            }
        }
        return f;
    }
}
