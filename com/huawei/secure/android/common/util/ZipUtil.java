package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/util/ZipUtil.class */
public class ZipUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9548a = "ZipUtil";
    private static final int b = 104857600;

    /* renamed from: c  reason: collision with root package name */
    private static final int f9549c = 100;
    private static final int d = 4096;
    private static final String e = "../";
    private static final String f = "..\\";

    /* JADX WARN: Code restructure failed: missing block: B:104:0x0221, code lost:
        com.huawei.secure.android.common.util.IOUtil.closeSecure(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0228, code lost:
        if (r12 != false) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x022b, code lost:
        a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0233, code lost:
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<java.io.File> a(java.io.File r7, java.io.File r8, long r9, boolean r11) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.a(java.io.File, java.io.File, long, boolean):java.util.List");
    }

    private static void a(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream, ZipInputStream zipInputStream, FileOutputStream fileOutputStream) {
        IOUtil.closeSecure((InputStream) fileInputStream);
        IOUtil.closeSecure((OutputStream) bufferedOutputStream);
        IOUtil.closeSecure((InputStream) zipInputStream);
        IOUtil.closeSecure((OutputStream) fileOutputStream);
    }

    private static void a(String str) {
        if (TextUtils.isEmpty(str) || !e(str)) {
            return;
        }
        Log.e(f9548a, "IllegalArgumentException--path is not a standard path");
        throw new IllegalArgumentException("path is not a standard path");
    }

    private static boolean a(File file) {
        if (file != null) {
            return file.exists() ? file.isDirectory() : file.mkdirs();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002e A[Catch: all -> 0x008a, IOException -> 0x0095, TRY_LEAVE, TryCatch #6 {IOException -> 0x0095, all -> 0x008a, blocks: (B:5:0x0019, B:7:0x0024, B:9:0x002e, B:11:0x004a, B:18:0x0062, B:21:0x0070), top: B:67:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.lang.String r5, long r6, int r8) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.util.ZipUtil.a(java.lang.String, long, int):boolean");
    }

    private static boolean a(String str, String str2, long j, int i) throws SecurityCommonException {
        if (TextUtils.isEmpty(str) || e(str)) {
            LogsUtil.e(f9548a, "zip file is not valid");
            return false;
        } else if (TextUtils.isEmpty(str2) || e(str2)) {
            LogsUtil.e(f9548a, "target directory is not valid");
            return false;
        } else if (a(str, j, i)) {
            return true;
        } else {
            LogsUtil.e(f9548a, "zip file contains valid chars or too many files");
            throw new SecurityCommonException("unsecure zipfile!");
        }
    }

    private static boolean a(List<File> list) {
        try {
            for (File file : list) {
                e(file);
            }
            return true;
        } catch (Exception e2) {
            LogsUtil.e(f9548a, "unzip fail delete file failed" + e2.getMessage());
            return false;
        }
    }

    private static File b(String str) {
        a(str);
        return new File(str);
    }

    private static boolean b(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (a(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e2) {
                Log.e(f9548a, "createOrExistsFile IOException ");
                return false;
            }
        }
        return false;
    }

    private static File c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return b(str);
    }

    private static void c(File file) {
        if (file == null || file.delete()) {
            return;
        }
        LogsUtil.e(f9548a, "delete file error");
    }

    private static String d(String str) {
        int lastIndexOf;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(File.separator)) != -1) {
            return str.substring(lastIndexOf + 1);
        }
        return str;
    }

    private static void d(File file) {
        if (file == null || file.exists() || file.mkdirs()) {
            return;
        }
        LogsUtil.e(f9548a, "mkdirs error , files exists or IOException.");
    }

    private static void e(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            c(file);
        } else if (!file.isDirectory()) {
        } else {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                c(file);
                return;
            }
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    c(file);
                    return;
                } else {
                    e(listFiles[i2]);
                    i = i2 + 1;
                }
            }
        }
    }

    private static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f9548a, "isContainInvalidStr: name is null");
            return true;
        }
        boolean z = true;
        if (!str.contains(e)) {
            z = true;
            if (!str.contains(f)) {
                z = true;
                if (!str.contains("..")) {
                    z = true;
                    if (!str.contains("./")) {
                        z = true;
                        if (!str.contains(".\\.\\")) {
                            if (str.contains("%00")) {
                                return true;
                            }
                            z = false;
                        }
                    }
                }
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    @Deprecated
    public static boolean unZip(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    @Deprecated
    public static boolean unZip(String str, String str2, boolean z) throws SecurityCommonException {
        return unZip(str, str2, 104857600L, 100, z);
    }

    public static List<File> unZipNew(String str, String str2, long j, int i, boolean z) throws SecurityCommonException {
        if (a(str, str2, j, i)) {
            String str3 = str2;
            if (str2.endsWith(File.separator)) {
                str3 = str2;
                if (str2.length() > File.separator.length()) {
                    str3 = str2.substring(0, str2.length() - File.separator.length());
                }
            }
            return a(c(str), c(str3), j, z);
        }
        return null;
    }

    public static List<File> unZipNew(String str, String str2, boolean z) throws SecurityCommonException {
        return unZipNew(str, str2, 104857600L, 100, z);
    }
}
