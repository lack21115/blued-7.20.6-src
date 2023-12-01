package com.tencent.tmsqmsp.oaid2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.tmsqmsp.oaid2.i0;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/j0.class */
public class j0 {
    public static String e = "SDI";
    public static String f = "SI";

    /* renamed from: a  reason: collision with root package name */
    public b f39639a;
    public ServiceConnection b;

    /* renamed from: c  reason: collision with root package name */
    public Context f39640c;
    public i0 d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/j0$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                j0.this.d = i0.a.a(iBinder);
                j0 j0Var = j0.this;
                b bVar = j0Var.f39639a;
                if (bVar != null) {
                    bVar.a(j0Var);
                }
                c.c(j0.f + " Service onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            j0.this.d = null;
            c.c(j0.f + " Service onServiceDisconnected");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/j0$b.class */
    public interface b {
        void a(j0 j0Var);
    }

    public j0(Context context, b bVar) {
        this.f39639a = null;
        this.f39640c = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f39640c = context;
        this.f39639a = bVar;
        this.b = new a();
    }

    public String a() {
        Context context = this.f39640c;
        if (context == null) {
            c.c(f + " Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SxCore first");
        }
        String packageName = context.getPackageName();
        c.a(f + "apackage：" + packageName);
        if (packageName == null || packageName.equals("")) {
            c.c(f + " input package is null!");
            return null;
        }
        try {
            i0 i0Var = this.d;
            if (i0Var != null) {
                String a2 = i0Var.a(packageName);
                c.a(f + " getAAID Package: " + packageName);
                return a2;
            }
            return null;
        } catch (Exception e2) {
            c.c(f + " geta error, RemoteException!");
            return null;
        }
    }

    public String b() {
        if (this.f39640c == null) {
            c.c(f + " Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SxCore first");
        }
        try {
            i0 i0Var = this.d;
            if (i0Var != null) {
                String a2 = i0Var.a();
                c.c(e + " geto call");
                return a2;
            }
            return null;
        } catch (Exception e2) {
            c.c(f + " geto error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public void c() {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.f39640c.bindService(intent, this.b, 1)) {
            c.c(f + " bindService Successful!");
            return;
        }
        this.f39639a.a(this);
        c.c(f + " bindService Failed!");
    }

    public boolean d() {
        try {
            if (this.d == null) {
                c.c(f + " Device not support opendeviceid");
                return false;
            }
            c.c(f + " Device support opendeviceid");
            return true;
        } catch (Exception e2) {
            c.c(f + " isSupport error, RemoteException!");
            return false;
        }
    }

    public void e() {
        try {
            this.f39640c.unbindService(this.b);
            c.c(f + " unBind Service successful");
        } catch (IllegalArgumentException e2) {
            c.c(f + " unBind Service exception");
        }
        this.d = null;
    }
}
