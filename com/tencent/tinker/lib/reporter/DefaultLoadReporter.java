package com.tencent.tinker.lib.reporter;

import android.content.Context;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.lib.tinker.TinkerLoadResult;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/reporter/DefaultLoadReporter.class */
public class DefaultLoadReporter implements LoadReporter {
    private static final String TAG = "Tinker.DefaultLoadReporter";
    public final Context context;

    public DefaultLoadReporter(Context context) {
        this.context = context;
    }

    public void checkAndCleanPatch() {
        SharePatchInfo sharePatchInfo;
        Tinker with = Tinker.with(this.context);
        if (with.isMainProcess()) {
            TinkerLoadResult tinkerLoadResultIfPresent = with.getTinkerLoadResultIfPresent();
            if (tinkerLoadResultIfPresent.versionChanged && (sharePatchInfo = tinkerLoadResultIfPresent.patchInfo) != null && !ShareTinkerInternals.isNullOrNil(sharePatchInfo.oldVersion)) {
                ShareTinkerLog.w(TAG, "checkAndCleanPatch, oldVersion %s is not null, try kill all other process", sharePatchInfo.oldVersion);
                ShareTinkerInternals.killAllOtherProcess(this.context);
            }
        }
        with.cleanPatch();
    }

    @Override // com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadException(Throwable th, int i) {
        if (i == -4) {
            ShareTinkerLog.i(TAG, "patch loadReporter onLoadException: patch load unCatch exception: %s", th);
            ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
            ShareTinkerLog.i(TAG, "unCaught exception disable tinker forever with sp", new Object[0]);
            String checkTinkerLastUncaughtCrash = SharePatchFileUtil.checkTinkerLastUncaughtCrash(this.context);
            if (!ShareTinkerInternals.isNullOrNil(checkTinkerLastUncaughtCrash)) {
                SharePatchFileUtil.safeDeleteFile(SharePatchFileUtil.getPatchLastCrashFile(this.context));
                ShareTinkerLog.e(TAG, "tinker uncaught real exception:" + checkTinkerLastUncaughtCrash, new Object[0]);
            }
        } else if (i == -3) {
            if (th.getMessage().contains(ShareConstants.CHECK_RES_INSTALL_FAIL)) {
                ShareTinkerLog.e(TAG, "patch loadReporter onLoadException: tinker res check fail:" + th.getMessage(), new Object[0]);
            } else {
                ShareTinkerLog.i(TAG, "patch loadReporter onLoadException: patch load resource exception: %s", th);
            }
            ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
            ShareTinkerLog.i(TAG, "res exception disable tinker forever with sp", new Object[0]);
        } else if (i == -2) {
            if (th.getMessage().contains(ShareConstants.CHECK_DEX_INSTALL_FAIL)) {
                ShareTinkerLog.e(TAG, "patch loadReporter onLoadException: tinker dex check fail:" + th.getMessage(), new Object[0]);
            } else {
                ShareTinkerLog.i(TAG, "patch loadReporter onLoadException: patch load dex exception: %s", th);
            }
            ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
            ShareTinkerLog.i(TAG, "dex exception disable tinker forever with sp", new Object[0]);
        } else if (i == -1) {
            ShareTinkerLog.i(TAG, "patch loadReporter onLoadException: patch load unknown exception: %s", th);
        }
        ShareTinkerLog.e(TAG, "tinker load exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        ShareTinkerLog.printErrStackTrace(TAG, th, "tinker load exception", new Object[0]);
        Tinker.with(this.context).setTinkerDisable();
        checkAndCleanPatch();
    }

    @Override // com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadFileMd5Mismatch(File file, int i) {
        ShareTinkerLog.i(TAG, "patch load Reporter onLoadFileMd5Mismatch: patch file md5 mismatch file: %s, fileType: %d", file.getAbsolutePath(), Integer.valueOf(i));
        checkAndCleanPatch();
    }

    @Override // com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadFileNotFound(File file, int i, boolean z) {
        ShareTinkerLog.i(TAG, "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType: %d, isDirectory: %b", file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z));
        if (i == 4) {
            retryPatch();
        } else {
            checkAndCleanPatch();
        }
    }

    @Override // com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadInterpret(int i, Throwable th) {
        ShareTinkerLog.i(TAG, "patch loadReporter onLoadInterpret: type: %d, throwable: %s", Integer.valueOf(i), th);
        if (i == 0) {
            ShareTinkerLog.i(TAG, "patch loadReporter onLoadInterpret ok", new Object[0]);
        } else if (i == 1) {
            ShareTinkerLog.e(TAG, "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
        } else if (i == 2) {
            ShareTinkerLog.e(TAG, "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
        }
        retryPatch();
    }

    @Override // com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadPackageCheckFail(File file, int i) {
        ShareTinkerLog.i(TAG, "patch loadReporter onLoadPackageCheckFail: load patch package check fail file path: %s, errorCode: %d", file.getAbsolutePath(), Integer.valueOf(i));
        checkAndCleanPatch();
    }

    @Override // com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadPatchInfoCorrupted(String str, String str2, File file) {
        ShareTinkerLog.i(TAG, "patch loadReporter onLoadPatchInfoCorrupted: patch info file damage: %s, from version: %s to version: %s", file.getAbsolutePath(), str, str2);
        checkAndCleanPatch();
    }

    @Override // com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadPatchListenerReceiveFail(File file, int i) {
        ShareTinkerLog.i(TAG, "patch loadReporter onLoadPatchListenerReceiveFail: patch receive fail: %s, code: %d", file.getAbsolutePath(), Integer.valueOf(i));
    }

    @Override // com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadPatchVersionChanged(String str, String str2, File file, String str3) {
        ShareTinkerLog.i(TAG, "patch loadReporter onLoadPatchVersionChanged: patch version change from " + str + " to " + str2, new Object[0]);
        if (str == null || str2 == null || str.equals(str2) || !Tinker.with(this.context).isMainProcess()) {
            return;
        }
        UpgradePatchRetry.getInstance(this.context).onPatchResetMaxCheck(str2);
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (file2.isDirectory() && !name.equals(str3)) {
                    SharePatchFileUtil.deleteDir(file2);
                }
            }
        }
    }

    @Override // com.tencent.tinker.lib.reporter.LoadReporter
    public void onLoadResult(File file, int i, long j) {
        ShareTinkerLog.i(TAG, "patch loadReporter onLoadResult: patch load result, path:%s, code: %d, cost: %dms", file.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(j));
    }

    public boolean retryPatch() {
        File file;
        Tinker with = Tinker.with(this.context);
        if (with.isMainProcess() && (file = with.getTinkerLoadResultIfPresent().patchVersionFile) != null && UpgradePatchRetry.getInstance(this.context).onPatchListenerCheck(SharePatchFileUtil.getMD5(file))) {
            ShareTinkerLog.i(TAG, "try to repair oat file on patch process", new Object[0]);
            TinkerInstaller.onReceiveUpgradePatch(this.context, file.getAbsolutePath());
            return true;
        }
        return false;
    }
}
