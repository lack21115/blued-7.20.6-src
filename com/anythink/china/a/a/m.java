package com.anythink.china.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.anythink.china.a.a.l;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/m.class */
public final class m {
    l a;
    ServiceConnection b = new ServiceConnection() { // from class: com.anythink.china.a.a.m.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            m.this.a = new l.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private Context c;

    public m(Context context) {
        this.c = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.c.bindService(intent, this.b, 1) || this.a == null) {
                aVar.a();
            } else {
                aVar.a(this.a.a(), false);
            }
        } catch (Throwable th) {
            th.getMessage();
            aVar.a();
        }
    }
}
