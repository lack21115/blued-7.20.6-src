package com.tencent.tinker.lib.reporter;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/reporter/DefaultPatchReporter.class */
public class DefaultPatchReporter implements PatchReporter {
    private static final String TAG = "Tinker.DefaultPatchReporter";
    private static boolean shouldRetry = false;
    protected final Context context;

    public DefaultPatchReporter(Context context) {
        this.context = context;
    }

    private void deleteOptFiles(List<File> list) {
        for (File file : list) {
            SharePatchFileUtil.safeDeleteFile(file);
        }
    }

    @Override // com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchDexOptFail(File file, List<File> list, Throwable th) {
        ShareTinkerLog.i(TAG, "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", file.getAbsolutePath(), Integer.valueOf(list.size()));
        ShareTinkerLog.printErrStackTrace(TAG, th, "onPatchDexOptFail:", new Object[0]);
        if (!th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_EXIST_FAIL) && !th.getMessage().contains(ShareConstants.CHECK_DEX_OAT_FORMAT_FAIL)) {
            Tinker.with(this.context).cleanPatchByPatchApk(file);
            return;
        }
        shouldRetry = true;
        deleteOptFiles(list);
    }

    @Override // com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchException(File file, Throwable th) {
        ShareTinkerLog.i(TAG, "patchReporter onPatchException: patch exception path: %s, throwable: %s", file.getAbsolutePath(), th.getMessage());
        ShareTinkerLog.e(TAG, "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        ShareTinkerLog.printErrStackTrace(TAG, th, "tinker patch exception", new Object[0]);
        Tinker.with(this.context).setTinkerDisable();
        Tinker.with(this.context).cleanPatchByPatchApk(file);
    }

    @Override // com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchInfoCorrupted(File file, String str, String str2) {
        ShareTinkerLog.i(TAG, "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", str, str2);
        Tinker.with(this.context).cleanPatch();
    }

    @Override // com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchPackageCheckFail(File file, int i) {
        ShareTinkerLog.i(TAG, "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", file.getAbsolutePath(), Integer.valueOf(i));
        if (i == -3 || i == -4 || i == -8) {
            Tinker.with(this.context).cleanPatchByPatchApk(file);
        }
    }

    @Override // com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchResult(File file, boolean z, long j) {
        ShareTinkerLog.i(TAG, "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", file.getAbsolutePath(), Boolean.valueOf(z), Long.valueOf(j));
        if (shouldRetry) {
            return;
        }
        UpgradePatchRetry.getInstance(this.context).onPatchServiceResult();
    }

    @Override // com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchServiceStart(Intent intent) {
        ShareTinkerLog.i(TAG, "patchReporter onPatchServiceStart: patch service start", new Object[0]);
        shouldRetry = false;
        UpgradePatchRetry.getInstance(this.context).onPatchServiceStart(intent);
    }

    @Override // com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchTypeExtractFail(File file, File file2, String str, int i) {
        ShareTinkerLog.i(TAG, "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", ShareTinkerInternals.getTypeString(i), file.getPath(), file2.getPath(), str);
        Tinker.with(this.context).cleanPatchByPatchApk(file);
    }

    @Override // com.tencent.tinker.lib.reporter.PatchReporter
    public void onPatchVersionCheckFail(File file, SharePatchInfo sharePatchInfo, String str) {
        ShareTinkerLog.i(TAG, "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", file.getAbsolutePath(), str);
    }
}
