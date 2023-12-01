package com.amap.api.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.amap.api.col.p0003sl.f;
import com.amap.api.col.p0003sl.iu;
import com.autonavi.aps.amapapi.utils.b;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/location/APSService.class */
public class APSService extends Service {
    f a;
    int b = 0;
    boolean c = false;

    private void a(Context context) {
        try {
            if (this.a == null) {
                this.a = new f(context);
            }
            this.a.a();
        } catch (Throwable th) {
            b.a(th, "APSService", "onCreate");
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return this.a.a(intent);
        } catch (Throwable th) {
            b.a(th, "APSService", "onBind");
            return null;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        a(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            this.a.b();
            if (this.c) {
                stopForeground(true);
            }
        } catch (Throwable th) {
            b.a(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra(iu.f, 0);
                if (intExtra == 1) {
                    int intExtra2 = intent.getIntExtra("i", 0);
                    Notification notification = (Notification) intent.getParcelableExtra(iu.g);
                    if (intExtra2 == 0 || notification == null) {
                        return 0;
                    }
                    startForeground(intExtra2, notification);
                    this.c = true;
                    this.b++;
                    return 0;
                } else if (intExtra == 2) {
                    if (intent.getBooleanExtra(iu.j, true) && this.b > 0) {
                        this.b--;
                    }
                    if (this.b > 0) {
                        stopForeground(false);
                        return 0;
                    }
                    stopForeground(true);
                    this.c = false;
                    return 0;
                } else {
                    return 0;
                }
            } catch (Throwable th) {
                return 0;
            }
        }
        return 0;
    }
}
