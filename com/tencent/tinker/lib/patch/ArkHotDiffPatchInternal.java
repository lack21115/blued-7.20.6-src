package com.tencent.tinker.lib.patch;

import android.content.Context;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareArkHotDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.ZipFile;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/patch/ArkHotDiffPatchInternal.class */
public class ArkHotDiffPatchInternal extends BasePatchInternal {
    private static final String TAG = "Tinker.ArkHotDiffPatchInternal";
    private static ArrayList<ShareArkHotDiffPatchInfo> arkPatchList = new ArrayList<>();

    private static boolean extractArkHotLibrary(Context context, String str, File file, int i) {
        ZipFile zipFile;
        String str2;
        Tinker with = Tinker.with(context);
        ZipFile zipFile2 = null;
        try {
            try {
                ZipFile zipFile3 = new ZipFile(file);
                try {
                    Iterator<ShareArkHotDiffPatchInfo> it = arkPatchList.iterator();
                    while (it.hasNext()) {
                        ShareArkHotDiffPatchInfo next = it.next();
                        String str3 = next.path;
                        if (str3.equals("")) {
                            str2 = next.name;
                        } else {
                            str2 = str3 + "/" + next.name;
                        }
                        String str4 = next.patchMd5;
                        if (!SharePatchFileUtil.checkIfMd5Valid(str4)) {
                            with.getPatchReporter().onPatchPackageCheckFail(file, BasePatchInternal.getMetaCorruptedCode(i));
                            SharePatchFileUtil.closeZip(zipFile3);
                            return false;
                        }
                        File file2 = new File(str + next.name);
                        if (!file2.exists()) {
                            file2.getParentFile().mkdirs();
                        } else if (!str4.equals(SharePatchFileUtil.getMD5(file2))) {
                            file2.delete();
                        }
                        if (!extract(zipFile3, zipFile3.getEntry(str2), file2, str4, false)) {
                            with.getPatchReporter().onPatchTypeExtractFail(file, file2, next.name, i);
                            SharePatchFileUtil.closeZip(zipFile3);
                            return false;
                        }
                    }
                    SharePatchFileUtil.closeZip(zipFile3);
                    return true;
                } catch (IOException e) {
                    e = e;
                    zipFile = zipFile3;
                    StringBuilder sb = new StringBuilder();
                    ZipFile zipFile4 = zipFile;
                    sb.append("patch ");
                    ZipFile zipFile5 = zipFile;
                    sb.append(ShareTinkerInternals.getTypeString(i));
                    ZipFile zipFile6 = zipFile;
                    sb.append(" extract failed (");
                    ZipFile zipFile7 = zipFile;
                    sb.append(e.getMessage());
                    ZipFile zipFile8 = zipFile;
                    sb.append(").");
                    zipFile2 = zipFile;
                    throw new TinkerRuntimeException(sb.toString(), e);
                } catch (Throwable th) {
                    th = th;
                    zipFile2 = zipFile3;
                    SharePatchFileUtil.closeZip(zipFile2);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
            zipFile = null;
        }
    }

    private static boolean patchArkHotLibraryExtract(Context context, String str, String str2, File file) {
        String str3 = str + "/" + ShareConstants.ARKHOTFIX_PATH + "/";
        arkPatchList.clear();
        ShareArkHotDiffPatchInfo.parseDiffPatchInfo(str2, arkPatchList);
        return extractArkHotLibrary(context, str3, file, 8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean tryRecoverArkHotLibrary(Tinker tinker, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        String str2 = shareSecurityCheck.getMetaContentMap().get(ShareConstants.ARKHOT_META_FILE);
        if (str2 == null) {
            return true;
        }
        patchArkHotLibraryExtract(context, str, str2, file);
        return true;
    }
}
