package com.soft.blued.tinker.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.soft.blued.tinker.util.Utils;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.TinkerServiceInternals;
import java.io.File;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/tinker/service/PatchLoadResultService.class */
public class PatchLoadResultService extends DefaultTinkerResultService {
    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        TinkerLog.i("Tinker.PatchLoadResultService", "app is background now, i can kill quietly", new Object[0]);
        Process.killProcess(Process.myPid());
    }

    @Override // com.tencent.tinker.lib.service.DefaultTinkerResultService, com.tencent.tinker.lib.service.AbstractResultService
    public void onPatchResult(final PatchResult patchResult) {
        if (patchResult == null) {
            TinkerLog.e("Tinker.PatchLoadResultService", "PatchLoadResultService received null result!!!!", new Object[0]);
            return;
        }
        TinkerLog.i("Tinker.PatchLoadResultService", "PatchLoadResultService receive result: %s", patchResult.toString());
        TinkerServiceInternals.killTinkerPatchServiceProcess(getApplicationContext());
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.soft.blued.tinker.service.PatchLoadResultService.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (patchResult.isSuccess) {
            deleteRawPatchFile(new File(patchResult.rawPatchFilePath));
            if (!checkIfNeedKill(patchResult)) {
                TinkerLog.i("Tinker.PatchLoadResultService", "I have already install the newly patch version!", new Object[0]);
            } else if (Utils.b()) {
                TinkerLog.i("Tinker.PatchLoadResultService", "it is in background, just restart process", new Object[0]);
                a();
            } else {
                TinkerLog.i("Tinker.PatchLoadResultService", "tinker wait screen to restart process", new Object[0]);
                new Utils.ScreenState(getApplicationContext(), new Utils.ScreenState.IOnScreenOff() { // from class: com.soft.blued.tinker.service.PatchLoadResultService.2
                    @Override // com.soft.blued.tinker.util.Utils.ScreenState.IOnScreenOff
                    public void a() {
                        PatchLoadResultService.this.a();
                    }
                });
            }
        }
    }
}
