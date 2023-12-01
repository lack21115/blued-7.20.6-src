package com.anythink.china.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.anythink.china.a.a.c;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6223a = "OaidAidlUtil";
    private static final String b = "com.huawei.hwid";

    /* renamed from: c  reason: collision with root package name */
    private static final String f6224c = "com.uodis.opendevice.OPENIDS_SERVICE";
    private Context d;
    private ServiceConnection e;
    private c f;
    private com.anythink.china.a.a g;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/d$a.class */
    final class a implements ServiceConnection {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f = c.a.a(iBinder);
            try {
                if (d.this.f != null) {
                    try {
                        if (d.this.g != null) {
                            d.this.g.a(d.this.f.a(), d.this.f.b());
                        }
                    } catch (RemoteException e) {
                        if (d.this.g != null) {
                            com.anythink.china.a.a aVar = d.this.g;
                            e.getMessage();
                            aVar.a();
                        }
                    } catch (Exception e2) {
                        if (d.this.g != null) {
                            com.anythink.china.a.a aVar2 = d.this.g;
                            e2.getMessage();
                            aVar2.a();
                        }
                    }
                }
            } finally {
                d.c(d.this);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            d.this.f = null;
        }
    }

    public d(Context context) {
        this.d = context;
    }

    private boolean a() {
        if (this.d == null) {
            return false;
        }
        this.e = new a(this, (byte) 0);
        Intent intent = new Intent(f6224c);
        intent.setPackage("com.huawei.hwid");
        return this.d.bindService(intent, this.e, 1);
    }

    private void b() {
        ServiceConnection serviceConnection;
        Context context = this.d;
        if (context == null || (serviceConnection = this.e) == null) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (Throwable th) {
        }
        this.f = null;
        this.d = null;
        this.g = null;
    }

    static /* synthetic */ void c(d dVar) {
        ServiceConnection serviceConnection;
        Context context = dVar.d;
        if (context == null || (serviceConnection = dVar.e) == null) {
            return;
        }
        try {
            context.unbindService(serviceConnection);
        } catch (Throwable th) {
        }
        dVar.f = null;
        dVar.d = null;
        dVar.g = null;
    }

    public final void a(com.anythink.china.a.a aVar) {
        this.g = aVar;
        if (this.d != null) {
            this.e = new a(this, (byte) 0);
            Intent intent = new Intent(f6224c);
            intent.setPackage("com.huawei.hwid");
            this.d.bindService(intent, this.e, 1);
        }
    }
}
