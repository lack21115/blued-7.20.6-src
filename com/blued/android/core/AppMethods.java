package com.blued.android.core;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.android.internal.util.cm.QSConstants;
import com.blued.android.core.utils.ByteArrayPool;
import com.blued.android.core.utils.Log;
import com.blued.android.core.utils.PoolingByteArrayOutputStream;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/AppMethods.class */
public class AppMethods {
    private static Toast a;

    /* renamed from: com.blued.android.core.AppMethods$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/AppMethods$1.class */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ CharSequence a;

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(AppInfo.d(), this.a, 0).show();
        }
    }

    public static int a(float f) {
        return (int) ((f * AppInfo.j) + 0.5d);
    }

    public static int a(int i) {
        return (int) ((i * AppInfo.j) + 0.5d);
    }

    public static String a() {
        return Build.VERSION.SDK + BridgeUtil.UNDERLINE_STR + Build.VERSION.RELEASE + BridgeUtil.UNDERLINE_STR + Build.MODEL;
    }

    public static String a(String str) {
        File externalCacheDir = AppInfo.d().getExternalCacheDir();
        if (externalCacheDir != null) {
            File file = new File(externalCacheDir, str);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.canRead() && file.canWrite()) {
                return file.getAbsolutePath();
            }
        }
        File cacheDir = AppInfo.d().getCacheDir();
        if (cacheDir != null) {
            File file2 = new File(cacheDir, str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (file2.canRead() && file2.canWrite()) {
                return file2.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void a(int i, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void a(Context context, Throwable th, String str, CrashInfoInterface crashInfoInterface) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        Throwable cause = th.getCause();
        while (true) {
            Throwable th2 = cause;
            if (th2 != null) {
                th2.printStackTrace(printWriter);
                cause = th2.getCause();
            } else {
                try {
                    break;
                } catch (PackageManager.NameNotFoundException e) {
                    Log.a("logCrashOnFile", "Error while collect package info", e);
                }
            }
        }
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
        if (packageInfo != null) {
            printWriter.append((CharSequence) ("\r\n" + packageInfo.versionName));
            printWriter.append((CharSequence) ("\r\nversionCode=" + packageInfo.versionCode));
        }
        if (crashInfoInterface != null) {
            String b = crashInfoInterface.b();
            if (!TextUtils.isEmpty(b)) {
                printWriter.append((CharSequence) ("\r\n" + b));
            }
        }
        String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()));
        printWriter.append((CharSequence) ("\r\ncrashTime=" + format));
        printWriter.append("\r\nbuildTime=<unknown>");
        printWriter.append("\r\nfromid=<unknown>");
        Field[] declaredFields = Build.class.getDeclaredFields();
        int length = declaredFields.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            Field field = declaredFields[i2];
            try {
                field.setAccessible(true);
                printWriter.append((CharSequence) ("\r\n" + field.getName() + ": " + field.get(null)));
            } catch (Exception e2) {
                Log.a("logCrashOnFile", "Error while collect crash info", e2);
            }
            i = i2 + 1;
        }
        String obj = stringWriter.toString();
        printWriter.close();
        String str2 = "";
        if (crashInfoInterface != null) {
            try {
                str2 = crashInfoInterface.a();
            } catch (Exception e3) {
                Log.a("logCrashOnFile", "an error occured while writing report file...", e3);
                return;
            }
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = c();
        }
        a(obj, str, str3);
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public static void a(CharSequence charSequence) {
        ToastUtils.a(charSequence, 0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public static void a(CharSequence charSequence, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static void a(String str, String str2, String str3) {
        Log.e("logOnFile", str);
        try {
            try {
                File file = new File(str2);
                if (file.exists() || file.mkdirs()) {
                    File file2 = new File(file, str3);
                    if (!file2.exists()) {
                        try {
                            file2.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (file2.length() > 102400) {
                        try {
                            if (file2.delete()) {
                                file2.createNewFile();
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    String str4 = "\r\n" + str;
                    FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
                    try {
                        fileOutputStream.write(str4.getBytes());
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    public static boolean a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public static boolean a(Intent intent) {
        List<ResolveInfo> queryIntentActivities = AppInfo.d().getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            File file2 = new File(str2);
            file2.delete();
            return file.renameTo(file2);
        }
        return false;
    }

    public static boolean a(String str, String str2, boolean z) {
        File file = new File(str2);
        if (file.exists()) {
            if (!z) {
                return true;
            }
            if (!file.delete()) {
                return false;
            }
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            File file2 = new File(str);
            if (!file2.exists()) {
                Log.e("IMAGE_LOADER", "saveImageCacheTo failed, fromFile don't exist, fromFilePath:" + str);
                return false;
            } else if (!file2.canRead()) {
                Log.e("IMAGE_LOADER", "saveImageCacheTo failed, fromFile don't read, fromFilePath:" + str);
                return false;
            } else {
                FileInputStream fileInputStream = new FileInputStream(str);
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                byte[] a2 = ByteArrayPool.a.a(1024);
                while (true) {
                    int read = fileInputStream.read(a2);
                    if (read <= 0) {
                        fileInputStream.close();
                        fileOutputStream.close();
                        ByteArrayPool.a.a(a2);
                        return true;
                    }
                    fileOutputStream.write(a2, 0, read);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        return a(inputStream, 0);
    }

    public static byte[] a(InputStream inputStream, int i) throws IOException {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(ByteArrayPool.a, i);
        byte[] bArr = null;
        if (inputStream == null) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ByteArrayPool.a.a((byte[]) null);
            poolingByteArrayOutputStream.close();
            return null;
        }
        try {
            byte[] a2 = ByteArrayPool.a.a(1024);
            while (true) {
                int read = inputStream.read(a2);
                if (read == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(a2, 0, read);
            }
            bArr = a2;
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            ByteArrayPool.a.a(a2);
            poolingByteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            ByteArrayPool.a.a(bArr);
            poolingByteArrayOutputStream.close();
            throw th;
        }
    }

    public static int b(int i) {
        return (int) ((i * AppInfo.j) + 0.5d);
    }

    public static String b(String str) {
        File externalFilesDir = AppInfo.d().getExternalFilesDir(null);
        if (externalFilesDir != null) {
            File file = new File(externalFilesDir, str);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.canRead() && file.canWrite()) {
                return file.getAbsolutePath();
            }
        }
        File filesDir = AppInfo.d().getFilesDir();
        if (filesDir != null) {
            File file2 = new File(filesDir, str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            if (file2.canRead() && file2.canWrite()) {
                return file2.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public static String b(String str, String str2) {
        String str3;
        String str4;
        String str5 = str;
        if (str == null) {
            str5 = "";
        }
        int indexOf = str5.indexOf(" (");
        if (indexOf > 0) {
            String substring = str5.substring(0, indexOf);
            String str6 = substring;
            if (substring.contains("Mozilla")) {
                str6 = "";
            }
            str4 = str6;
            str3 = "Mozilla/5.0 " + str5.substring(indexOf + 1);
        } else {
            str3 = "Mozilla/5.0 " + str5;
            str4 = "";
        }
        String stringBuffer = new StringBuffer("" + AppInfo.l + BridgeUtil.UNDERLINE_STR + AppInfo.m + BridgeUtil.UNDERLINE_STR + AppInfo.g + BridgeUtil.UNDERLINE_STR + AppInfo.h).reverse().toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Android/");
        sb.append(stringBuffer);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str3);
        sb3.append(" ");
        sb3.append(sb2);
        String sb4 = sb3.toString();
        String id = TimeZone.getDefault().getID();
        String str7 = sb4;
        if (!TextUtils.isEmpty(id)) {
            str7 = sb4 + " (" + id + ")";
        }
        String str8 = str7;
        if (!TextUtils.isEmpty(str4)) {
            str8 = str7 + " " + str4;
        }
        String e = AppInfo.e();
        String str9 = str8;
        if (!TextUtils.isEmpty(e)) {
            str9 = str8 + " app/" + e;
        }
        String str10 = str9;
        if (!TextUtils.isEmpty(str2)) {
            str10 = str9 + " " + str2;
        }
        return str10;
    }

    public static void b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String c() {
        String format = new SimpleDateFormat("yyyyMMdd-HHmmss").format(Long.valueOf(System.currentTimeMillis()));
        return "crash-" + format + ".txt";
    }

    public static boolean c(int i) {
        try {
            return Integer.parseInt(Build.VERSION.SDK) >= i;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char charAt = str.charAt(0);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= str.length()) {
                z = true;
                break;
            } else if (charAt != str.charAt(i2)) {
                z = false;
                break;
            } else {
                i = i2 + 1;
            }
        }
        return !z;
    }

    public static String d() {
        File externalStoragePublicDirectory = Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) : null;
        if (externalStoragePublicDirectory != null) {
            if (!externalStoragePublicDirectory.exists()) {
                externalStoragePublicDirectory.mkdirs();
            }
            if (externalStoragePublicDirectory.canRead() && externalStoragePublicDirectory.canWrite()) {
                return externalStoragePublicDirectory.getAbsolutePath();
            }
            return null;
        }
        return null;
    }

    public static void d(int i) {
        ToastUtils.a(i, 0);
    }

    public static boolean d(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String replace = str.replace(":", "");
        char charAt = replace.charAt(0);
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 >= replace.length()) {
                z = true;
                break;
            } else if (charAt != replace.charAt(i2)) {
                z = false;
                break;
            } else {
                i = i2 + 1;
            }
        }
        return !z;
    }

    public static String e() {
        WifiManager wifiManager = (WifiManager) AppInfo.d().getApplicationContext().getSystemService(QSConstants.TILE_WIFI);
        if (wifiManager != null) {
            try {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                return connectionInfo != null ? connectionInfo.getMacAddress() : "00:00:00:00:00:00";
            } catch (SecurityException e) {
                e.printStackTrace();
                return "00:00:00:00:00:00";
            }
        }
        return "00:00:00:00:00:00";
    }

    public static boolean f() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String g() {
        String property = System.getProperty("http.agent");
        if (property == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = property.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return stringBuffer.toString();
            }
            char charAt = property.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
            } else {
                stringBuffer.append(charAt);
            }
            i = i2 + 1;
        }
    }
}
