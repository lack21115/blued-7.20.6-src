package com.anythink.china.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f6217a = new LinkedBlockingQueue<>(1);
    ServiceConnection b = new ServiceConnection() { // from class: com.anythink.china.a.a.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.f6217a.put(iBinder);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Context f6218c;

    public b(Context context) {
        this.f6218c = context;
    }

    public final void a(com.anythink.china.a.a aVar) {
        try {
            this.f6218c.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        if (!this.f6218c.bindService(intent, this.b, 1)) {
            aVar.a();
            return;
        }
        try {
            aVar.a(new a(this.f6217a.take()).a(), false);
        } catch (Exception e) {
            e.getMessage();
            aVar.a();
        } catch (Throwable th2) {
            th2.getMessage();
            aVar.a();
        }
    }
}
