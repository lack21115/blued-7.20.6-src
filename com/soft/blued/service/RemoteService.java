package com.soft.blued.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.soft.blued.aidl.IMyAidlInterface;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/service/RemoteService.class */
public class RemoteService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private MyConn f29765a;
    private MyBinder b;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/service/RemoteService$MyBinder.class */
    class MyBinder extends IMyAidlInterface.Stub {
        MyBinder() {
        }

        @Override // com.soft.blued.aidl.IMyAidlInterface
        public String a() throws RemoteException {
            return RemoteService.class.getSimpleName();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/service/RemoteService$MyConn.class */
    class MyConn implements ServiceConnection {
        MyConn() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Logger.a("RemoteServices", "onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Logger.a("RemoteServices", "restart AutoStrartService onServiceDisconnected");
            try {
                AutoStartService.startService(RemoteService.this);
                RemoteService.this.bindService(new Intent(RemoteService.this, AutoStartService.class), RemoteService.this.f29765a, 64);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Logger.a("RemoteServices", "restart AutoStrartService done");
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.b;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Logger.a("RemoteServices", "RemoteService onCreate");
        this.f29765a = new MyConn();
        this.b = new MyBinder();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger.a("RemoteServices", "RemoteService onDestroy");
        unbindService(this.f29765a);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Logger.a("RemoteServices", "RemoteService onStartCommand");
        bindService(new Intent(this, AutoStartService.class), this.f29765a, 64);
        return 1;
    }
}
