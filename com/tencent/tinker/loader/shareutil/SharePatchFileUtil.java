package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.igexin.assist.util.AssistUtils;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/SharePatchFileUtil.class */
public class SharePatchFileUtil {
    private static final String TAG = "Tinker.PatchFileUtil";
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean checkIfMd5Valid(String str) {
        return str != null && str.length() == 32;
    }

    public static boolean checkResourceArscMd5(File file, String str) {
        ZipFile zipFile;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry(ShareConstants.RES_ARSC);
                if (entry == null) {
                    ShareTinkerLog.i(TAG, "checkResourceArscMd5 resources.arsc not found", new Object[0]);
                    closeZip(zipFile2);
                    return false;
                }
                InputStream inputStream = zipFile2.getInputStream(entry);
                String md5 = getMD5(inputStream);
                if (md5 == null || !md5.equals(str)) {
                    closeQuietly(inputStream);
                    closeZip(zipFile2);
                    return false;
                }
                closeQuietly(inputStream);
                closeZip(zipFile2);
                return true;
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                try {
                    ShareTinkerLog.i(TAG, "checkResourceArscMd5 throwable:" + th.getMessage(), new Object[0]);
                    closeZip(zipFile);
                    return false;
                } catch (Throwable th2) {
                    closeZip(zipFile);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
        }
    }

