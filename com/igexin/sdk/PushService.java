package com.igexin.sdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.getui.gtc.base.GtcProvider;
import com.igexin.c.a.c.a;
import com.igexin.c.a.c.a.c;
import com.igexin.c.a.c.a.d;
import com.igexin.push.core.ServiceManager;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/sdk/PushService.class */
public class PushService extends Service {
    private final String TAG = getClass().getName();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String type = (intent == null || intent.getType() == null) ? "" : intent.getType();
        if (!type.startsWith("GB-") && !type.startsWith("PB-")) {
            return c.f23254a.equals(type) ? d.a().f23258a.getBinder() : type.startsWith("GTC-") ? ServiceManager.getInstance().a((Service) this, intent) : ServiceManager.getInstance().a((Service) this, intent);
        }
        ServiceManager.getInstance().a(this, intent, 0, 0);
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            GtcProvider.setContext(this);
        } catch (Exception e) {
            a.a(e);
        }
        super.onCreate();
        ServiceManager.getInstance();
        ServiceManager.a((Context) this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ServiceManager serviceManager = ServiceManager.getInstance();
        a.a("ServiceManager|onDestroy...", new Object[0]);
        if (serviceManager.f23382a != null) {
            serviceManager.f23382a.onServiceDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        ServiceManager.getInstance();
        ServiceManager.a();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        ServiceManager.getInstance().a(this, intent, i, i2);
        return 2;
    }
}
