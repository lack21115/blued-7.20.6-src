package com.tencent.tinker.lib.patch;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.tinker.commons.dexpatcher.DexPatchApplier;
import com.tencent.tinker.commons.util.IOHelper;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/patch/DexDiffPatchInternal.class */
public class DexDiffPatchInternal extends BasePatchInternal {
    protected static final int MAX_WAIT_COUNT = 120;
    protected static final String TAG = "Tinker.DexDiffPatchInternal";
    protected static final int WAIT_ASYN_OAT_TIME = 10000;
    private static ArrayList<File> optFiles = new ArrayList<>();
    private static ArrayList<ShareDexDiffPatchInfo> patchList = new ArrayList<>();
    private static HashMap<ShareDexDiffPatchInfo, File> classNDexInfo = new HashMap<>();
    private static boolean isVmArt = ShareTinkerInternals.isVmArt();

    private static boolean checkAllDexOptFile(ArrayList<File> arrayList, int i) {
        Iterator<File> it = arrayList.iterator();
        while (it.hasNext()) {
            File next = it.next();
            if (!SharePatchFileUtil.isLegalFile(next) && !SharePatchFileUtil.shouldAcceptEvenIfIllegal(next)) {
                ShareTinkerLog.e(TAG, "parallel dex optimizer file %s is not exist, just wait %d times", next.getName(), Integer.valueOf(i));
                return false;
            }
        }
        return true;
    }

