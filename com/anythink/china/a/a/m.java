package com.anythink.china.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.anythink.china.a.a.l;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    l f6239a;
    ServiceConnection b = new ServiceConnection() { // from class: com.anythink.china.a.a.m.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            m.this.f6239a = new l.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Context f6240c;

    public m(Context context) {
        this.f6240c = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.f6240c.bindService(intent, this.b, 1) || this.f6239a == null) {
                aVar.a();
            } else {
                aVar.a(this.f6239a.a(), false);
            }
        } catch (Throwable th) {
            th.getMessage();
            aVar.a();
        }
    }
}
