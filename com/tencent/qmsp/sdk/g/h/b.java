package com.tencent.qmsp.sdk.g.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.qmsp.sdk.g.h.a;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/h/b.class */
public class b {
    private static String e = "SDI";
    public static String f = "SI";

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC0832b f24958a;
    private ServiceConnection b;

    /* renamed from: c  reason: collision with root package name */
    private Context f24959c;
    public com.tencent.qmsp.sdk.g.h.a d;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/h/b$a.class */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                b.this.d = a.AbstractBinderC0830a.a(iBinder);
                if (b.this.f24958a != null) {
                    b.this.f24958a.a(b.this);
                }
                StringBuilder sb = new StringBuilder();
                sb.append(b.f);
                sb.append(" Service onServiceConnected");
                com.tencent.qmsp.sdk.base.c.c(sb.toString());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.d = null;
            com.tencent.qmsp.sdk.base.c.c(b.f + " Service onServiceDisconnected");
        }
    }

    /* renamed from: com.tencent.qmsp.sdk.g.h.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/h/b$b.class */
    public interface InterfaceC0832b {
        void a(b bVar);
    }

    public b(Context context, InterfaceC0832b interfaceC0832b) {
        this.f24958a = null;
        this.f24959c = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f24959c = context;
        this.f24958a = interfaceC0832b;
        this.b = new a();
    }

    public String a() {
        StringBuilder sb;
        String str;
        Context context = this.f24959c;
        if (context == null) {
            com.tencent.qmsp.sdk.base.c.c(f + " Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SxCore first");
        }
        String packageName = context.getPackageName();
        com.tencent.qmsp.sdk.base.c.a(f + "apackage：" + packageName);
        if (packageName == null || packageName.equals("")) {
            sb = new StringBuilder();
            sb.append(f);
            str = " input package is null!";
        } else {
            try {
                if (this.d != null) {
                    String a2 = this.d.a(packageName);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(f);
                    sb2.append(" getAAID Package: ");
                    sb2.append(packageName);
                    com.tencent.qmsp.sdk.base.c.a(sb2.toString());
                    return a2;
                }
                return null;
            } catch (Exception e2) {
                sb = new StringBuilder();
                sb.append(f);
                str = " geta error, RemoteException!";
            }
        }
        sb.append(str);
        com.tencent.qmsp.sdk.base.c.c(sb.toString());
        return null;
    }

    public String b() {
        if (this.f24959c == null) {
            com.tencent.qmsp.sdk.base.c.c(f + " Context is null.");
            throw new IllegalArgumentException("Context is null, must be new SxCore first");
        }
        try {
            if (this.d != null) {
                String a2 = this.d.a();
                StringBuilder sb = new StringBuilder();
                sb.append(e);
                sb.append(" geto call");
                com.tencent.qmsp.sdk.base.c.c(sb.toString());
                return a2;
            }
            return null;
        } catch (Exception e2) {
            com.tencent.qmsp.sdk.base.c.c(f + " geto error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public void c() {
        StringBuilder sb;
        String str;
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.f24959c.bindService(intent, this.b, 1)) {
            sb = new StringBuilder();
            sb.append(f);
            str = " bindService Successful!";
        } else {
            this.f24958a.a(this);
            sb = new StringBuilder();
            sb.append(f);
            str = " bindService Failed!";
        }
        sb.append(str);
        com.tencent.qmsp.sdk.base.c.c(sb.toString());
    }

    public boolean d() {
        try {
            if (this.d == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(f);
                sb.append(" Device not support opendeviceid");
                com.tencent.qmsp.sdk.base.c.c(sb.toString());
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f);
            sb2.append(" Device support opendeviceid");
            com.tencent.qmsp.sdk.base.c.c(sb2.toString());
            return true;
        } catch (Exception e2) {
            com.tencent.qmsp.sdk.base.c.c(f + " isSupport error, RemoteException!");
            return false;
        }
    }

    public void e() {
        try {
            this.f24959c.unbindService(this.b);
            StringBuilder sb = new StringBuilder();
            sb.append(f);
            sb.append(" unBind Service successful");
            com.tencent.qmsp.sdk.base.c.c(sb.toString());
        } catch (IllegalArgumentException e2) {
            com.tencent.qmsp.sdk.base.c.c(f + " unBind Service exception");
        }
        this.d = null;
    }
}
