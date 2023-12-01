package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.tinker.loader.TinkerRuntimeException;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/shareutil/ShareTinkerInternals.class */
public class ShareTinkerInternals {
    private static final String PATCH_PROCESS_NAME = ":patch";
    private static final String SAFEMODE_COUNT_REC_PREFIX = "safemode_count_rec_";
    private static final String TAG = "Tinker.TinkerInternals";
    private static final boolean VM_IS_ART = isVmArt(System.getProperty("java.vm.version"));
    private static final boolean VM_IS_JIT = isVmJitInternal();
    private static Boolean isPatchProcess = null;
    private static Boolean isARKHotRunning = null;
    private static String processName = null;
    private static String tinkerID = null;
    private static String currentInstructionSet = null;

    public static ShareDexDiffPatchInfo changeTestDexToClassN(ShareDexDiffPatchInfo shareDexDiffPatchInfo, int i) {
        String str;
        if (shareDexDiffPatchInfo.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
            if (i != 1) {
                str = "classes" + i + ShareConstants.DEX_SUFFIX;
            } else {
                str = "classes.dex";
            }
            return new ShareDexDiffPatchInfo(str, shareDexDiffPatchInfo.path, shareDexDiffPatchInfo.destMd5InDvm, shareDexDiffPatchInfo.destMd5InArt, shareDexDiffPatchInfo.dexDiffMd5, shareDexDiffPatchInfo.oldDexCrC, shareDexDiffPatchInfo.newOrPatchedDexCrC, shareDexDiffPatchInfo.dexMode);
        }
        return null;
    }

    public static int checkPackageAndTinkerFlag(ShareSecurityCheck shareSecurityCheck, int i) {
        if (isTinkerEnabledAll(i)) {
            return 0;
        }
        HashMap<String, String> metaContentMap = shareSecurityCheck.getMetaContentMap();
        if (isTinkerEnabledForDex(i) || !metaContentMap.containsKey(ShareConstants.DEX_META_FILE)) {
            if (isTinkerEnabledForNativeLib(i) || !metaContentMap.containsKey(ShareConstants.SO_META_FILE)) {
                return (isTinkerEnabledForResource(i) || !metaContentMap.containsKey(ShareConstants.RES_META_FILE)) ? 0 : -9;
            }
            return -9;
        }
        return -9;
    }

    public static int checkSignatureAndTinkerID(Context context, File file, ShareSecurityCheck shareSecurityCheck) {
        if (shareSecurityCheck.verifyPatchMetaSignature(file)) {
            String manifestTinkerID = getManifestTinkerID(context);
            if (manifestTinkerID == null) {
                return -5;
            }
            HashMap<String, String> packagePropertiesIfPresent = shareSecurityCheck.getPackagePropertiesIfPresent();
            if (packagePropertiesIfPresent == null) {
                return -2;
            }
            String str = packagePropertiesIfPresent.get(ShareConstants.TINKER_ID);
            if (str == null) {
                return -6;
            }
            if (manifestTinkerID.equals(str)) {
                return 0;
            }
            ShareTinkerLog.e(TAG, "tinkerId is not equal, base is " + manifestTinkerID + ", but patch is " + str, new Object[0]);
            return -7;
        }
        return -1;
    }

    public static int checkTinkerPackage(Context context, int i, File file, ShareSecurityCheck shareSecurityCheck) {
        int checkSignatureAndTinkerID = checkSignatureAndTinkerID(context, file, shareSecurityCheck);
        int i2 = checkSignatureAndTinkerID;
        if (checkSignatureAndTinkerID == 0) {
            i2 = checkPackageAndTinkerFlag(shareSecurityCheck, i);
        }
        return i2;
    }

