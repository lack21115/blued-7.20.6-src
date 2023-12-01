package com.tencent.tinker.lib.patch;

import android.content.Context;
import android.os.Build;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/patch/UpgradePatch.class */
public class UpgradePatch extends AbstractPatch {
    private static final String TAG = "Tinker.UpgradePatch";

    @Override // com.tencent.tinker.lib.patch.AbstractPatch
    public boolean tryPatch(Context context, String str, PatchResult patchResult) {
        SharePatchInfo sharePatchInfo;
        Tinker with = Tinker.with(context);
        File file = new File(str);
        if (!with.isTinkerEnabled() || !ShareTinkerInternals.isTinkerEnableWithSharedPreferences(context)) {
            ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
            return false;
        } else if (!SharePatchFileUtil.isLegalFile(file)) {
            ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
            return false;
        } else {
            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
            int checkTinkerPackage = ShareTinkerInternals.checkTinkerPackage(context, with.getTinkerFlags(), file, shareSecurityCheck);
            if (checkTinkerPackage != 0) {
                ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
                with.getPatchReporter().onPatchPackageCheckFail(file, checkTinkerPackage);
                return false;
            }
            String md5 = SharePatchFileUtil.getMD5(file);
            if (md5 == null) {
                ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
                return false;
            }
            patchResult.patchVersion = md5;
            ShareTinkerLog.i(TAG, "UpgradePatch tryPatch:patchMd5:%s", md5);
            String absolutePath = with.getPatchDirectory().getAbsolutePath();
            File patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(absolutePath);
            File patchInfoFile = SharePatchFileUtil.getPatchInfoFile(absolutePath);
            HashMap<String, String> packagePropertiesIfPresent = shareSecurityCheck.getPackagePropertiesIfPresent();
            if (packagePropertiesIfPresent == null) {
                ShareTinkerLog.e(TAG, "UpgradePatch packageProperties is null, do we process a valid patch apk ?", new Object[0]);
                return false;
            }
            String str2 = packagePropertiesIfPresent.get("is_protected_app");
            boolean z = (str2 == null || str2.isEmpty() || "0".equals(str2)) ? false : true;
            SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(patchInfoFile, patchInfoLockFile);
            if (readAndCheckPropertyWithLock == null) {
                sharePatchInfo = new SharePatchInfo("", md5, z, false, Build.FINGERPRINT, "odex", false);
            } else if (readAndCheckPropertyWithLock.oldVersion == null || readAndCheckPropertyWithLock.newVersion == null || readAndCheckPropertyWithLock.oatDir == null) {
                ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
                with.getPatchReporter().onPatchInfoCorrupted(file, readAndCheckPropertyWithLock.oldVersion, readAndCheckPropertyWithLock.newVersion);
                return false;
            } else if (!SharePatchFileUtil.checkIfMd5Valid(md5)) {
                ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid", md5);
                with.getPatchReporter().onPatchVersionCheckFail(file, readAndCheckPropertyWithLock, md5);
                return false;
            } else {
                boolean equals = readAndCheckPropertyWithLock.oatDir.equals(ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH);
                if (!equals && !ShareTinkerInternals.isNullOrNil(readAndCheckPropertyWithLock.newVersion) && readAndCheckPropertyWithLock.newVersion.equals(md5) && !readAndCheckPropertyWithLock.isRemoveNewVersion) {
                    ShareTinkerLog.e(TAG, "patch already applied, md5: %s", md5);
                    UpgradePatchRetry.getInstance(context).onPatchResetMaxCheck(md5);
                    return true;
                }
                sharePatchInfo = new SharePatchInfo(readAndCheckPropertyWithLock.oldVersion, md5, z, false, Build.FINGERPRINT, equals ? ShareConstants.CHANING_DEX_OPTIMIZE_PATH : readAndCheckPropertyWithLock.oatDir, false);
            }
            String str3 = absolutePath + "/" + SharePatchFileUtil.getPatchVersionDirectory(md5);
            ShareTinkerLog.i(TAG, "UpgradePatch tryPatch:patchVersionDirectory:%s", str3);
            File file2 = new File(str3 + "/" + SharePatchFileUtil.getPatchVersionFile(md5));
            try {
                if (!md5.equals(SharePatchFileUtil.getMD5(file2))) {
                    SharePatchFileUtil.copyFileUsingStream(file, file2);
                    ShareTinkerLog.w(TAG, "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d", file.getAbsolutePath(), Long.valueOf(file.length()), file2.getAbsolutePath(), Long.valueOf(file2.length()));
                }
                if (!DexDiffPatchInternal.tryRecoverDexFiles(with, shareSecurityCheck, context, str3, file2, patchResult)) {
                    ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
                    return false;
                } else if (ArkHotDiffPatchInternal.tryRecoverArkHotLibrary(with, shareSecurityCheck, context, str3, file2)) {
                    if (!BsDiffPatchInternal.tryRecoverLibraryFiles(with, shareSecurityCheck, context, str3, file2)) {
                        ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
                        return false;
                    } else if (!ResDiffPatchInternal.tryRecoverResourceFiles(with, shareSecurityCheck, context, str3, file2)) {
                        ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
                        return false;
                    } else if (!DexDiffPatchInternal.waitAndCheckDexOptFile(file, with)) {
                        ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:new patch recover, check dex opt file failed", new Object[0]);
                        return false;
                    } else if (SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, sharePatchInfo, patchInfoLockFile)) {
                        UpgradePatchRetry.getInstance(context).onPatchResetMaxCheck(md5);
                        ShareTinkerLog.w(TAG, "UpgradePatch tryPatch: done, it is ok", new Object[0]);
                        return true;
                    } else {
                        ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
                        with.getPatchReporter().onPatchInfoCorrupted(file, sharePatchInfo.oldVersion, sharePatchInfo.newVersion);
                        return false;
                    }
                } else {
                    return false;
                }
            } catch (IOException e) {
                ShareTinkerLog.e(TAG, "UpgradePatch tryPatch:copy patch file fail from %s to %s", file.getPath(), file2.getPath());
                with.getPatchReporter().onPatchTypeExtractFail(file, file2, file.getName(), 1);
                return false;
            }
        }
    }
}
