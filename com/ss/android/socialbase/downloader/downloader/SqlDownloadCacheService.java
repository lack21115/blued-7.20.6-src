package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/downloader/SqlDownloadCacheService.class */
public class SqlDownloadCacheService extends Service {
    private static final String TAG = SqlDownloadCacheService.class.getSimpleName();

    public static void startServiceAndBind(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                Log.w(TAG, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IDownloadCache downloadCache = DownloadComponentManager.getDownloadCache();
        ISqlDownloadCache sqlDownloadCache = downloadCache instanceof DefaultDownloadCache ? ((DefaultDownloadCache) downloadCache).getSqlDownloadCache() : downloadCache instanceof ISqlDownloadCache ? (ISqlDownloadCache) downloadCache : null;
        return sqlDownloadCache instanceof IBinder ? sqlDownloadCache : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(getApplicationContext());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (DownloadComponentManager.notAutoRebootService()) {
            onStartCommand = 2;
        }
        return onStartCommand;
    }
}
