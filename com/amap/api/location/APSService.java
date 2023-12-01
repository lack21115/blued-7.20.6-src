package com.amap.api.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.amap.api.col.p0003sl.f;
import com.autonavi.aps.amapapi.utils.b;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/location/APSService.class */
public class APSService extends Service {

    /* renamed from: a  reason: collision with root package name */
    f f5483a;
    int b = 0;

    /* renamed from: c  reason: collision with root package name */
    boolean f5484c = false;

    private void a(Context context) {
        try {
            if (this.f5483a == null) {
                this.f5483a = new f(context);
            }
            this.f5483a.a();
        } catch (Throwable th) {
            b.a(th, "APSService", "onCreate");
        }
        super.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        try {
            return this.f5483a.a(intent);
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
            this.f5483a.b();
            if (this.f5484c) {
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
                int intExtra = intent.getIntExtra("g", 0);
                if (intExtra == 1) {
                    int intExtra2 = intent.getIntExtra("i", 0);
                    Notification notification = (Notification) intent.getParcelableExtra("h");
                    if (intExtra2 == 0 || notification == null) {
                        return 0;
                    }
                    startForeground(intExtra2, notification);
                    this.f5484c = true;
                    this.b++;
                    return 0;
                } else if (intExtra == 2) {
                    if (intent.getBooleanExtra("j", true) && this.b > 0) {
                        this.b--;
                    }
                    if (this.b > 0) {
                        stopForeground(false);
                        return 0;
                    }
                    stopForeground(true);
                    this.f5484c = false;
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
