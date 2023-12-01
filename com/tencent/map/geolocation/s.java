package com.tencent.map.geolocation;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import c.t.m.g.s3;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/s.class */
public class s extends Service {
    public static boolean removeNotification = true;
    public volatile boolean isStartForeground = false;
    public MyBinder mBinder = new MyBinder();

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/map/geolocation/s$MyBinder.class */
    public class MyBinder extends Binder {
        public MyBinder() {
        }

        public s getService() {
            return s.this;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            Notification notification = (Notification) intent.getExtras().get("LocNotification");
            int intValue = ((Integer) intent.getExtras().get("LocNotificationId")).intValue();
            if (intValue > 0 && notification != null && !this.isStartForeground) {
                startForeground(intValue, notification);
                s3.a("LOC", "startForeground");
                this.isStartForeground = true;
            }
        } catch (Throwable th) {
        }
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.isStartForeground) {
            this.isStartForeground = false;
            try {
                stopForeground(removeNotification);
            } catch (Throwable th) {
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        if (this.isStartForeground) {
            this.isStartForeground = false;
            try {
                stopForeground(removeNotification);
                s3.a("LOC", "stopForeground");
            } catch (Throwable th) {
            }
        }
        return super.onUnbind(intent);
    }
}
