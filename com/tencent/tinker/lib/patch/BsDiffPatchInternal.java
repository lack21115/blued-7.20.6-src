package com.tencent.tinker.lib.patch;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import com.tencent.tinker.bsdiff.BSPatch;
import com.tencent.tinker.commons.util.IOHelper;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareBsDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/patch/BsDiffPatchInternal.class */
public class BsDiffPatchInternal extends BasePatchInternal {
    private static final String TAG = "Tinker.BsDiffPatchInternal";

    private static boolean extractBsDiffInternals(Context context, String str, String str2, File file, int i) {
        ZipFile zipFile;
        ZipFile zipFile2;
        String str3;
        InputStream inputStream;
        InputStream inputStream2;
        ArrayList arrayList = new ArrayList();
        ShareBsDiffPatchInfo.parseDiffPatchInfo(str2, arrayList);
        if (arrayList.isEmpty()) {
            ShareTinkerLog.w(TAG, "extract patch list is empty! type:%s:", ShareTinkerInternals.getTypeString(i));
            return true;
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        Tinker with = Tinker.with(context);
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            ShareTinkerLog.w(TAG, "applicationInfo == null!!!!", new Object[0]);
            return false;
        }
        try {
            ZipFile zipFile3 = new ZipFile(applicationInfo.sourceDir);
            try {
                ZipFile zipFile4 = new ZipFile(file);
                try {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ShareBsDiffPatchInfo shareBsDiffPatchInfo = (ShareBsDiffPatchInfo) it.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (shareBsDiffPatchInfo.path.equals("")) {
                            str3 = shareBsDiffPatchInfo.name;
                        } else {
                            str3 = shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name;
                        }
                        String str4 = shareBsDiffPatchInfo.md5;
                        if (SharePatchFileUtil.checkIfMd5Valid(str4)) {
                            File file3 = new File(str + (shareBsDiffPatchInfo.path + "/" + shareBsDiffPatchInfo.name));
                            if (!file3.exists()) {
                                file3.getParentFile().mkdirs();
                            } else if (str4.equals(SharePatchFileUtil.getMD5(file3))) {
                                ShareTinkerLog.w(TAG, "bsdiff file %s is already exist, and md5 match, just continue", file3.getPath());
                            } else {
                                ShareTinkerLog.w(TAG, "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                                file3.delete();
                            }
                            String str5 = shareBsDiffPatchInfo.patchMd5;
                            ZipEntry entry = zipFile4.getEntry(str3);
                            if (entry == null) {
                                ShareTinkerLog.w(TAG, "patch entry is null. path:" + str3, new Object[0]);
                                with.getPatchReporter().onPatchTypeExtractFail(file, file3, shareBsDiffPatchInfo.name, i);
                            } else if (str5.equals("0")) {
                                if (!extract(zipFile4, entry, file3, str4, false)) {
                                    ShareTinkerLog.w(TAG, "Failed to extract file " + file3.getPath(), new Object[0]);
                                    with.getPatchReporter().onPatchTypeExtractFail(file, file3, shareBsDiffPatchInfo.name, i);
                                }
                            } else if (SharePatchFileUtil.checkIfMd5Valid(str5)) {
                                ZipEntry entry2 = zipFile3.getEntry(str3);
                                if (entry2 == null) {
                                    ShareTinkerLog.w(TAG, "apk entry is null. path:" + str3, new Object[0]);
                                    with.getPatchReporter().onPatchTypeExtractFail(file, file3, shareBsDiffPatchInfo.name, i);
                                } else {
                                    String str6 = shareBsDiffPatchInfo.rawCrc;
                                    String valueOf = String.valueOf(entry2.getCrc());
                                    if (valueOf.equals(str6)) {
                                        try {
                                            inputStream2 = zipFile3.getInputStream(entry2);
                                            try {
                                                InputStream inputStream3 = zipFile4.getInputStream(entry);
                                                try {
                                                    BSPatch.patchFast(inputStream2, inputStream3, file3);
                                                    IOHelper.closeQuietly(inputStream2);
                                                    IOHelper.closeQuietly(inputStream3);
                                                    if (SharePatchFileUtil.verifyFileMd5(file3, str4)) {
                                                        ShareTinkerLog.w(TAG, "success recover bsdiff file: %s, use time: %d", file3.getPath(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                                    } else {
                                                        ShareTinkerLog.w(TAG, "Failed to recover diff file " + file3.getPath(), new Object[0]);
                                                        with.getPatchReporter().onPatchTypeExtractFail(file, file3, shareBsDiffPatchInfo.name, i);
                                                        SharePatchFileUtil.safeDeleteFile(file3);
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    inputStream = inputStream3;
                                                    IOHelper.closeQuietly(inputStream2);
                                                    IOHelper.closeQuietly(inputStream);
                                                    throw th;
                                                }
                                            } catch (Throwable th2) {
                                                th = th2;
                                                inputStream = null;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            inputStream = null;
                                            inputStream2 = null;
                                        }
                                    } else {
                                        ShareTinkerLog.e(TAG, "apk entry %s crc is not equal, expect crc: %s, got crc: %s", str3, str6, valueOf);
                                        with.getPatchReporter().onPatchTypeExtractFail(file, file3, shareBsDiffPatchInfo.name, i);
                                    }
                                }
                            } else {
                                ShareTinkerLog.w(TAG, "meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(i), shareBsDiffPatchInfo.name, str5);
                                with.getPatchReporter().onPatchPackageCheckFail(file, BasePatchInternal.getMetaCorruptedCode(i));
                            }
                        } else {
                            ShareTinkerLog.w(TAG, "meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(i), shareBsDiffPatchInfo.name, shareBsDiffPatchInfo.md5);
                            with.getPatchReporter().onPatchPackageCheckFail(file, BasePatchInternal.getMetaCorruptedCode(i));
                        }
                        SharePatchFileUtil.closeZip(zipFile3);
                        SharePatchFileUtil.closeZip(zipFile4);
                        return false;
                    }
                    SharePatchFileUtil.closeZip(zipFile3);
                    SharePatchFileUtil.closeZip(zipFile4);
                    return true;
                } catch (Throwable th4) {
                    th = th4;
                    zipFile2 = zipFile3;
                    zipFile = zipFile4;
                    try {
                        throw new TinkerRuntimeException("patch " + ShareTinkerInternals.getTypeString(i) + " extract failed (" + th.getMessage() + ").", th);
                    } catch (Throwable th5) {
                        SharePatchFileUtil.closeZip(zipFile2);
                        SharePatchFileUtil.closeZip(zipFile);
                        throw th5;
                    }
                }
            } catch (Throwable th6) {
                th = th6;
                zipFile2 = zipFile3;
                zipFile = null;
            }
        } catch (Throwable th7) {
            th = th7;
            zipFile = null;
            zipFile2 = null;
        }
    }

    private static boolean patchLibraryExtractViaBsDiff(Context context, String str, String str2, File file) {
        return extractBsDiffInternals(context, str + "/" + ShareConstants.SO_PATH + "/", str2, file, 5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean tryRecoverLibraryFiles(Tinker tinker, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        if (!tinker.isEnabledForNativeLib()) {
            ShareTinkerLog.w(TAG, "patch recover, library is not enabled", new Object[0]);
            return true;
        }
        String str2 = shareSecurityCheck.getMetaContentMap().get(ShareConstants.SO_META_FILE);
        if (str2 == null) {
            ShareTinkerLog.w(TAG, "patch recover, library is not contained", new Object[0]);
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean patchLibraryExtractViaBsDiff = patchLibraryExtractViaBsDiff(context, str, str2, file);
        ShareTinkerLog.i(TAG, "recover lib result:%b, cost:%d", Boolean.valueOf(patchLibraryExtractViaBsDiff), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        return patchLibraryExtractViaBsDiff;
    }
}