    public static void cleanPatch(Application application) {
        if (application == null) {
            throw new TinkerRuntimeException("app is null");
        }
        File patchDirectory = SharePatchFileUtil.getPatchDirectory(application);
        if (!patchDirectory.exists()) {
            ShareTinkerLog.w(TAG, "try to clean patch while there're not any applied patches.", new Object[0]);
            return;
        }
        File patchInfoFile = SharePatchFileUtil.getPatchInfoFile(patchDirectory.getAbsolutePath());
        if (!patchInfoFile.exists()) {
            ShareTinkerLog.w(TAG, "try to clean patch while patch info file does not exist.", new Object[0]);
            return;
        }
        File patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(patchDirectory.getAbsolutePath());
        SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(patchInfoFile, patchInfoLockFile);
        if (readAndCheckPropertyWithLock != null) {
            readAndCheckPropertyWithLock.isRemoveNewVersion = true;
            SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, readAndCheckPropertyWithLock, patchInfoLockFile);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.zip.ZipFile] */
    public static Properties fastGetPatchPackageMeta(File file) {
        ZipFile zipFile;
        InputStream inputStream;
        if (file != null && file.isFile()) {
            try {
                if (file.length() != 0) {
                    try {
                        zipFile = new ZipFile(file);
                    } catch (IOException e) {
                        e = e;
                        zipFile = null;
                    } catch (Throwable th) {
                        th = th;
                        file = null;
                        SharePatchFileUtil.closeZip(file);
                        throw th;
                    }
                    try {
                        ZipEntry entry = zipFile.getEntry(ShareConstants.PACKAGE_META_FILE);
                        if (entry == null) {
                            ShareTinkerLog.e(TAG, "patch meta entry not found", new Object[0]);
                            SharePatchFileUtil.closeZip(zipFile);
                            return null;
                        }
                        try {
                            inputStream = zipFile.getInputStream(entry);
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = null;
                        }
                        try {
                            Properties properties = new Properties();
                            properties.load(inputStream);
                            SharePatchFileUtil.closeQuietly(inputStream);
                            SharePatchFileUtil.closeZip(zipFile);
                            return properties;
                        } catch (Throwable th3) {
                            th = th3;
                            SharePatchFileUtil.closeQuietly(inputStream);
                            throw th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        StringBuilder sb = new StringBuilder();
                        ZipFile zipFile2 = zipFile;
                        sb.append("fastGetPatchPackageMeta exception:");
                        ZipFile zipFile3 = zipFile;
                        sb.append(e.getMessage());
                        ZipFile zipFile4 = zipFile;
                        ShareTinkerLog.e(TAG, sb.toString(), new Object[0]);
                        SharePatchFileUtil.closeZip(zipFile);
                        return null;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        ShareTinkerLog.e(TAG, "patchFile is illegal", new Object[0]);
        return null;
    }

    public static String getCurrentInstructionSet() throws Exception {
        String str = currentInstructionSet;
        if (str != null) {
            return str;
        }
        currentInstructionSet = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
        ShareTinkerLog.d(TAG, "getCurrentInstructionSet:" + currentInstructionSet, new Object[0]);
        return currentInstructionSet;
    }

    public static String getCurrentOatMode(Context context, String str) {
        String str2 = str;
        if (str.equals(ShareConstants.CHANING_DEX_OPTIMIZE_PATH)) {
            if (isInMainProcess(context)) {
                return "odex";
            }
            str2 = ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH;
        }
        return str2;
    }

    public static String getExceptionCauseString(Throwable th) {
        if (th == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (true) {
            try {
                Throwable cause = th.getCause();
                if (cause == null) {
                    th.printStackTrace(printStream);
                    return toVisualString(byteArrayOutputStream.toString());
                }
                th = cause;
            } finally {
                SharePatchFileUtil.closeQuietly(printStream);
            }
        }
    }

    public static String getManifestTinkerID(Context context) {
        String str = tinkerID;
        if (str != null) {
            return str;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(ShareConstants.TINKER_ID);
            if (obj != null) {
                tinkerID = String.valueOf(obj);
            } else {
                tinkerID = null;
            }
            return tinkerID;
        } catch (Exception e) {
            ShareTinkerLog.e(TAG, "getManifestTinkerID exception:" + e.getMessage(), new Object[0]);
            return null;
        }
    }

    public static String getProcessName(Context context) {
        String str = processName;
        if (str != null) {
            return str;
        }
        String processNameInternal = getProcessNameInternal(context);
        processName = processNameInternal;
        return processNameInternal;
    }

    private static String getProcessNameInternal(Context context) {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo;
        FileInputStream fileInputStream;
        int i;
        int i2;
        int myPid = Process.myPid();
        if (context == null || myPid <= 0) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            try {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runningAppProcessInfo = null;
                            break;
                        }
                        runningAppProcessInfo = it.next();
                        if (runningAppProcessInfo.pid == myPid) {
                            break;
                        }
                    }
                    if (runningAppProcessInfo != null) {
                        return runningAppProcessInfo.processName;
                    }
                }
            } catch (Exception e) {
                ShareTinkerLog.e(TAG, "getProcessNameInternal exception:" + e.getMessage(), new Object[0]);
            }
        }
        byte[] bArr = new byte[128];
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("/proc/");
                    sb.append(myPid);
                    sb.append("/cmdline");
                    fileInputStream = new FileInputStream(sb.toString());
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            fileInputStream.close();
                            return "";
                        }
                        int i3 = 0;
                        while (true) {
                            i = i3;
                            i2 = read;
                            if (i >= read) {
                                break;
                            } else if ((bArr[i] & 255) > 128 || bArr[i] <= 0) {
                                break;
                            } else {
                                i3 = i + 1;
                            }
                        }
                        i2 = i;
                        String str = new String(bArr, 0, i2);
                        try {
                            fileInputStream.close();
                            return str;
                        } catch (Exception e2) {
                            return str;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        StringBuilder sb2 = new StringBuilder();
                        FileInputStream fileInputStream3 = fileInputStream;
                        sb2.append("getProcessNameInternal exception:");
                        FileInputStream fileInputStream4 = fileInputStream;
                        sb2.append(e.getMessage());
                        FileInputStream fileInputStream5 = fileInputStream;
                        ShareTinkerLog.e(TAG, sb2.toString(), new Object[0]);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            return "";
                        }
                        return "";
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream;
                        th = th;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileInputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            return "";
        }
    }

