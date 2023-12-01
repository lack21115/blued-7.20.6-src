package com.tencent.tinker.loader;

import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.ComponentHotplug;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/TinkerLoader.class */
public class TinkerLoader extends AbstractTinkerLoader {
    private static final String TAG = "Tinker.TinkerLoader";
    private SharePatchInfo patchInfo;

    private boolean checkSafeModeCount(TinkerApplication tinkerApplication) {
        int safeModeCount = ShareTinkerInternals.getSafeModeCount(tinkerApplication);
        if (safeModeCount >= 2) {
            ShareTinkerInternals.setSafeModeCount(tinkerApplication, 0);
            return false;
        }
        tinkerApplication.setUseSafeMode(true);
        ShareTinkerInternals.setSafeModeCount(tinkerApplication, safeModeCount + 1);
        return true;
    }

    private void tryLoadPatchFilesInternal(TinkerApplication tinkerApplication, Intent intent) {
        int tinkerFlags = tinkerApplication.getTinkerFlags();
        if (!ShareTinkerInternals.isTinkerEnabled(tinkerFlags)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles: tinker is disable, just return", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -1);
        } else if (ShareTinkerInternals.isInPatchProcess(tinkerApplication)) {
            ShareTinkerLog.w(TAG, "tryLoadPatchFiles: we don't load patch with :patch process itself, just return", new Object[0]);
            ShareIntentUtil.setIntentReturnCode(intent, -1);
        } else {
            File patchDirectory = SharePatchFileUtil.getPatchDirectory(tinkerApplication);
            if (patchDirectory == null) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:getPatchDirectory == null", new Object[0]);
                ShareIntentUtil.setIntentReturnCode(intent, -2);
                return;
            }
            String absolutePath = patchDirectory.getAbsolutePath();
            if (!patchDirectory.exists()) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:patch dir not exist:" + absolutePath, new Object[0]);
                ShareIntentUtil.setIntentReturnCode(intent, -2);
                return;
            }
            File patchInfoFile = SharePatchFileUtil.getPatchInfoFile(absolutePath);
            if (!patchInfoFile.exists()) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:patch info not exist:" + patchInfoFile.getAbsolutePath(), new Object[0]);
                ShareIntentUtil.setIntentReturnCode(intent, -3);
                return;
            }
            File patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(absolutePath);
            SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(patchInfoFile, patchInfoLockFile);
            this.patchInfo = readAndCheckPropertyWithLock;
            if (readAndCheckPropertyWithLock == null) {
                ShareIntentUtil.setIntentReturnCode(intent, -4);
                return;
            }
            boolean z = readAndCheckPropertyWithLock.isProtectedApp;
            intent.putExtra(ShareIntentUtil.INTENT_IS_PROTECTED_APP, z);
            String str = this.patchInfo.oldVersion;
            String str2 = this.patchInfo.newVersion;
            String str3 = this.patchInfo.oatDir;
            if (str == null || str2 == null || str3 == null) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchInfoCorrupted", new Object[0]);
                ShareIntentUtil.setIntentReturnCode(intent, -4);
                return;
            }
            boolean isInMainProcess = ShareTinkerInternals.isInMainProcess(tinkerApplication);
            boolean z2 = this.patchInfo.isRemoveNewVersion;
            if (isInMainProcess) {
                String patchVersionDirectory = SharePatchFileUtil.getPatchVersionDirectory(str2);
                String str4 = str;
                String str5 = str2;
                if (z2) {
                    ShareTinkerLog.w(TAG, "found clean patch mark and we are in main process, delete patch file now.", new Object[0]);
                    str4 = str;
                    str5 = str2;
                    if (patchVersionDirectory != null) {
                        boolean equals = str.equals(str2);
                        str4 = str;
                        if (equals) {
                            str4 = "";
                        }
                        this.patchInfo.oldVersion = str4;
                        this.patchInfo.newVersion = str4;
                        this.patchInfo.isRemoveNewVersion = false;
                        SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, this.patchInfo, patchInfoLockFile);
                        SharePatchFileUtil.deleteDir(absolutePath + BridgeUtil.SPLIT_MARK + patchVersionDirectory);
                        if (equals) {
                            ShareTinkerInternals.killProcessExceptMain(tinkerApplication);
                            ShareIntentUtil.setIntentReturnCode(intent, -2);
                            return;
                        }
                        str5 = str4;
                    }
                }
                str = str4;
                str2 = str5;
                if (this.patchInfo.isRemoveInterpretOATDir) {
                    ShareTinkerLog.i(TAG, "tryLoadPatchFiles: isRemoveInterpretOATDir is true, try to delete interpret optimize files", new Object[0]);
                    this.patchInfo.isRemoveInterpretOATDir = false;
                    SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, this.patchInfo, patchInfoLockFile);
                    ShareTinkerInternals.killProcessExceptMain(tinkerApplication);
                    SharePatchFileUtil.deleteDir((absolutePath + BridgeUtil.SPLIT_MARK + patchVersionDirectory) + BridgeUtil.SPLIT_MARK + ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH);
                    str = str4;
                    str2 = str5;
                }
            }
            intent.putExtra(ShareIntentUtil.INTENT_PATCH_OLD_VERSION, str);
            intent.putExtra(ShareIntentUtil.INTENT_PATCH_NEW_VERSION, str2);
            boolean z3 = !str.equals(str2);
            boolean equals2 = str3.equals(ShareConstants.CHANING_DEX_OPTIMIZE_PATH);
            String currentOatMode = ShareTinkerInternals.getCurrentOatMode(tinkerApplication, str3);
            intent.putExtra(ShareIntentUtil.INTENT_PATCH_OAT_DIR, currentOatMode);
            String str6 = str;
            if (z3) {
                str6 = str;
                if (isInMainProcess) {
                    str6 = str2;
                }
            }
            if (ShareTinkerInternals.isNullOrNil(str6)) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:version is blank, wait main process to restart", new Object[0]);
                ShareIntentUtil.setIntentReturnCode(intent, -5);
                return;
            }
            String patchVersionDirectory2 = SharePatchFileUtil.getPatchVersionDirectory(str6);
            if (patchVersionDirectory2 == null) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:patchName is null", new Object[0]);
                ShareIntentUtil.setIntentReturnCode(intent, -6);
                return;
            }
            String str7 = absolutePath + BridgeUtil.SPLIT_MARK + patchVersionDirectory2;
            File file = new File(str7);
            if (!file.exists()) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchVersionDirectoryNotFound", new Object[0]);
                ShareIntentUtil.setIntentReturnCode(intent, -6);
                return;
            }
            String patchVersionFile = SharePatchFileUtil.getPatchVersionFile(str6);
            File file2 = patchVersionFile != null ? new File(file.getAbsolutePath(), patchVersionFile) : null;
            if (!SharePatchFileUtil.isLegalFile(file2)) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchVersionFileNotFound", new Object[0]);
                ShareIntentUtil.setIntentReturnCode(intent, -7);
                return;
            }
            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(tinkerApplication);
            int checkTinkerPackage = ShareTinkerInternals.checkTinkerPackage(tinkerApplication, tinkerFlags, file2, shareSecurityCheck);
            if (checkTinkerPackage != 0) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:checkTinkerPackage", new Object[0]);
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, checkTinkerPackage);
                ShareIntentUtil.setIntentReturnCode(intent, -8);
                return;
            }
            intent.putExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_CONFIG, shareSecurityCheck.getPackagePropertiesIfPresent());
            boolean isTinkerEnabledForDex = ShareTinkerInternals.isTinkerEnabledForDex(tinkerFlags);
            boolean isArkHotRuning = ShareTinkerInternals.isArkHotRuning();
            if (!isArkHotRuning && isTinkerEnabledForDex && !TinkerDexLoader.checkComplete(str7, shareSecurityCheck, currentOatMode, intent)) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:dex check fail", new Object[0]);
                return;
            }
            boolean isTinkerEnabledForArkHot = ShareTinkerInternals.isTinkerEnabledForArkHot(tinkerFlags);
            if (isArkHotRuning && isTinkerEnabledForArkHot && !TinkerArkHotLoader.checkComplete(str7, shareSecurityCheck, intent)) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:dex check fail", new Object[0]);
            } else if (ShareTinkerInternals.isTinkerEnabledForNativeLib(tinkerFlags) && !TinkerSoLoader.checkComplete(str7, shareSecurityCheck, intent)) {
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:native lib check fail", new Object[0]);
            } else {
                boolean isTinkerEnabledForResource = ShareTinkerInternals.isTinkerEnabledForResource(tinkerFlags);
                ShareTinkerLog.w(TAG, "tryLoadPatchFiles:isEnabledForResource:" + isTinkerEnabledForResource, new Object[0]);
                if (isTinkerEnabledForResource && !TinkerResourceLoader.checkComplete(tinkerApplication, str7, shareSecurityCheck, intent)) {
                    ShareTinkerLog.w(TAG, "tryLoadPatchFiles:resource check fail", new Object[0]);
                    return;
                }
                boolean z4 = ShareTinkerInternals.isVmArt() && ShareTinkerInternals.isSystemOTA(this.patchInfo.fingerPrint) && Build.VERSION.SDK_INT >= 21 && !ShareTinkerInternals.isAfterAndroidO();
                intent.putExtra(ShareIntentUtil.INTENT_PATCH_SYSTEM_OTA, z4);
                if (isInMainProcess) {
                    if (z3) {
                        this.patchInfo.oldVersion = str6;
                    }
                    if (equals2) {
                        this.patchInfo.oatDir = currentOatMode;
                        this.patchInfo.isRemoveInterpretOATDir = true;
                    }
                }
                if (!checkSafeModeCount(tinkerApplication)) {
                    if (isInMainProcess) {
                        this.patchInfo.oldVersion = "";
                        this.patchInfo.newVersion = "";
                        this.patchInfo.isRemoveNewVersion = false;
                        SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, this.patchInfo, patchInfoLockFile);
                        ShareTinkerInternals.killProcessExceptMain(tinkerApplication);
                        SharePatchFileUtil.deleteDir(absolutePath + BridgeUtil.SPLIT_MARK + patchVersionDirectory2);
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_EXCEPTION, new TinkerRuntimeException("checkSafeModeCount fail"));
                        ShareIntentUtil.setIntentReturnCode(intent, -25);
                        ShareTinkerLog.w(TAG, "tryLoadPatchFiles:checkSafeModeCount fail, patch was deleted.", new Object[0]);
                        return;
                    }
                    ShareTinkerLog.w(TAG, "tryLoadPatchFiles:checkSafeModeCount fail, but we are not in main process, mark the patch to be deleted and continue load patch.", new Object[0]);
                    ShareTinkerInternals.cleanPatch(tinkerApplication);
                }
                if (!isArkHotRuning && isTinkerEnabledForDex) {
                    boolean loadTinkerJars = TinkerDexLoader.loadTinkerJars(tinkerApplication, str7, currentOatMode, intent, z4, z);
                    if (z4) {
                        this.patchInfo.fingerPrint = Build.FINGERPRINT;
                        this.patchInfo.oatDir = loadTinkerJars ? ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH : "odex";
                        if (!SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, this.patchInfo, patchInfoLockFile)) {
                            ShareIntentUtil.setIntentReturnCode(intent, -19);
                            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onReWritePatchInfoCorrupted", new Object[0]);
                            return;
                        }
                        intent.putExtra(ShareIntentUtil.INTENT_PATCH_OAT_DIR, this.patchInfo.oatDir);
                        equals2 = false;
                    }
                    if (!loadTinkerJars) {
                        ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchLoadDexesFail", new Object[0]);
                        return;
                    }
                }
                if (isArkHotRuning && isTinkerEnabledForArkHot && !TinkerArkHotLoader.loadTinkerArkHot(tinkerApplication, str7, intent)) {
                    ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchLoadArkApkFail", new Object[0]);
                } else if (isTinkerEnabledForResource && !TinkerResourceLoader.loadTinkerResources(tinkerApplication, str7, intent)) {
                    ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onPatchLoadResourcesFail", new Object[0]);
                } else {
                    if ((isTinkerEnabledForDex || isTinkerEnabledForArkHot) && isTinkerEnabledForResource) {
                        ComponentHotplug.install(tinkerApplication, shareSecurityCheck);
                    }
                    if (!AppInfoChangedBlocker.tryStart(tinkerApplication)) {
                        ShareTinkerLog.w(TAG, "tryLoadPatchFiles:AppInfoChangedBlocker install fail.", new Object[0]);
                        ShareIntentUtil.setIntentReturnCode(intent, -28);
                        return;
                    }
                    if (isInMainProcess && (z3 || equals2)) {
                        if (!SharePatchInfo.rewritePatchInfoFileWithLock(patchInfoFile, this.patchInfo, patchInfoLockFile)) {
                            ShareIntentUtil.setIntentReturnCode(intent, -19);
                            ShareTinkerLog.w(TAG, "tryLoadPatchFiles:onReWritePatchInfoCorrupted", new Object[0]);
                            return;
                        }
                        ShareTinkerInternals.killProcessExceptMain(tinkerApplication);
                    }
                    ShareIntentUtil.setIntentReturnCode(intent, 0);
                    ShareTinkerLog.i(TAG, "tryLoadPatchFiles: load end, ok!", new Object[0]);
                }
            }
        }
    }

    @Override // com.tencent.tinker.loader.AbstractTinkerLoader
    public Intent tryLoad(TinkerApplication tinkerApplication) {
        ShareTinkerLog.d(TAG, "tryLoad test test", new Object[0]);
        Intent intent = new Intent();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tryLoadPatchFilesInternal(tinkerApplication, intent);
        ShareIntentUtil.setIntentPatchCostTime(intent, SystemClock.elapsedRealtime() - elapsedRealtime);
        return intent;
    }
}
