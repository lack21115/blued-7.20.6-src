package cn.shuzilm.core;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import java.util.UUID;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/DUService.class */
public class DUService extends Service {
    public static WakeListener callback;

    /* renamed from: a  reason: collision with root package name */
    private Context f4164a;
    private t b = new t(this);

    /* renamed from: c  reason: collision with root package name */
    private String f4165c;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (this.f4164a == null) {
            this.f4164a = getApplicationContext();
        }
        this.f4165c = intent.getStringExtra("apikey");
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (Looper.myLooper() != null) {
            DUHelper.init(this.f4164a, this.f4165c);
        }
        return this.b;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.f4164a == null) {
            this.f4164a = getApplicationContext();
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String str;
        try {
            DUHelper.loadLibrary();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            str = intent.getStringExtra("s");
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        if (str != null) {
            try {
                String replace = UUID.randomUUID().toString().replace("-", "");
                DUHelper.onIEvent(getApplicationContext(), str + "," + replace);
                callback.handleWakeup(replace);
                return 1;
            } catch (Exception e3) {
                e3.printStackTrace();
                return 1;
            }
        }
        return 1;
    }
}
