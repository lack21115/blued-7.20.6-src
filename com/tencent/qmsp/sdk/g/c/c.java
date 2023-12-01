package com.tencent.qmsp.sdk.g.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qmsp.sdk.g.c.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/c/c.class */
public class c {
    private static String e = "LXOP";

    /* renamed from: a  reason: collision with root package name */
    private Context f24931a;
    public com.tencent.qmsp.sdk.g.c.a b;

    /* renamed from: c  reason: collision with root package name */
    private ServiceConnection f24932c;
    public b d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/c/c$a.class */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                c.this.b = a.AbstractBinderC0825a.a(iBinder);
                if (c.this.d != null) {
                    c.this.d.a(c.this);
                }
                c.this.b("Service onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            c cVar = c.this;
            cVar.b = null;
            cVar.b("Service onServiceDisconnected");
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/c/c$b.class */
    public interface b {
        void a(c cVar);
    }

    public c(Context context, b bVar) {
        String str;
        this.f24931a = null;
        this.d = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f24931a = context;
        this.d = bVar;
        this.f24932c = new a();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f24931a.bindService(intent, this.f24932c, 1)) {
            str = "bindService Successful!";
        } else {
            b bVar2 = this.d;
            if (bVar2 != null) {
                bVar2.a(this);
            }
            str = "bindService Failed!!!";
        }
        b(str);
    }

    private void a(String str) {
        com.tencent.qmsp.sdk.base.c.b(e + " " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.tencent.qmsp.sdk.base.c.a(e + " " + str);
    }

    public String a() {
        if (this.f24931a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.b != null) {
                return this.b.g();
            }
            return null;
        } catch (Exception e2) {
            a("getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
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
        Context context = this.f24931a;
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
            if (this.b != null) {
                return this.b.b(packageName);
            }
            return null;
        } catch (Exception e2) {
            a("getAAID error, RemoteException!");
            return null;
        }
    }

    public void d() {
        try {
            this.f24931a.unbindService(this.f24932c);
            b("unBind Service successful");
        } catch (IllegalArgumentException e2) {
            a("unBind Service exception");
        }
        this.b = null;
    }
}