    private static boolean checkClassNDexFiles(String str) {
        boolean z;
        boolean z2 = false;
        boolean z3 = false;
        if (!patchList.isEmpty()) {
            if (!isVmArt) {
                return false;
            }
            Iterator<ShareDexDiffPatchInfo> it = patchList.iterator();
            ShareDexDiffPatchInfo shareDexDiffPatchInfo = null;
            File file = null;
            while (it.hasNext()) {
                ShareDexDiffPatchInfo next = it.next();
                File file2 = new File(str + next.realName);
                if (ShareConstants.CLASS_N_PATTERN.matcher(file2.getName()).matches()) {
                    classNDexInfo.put(next, file2);
                }
                if (next.rawName.startsWith(ShareConstants.TEST_DEX_NAME)) {
                    shareDexDiffPatchInfo = next;
                    file = file2;
                }
            }
            if (shareDexDiffPatchInfo != null) {
                HashMap<ShareDexDiffPatchInfo, File> hashMap = classNDexInfo;
                hashMap.put(ShareTinkerInternals.changeTestDexToClassN(shareDexDiffPatchInfo, hashMap.size() + 1), file);
            }
            File file3 = new File(str, ShareConstants.CLASS_N_APK_NAME);
            if (file3.exists()) {
                Iterator<ShareDexDiffPatchInfo> it2 = classNDexInfo.keySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z = true;
                        break;
                    }
                    ShareDexDiffPatchInfo next2 = it2.next();
                    if (!SharePatchFileUtil.verifyDexFileMd5(file3, next2.rawName, next2.destMd5InArt)) {
                        ShareTinkerLog.e(TAG, "verify dex file md5 error, entry name; %s, file len: %d", next2.rawName, Long.valueOf(file3.length()));
                        z = false;
                        break;
                    }
                }
                z2 = z;
                if (!z) {
                    SharePatchFileUtil.safeDeleteFile(file3);
                    z2 = z;
                }
            }
            z3 = z2;
            if (z2) {
                Iterator<File> it3 = classNDexInfo.values().iterator();
                while (true) {
                    z3 = z2;
                    if (!it3.hasNext()) {
                        break;
                    }
                    SharePatchFileUtil.safeDeleteFile(it3.next());
                }
            }
        }
        return z3;
    }

    private static boolean dexOptimizeDexFiles(Context context, List<File> list, String str, File file, PatchResult patchResult) {
        Tinker with = Tinker.with(context);
        optFiles.clear();
        if (list != null) {
            File file2 = new File(str);
            if (!file2.exists() && !file2.mkdirs()) {
                ShareTinkerLog.w(TAG, "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
                return false;
            }
            for (File file3 : list) {
                optFiles.add(new File(SharePatchFileUtil.optimizedPathFor(file3, file2)));
            }
            ShareTinkerLog.i(TAG, "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", Integer.valueOf(list.size()), str);
            final Vector vector = new Vector();
            final Throwable[] thArr = new Throwable[1];
            if (patchResult != null) {
                patchResult.dexoptTriggerTime = System.currentTimeMillis();
            }
            final boolean[] zArr = {false};
            TinkerDexOptimizer.optimizeAll(context, list, file2, TinkerApplication.getInstance().isUseDelegateLastClassLoader(), new TinkerDexOptimizer.ResultCallback() { // from class: com.tencent.tinker.lib.patch.DexDiffPatchInternal.1
                long startTime;

                @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                public void onFailed(File file4, File file5, Throwable th) {
                    ShareTinkerLog.i(DexDiffPatchInternal.TAG, "fail to parallel optimize dex %s use time %d", file4.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime));
                    vector.add(file4);
                    thArr[0] = th;
                }

                @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                public void onStart(File file4, File file5) {
                    this.startTime = System.currentTimeMillis();
                    ShareTinkerLog.i(DexDiffPatchInternal.TAG, "start to parallel optimize dex %s, size: %d", file4.getPath(), Long.valueOf(file4.length()));
                }

                @Override // com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback
                public void onSuccess(File file4, File file5, File file6) {
                    ShareTinkerLog.i(DexDiffPatchInternal.TAG, "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", file4.getPath(), file6.getPath(), Long.valueOf(file6.length()), Long.valueOf(System.currentTimeMillis() - this.startTime));
                    if (file6.exists()) {
                        return;
                    }
                    synchronized (zArr) {
                        zArr[0] = true;
                    }
                }
            });
            if (patchResult != null) {
                synchronized (zArr) {
                    patchResult.isOatGenerated = !zArr[0];
                }
            }
            if (vector.isEmpty()) {
                return true;
            }
            with.getPatchReporter().onPatchDexOptFail(file, vector, thArr[0]);
            return false;
        }
        return true;
    }

    private static boolean extractDexDiffInternals(Context context, String str, String str2, File file, int i) {
        ZipFile zipFile;
        ZipFile zipFile2;
        Throwable th;
        String str3;
        patchList.clear();
        ShareDexDiffPatchInfo.parseDexDiffPatchInfo(str2, patchList);
        if (patchList.isEmpty()) {
            ShareTinkerLog.w(TAG, "extract patch list is empty! type:%s:", ShareTinkerInternals.getTypeString(i));
            return true;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        Tinker with = Tinker.with(context);
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                ShareTinkerLog.w(TAG, "applicationInfo == null!!!!", new Object[0]);
                SharePatchFileUtil.closeZip(null);
                SharePatchFileUtil.closeZip(null);
                return false;
            }
            ZipFile zipFile3 = new ZipFile(applicationInfo.sourceDir);
            try {
                ZipFile zipFile4 = new ZipFile(file);
                try {
                    if (checkClassNDexFiles(str)) {
                        ShareTinkerLog.w(TAG, "class n dex file %s is already exist, and md5 match, just continue", ShareConstants.CLASS_N_APK_NAME);
                        SharePatchFileUtil.closeZip(zipFile3);
                        SharePatchFileUtil.closeZip(zipFile4);
                        return true;
                    }
                    Iterator<ShareDexDiffPatchInfo> it = patchList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            ShareDexDiffPatchInfo next = it.next();
                            long currentTimeMillis = System.currentTimeMillis();
                            if (next.path.equals("")) {
                                str3 = next.rawName;
                            } else {
                                str3 = next.path + "/" + next.rawName;
                            }
                            String str4 = next.dexDiffMd5;
                            String str5 = next.oldDexCrC;
                            if (isVmArt || !next.destMd5InDvm.equals("0")) {
                                String str6 = isVmArt ? next.destMd5InArt : next.destMd5InDvm;
                                if (!SharePatchFileUtil.checkIfMd5Valid(str6)) {
                                    ShareTinkerLog.w(TAG, "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(i), next.rawName, str6);
                                    with.getPatchReporter().onPatchPackageCheckFail(file, BasePatchInternal.getMetaCorruptedCode(i));
                                    break;
                                }
                                File file3 = new File(str + next.realName);
                                if (!file3.exists()) {
                                    file3.getParentFile().mkdirs();
                                } else if (SharePatchFileUtil.verifyDexFileMd5(file3, str6)) {
                                    ShareTinkerLog.w(TAG, "dex file %s is already exist, and md5 match, just continue", file3.getPath());
                                } else {
                                    ShareTinkerLog.w(TAG, "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                                    file3.delete();
                                }
                                ZipEntry entry = zipFile4.getEntry(str3);
                                ZipEntry entry2 = zipFile3.getEntry(str3);
                                if (str5.equals("0")) {
                                    if (entry == null) {
                                        ShareTinkerLog.w(TAG, "patch entry is null. path:" + str3, new Object[0]);
                                        with.getPatchReporter().onPatchTypeExtractFail(file, file3, next.rawName, i);
                                        break;
                                    } else if (!extractDexFile(zipFile4, entry, file3, next)) {
                                        ShareTinkerLog.w(TAG, "Failed to extract raw patch file " + file3.getPath(), new Object[0]);
                                        with.getPatchReporter().onPatchTypeExtractFail(file, file3, next.rawName, i);
                                        break;
                                    }
                                } else if (str4.equals("0")) {
                                    if (isVmArt) {
                                        if (entry2 == null) {
                                            ShareTinkerLog.w(TAG, "apk entry is null. path:" + str3, new Object[0]);
                                            with.getPatchReporter().onPatchTypeExtractFail(file, file3, next.rawName, i);
                                            break;
                                        }
                                        String valueOf = String.valueOf(entry2.getCrc());
                                        if (!valueOf.equals(str5)) {
                                            ShareTinkerLog.e(TAG, "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str5, valueOf);
                                            with.getPatchReporter().onPatchTypeExtractFail(file, file3, next.rawName, i);
                                            break;
                                        }
                                        extractDexFile(zipFile3, entry2, file3, next);
                                        if (!SharePatchFileUtil.verifyDexFileMd5(file3, str6)) {
                                            ShareTinkerLog.w(TAG, "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                            with.getPatchReporter().onPatchTypeExtractFail(file, file3, next.rawName, i);
                                            SharePatchFileUtil.safeDeleteFile(file3);
                                            break;
                                        }
                                    }
                                } else if (entry == null) {
                                    ShareTinkerLog.w(TAG, "patch entry is null. path:" + str3, new Object[0]);
                                    with.getPatchReporter().onPatchTypeExtractFail(file, file3, next.rawName, i);
                                    break;
                                } else if (!SharePatchFileUtil.checkIfMd5Valid(str4)) {
                                    ShareTinkerLog.w(TAG, "meta file md5 invalid, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(i), next.rawName, str4);
                                    with.getPatchReporter().onPatchPackageCheckFail(file, BasePatchInternal.getMetaCorruptedCode(i));
                                    break;
                                } else if (entry2 == null) {
                                    ShareTinkerLog.w(TAG, "apk entry is null. path:" + str3, new Object[0]);
                                    with.getPatchReporter().onPatchTypeExtractFail(file, file3, next.rawName, i);
                                    break;
                                } else {
                                    String valueOf2 = String.valueOf(entry2.getCrc());
                                    if (!valueOf2.equals(str5)) {
                                        ShareTinkerLog.e(TAG, "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str5, valueOf2);
                                        with.getPatchReporter().onPatchTypeExtractFail(file, file3, next.rawName, i);
                                        break;
                                    }
                                    patchDexFile(zipFile3, zipFile4, entry2, entry, next, file3);
                                    if (!SharePatchFileUtil.verifyDexFileMd5(file3, str6)) {
                                        ShareTinkerLog.w(TAG, "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                        with.getPatchReporter().onPatchTypeExtractFail(file, file3, next.rawName, i);
                                        SharePatchFileUtil.safeDeleteFile(file3);
                                        break;
                                    }
                                    ShareTinkerLog.w(TAG, "success recover dex file: %s, size: %d, use time: %d", file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                }
                            } else {
                                ShareTinkerLog.w(TAG, "patch dex %s is only for art, just continue", str3);
                            }
                        } else if (mergeClassNDexFiles(context, file, str)) {
                            SharePatchFileUtil.closeZip(zipFile3);
                            SharePatchFileUtil.closeZip(zipFile4);
                            return true;
                        }
                    }
                    SharePatchFileUtil.closeZip(zipFile3);
                    SharePatchFileUtil.closeZip(zipFile4);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    zipFile = zipFile4;
                    th = th;
                    zipFile2 = zipFile3;
                    try {
                        throw new TinkerRuntimeException("patch " + ShareTinkerInternals.getTypeString(i) + " extract failed (" + th.getMessage() + ").", th);
                    } catch (Throwable th3) {
                        SharePatchFileUtil.closeZip(zipFile2);
                        SharePatchFileUtil.closeZip(zipFile);
                        throw th3;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                zipFile = null;
            }
        } catch (Throwable th5) {
            zipFile = null;
            zipFile2 = null;
            th = th5;
        }
    }

    private static boolean extractDexFile(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) throws IOException {
        String str = isVmArt ? shareDexDiffPatchInfo.destMd5InArt : shareDexDiffPatchInfo.destMd5InDvm;
        return (SharePatchFileUtil.isRawDexFile(shareDexDiffPatchInfo.rawName) && shareDexDiffPatchInfo.isJarMode) ? extractDexToJar(zipFile, zipEntry, file, str) : extract(zipFile, zipEntry, file, str, true);
    }

    private static boolean extractDexToJar(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException {
        ZipOutputStream zipOutputStream;
        BufferedInputStream bufferedInputStream;
        int i = 0;
        boolean z = false;
        while (i < 2 && !z) {
            int i2 = i + 1;
            ShareTinkerLog.i(TAG, "try Extracting " + file.getPath(), new Object[0]);
            try {
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                    try {
                        byte[] bArr = new byte[16384];
                        zipOutputStream2.putNextEntry(new ZipEntry("classes.dex"));
                        for (int read = bufferedInputStream2.read(bArr); read != -1; read = bufferedInputStream2.read(bArr)) {
                            zipOutputStream2.write(bArr, 0, read);
                        }
                        zipOutputStream2.closeEntry();
                        IOHelper.closeQuietly(bufferedInputStream2);
                        IOHelper.closeQuietly(zipOutputStream2);
                        boolean verifyDexFileMd5 = SharePatchFileUtil.verifyDexFileMd5(file, str);
                        ShareTinkerLog.i(TAG, "isExtractionSuccessful: %b", Boolean.valueOf(verifyDexFileMd5));
                        i = i2;
                        z = verifyDexFileMd5;
                        if (!verifyDexFileMd5) {
                            if (file.delete()) {
                                i = i2;
                                z = verifyDexFileMd5;
                                if (file.exists()) {
                                }
                            }
                            ShareTinkerLog.e(TAG, "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                            i = i2;
                            z = verifyDexFileMd5;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        zipOutputStream = zipOutputStream2;
                        IOHelper.closeQuietly(bufferedInputStream);
                        IOHelper.closeQuietly(zipOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                    zipOutputStream = zipOutputStream2;
                }
            } catch (Throwable th3) {
                th = th3;
                zipOutputStream = null;
                bufferedInputStream = null;
            }
        }
        return z;
    }

    private static ZipEntry makeStoredZipEntry(ZipEntry zipEntry, String str) {
        ZipEntry zipEntry2 = new ZipEntry(str);
        zipEntry2.setMethod(0);
        zipEntry2.setCompressedSize(zipEntry.getSize());
        zipEntry2.setSize(zipEntry.getSize());
        zipEntry2.setCrc(zipEntry.getCrc());
        return zipEntry2;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x023e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean mergeClassNDexFiles(android.content.Context r10, java.io.File r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.patch.DexDiffPatchInternal.mergeClassNDexFiles(android.content.Context, java.io.File, java.lang.String):boolean");
    }

    private static boolean patchDexExtractViaDexDiff(Context context, String str, String str2, File file, PatchResult patchResult) {
        String str3 = str + "/" + ShareConstants.DEX_PATH + "/";
        if (!extractDexDiffInternals(context, str3, str2, file, 3)) {
            ShareTinkerLog.w(TAG, "patch recover, extractDiffInternals fail", new Object[0]);
            return false;
        }
        File[] listFiles = new File(str3).listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles != null) {
            int length = listFiles.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                File file2 = listFiles[i2];
                String name = file2.getName();
                if (file2.isFile() && (name.endsWith(ShareConstants.DEX_SUFFIX) || name.endsWith(ShareConstants.JAR_SUFFIX) || name.endsWith(".apk"))) {
                    arrayList.add(file2);
                }
                i = i2 + 1;
            }
        }
        ShareTinkerLog.i(TAG, "legal files to do dexopt: " + arrayList, new Object[0]);
        return dexOptimizeDexFiles(context, arrayList, str + "/odex/", file, patchResult);
    }

    private static void patchDexFile(ZipFile zipFile, ZipFile zipFile2, ZipEntry zipEntry, ZipEntry zipEntry2, ShareDexDiffPatchInfo shareDexDiffPatchInfo, File file) throws IOException {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2;
        ZipInputStream zipInputStream;
        ZipEntry nextEntry;
        try {
            BufferedInputStream bufferedInputStream4 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
            if (zipEntry2 != null) {
                try {
                    bufferedInputStream3 = new BufferedInputStream(zipFile2.getInputStream(zipEntry2));
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream2 = bufferedInputStream4;
                    bufferedInputStream = null;
                    IOHelper.closeQuietly(bufferedInputStream2);
                    IOHelper.closeQuietly(bufferedInputStream);
                    throw th;
                }
            } else {
                bufferedInputStream3 = null;
            }
            try {
                boolean isRawDexFile = SharePatchFileUtil.isRawDexFile(shareDexDiffPatchInfo.rawName);
                try {
                    try {
                        if (isRawDexFile && !shareDexDiffPatchInfo.isJarMode) {
                            new DexPatchApplier(bufferedInputStream4, bufferedInputStream3).executeAndSaveTo(file);
                            IOHelper.closeQuietly(bufferedInputStream4);
                            IOHelper.closeQuietly(bufferedInputStream3);
                            return;
                        }
                        zipOutputStream2.putNextEntry(new ZipEntry("classes.dex"));
                        if (isRawDexFile) {
                            new DexPatchApplier(bufferedInputStream4, bufferedInputStream3).executeAndSaveTo(zipOutputStream2);
                        } else {
                            try {
                                zipInputStream = new ZipInputStream(bufferedInputStream4);
                                do {
                                    try {
                                        nextEntry = zipInputStream.getNextEntry();
                                        if (nextEntry == null) {
                                            break;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        IOHelper.closeQuietly(zipInputStream);
                                        throw th;
                                    }
                                } while (!"classes.dex".equals(nextEntry.getName()));
                                if (nextEntry == null) {
                                    throw new TinkerRuntimeException("can't recognize zip dex format file:" + file.getAbsolutePath());
                                }
                                new DexPatchApplier(zipInputStream, bufferedInputStream3).executeAndSaveTo(zipOutputStream2);
                                IOHelper.closeQuietly(zipInputStream);
                            } catch (Throwable th3) {
                                th = th3;
                                zipInputStream = null;
                            }
                        }
                        zipOutputStream2.closeEntry();
                        IOHelper.closeQuietly(zipOutputStream2);
                        IOHelper.closeQuietly(bufferedInputStream4);
                        IOHelper.closeQuietly(bufferedInputStream3);
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        zipOutputStream = zipOutputStream2;
                        IOHelper.closeQuietly(zipOutputStream);
                        throw th;
                    }
                    zipOutputStream2 = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                } catch (Throwable th5) {
                    th = th5;
                    zipOutputStream = null;
                }
            } catch (Throwable th6) {
                bufferedInputStream = bufferedInputStream3;
                bufferedInputStream2 = bufferedInputStream4;
                th = th6;
                IOHelper.closeQuietly(bufferedInputStream2);
                IOHelper.closeQuietly(bufferedInputStream);
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            bufferedInputStream = null;
            bufferedInputStream2 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean tryRecoverDexFiles(Tinker tinker, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file, PatchResult patchResult) {
        if (!tinker.isEnabledForDex()) {
            ShareTinkerLog.w(TAG, "patch recover, dex is not enabled", new Object[0]);
            return true;
        }
        String str2 = shareSecurityCheck.getMetaContentMap().get(ShareConstants.DEX_META_FILE);
        if (str2 == null) {
            ShareTinkerLog.w(TAG, "patch recover, dex is not contained", new Object[0]);
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean patchDexExtractViaDexDiff = patchDexExtractViaDexDiff(context, str, str2, file, patchResult);
        ShareTinkerLog.i(TAG, "recover dex result:%b, cost:%d", Boolean.valueOf(patchDexExtractViaDexDiff), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        return patchDexExtractViaDexDiff;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean waitAndCheckDexOptFile(File file, Tinker tinker) {
        if (optFiles.isEmpty()) {
            return true;
        }
        int size = patchList.size() * 30;
        int i = size;
        if (size > 120) {
            i = 120;
        }
        ShareTinkerLog.i(TAG, "raw dex count: %d, dex opt dex count: %d, final wait times: %d", Integer.valueOf(patchList.size()), Integer.valueOf(optFiles.size()), Integer.valueOf(i));
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 + 1;
            i2 = i3;
            if (!checkAllDexOptFile(optFiles, i3)) {
                try {
                    Thread.sleep(10000L);
                    i2 = i3;
                } catch (InterruptedException e) {
                    ShareTinkerLog.e(TAG, "thread sleep InterruptedException e:" + e, new Object[0]);
                    i2 = i3;
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = optFiles.iterator();
        while (it.hasNext()) {
            File next = it.next();
            ShareTinkerLog.i(TAG, "check dex optimizer file exist: %s, size %d", next.getPath(), Long.valueOf(next.length()));
            if (!SharePatchFileUtil.isLegalFile(next) && !SharePatchFileUtil.shouldAcceptEvenIfIllegal(next)) {
                ShareTinkerLog.e(TAG, "final parallel dex optimizer file %s is not exist, return false", next.getName());
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            tinker.getPatchReporter().onPatchDexOptFail(file, arrayList, new TinkerRuntimeException(ShareConstants.CHECK_DEX_OAT_EXIST_FAIL));
            return false;
        } else if (Build.VERSION.SDK_INT >= 21) {
            Iterator<File> it2 = optFiles.iterator();
            Throwable th = null;
            while (it2.hasNext()) {
                File next2 = it2.next();
                if (!SharePatchFileUtil.shouldAcceptEvenIfIllegal(next2)) {
                    ShareTinkerLog.i(TAG, "check dex optimizer file format: %s, size %d", next2.getName(), Long.valueOf(next2.length()));
                    try {
                        if (ShareElfFile.getFileTypeByMagic(next2) == 1) {
                            try {
                                IOHelper.closeQuietly(new ShareElfFile(next2));
                            } finally {
                                th = th;
                                try {
                                } catch (Throwable th2) {
                                }
                            }
                        } else {
                            continue;
                        }
                    } catch (IOException e2) {
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return true;
            }
            tinker.getPatchReporter().onPatchDexOptFail(file, arrayList, th == null ? new TinkerRuntimeException(ShareConstants.CHECK_DEX_OAT_FORMAT_FAIL) : new TinkerRuntimeException(ShareConstants.CHECK_DEX_OAT_FORMAT_FAIL, th));
            return false;
        } else {
            return true;
        }
    }
}