    public static String checkTinkerLastUncaughtCrash(Context context) {
        BufferedReader bufferedReader;
        File patchLastCrashFile = getPatchLastCrashFile(context);
        BufferedReader bufferedReader2 = null;
        if (!isLegalFile(patchLastCrashFile)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(patchLastCrashFile)));
            while (true) {
                bufferedReader2 = bufferedReader;
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            closeQuietly(bufferedReader);
                            return stringBuffer.toString();
                        }
                        stringBuffer.append(readLine);
                        stringBuffer.append("\n");
                    } catch (Throwable th) {
                        th = th;
                        closeQuietly(bufferedReader2);
                        throw th;
                    }
                } catch (Exception e) {
                    e = e;
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader3 = bufferedReader;
                    sb.append("checkTinkerLastUncaughtCrash exception: ");
                    BufferedReader bufferedReader4 = bufferedReader;
                    sb.append(e);
                    bufferedReader2 = bufferedReader;
                    ShareTinkerLog.e(TAG, sb.toString(), new Object[0]);
                    closeQuietly(bufferedReader);
                    return null;
                }
            }
        } catch (Exception e2) {
            e = e2;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            closeQuietly(bufferedReader2);
            throw th;
        }
    }

    public static void closeQuietly(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            if (obj instanceof Closeable) {
                ((Closeable) obj).close();
            } else if (Build.VERSION.SDK_INT >= 19 && (obj instanceof AutoCloseable)) {
                ((AutoCloseable) obj).close();
            } else if (obj instanceof ZipFile) {
                ((ZipFile) obj).close();
            } else {
                throw new IllegalArgumentException("obj: " + obj + " cannot be closed.");
            }
        } catch (Throwable th) {
        }
    }

    public static void closeZip(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e) {
                ShareTinkerLog.w(TAG, "Failed to close resource", e);
            }
        }
    }

    public static void copyFileUsingStream(File file, File file2) throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        if (!isLegalFile(file) || file2 == null || file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2, false);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        return;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(fileInputStream);
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            fileInputStream = null;
        }
    }

    public static final boolean deleteDir(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            safeDeleteFile(file);
            return true;
        } else if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return true;
        } else {
            for (File file2 : listFiles) {
                deleteDir(file2);
            }
            safeDeleteFile(file);
            return true;
        }
    }

    public static final boolean deleteDir(String str) {
        if (str == null) {
            return false;
        }
        return deleteDir(new File(str));
    }

    public static void ensureFileDirectory(File file) {
        if (file == null) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile.exists()) {
            return;
        }
        parentFile.mkdirs();
    }

    public static long getFileOrDirectorySize(File file) {
        long j = 0;
        long j2 = 0;
        if (file != null) {
            if (!file.exists()) {
                return 0L;
            }
            if (file.isFile()) {
                return file.length();
            }
            File[] listFiles = file.listFiles();
            j2 = 0;
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    j2 = j;
                    if (i2 >= length) {
                        break;
                    }
                    File file2 = listFiles[i2];
                    j += file2.isDirectory() ? getFileOrDirectorySize(file2) : file2.length();
                    i = i2 + 1;
                }
            }
        }
        return j2;
    }

    public static String getMD5(File file) {
        FileInputStream fileInputStream;
        if (file == null) {
            return null;
        }
        try {
            if (file.exists()) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e) {
                    e = e;
                    fileInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    file = null;
                    closeQuietly(file);
                    throw th;
                }
                try {
                    String md5 = getMD5(fileInputStream);
                    closeQuietly(fileInputStream);
                    return md5;
                } catch (Exception e2) {
                    e = e2;
                    ShareTinkerLog.e(TAG, e.getMessage(), new Object[0]);
                    closeQuietly(fileInputStream);
                    return null;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final String getMD5(InputStream inputStream) {
        int i;
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder(32);
            byte[] bArr = new byte[102400];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            for (byte b : messageDigest.digest()) {
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr[i] = hexDigits[(b >>> 4) & 15];
                i = i2 + 1;
                cArr[i2] = hexDigits[b & 15];
            }
            return new String(cArr);
        } catch (Exception e) {
            return null;
        }
    }

    public static File getPatchDirectory(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, (AssistUtils.BRAND_OPPO.equalsIgnoreCase(Build.MANUFACTURER) && Build.VERSION.SDK_INT == 22) ? ShareConstants.PATCH_DIRECTORY_NAME_SPEC : ShareConstants.PATCH_DIRECTORY_NAME);
    }

    public static File getPatchInfoFile(String str) {
        return new File(str + BridgeUtil.SPLIT_MARK + ShareConstants.PATCH_INFO_NAME);
    }

    public static File getPatchInfoLockFile(String str) {
        return new File(str + BridgeUtil.SPLIT_MARK + ShareConstants.PATCH_INFO_LOCK_NAME);
    }

    public static File getPatchLastCrashFile(Context context) {
        File patchTempDirectory = getPatchTempDirectory(context);
        if (patchTempDirectory == null) {
            return null;
        }
        return new File(patchTempDirectory, ShareConstants.PATCH_TEMP_LAST_CRASH_NAME);
    }

    public static File getPatchTempDirectory(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        return new File(applicationInfo.dataDir, ShareConstants.PATCH_TEMP_DIRECTORY_NAME);
    }

    public static String getPatchVersionDirectory(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return ShareConstants.PATCH_BASE_NAME + str.substring(0, 8);
    }

    public static String getPatchVersionFile(String str) {
        if (str == null || str.length() != 32) {
            return null;
        }
        return getPatchVersionDirectory(str) + ".apk";
    }

    public static final boolean isLegalFile(File file) {
        return file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0;
    }

    public static boolean isRawDexFile(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(ShareConstants.DEX_SUFFIX);
    }

    public static String loadDigestes(JarFile jarFile, JarEntry jarEntry) throws Exception {
        BufferedInputStream bufferedInputStream;
        StringBuilder sb = new StringBuilder();
        try {
            byte[] bArr = new byte[16384];
            bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
            while (true) {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        closeQuietly(bufferedInputStream);
                        return sb.toString();
                    }
                    sb.append(new String(bArr, 0, read));
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = null;
        }
    }

    public static String optimizedPathFor(File file, File file2) {
        if (!ShareTinkerInternals.isAfterAndroidO()) {
            String name = file.getName();
            String str = name;
            if (!name.endsWith(ShareConstants.DEX_SUFFIX)) {
                int lastIndexOf = name.lastIndexOf(".");
                if (lastIndexOf < 0) {
                    str = name + ShareConstants.DEX_SUFFIX;
                } else {
                    StringBuilder sb = new StringBuilder(lastIndexOf + 4);
                    sb.append((CharSequence) name, 0, lastIndexOf);
                    sb.append(ShareConstants.DEX_SUFFIX);
                    str = sb.toString();
                }
            }
            return new File(file2, str).getPath();
        }
        try {
            String currentInstructionSet = ShareTinkerInternals.getCurrentInstructionSet();
            File parentFile = file.getParentFile();
            String name2 = file.getName();
            int lastIndexOf2 = name2.lastIndexOf(46);
            String str2 = name2;
            if (lastIndexOf2 > 0) {
                str2 = name2.substring(0, lastIndexOf2);
            }
            return parentFile.getAbsolutePath() + "/oat/" + currentInstructionSet + BridgeUtil.SPLIT_MARK + str2 + ShareConstants.ODEX_SUFFIX;
        } catch (Exception e) {
            throw new TinkerRuntimeException("getCurrentInstructionSet fail:", e);
        }
    }

    public static final boolean safeDeleteFile(File file) {
        boolean z = true;
        if (file == null) {
            return true;
        }
        if (file.exists()) {
            ShareTinkerLog.i(TAG, "safeDeleteFile, try to delete path: " + file.getPath(), new Object[0]);
            boolean delete = file.delete();
            z = delete;
            if (!delete) {
                ShareTinkerLog.e(TAG, "Failed to delete file, try to delete when exit. path: " + file.getPath(), new Object[0]);
                file.deleteOnExit();
                z = delete;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
        if (r7 != false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean shouldAcceptEvenIfIllegal(java.io.File r5) {
        /*
            java.lang.String r0 = "vivo"
            java.lang.String r1 = android.os.Build.MANUFACTURER
            boolean r0 = r0.equalsIgnoreCase(r1)
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = r9
            if (r0 != 0) goto L33
            java.lang.String r0 = "oppo"
            java.lang.String r1 = android.os.Build.MANUFACTURER
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 != 0) goto L33
            java.lang.String r0 = "meizu"
            java.lang.String r1 = android.os.Build.MANUFACTURER
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto L2e
            goto L33
        L2e:
            r0 = 0
            r6 = r0
            goto L35
        L33:
            r0 = 1
            r6 = r0
        L35:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            if (r0 >= r1) goto L59
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L4b
            int r0 = android.os.Build.VERSION.PREVIEW_SDK_INT
            if (r0 != 0) goto L59
        L4b:
            boolean r0 = com.tencent.tinker.loader.shareutil.ShareTinkerInternals.isArkHotRuning()
            if (r0 == 0) goto L54
            goto L59
        L54:
            r0 = 0
            r7 = r0
            goto L5b
        L59:
            r0 = 1
            r7 = r0
        L5b:
            r0 = r5
            boolean r0 = r0.exists()
            if (r0 == 0) goto L73
            r0 = r5
            long r0 = r0.length()
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L6e
            goto L73
        L6e:
            r0 = 0
            r8 = r0
            goto L75
        L73:
            r0 = 1
            r8 = r0
        L75:
            r0 = r6
            if (r0 != 0) goto L81
            r0 = r10
            r9 = r0
            r0 = r7
            if (r0 == 0) goto L8c
        L81:
            r0 = r10
            r9 = r0
            r0 = r8
            if (r0 == 0) goto L8c
            r0 = 1
            r9 = r0
        L8c:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.SharePatchFileUtil.shouldAcceptEvenIfIllegal(java.io.File):boolean");
    }

    public static boolean verifyDexFileMd5(File file, String str) {
        return verifyDexFileMd5(file, "classes.dex", str);
    }

    public static boolean verifyDexFileMd5(File file, String str, String str2) {
        ZipFile zipFile;
        ZipFile zipFile2;
        String str3;
        if (file == null || str2 == null || str == null) {
            return false;
        }
        if (isRawDexFile(file.getName())) {
            str3 = getMD5(file);
        } else {
            try {
                zipFile2 = new ZipFile(file);
            } catch (Throwable th) {
                th = th;
                zipFile = null;
            }
            try {
                ZipEntry entry = zipFile2.getEntry(str);
                if (entry == null) {
                    ShareTinkerLog.e(TAG, "There's no entry named: classes.dex in " + file.getAbsolutePath(), new Object[0]);
                    closeZip(zipFile2);
                    return false;
                }
                InputStream inputStream = zipFile2.getInputStream(entry);
                String md5 = getMD5(inputStream);
                closeQuietly(inputStream);
                str3 = md5;
                closeZip(zipFile2);
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile2;
                try {
                    ShareTinkerLog.e(TAG, "Bad dex jar file: " + file.getAbsolutePath(), th);
                    closeZip(zipFile);
                    return false;
                } catch (Throwable th3) {
                    closeZip(zipFile);
                    throw th3;
                }
            }
        }
        return str2.equals(str3);
    }

    public static boolean verifyFileMd5(File file, String str) {
        String md5;
        if (str == null || (md5 = getMD5(file)) == null) {
            return false;
        }
        return str.equals(md5);
    }
}
