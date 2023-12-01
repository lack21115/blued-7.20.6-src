package com.android.internal.backup;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/backup/LocalTransportService.class */
public class LocalTransportService extends Service {
    private static LocalTransport sTransport = null;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return sTransport.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        if (sTransport == null) {
            sTransport = new LocalTransport(this);
        }
    }
}
