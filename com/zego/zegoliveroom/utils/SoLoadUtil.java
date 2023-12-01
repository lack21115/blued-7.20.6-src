package com.zego.zegoliveroom.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoliveroom/utils/SoLoadUtil.class */
public final class SoLoadUtil {
    private static final int BUFFER_SIZE = 65536;
    private static final String VERSION_FILE_NAME_TEMPLATE = "cur_ver_%d.txt";

    private static boolean copyFile(File file, File file2) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2, false));
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = null;
            }
            try {
                byte[] bArr = new byte[65536];
                int i = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 65536);
                    if (read == -1) {
                        bufferedOutputStream.flush();
                        bufferedInputStream.close();
                        bufferedOutputStream.close();
                        return true;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                    int i2 = i + 1;
                    i = i2;
                    if (i2 % 10 == 0) {
                        bufferedOutputStream.flush();
                        i = i2;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
    }

    private static File getCustomizeLibDir(Context context, String str) {
        return new File(context.getDir("libs", 0), str);
    }

    private static String[] getSupportABIs() {
        return Build.VERSION.SDK_INT >= 21 ? Build.SUPPORTED_ABIS : new String[]{Build.CPU_ABI, Build.CPU_ABI2};
    }

    private static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean loadSoFile(String str, Context context) {
        File customizeLibDir = getCustomizeLibDir(context, "apk");
        File file = new File(customizeLibDir, versionFileName(getVersionCode(context)));
        File file2 = new File(customizeLibDir, str);
        int unzipSo = (file.exists() && file2.exists()) ? 0 : unzipSo(context, str, file2, file);
        Log.e("ZegoSoLoadUtil", "unzip " + str + " from apk, errorCode: " + unzipSo);
        System.load(file2.getPath());
        return true;
    }

    public static boolean loadSpecialLibrary(String str, Context context) {
        File file = new File(str);
        if (file.exists()) {
            try {
                System.load(str);
                return true;
            } catch (UnsatisfiedLinkError e) {
                File file2 = new File(getCustomizeLibDir(context, "ext"), file.getName());
                if (!file2.exists() || file2.length() != file.length()) {
                    try {
                        copyFile(file, file2);
                    } catch (Exception e2) {
                        Log.e("Java_ZegoLiveRoom", String.format("copyFile from %s to %s failed", file, file2), e2);
                    }
                }
                System.load(file2.getAbsolutePath());
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0036, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0033, code lost:
        if (r8.createNewFile() == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int unzipSo(android.content.Context r5, java.lang.String r6, java.io.File r7, java.io.File r8) {
        /*
            r0 = r5
            java.lang.String r0 = r0.getPackageCodePath()
            r5 = r0
            java.lang.String[] r0 = getSupportABIs()
            r12 = r0
            r0 = r12
            int r0 = r0.length
            r10 = r0
            r0 = 0
            r9 = r0
        L12:
            r0 = r9
            r1 = r10
            if (r0 >= r1) goto L4b
            r0 = r12
            r1 = r9
            r0 = r0[r1]
            r13 = r0
            r0 = r5
            r1 = r6
            r2 = r13
            r3 = r7
            boolean r0 = unzipSpecialABISo(r0, r1, r2, r3)     // Catch: java.lang.Exception -> L43
            if (r0 == 0) goto L3a
            r0 = r8
            boolean r0 = r0.createNewFile()     // Catch: java.lang.Exception -> L43
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L38
            r0 = 0
            return r0
        L38:
            r0 = -1
            return r0
        L3a:
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L12
        L43:
            r5 = move-exception
            r0 = r5
            r0.printStackTrace()
            r0 = -2
            return r0
        L4b:
            r0 = -3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.zegoliveroom.utils.SoLoadUtil.unzipSo(android.content.Context, java.lang.String, java.io.File, java.io.File):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
        if (r12 == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
        r0 = new byte[65536];
        r0 = r11.getParentFile();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
        if (r0.exists() != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0080, code lost:
        r0.mkdirs();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0088, code lost:
        r9 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(r11), 65536);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0098, code lost:
        r0 = r8.read(r0, 0, 65536);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a4, code lost:
        if (r0 == (-1)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a7, code lost:
        r9.write(r0, 0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b2, code lost:
        r9.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b7, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bb, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bf, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c0, code lost:
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c4, code lost:
        r10 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c5, code lost:
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:
        if (r9 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cc, code lost:
        r9.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d1, code lost:
        throw r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d3, code lost:
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d7, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean unzipSpecialABISo(java.lang.String r8, java.lang.String r9, java.lang.String r10, java.io.File r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.zegoliveroom.utils.SoLoadUtil.unzipSpecialABISo(java.lang.String, java.lang.String, java.lang.String, java.io.File):boolean");
    }

    private static String versionFileName(int i) {
        return String.format(VERSION_FILE_NAME_TEMPLATE, Integer.valueOf(i));
    }
}
