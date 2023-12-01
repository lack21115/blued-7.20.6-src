package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/aw.class */
public class aw implements au {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40637a = "Coolpad";
    private static final String b = "com.coolpad.deviceidsupport";

    /* renamed from: c  reason: collision with root package name */
    private static final String f40638c = "com.coolpad.deviceidsupport.DeviceIdService";
    private static a d;
    private CountDownLatch f;
    private Context g;
    private String e = "";
    private final ServiceConnection h = new ServiceConnection() { // from class: com.umeng.analytics.pro.aw.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = aw.d = a.b.a(iBinder);
                aw.this.e = aw.d.b(aw.this.g.getPackageName());
                Log.d(aw.f40637a, "onServiceConnected: oaid = " + aw.this.e);
            } catch (RemoteException | NullPointerException e) {
                Log.e(aw.f40637a, "onServiceConnected failed e=" + e.getMessage());
            }
            aw.this.f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(aw.f40637a, "onServiceDisconnected");
            a unused = aw.d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(b, f40638c));
            if (context.bindService(intent, this.h, 1)) {
                return;
            }
            Log.e(f40637a, "bindService return false");
        } catch (Throwable th) {
            Log.e(f40637a, "bindService failed. e=" + th.getMessage());
            this.f.countDown();
        }
    }

    private void c(Context context) {
        try {
            Log.d(f40637a, "call unbindService.");
            context.unbindService(this.h);
        } catch (Throwable th) {
            Log.e(f40637a, "unbindService failed. e=" + th.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.g = context.getApplicationContext();
        this.f = new CountDownLatch(1);
        try {
            try {
                b(context);
                if (!this.f.await(500L, TimeUnit.MILLISECONDS)) {
                    Log.e(f40637a, "getOAID time-out");
                }
                return this.e;
            } catch (InterruptedException e) {
                Log.e(f40637a, "getOAID interrupted. e=" + e.getMessage());
                c(context);
                return null;
            }
        } finally {
            c(context);
        }
    }
}
