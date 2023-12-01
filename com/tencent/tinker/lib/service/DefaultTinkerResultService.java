package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerLoadResult;
import com.tencent.tinker.lib.util.TinkerServiceInternals;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/service/DefaultTinkerResultService.class */
public class DefaultTinkerResultService extends AbstractResultService {
    private static final String TAG = "Tinker.DefaultTinkerResultService";

    public boolean checkIfNeedKill(PatchResult patchResult) {
        TinkerLoadResult tinkerLoadResultIfPresent;
        Tinker with = Tinker.with(getApplicationContext());
        if (!with.isTinkerLoaded() || (tinkerLoadResultIfPresent = with.getTinkerLoadResultIfPresent()) == null) {
            return true;
        }
        return patchResult.patchVersion == null || !patchResult.patchVersion.equals(tinkerLoadResultIfPresent.currentVersion);
    }

    public void deleteRawPatchFile(File file) {
        if (SharePatchFileUtil.isLegalFile(file)) {
            ShareTinkerLog.w(TAG, "deleteRawPatchFile rawFile path: %s", file.getPath());
            String name = file.getName();
            if (!name.startsWith(ShareConstants.PATCH_BASE_NAME) || !name.endsWith(".apk")) {
                SharePatchFileUtil.safeDeleteFile(file);
                return;
            }
            File parentFile = file.getParentFile();
            if (!parentFile.getName().startsWith(ShareConstants.PATCH_BASE_NAME)) {
                SharePatchFileUtil.safeDeleteFile(file);
                return;
            }
            File parentFile2 = parentFile.getParentFile();
            if (parentFile2.getName().equals(ShareConstants.PATCH_DIRECTORY_NAME) || parentFile2.getName().equals(ShareConstants.PATCH_DIRECTORY_NAME_SPEC)) {
                return;
            }
            SharePatchFileUtil.safeDeleteFile(file);
        }
    }

    @Override // com.tencent.tinker.lib.service.AbstractResultService
    public void onPatchResult(PatchResult patchResult) {
        if (patchResult == null) {
            ShareTinkerLog.e(TAG, "DefaultTinkerResultService received null result!!!!", new Object[0]);
            return;
        }
        ShareTinkerLog.i(TAG, "DefaultTinkerResultService received a result:%s ", patchResult.toString());
        TinkerServiceInternals.killTinkerPatchServiceProcess(getApplicationContext());
        if (patchResult.isSuccess) {
            deleteRawPatchFile(new File(patchResult.rawPatchFilePath));
            if (checkIfNeedKill(patchResult)) {
                Process.killProcess(Process.myPid());
            } else {
                ShareTinkerLog.i(TAG, "I have already install the newly patch version!", new Object[0]);
            }
        }
    }
}