    public static int getSafeModeCount(Context context) {
        String str = SAFEMODE_COUNT_REC_PREFIX + getProcessName(context);
        File file = new File(SharePatchFileUtil.getPatchDirectory(context), str);
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(new FileInputStream(file));
            try {
                String readUTF = dataInputStream2.readUTF();
                if (!"safe_mode_count_1.9.14.15".equals(readUTF)) {
                    ShareTinkerLog.w(TAG, "getSafeModeCount: key is not equal, expt: %s, actul: %s, return 0 instead.", "safe_mode_count_1.9.14.15", readUTF);
                    SharePatchFileUtil.closeQuietly(dataInputStream2);
                    return 0;
                }
                int readInt = dataInputStream2.readInt();
                ShareTinkerLog.i(TAG, "getSafeModeCount: count: %s", Integer.valueOf(readInt));
                SharePatchFileUtil.closeQuietly(dataInputStream2);
                return readInt;
            } catch (Throwable th) {
                dataInputStream = dataInputStream2;
                try {
                    ShareTinkerLog.w(TAG, "getSafeModeCount: recFileName:" + str + " failed, return 0 instead.", new Object[0]);
                    SharePatchFileUtil.closeQuietly(dataInputStream);
                    return 0;
                } catch (Throwable th2) {
                    SharePatchFileUtil.closeQuietly(dataInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
        }
    }

    private static String getTinkerSwitchSPKey(Context context) {
        String manifestTinkerID = getManifestTinkerID(context);
        String str = manifestTinkerID;
        if (isNullOrNil(manifestTinkerID)) {
            str = "@@";
        }
        return "tinker_enable_1.9.14.15_" + str;
    }

    public static String getTypeString(int i) {
        switch (i) {
            case 1:
                return "patch_file";
            case 2:
                return "patch_info";
            case 3:
                return ShareConstants.DEX_PATH;
            case 4:
                return "dex_opt";
            case 5:
                return "lib";
            case 6:
                return "resource";
            default:
                return "unknown";
        }
    }

    public static boolean isAfterAndroidO() {
        return Build.VERSION.SDK_INT > 25;
    }

    public static boolean isArkHotRuning() {
        Boolean bool = isARKHotRunning;
        if (bool != null) {
            return bool.booleanValue();
        }
        isARKHotRunning = false;
        try {
            Method declaredMethod = ClassLoader.getSystemClassLoader().getParent().loadClass("com.huawei.ark.app.ArkApplicationInfo").getDeclaredMethod("isRunningInArk", new Class[0]);
            declaredMethod.setAccessible(true);
            isARKHotRunning = (Boolean) declaredMethod.invoke(null, new Object[0]);
        } catch (ClassNotFoundException e) {
            ShareTinkerLog.i(TAG, "class not found exception", new Object[0]);
        } catch (IllegalAccessException e2) {
            ShareTinkerLog.i(TAG, "illegal access exception", new Object[0]);
        } catch (IllegalArgumentException e3) {
            ShareTinkerLog.i(TAG, "illegal argument exception", new Object[0]);
        } catch (NoSuchMethodException e4) {
            ShareTinkerLog.i(TAG, "no such method exception", new Object[0]);
        } catch (SecurityException e5) {
            ShareTinkerLog.i(TAG, "security exception", new Object[0]);
        } catch (InvocationTargetException e6) {
            ShareTinkerLog.i(TAG, "invocation target exception", new Object[0]);
        }
        return isARKHotRunning.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0030, code lost:
        if (r0.length() == 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isInMainProcess(android.content.Context r3) {
        /*
            r0 = r3
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L11
            r0 = r4
            java.lang.String r0 = r0.processName
            r4 = r0
            goto L13
        L11:
            r0 = 0
            r4 = r0
        L13:
            r0 = r4
            r5 = r0
            r0 = r4
            boolean r0 = isNullOrNil(r0)
            if (r0 == 0) goto L21
            r0 = r3
            java.lang.String r0 = r0.getPackageName()
            r5 = r0
        L21:
            r0 = r3
            java.lang.String r0 = getProcessName(r0)
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L33
            r0 = r4
            r3 = r0
            r0 = r4
            int r0 = r0.length()
            if (r0 != 0) goto L37
        L33:
            java.lang.String r0 = ""
            r3 = r0
        L37:
            r0 = r5
            r1 = r3
            boolean r0 = r0.equals(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareTinkerInternals.isInMainProcess(android.content.Context):boolean");
    }

    public static boolean isInPatchProcess(Context context) {
        Boolean bool = isPatchProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(getProcessName(context).endsWith(PATCH_PROCESS_NAME));
        isPatchProcess = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean isNullOrNil(String str) {
        return str == null || str.length() <= 0;
    }

    public static boolean isSystemOTA(String str) {
        String str2 = Build.FINGERPRINT;
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            ShareTinkerLog.d(TAG, "fingerprint empty:" + str + ",current:" + str2, new Object[0]);
            return false;
        } else if (str.equals(str2)) {
            ShareTinkerLog.d(TAG, "same fingerprint:" + str2, new Object[0]);
            return false;
        } else {
            ShareTinkerLog.d(TAG, "system OTA,fingerprint not equal:" + str + "," + str2, new Object[0]);
            return true;
        }
    }

    public static boolean isTinkerEnableWithSharedPreferences(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences(ShareConstants.TINKER_SHARE_PREFERENCE_CONFIG, 4).getBoolean(getTinkerSwitchSPKey(context), true);
    }

    public static boolean isTinkerEnabled(int i) {
        return i != 0;
    }

    public static boolean isTinkerEnabledAll(int i) {
        return i == 15;
    }

    public static boolean isTinkerEnabledForArkHot(int i) {
        return (i & 8) != 0;
    }

    public static boolean isTinkerEnabledForDex(int i) {
        return (i & 1) != 0;
    }

    public static boolean isTinkerEnabledForNativeLib(int i) {
        return (i & 2) != 0;
    }

    public static boolean isTinkerEnabledForResource(int i) {
        return (i & 4) != 0;
    }

    public static boolean isVmArt() {
        return VM_IS_ART || Build.VERSION.SDK_INT >= 21;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0043, code lost:
        if (r0 >= 1) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isVmArt(java.lang.String r3) {
        /*
            r0 = 0
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r3
            if (r0 == 0) goto L48
            java.lang.String r0 = "(\\d+)\\.(\\d+)(\\.\\d+)?"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            r1 = r3
            java.util.regex.Matcher r0 = r0.matcher(r1)
            r3 = r0
            r0 = r7
            r6 = r0
            r0 = r3
            boolean r0 = r0.matches()
            if (r0 == 0) goto L48
            r0 = r3
            r1 = 1
            java.lang.String r0 = r0.group(r1)     // Catch: java.lang.NumberFormatException -> L4a
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L4a
            r4 = r0
            r0 = r3
            r1 = 2
            java.lang.String r0 = r0.group(r1)     // Catch: java.lang.NumberFormatException -> L4a
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L4a
            r5 = r0
            r0 = r4
            r1 = 2
            if (r0 > r1) goto L46
            r0 = r7
            r6 = r0
            r0 = r4
            r1 = 2
            if (r0 != r1) goto L48
            r0 = r7
            r6 = r0
            r0 = r5
            r1 = 1
            if (r0 < r1) goto L48
        L46:
            r0 = 1
            r6 = r0
        L48:
            r0 = r6
            return r0
        L4a:
            r3 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.shareutil.ShareTinkerInternals.isVmArt(java.lang.String):boolean");
    }

    public static boolean isVmJit() {
        return VM_IS_JIT && Build.VERSION.SDK_INT < 24;
    }

    private static boolean isVmJitInternal() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, String.class);
            String str = (String) declaredMethod.invoke(null, "dalvik.vm.usejit");
            String str2 = (String) declaredMethod.invoke(null, "dalvik.vm.usejitprofiles");
            if (isNullOrNil(str) || !isNullOrNil(str2)) {
                return false;
            }
            return str.equals("true");
        } catch (Throwable th) {
            ShareTinkerLog.e(TAG, "isVmJitInternal ex:" + th, new Object[0]);
            return false;
        }
    }

    public static void killAllOtherProcess(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    public static void killProcessExceptMain(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.uid == Process.myUid() && !runningAppProcessInfo.processName.equals(context.getPackageName())) {
                Process.killProcess(runningAppProcessInfo.pid);
            }
        }
    }

    public static void setSafeModeCount(Context context, int i) {
        String str = SAFEMODE_COUNT_REC_PREFIX + getProcessName(context);
        File file = new File(SharePatchFileUtil.getPatchDirectory(context), str);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        DataOutputStream dataOutputStream = null;
        try {
            DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream2.writeUTF("safe_mode_count_1.9.14.15");
                dataOutputStream2.writeInt(i);
                ShareTinkerLog.i(TAG, "setSafeModeCount: count: %s", Integer.valueOf(i));
                SharePatchFileUtil.closeQuietly(dataOutputStream2);
            } catch (Throwable th) {
                dataOutputStream = dataOutputStream2;
                try {
                    ShareTinkerLog.w(TAG, "setSafeModeCount: recFileName:" + str + " failed, return 0 instead.", new Object[0]);
                    SharePatchFileUtil.closeQuietly(dataOutputStream);
                } catch (Throwable th2) {
                    SharePatchFileUtil.closeQuietly(dataOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
        }
    }

    public static void setTinkerDisableWithSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ShareConstants.TINKER_SHARE_PREFERENCE_CONFIG, 4);
        sharedPreferences.edit().putBoolean(getTinkerSwitchSPKey(context), false).commit();
    }

    public static String toVisualString(String str) {
        char[] charArray;
        int i;
        boolean z;
        if (str == null || (charArray = str.toCharArray()) == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= charArray.length) {
                z = false;
                break;
            } else if (charArray[i] > 127) {
                charArray[i] = 0;
                z = true;
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (z) {
            str = new String(charArray, 0, i);
        }
        return str;
    }
}
