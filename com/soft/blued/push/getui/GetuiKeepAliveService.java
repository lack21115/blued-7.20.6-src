package com.soft.blued.push.getui;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.igexin.sdk.GTServiceManager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/push/getui/GetuiKeepAliveService.class */
public class GetuiKeepAliveService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        GTServiceManager.getInstance().onServiceCreate(this, intent);
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        GTServiceManager.getInstance().onServiceCreate(this, intent);
        return 2;
    }
}
