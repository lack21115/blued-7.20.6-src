package com.ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/impls/DownloadHandleService.class */
public class DownloadHandleService extends Service {
    private static final String TAG = DownloadHandleService.class.getSimpleName();

    private void handleIntent(Intent intent) {
        final int intExtra;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (intExtra = intent.getIntExtra("extra_download_id", 0)) == 0) {
            return;
        }
        if (action.equals(DownloadConstants.ACTION_RETRY)) {
            DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DownloadHandleService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        DownloadProcessDispatcher.getInstance().retryDelayStart(intExtra);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else if (action.equals(DownloadConstants.ACTION_DOWNLOAD_PROCESS_NOTIFY)) {
            DownloadProcessDispatcher.getInstance().recordTaskProcessIndependent(intExtra);
        } else if (action.equals(DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY)) {
            DownloadComponentManager.setDownloadInMultiProcess();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        handleIntent(intent);
        return 2;
    }
}
