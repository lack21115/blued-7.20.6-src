package com.alibaba.mtl.appmonitor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/AppMonitorService.class */
public class AppMonitorService extends Service {

    /* renamed from: a  reason: collision with root package name */
    IMonitor f4449a = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.f4449a == null) {
            this.f4449a = new Monitor(getApplication());
        }
        return (IBinder) this.f4449a;
    }

    @Override // android.app.Service
    public void onDestroy() {
        IMonitor iMonitor = this.f4449a;
        if (iMonitor != null) {
            try {
                iMonitor.triggerUpload();
            } catch (RemoteException e) {
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        IMonitor iMonitor = this.f4449a;
        if (iMonitor != null) {
            try {
                iMonitor.triggerUpload();
            } catch (RemoteException e) {
            }
        }
        super.onLowMemory();
    }
}
