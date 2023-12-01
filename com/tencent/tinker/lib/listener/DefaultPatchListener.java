package com.tencent.tinker.lib.listener;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.tinker.lib.service.TinkerPatchForeService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerLoadResult;
import com.tencent.tinker.lib.util.TinkerServiceInternals;
import com.tencent.tinker.lib.util.UpgradePatchRetry;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/listener/DefaultPatchListener.class */
public class DefaultPatchListener implements PatchListener {
    private ServiceConnection connection;
    protected final Context context;

    public DefaultPatchListener(Context context) {
        this.context = context;
    }

    private void runForgService() {
        try {
            this.connection = new ServiceConnection() { // from class: com.tencent.tinker.lib.listener.DefaultPatchListener.1
                public void onBindingDied(ComponentName componentName) {
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    if (DefaultPatchListener.this.context == null || DefaultPatchListener.this.connection == null) {
                        return;
                    }
                    try {
                        DefaultPatchListener.this.context.unbindService(DefaultPatchListener.this.connection);
                    } catch (Throwable th) {
                    }
                }
            };
            this.context.bindService(new Intent(this.context, TinkerPatchForeService.class), this.connection, 1);
        } catch (Throwable th) {
        }
    }

    @Override // com.tencent.tinker.lib.listener.PatchListener
    public int onPatchReceived(String str) {
        int patchCheck = patchCheck(str, SharePatchFileUtil.getMD5(new File(str)));
        if (patchCheck != 0) {
            Tinker.with(this.context).getLoadReporter().onLoadPatchListenerReceiveFail(new File(str), patchCheck);
            return patchCheck;
        }
        runForgService();
        TinkerPatchService.runPatchService(this.context, str);
        return patchCheck;
    }

    public int patchCheck(String str, String str2) {
        Tinker with = Tinker.with(this.context);
        if (with.isTinkerEnabled() && ShareTinkerInternals.isTinkerEnableWithSharedPreferences(this.context)) {
            if (!TextUtils.isEmpty(str2) && SharePatchFileUtil.isLegalFile(new File(str))) {
                if (with.isPatchProcess()) {
                    return -4;
                }
                if (TinkerServiceInternals.isTinkerPatchServiceRunning(this.context)) {
                    return -3;
                }
                if (ShareTinkerInternals.isVmJit()) {
                    return -5;
                }
                TinkerLoadResult tinkerLoadResultIfPresent = with.getTinkerLoadResultIfPresent();
                if (!(with.isMainProcess() && tinkerLoadResultIfPresent != null && tinkerLoadResultIfPresent.useInterpretMode)) {
                    if (with.isTinkerLoaded() && tinkerLoadResultIfPresent != null && str2.equals(tinkerLoadResultIfPresent.currentVersion)) {
                        return -6;
                    }
                    String absolutePath = with.getPatchDirectory().getAbsolutePath();
                    try {
                        SharePatchInfo readAndCheckPropertyWithLock = SharePatchInfo.readAndCheckPropertyWithLock(SharePatchFileUtil.getPatchInfoFile(absolutePath), SharePatchFileUtil.getPatchInfoLockFile(absolutePath));
                        if (readAndCheckPropertyWithLock != null && !ShareTinkerInternals.isNullOrNil(readAndCheckPropertyWithLock.newVersion) && !readAndCheckPropertyWithLock.isRemoveNewVersion) {
                            if (str2.equals(readAndCheckPropertyWithLock.newVersion)) {
                                return -6;
                            }
                        }
                    } catch (Throwable th) {
                    }
                }
                return !UpgradePatchRetry.getInstance(this.context).onPatchListenerCheck(str2) ? -7 : 0;
            }
            return -2;
        }
        return -1;
    }
}
