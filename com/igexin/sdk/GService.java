package com.igexin.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.getui.gtc.base.GtcProvider;
import com.igexin.push.core.ServiceManager;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/GService.class */
public class GService extends Service {
    public static final String TAG = GService.class.getName();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            GtcProvider.setContext(getApplicationContext());
            ServiceManager.getInstance().a(getApplicationContext(), intent);
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            GtcProvider.setContext(getApplicationContext());
        } catch (Throwable th) {
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            GtcProvider.setContext(getApplicationContext());
            ServiceManager.getInstance().a(getApplicationContext(), intent);
            return 2;
        } catch (Throwable th) {
            return 2;
        }
    }
}
