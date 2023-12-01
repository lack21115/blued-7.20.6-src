package com.tencent.tinker.lib.patch;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.tinker.bsdiff.BSPatch;
import com.tencent.tinker.commons.util.IOHelper;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/patch/ResDiffPatchInternal.class */
public class ResDiffPatchInternal extends BasePatchInternal {
    protected static final String TAG = "Tinker.ResDiffPatchInternal";

    private static boolean checkAndExtractResourceLargeFile(Context context, String str, File file, File file2, File file3, ShareResPatchInfo shareResPatchInfo, int i) {
        ZipFile zipFile;
        ZipFile zipFile2;
        InputStream inputStream;
        InputStream inputStream2;
        long currentTimeMillis = System.currentTimeMillis();
        Tinker with = Tinker.with(context);
        try {
            ZipFile zipFile3 = new ZipFile(str);
            try {
                ZipEntry entry = zipFile3.getEntry(ShareConstants.RES_ARSC);
                File file4 = new File(file, ShareConstants.RES_ARSC);
                if (entry == null) {
                    try {
                        ShareTinkerLog.w(TAG, "resources apk entry is null. path:resources.arsc", new Object[0]);
                        with.getPatchReporter().onPatchTypeExtractFail(file3, file4, ShareConstants.RES_ARSC, i);
                        SharePatchFileUtil.closeZip(zipFile3);
                        SharePatchFileUtil.closeZip(null);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        zipFile = null;
                    }
                } else {
                    String valueOf = String.valueOf(entry.getCrc());
                    if (!valueOf.equals(shareResPatchInfo.arscBaseCrc)) {
                        ShareTinkerLog.e(TAG, "resources.arsc's crc is not equal, expect crc: %s, got crc: %s", shareResPatchInfo.arscBaseCrc, valueOf);
                        with.getPatchReporter().onPatchTypeExtractFail(file3, file4, ShareConstants.RES_ARSC, i);
                        SharePatchFileUtil.closeZip(zipFile3);
                        SharePatchFileUtil.closeZip(null);
                        return false;
                    } else if (shareResPatchInfo.largeModRes.isEmpty() && shareResPatchInfo.storeRes.isEmpty()) {
                        ShareTinkerLog.i(TAG, "no large modify or store resources, just return", new Object[0]);
                        SharePatchFileUtil.closeZip(zipFile3);
                        SharePatchFileUtil.closeZip(null);
                        return true;
                    } else {
                        ZipFile zipFile4 = new ZipFile(file3);
                        try {
                            for (String str2 : shareResPatchInfo.storeRes.keySet()) {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                File file5 = new File(file2, str2);
                                SharePatchFileUtil.ensureFileDirectory(file5);
                                ZipEntry entry2 = zipFile4.getEntry(str2);
                                if (entry2 == null) {
                                    ShareTinkerLog.w(TAG, "store patch entry is null. path:" + str2, new Object[0]);
                                    with.getPatchReporter().onPatchTypeExtractFail(file3, file5, str2, i);
                                    SharePatchFileUtil.closeZip(zipFile3);
                                    SharePatchFileUtil.closeZip(zipFile4);
                                    return false;
                                }
                                extract(zipFile4, entry2, file5, null, false);
                                if (entry2.getSize() != file5.length()) {
                                    ShareTinkerLog.w(TAG, "resource meta file size mismatch, type:%s, name: %s, patch size: %d, file size; %d", ShareTinkerInternals.getTypeString(i), str2, Long.valueOf(entry2.getSize()), Long.valueOf(file5.length()));
                                    with.getPatchReporter().onPatchPackageCheckFail(file3, BasePatchInternal.getMetaCorruptedCode(i));
                                    SharePatchFileUtil.closeZip(zipFile3);
                                    SharePatchFileUtil.closeZip(zipFile4);
                                    return false;
                                }
                                shareResPatchInfo.storeRes.put(str2, file5);
                                ShareTinkerLog.w(TAG, "success recover store file:%s, file size:%d, use time:%d", file5.getPath(), Long.valueOf(file5.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                            }
                            Iterator<String> it = shareResPatchInfo.largeModRes.iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                long currentTimeMillis3 = System.currentTimeMillis();
                                ShareResPatchInfo.LargeModeInfo largeModeInfo = shareResPatchInfo.largeModMap.get(next);
                                if (largeModeInfo == null) {
                                    ShareTinkerLog.w(TAG, "resource not found largeModeInfo, type:%s, name: %s", ShareTinkerInternals.getTypeString(i), next);
                                    with.getPatchReporter().onPatchPackageCheckFail(file3, BasePatchInternal.getMetaCorruptedCode(i));
                                    SharePatchFileUtil.closeZip(zipFile3);
                                    SharePatchFileUtil.closeZip(zipFile4);
                                    return false;
                                }
                                largeModeInfo.file = new File(file2, next);
                                SharePatchFileUtil.ensureFileDirectory(largeModeInfo.file);
                                if (SharePatchFileUtil.checkIfMd5Valid(largeModeInfo.md5)) {
                                    ZipEntry entry3 = zipFile4.getEntry(next);
                                    if (entry3 == null) {
                                        ShareTinkerLog.w(TAG, "large mod patch entry is null. path:" + next, new Object[0]);
                                        with.getPatchReporter().onPatchTypeExtractFail(file3, largeModeInfo.file, next, i);
                                    } else {
                                        ZipEntry entry4 = zipFile3.getEntry(next);
                                        if (entry4 == null) {
                                            ShareTinkerLog.w(TAG, "resources apk entry is null. path:" + next, new Object[0]);
                                            with.getPatchReporter().onPatchTypeExtractFail(file3, largeModeInfo.file, next, i);
                                        } else {
                                            try {
                                                inputStream = zipFile3.getInputStream(entry4);
                                                try {
                                                    inputStream2 = zipFile4.getInputStream(entry3);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    inputStream2 = null;
                                                    IOHelper.closeQuietly(inputStream);
                                                    IOHelper.closeQuietly(inputStream2);
                                                    throw th;
                                                }
                                                try {
                                                    BSPatch.patchFast(inputStream, inputStream2, largeModeInfo.file);
                                                    IOHelper.closeQuietly(inputStream);
                                                    IOHelper.closeQuietly(inputStream2);
                                                    if (SharePatchFileUtil.verifyFileMd5(largeModeInfo.file, largeModeInfo.md5)) {
                                                        ShareTinkerLog.w(TAG, "success recover large modify file:%s, file size:%d, use time:%d", largeModeInfo.file.getPath(), Long.valueOf(largeModeInfo.file.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                                    } else {
                                                        ShareTinkerLog.w(TAG, "Failed to recover large modify file:%s", largeModeInfo.file.getPath());
                                                        SharePatchFileUtil.safeDeleteFile(largeModeInfo.file);
                                                        with.getPatchReporter().onPatchTypeExtractFail(file3, largeModeInfo.file, next, i);
                                                    }
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    IOHelper.closeQuietly(inputStream);
                                                    IOHelper.closeQuietly(inputStream2);
                                                    throw th;
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                                inputStream = null;
                                            }
                                        }
                                    }
                                } else {
                                    ShareTinkerLog.w(TAG, "resource meta file md5 mismatch, type:%s, name: %s, md5: %s", ShareTinkerInternals.getTypeString(i), next, largeModeInfo.md5);
                                    with.getPatchReporter().onPatchPackageCheckFail(file3, BasePatchInternal.getMetaCorruptedCode(i));
                                }
                                SharePatchFileUtil.closeZip(zipFile3);
                                SharePatchFileUtil.closeZip(zipFile4);
                                return false;
                            }
                            ShareTinkerLog.w(TAG, "success recover all large modify and store resources use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            SharePatchFileUtil.closeZip(zipFile3);
                            SharePatchFileUtil.closeZip(zipFile4);
                            return true;
                        } catch (Throwable th5) {
                            th = th5;
                            zipFile = zipFile4;
                        }
                    }
                }
                zipFile2 = zipFile3;
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
        try {
            throw new TinkerRuntimeException("patch " + ShareTinkerInternals.getTypeString(i) + " extract failed (" + th.getMessage() + ").", th);
        } catch (Throwable th8) {
            SharePatchFileUtil.closeZip(zipFile2);
            SharePatchFileUtil.closeZip(zipFile);
            throw th8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x03ab, code lost:
        if (r0.hasNext() == false) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x03ae, code lost:
        r0 = r0.next();
        r0 = r9.getEntry(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x03c2, code lost:
        if (r0 != null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x03c5, code lost:
        com.tencent.tinker.loader.shareutil.ShareTinkerLog.w(com.tencent.tinker.lib.patch.ResDiffPatchInternal.TAG, "mod patch entry is null. path:" + r0, new java.lang.Object[0]);
        r0.getPatchReporter().onPatchTypeExtractFail(r11, r0, r0, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x03fe, code lost:
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r0);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r10);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r9);
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.deleteDir(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0410, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x041a, code lost:
        if (r0.storeRes.containsKey(r0) == false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x041d, code lost:
        com.tencent.tinker.ziputils.ziputil.TinkerZipUtil.extractLargeModifyFile(r0, r0.storeRes.get(r0), r0.getCrc(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0438, code lost:
        com.tencent.tinker.ziputils.ziputil.TinkerZipUtil.extractTinkerEntry(r9, r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0443, code lost:
        r0.setComment(r10.getComment());
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x044e, code lost:
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r0);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r10);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r9);
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.deleteDir(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0469, code lost:
        if (com.tencent.tinker.loader.shareutil.SharePatchFileUtil.checkResourceArscMd5(r0, r0.resArscMd5) != false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x046c, code lost:
        com.tencent.tinker.loader.shareutil.ShareTinkerLog.i(com.tencent.tinker.lib.patch.ResDiffPatchInternal.TAG, "check final new resource file fail path:%s, entry count:%d, size:%d", r0.getAbsolutePath(), java.lang.Integer.valueOf(r13), java.lang.Long.valueOf(r0.length()));
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.safeDeleteFile(r0);
        r0.getPatchReporter().onPatchTypeExtractFail(r11, r0, com.tencent.tinker.loader.shareutil.ShareConstants.RES_NAME, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x04ac, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x04ad, code lost:
        com.tencent.tinker.loader.shareutil.ShareTinkerLog.i(com.tencent.tinker.lib.patch.ResDiffPatchInternal.TAG, "final new resource file:%s, entry count:%d, size:%d", r0.getAbsolutePath(), java.lang.Integer.valueOf(r13), java.lang.Long.valueOf(r0.length()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x04d5, code lost:
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x04d6, code lost:
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r11);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r10);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r9);
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.deleteDir(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x04e9, code lost:
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0531, code lost:
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x053a, code lost:
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0543, code lost:
        r8 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0556, code lost:
        r11 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0200, code lost:
        r0 = r10.getEntry(com.tencent.tinker.loader.shareutil.ShareConstants.RES_MANIFEST);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0208, code lost:
        if (r0 != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x020b, code lost:
        com.tencent.tinker.loader.shareutil.ShareTinkerLog.w(com.tencent.tinker.lib.patch.ResDiffPatchInternal.TAG, "manifest patch entry is null. path:AndroidManifest.xml", new java.lang.Object[0]);
        r0.getPatchReporter().onPatchTypeExtractFail(r11, r0, com.tencent.tinker.loader.shareutil.ShareConstants.RES_MANIFEST, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x022c, code lost:
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r0);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r10);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r9);
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.deleteDir(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x023e, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x023f, code lost:
        com.tencent.tinker.ziputils.ziputil.TinkerZipUtil.extractTinkerEntry(r10, r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0248, code lost:
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x024c, code lost:
        r0 = r0.largeModRes.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x025f, code lost:
        if (r0.hasNext() == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0262, code lost:
        r0 = r0.next();
        r0 = r10.getEntry(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0277, code lost:
        if (r0 != null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x027a, code lost:
        com.tencent.tinker.loader.shareutil.ShareTinkerLog.w(com.tencent.tinker.lib.patch.ResDiffPatchInternal.TAG, "large patch entry is null. path:" + r0, new java.lang.Object[0]);
        r0.getPatchReporter().onPatchTypeExtractFail(r11, r0, r0, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x02b1, code lost:
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r0);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r10);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r9);
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.deleteDir(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x02c3, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x02c4, code lost:
        r0 = r0.largeModMap.get(r0);
        com.tencent.tinker.ziputils.ziputil.TinkerZipUtil.extractLargeModifyFile(r0, r0.file, r0.crc, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02e6, code lost:
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x02ed, code lost:
        r0 = r0.addRes.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x02fe, code lost:
        if (r0.hasNext() == false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0301, code lost:
        r0 = r0.next();
        r0 = r9.getEntry(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0315, code lost:
        if (r0 != null) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0318, code lost:
        com.tencent.tinker.loader.shareutil.ShareTinkerLog.w(com.tencent.tinker.lib.patch.ResDiffPatchInternal.TAG, "add patch entry is null. path:" + r0, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0348, code lost:
        r0.getPatchReporter().onPatchTypeExtractFail(r11, r0, r0, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0355, code lost:
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r0);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r10);
        com.tencent.tinker.commons.util.IOHelper.closeQuietly(r9);
        com.tencent.tinker.loader.shareutil.SharePatchFileUtil.deleteDir(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0367, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0371, code lost:
        if (r0.storeRes.containsKey(r0) == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0374, code lost:
        com.tencent.tinker.ziputils.ziputil.TinkerZipUtil.extractLargeModifyFile(r0, r0.storeRes.get(r0), r0.getCrc(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x038f, code lost:
        com.tencent.tinker.ziputils.ziputil.TinkerZipUtil.extractTinkerEntry(r9, r0, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x039a, code lost:
        r0 = r0.modRes.iterator();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean extractResourceDiffInternals(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.io.File r11, int r12) {
        /*
            Method dump skipped, instructions count: 1383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.lib.patch.ResDiffPatchInternal.extractResourceDiffInternals(android.content.Context, java.lang.String, java.lang.String, java.io.File, int):boolean");
    }

    private static boolean patchResourceExtractViaResourceDiff(Context context, String str, String str2, File file) {
        if (extractResourceDiffInternals(context, str + "/" + ShareConstants.RES_PATH + "/", str2, file, 6)) {
            return true;
        }
        ShareTinkerLog.w(TAG, "patch recover, extractDiffInternals fail", new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean tryRecoverResourceFiles(Tinker tinker, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        if (!tinker.isEnabledForResource()) {
            ShareTinkerLog.w(TAG, "patch recover, resource is not enabled", new Object[0]);
            return true;
        }
        String str2 = shareSecurityCheck.getMetaContentMap().get(ShareConstants.RES_META_FILE);
        if (str2 == null || str2.length() == 0) {
            ShareTinkerLog.w(TAG, "patch recover, resource is not contained", new Object[0]);
            return true;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean patchResourceExtractViaResourceDiff = patchResourceExtractViaResourceDiff(context, str, str2, file);
        ShareTinkerLog.i(TAG, "recover resource result:%b, cost:%d", Boolean.valueOf(patchResourceExtractViaResourceDiff), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        return patchResourceExtractViaResourceDiff;
    }
}
