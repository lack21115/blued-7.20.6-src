package com.tencent.tinker.lib.tinker;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/tinker/TinkerLoadResult.class */
public class TinkerLoadResult {
    private static final String TAG = "Tinker.TinkerLoadResult";
    public long costTime;
    public String currentVersion;
    public File dexDirectory;
    public HashMap<String, String> dexes;
    public File libraryDirectory;
    public HashMap<String, String> libs;
    public int loadCode;
    public String oatDir;
    public HashMap<String, String> packageConfig;
    public SharePatchInfo patchInfo;
    public File patchVersionDirectory;
    public File patchVersionFile;
    public File resourceDirectory;
    public File resourceFile;
    public boolean systemOTA;
    public boolean useInterpretMode;
    public boolean versionChanged;

    public String getPackageConfigByName(String str) {
        HashMap<String, String> hashMap = this.packageConfig;
        if (hashMap != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public boolean parseTinkerResult(Context context, Intent intent) {
        int i;
        Tinker with = Tinker.with(context);
        this.loadCode = ShareIntentUtil.getIntentReturnCode(intent);
        this.costTime = ShareIntentUtil.getIntentPatchCostTime(intent);
        this.systemOTA = ShareIntentUtil.getBooleanExtra(intent, ShareIntentUtil.INTENT_PATCH_SYSTEM_OTA, false);
        String stringExtra = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_PATCH_OAT_DIR);
        this.oatDir = stringExtra;
        this.useInterpretMode = ShareConstants.INTERPRET_DEX_OPTIMIZE_PATH.equals(stringExtra);
        boolean isMainProcess = with.isMainProcess();
        ShareTinkerLog.i(TAG, "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", Integer.valueOf(this.loadCode), ShareTinkerInternals.getProcessName(context), Boolean.valueOf(isMainProcess), Boolean.valueOf(this.systemOTA), Build.FINGERPRINT, this.oatDir, Boolean.valueOf(this.useInterpretMode));
        String stringExtra2 = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_PATCH_OLD_VERSION);
        String stringExtra3 = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_PATCH_NEW_VERSION);
        File patchDirectory = with.getPatchDirectory();
        File patchInfoFile = with.getPatchInfoFile();
        if (stringExtra2 != null && stringExtra3 != null) {
            if (isMainProcess) {
                this.currentVersion = stringExtra3;
            } else {
                this.currentVersion = stringExtra2;
            }
            ShareTinkerLog.i(TAG, "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", stringExtra2, stringExtra3, this.currentVersion);
            String patchVersionDirectory = SharePatchFileUtil.getPatchVersionDirectory(this.currentVersion);
            if (!ShareTinkerInternals.isNullOrNil(patchVersionDirectory)) {
                this.patchVersionDirectory = new File(patchDirectory.getAbsolutePath() + BridgeUtil.SPLIT_MARK + patchVersionDirectory);
                this.patchVersionFile = new File(this.patchVersionDirectory.getAbsolutePath(), SharePatchFileUtil.getPatchVersionFile(this.currentVersion));
                this.dexDirectory = new File(this.patchVersionDirectory, ShareConstants.DEX_PATH);
                this.libraryDirectory = new File(this.patchVersionDirectory, "lib");
                this.resourceDirectory = new File(this.patchVersionDirectory, ShareConstants.RES_PATH);
                this.resourceFile = new File(this.resourceDirectory, ShareConstants.RES_NAME);
            }
            this.patchInfo = new SharePatchInfo(stringExtra2, stringExtra3, ShareIntentUtil.getBooleanExtra(intent, ShareIntentUtil.INTENT_IS_PROTECTED_APP, false), false, Build.FINGERPRINT, this.oatDir, false);
            this.versionChanged = !stringExtra2.equals(stringExtra3);
        }
        Throwable intentPatchException = ShareIntentUtil.getIntentPatchException(intent);
        if (intentPatchException != null) {
            ShareTinkerLog.i(TAG, "Tinker load have exception loadCode:%d", Integer.valueOf(this.loadCode));
            int i2 = this.loadCode;
            if (i2 == -25) {
                i = -4;
            } else if (i2 != -23) {
                i = -1;
                if (i2 != -20) {
                    i = i2 != -14 ? -1 : -2;
                }
            } else {
                i = -3;
            }
            with.getLoadReporter().onLoadException(intentPatchException, i);
            return false;
        }
        int i3 = this.loadCode;
        if (i3 == -10000) {
            ShareTinkerLog.e(TAG, "can't get the right intent return code", new Object[0]);
            throw new TinkerRuntimeException("can't get the right intent return code");
        } else if (i3 == -24) {
            File file = this.resourceFile;
            if (file == null) {
                ShareTinkerLog.e(TAG, "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
                throw new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
            }
            ShareTinkerLog.e(TAG, "patch resource file md5 is mismatch: %s", file.getAbsolutePath());
            with.getLoadReporter().onLoadFileMd5Mismatch(this.resourceFile, 6);
            return false;
        } else if (i3 == -22) {
            if (this.patchVersionDirectory == null) {
                ShareTinkerLog.e(TAG, "patch resource file not found, warning why the path is null!!!!", new Object[0]);
                throw new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
            }
            ShareTinkerLog.e(TAG, "patch resource file not found:%s", this.resourceFile.getAbsolutePath());
            with.getLoadReporter().onLoadFileNotFound(this.resourceFile, 6, false);
            return false;
        } else if (i3 == -21) {
            if (this.patchVersionDirectory == null) {
                ShareTinkerLog.e(TAG, "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
                throw new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
            }
            ShareTinkerLog.e(TAG, "patch resource file directory not found:%s", this.resourceDirectory.getAbsolutePath());
            with.getLoadReporter().onLoadFileNotFound(this.resourceDirectory, 6, true);
            return false;
        } else {
            switch (i3) {
                case -19:
                    ShareTinkerLog.i(TAG, "rewrite patch info file corrupted", new Object[0]);
                    with.getLoadReporter().onLoadPatchInfoCorrupted(stringExtra2, stringExtra3, patchInfoFile);
                    return false;
                case -18:
                    String stringExtra4 = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_PATCH_MISSING_LIB_PATH);
                    if (stringExtra4 == null) {
                        ShareTinkerLog.e(TAG, "patch lib file not found, but path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
                    }
                    ShareTinkerLog.e(TAG, "patch lib file not found:%s", stringExtra4);
                    with.getLoadReporter().onLoadFileNotFound(new File(stringExtra4), 5, false);
                    return false;
                case -17:
                    if (this.patchVersionDirectory == null) {
                        ShareTinkerLog.e(TAG, "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
                        throw new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
                    }
                    ShareTinkerLog.e(TAG, "patch lib file directory not found:%s", this.libraryDirectory.getAbsolutePath());
                    with.getLoadReporter().onLoadFileNotFound(this.libraryDirectory, 5, true);
                    return false;
                case -16:
                    with.getLoadReporter().onLoadInterpret(2, ShareIntentUtil.getIntentInterpretException(intent));
                    return false;
                case -15:
                    with.getLoadReporter().onLoadInterpret(1, ShareIntentUtil.getIntentInterpretException(intent));
                    return false;
                default:
                    switch (i3) {
                        case -13:
                            String stringExtra5 = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_PATCH_MISMATCH_DEX_PATH);
                            if (stringExtra5 == null) {
                                ShareTinkerLog.e(TAG, "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
                                throw new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
                            }
                            ShareTinkerLog.e(TAG, "patch dex file md5 is mismatch: %s", stringExtra5);
                            with.getLoadReporter().onLoadFileMd5Mismatch(new File(stringExtra5), 3);
                            return false;
                        case -12:
                            ShareTinkerLog.e(TAG, "patch dex load fail, classloader is null", new Object[0]);
                            return false;
                        case -11:
                            String stringExtra6 = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_PATCH_MISSING_DEX_PATH);
                            if (stringExtra6 == null) {
                                ShareTinkerLog.e(TAG, "patch dex opt file not found, but path is null!!!!", new Object[0]);
                                throw new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
                            }
                            ShareTinkerLog.e(TAG, "patch dex opt file not found:%s", stringExtra6);
                            with.getLoadReporter().onLoadFileNotFound(new File(stringExtra6), 4, false);
                            return false;
                        case -10:
                            String stringExtra7 = ShareIntentUtil.getStringExtra(intent, ShareIntentUtil.INTENT_PATCH_MISSING_DEX_PATH);
                            if (stringExtra7 == null) {
                                ShareTinkerLog.e(TAG, "patch dex file not found, but path is null!!!!", new Object[0]);
                                throw new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
                            }
                            ShareTinkerLog.e(TAG, "patch dex file not found:%s", stringExtra7);
                            with.getLoadReporter().onLoadFileNotFound(new File(stringExtra7), 3, false);
                            return false;
                        case -9:
                            File file2 = this.dexDirectory;
                            if (file2 == null) {
                                ShareTinkerLog.e(TAG, "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
                                throw new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
                            }
                            ShareTinkerLog.e(TAG, "patch dex file directory not found:%s", file2.getAbsolutePath());
                            with.getLoadReporter().onLoadFileNotFound(this.dexDirectory, 3, true);
                            return false;
                        case -8:
                            ShareTinkerLog.i(TAG, "patch package check fail", new Object[0]);
                            if (this.patchVersionFile != null) {
                                with.getLoadReporter().onLoadPackageCheckFail(this.patchVersionFile, intent.getIntExtra(ShareIntentUtil.INTENT_PATCH_PACKAGE_PATCH_CHECK, -10000));
                                return false;
                            }
                            throw new TinkerRuntimeException("error patch package check fail , but file is null");
                        case -7:
                            ShareTinkerLog.e(TAG, "patch version file not found, current version:%s", this.currentVersion);
                            if (this.patchVersionFile != null) {
                                with.getLoadReporter().onLoadFileNotFound(this.patchVersionFile, 1, false);
                                return false;
                            }
                            throw new TinkerRuntimeException("error load patch version file not exist, but file is null");
                        case -6:
                            ShareTinkerLog.e(TAG, "patch version directory not found, current version:%s", this.currentVersion);
                            with.getLoadReporter().onLoadFileNotFound(this.patchVersionDirectory, 1, true);
                            return false;
                        case -5:
                            ShareTinkerLog.e(TAG, "path info blank, wait main process to restart", new Object[0]);
                            return false;
                        case -4:
                            ShareTinkerLog.e(TAG, "path info corrupted", new Object[0]);
                            with.getLoadReporter().onLoadPatchInfoCorrupted(stringExtra2, stringExtra3, patchInfoFile);
                            return false;
                        case -3:
                        case -2:
                            ShareTinkerLog.w(TAG, "can't find patch file, is ok, just return", new Object[0]);
                            return false;
                        case -1:
                            ShareTinkerLog.w(TAG, "tinker is disable, just return", new Object[0]);
                            return false;
                        case 0:
                            ShareTinkerLog.i(TAG, "oh yeah, tinker load all success", new Object[0]);
                            with.setTinkerLoaded(true);
                            this.dexes = ShareIntentUtil.getIntentPatchDexPaths(intent);
                            this.libs = ShareIntentUtil.getIntentPatchLibsPaths(intent);
                            this.packageConfig = ShareIntentUtil.getIntentPackageConfig(intent);
                            if (this.useInterpretMode) {
                                with.getLoadReporter().onLoadInterpret(0, null);
                            }
                            if (isMainProcess && this.versionChanged) {
                                with.getLoadReporter().onLoadPatchVersionChanged(stringExtra2, stringExtra3, patchDirectory, this.patchVersionDirectory.getName());
                                return true;
                            }
                            return true;
                        default:
                            return false;
                    }
            }
        }
    }
}
