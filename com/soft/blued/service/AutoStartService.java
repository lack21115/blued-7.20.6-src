package com.soft.blued.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.aidl.IMyAidlInterface;
import com.soft.blued.app.InitTaskUtil;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.ServiceUtils;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/service/AutoStartService.class */
public class AutoStartService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private MyBinder f29762a;
    private MyConn b;

    /* renamed from: c  reason: collision with root package name */
    private IBinder f29763c;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/service/AutoStartService$MyBinder.class */
    static class MyBinder extends IMyAidlInterface.Stub {
        MyBinder() {
        }

        @Override // com.soft.blued.aidl.IMyAidlInterface
        public String a() throws RemoteException {
            return AutoStartService.class.getSimpleName();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/service/AutoStartService$MyConn.class */
    class MyConn implements ServiceConnection {
        MyConn() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Logger.a("AutoStartService", "AutoStartService onServiceConnected");
            AutoStartService.this.f29763c = iBinder;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Logger.a("AutoStartService", "onServiceDisconnected");
            Logger.a("AutoStartService", "restart RemoteService onServiceDisconnected");
            try {
                ServiceUtils.startService(AutoStartService.this, RemoteService.class, null);
                AutoStartService.this.bindService(new Intent(AutoStartService.this, RemoteService.class), AutoStartService.this.b, 64);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a() {
        try {
            Intent intent = new Intent();
            intent.setAction("com.soft.blued.android.ACTION_AUTOSTARTER");
            ((AlarmManager) AppInfo.d().getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + 300000, PendingIntent.getBroadcast(this, 0, intent, 134217728));
        } catch (Exception e) {
        }
    }

    public static void startService(Context context) {
        if (InitTaskUtil.getStartAutoStartService()) {
            ServiceUtils.startService(context, AutoStartService.class, null);
            ServiceUtils.startService(context, RemoteService.class, null);
        }
    }

    public static void stopService(Context context) {
        try {
            context.stopService(new Intent(context, AutoStartService.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f29762a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Logger.a("AutoStartService", "AutoStartService.onCreate()");
        this.f29762a = new MyBinder();
        this.b = new MyConn();
        InitTaskUtil.setStartAutoStartService(false);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Logger.a("AutoStartService", "AutoStartService.onDestroy()");
        if (this.f29763c != null) {
            Logger.a("AutoStartService", "unbind remote service");
            unbindService(this.b);
            this.f29763c = null;
        }
        if (UserInfo.getInstance().isLogin()) {
            a();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Logger.a("AutoStartService", "AutoStartService onStartCommand");
        bindService(new Intent(this, RemoteService.class), this.b, 64);
        return 1;
    }
}
