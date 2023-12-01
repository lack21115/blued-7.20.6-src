package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.tmsqmsp.oaid2.n;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/p.class */
public class p {
    public static String e = "LXOP";

    /* renamed from: a  reason: collision with root package name */
    public Context f25965a;
    public n b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f25966c;
    public b d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/p$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                p.this.b = n.a.a(iBinder);
                p pVar = p.this;
                b bVar = pVar.d;
                if (bVar != null) {
                    bVar.a(pVar);
                }
                p.this.b("Service onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            p pVar = p.this;
            pVar.b = null;
            pVar.b("Service onServiceDisconnected");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/p$b.class */
    public interface b {
        void a(p pVar);
    }

    public p(Context context, b bVar) {
        this.f25965a = null;
        this.d = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f25965a = context;
        this.d = bVar;
        this.f25966c = new a();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f25965a.bindService(intent, this.f25966c, 1)) {
            b("bindService Successful!");
            return;
        }
        b bVar2 = this.d;
        if (bVar2 != null) {
            bVar2.a(this);
        }
        b("bindService Failed!!!");
    }

    public String a() {
        if (this.f25965a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            n nVar = this.b;
            if (nVar != null) {
                return nVar.b();
            }
            return null;
        } catch (Exception e2) {
            a("getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public final void a(String str) {
        c.b(e + " " + str);
    }

    public final void b(String str) {
        c.a(e + " " + str);
    }

    public boolean b() {
        try {
            if (this.b == null) {
                return false;
            }
            b("Device support opendeviceid");
            return this.b.c();
        } catch (Exception e2) {
            a("isSupport error, RemoteException!");
            return false;
        }
    }

    public String c() {
        Context context = this.f25965a;
        if (context == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        b("liufeng, getAAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            b("input package is null!");
            return null;
        }
        try {
            n nVar = this.b;
            if (nVar != null) {
                return nVar.b(packageName);
            }
            return null;
        } catch (Exception e2) {
            a("getAAID error, RemoteException!");
            return null;
        }
    }

    public void d() {
        try {
            this.f25965a.unbindService(this.f25966c);
            b("unBind Service successful");
        } catch (IllegalArgumentException e2) {
            a("unBind Service exception");
        }
        this.b = null;
    }
}
