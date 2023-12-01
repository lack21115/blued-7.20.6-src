package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/DefaultDownloadServiceHandler.class */
public class DefaultDownloadServiceHandler extends AbsDownloadServiceHandler {
    private static final String TAG = DefaultDownloadServiceHandler.class.getSimpleName();

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommand(Intent intent, int i, int i2) {
        if (Logger.debug()) {
            Logger.d(TAG, "onStartCommand");
        }
        if (!DownloadExpSwitchCode.isSwitchEnable(262144)) {
            this.isServiceAlive = true;
        }
        resumePendingTask();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler, com.ss.android.socialbase.downloader.downloader.IDownloadServiceHandler
    public void onStartCommandOnMainThread() {
        if (DownloadExpSwitchCode.isSwitchEnable(262144)) {
            this.isServiceAlive = true;
            this.isInvokeStartService = false;
            if (Logger.debug()) {
                Logger.d(TAG, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.AbsDownloadServiceHandler
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, DownloadService.class));
        this.isServiceAlive = false;
    }
}
