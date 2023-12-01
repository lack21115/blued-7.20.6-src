package com.bun.miitmdid.c.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.zui.deviceidservice.IDeviceidInterface;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/g/a.class */
public class a {
    private static String e = "OpenDeviceId library";
    private static boolean f;

    /* renamed from: a  reason: collision with root package name */
    private Context f21141a;
    private IDeviceidInterface b;

    /* renamed from: c  reason: collision with root package name */
    private ServiceConnection f21142c;
    private com.bun.miitmdid.c.e.a d;

    /* renamed from: com.bun.miitmdid.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/c/g/a$a.class */
    class ServiceConnectionC0302a implements ServiceConnection {
        ServiceConnectionC0302a() {
        }

        @Override // android.content.ServiceConnection
        public native synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        public native void onServiceDisconnected(ComponentName componentName);
    }

    public a(Context context, com.bun.miitmdid.c.e.a aVar) {
        this.f21141a = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.f21141a = context;
        this.d = aVar;
        this.f21142c = new ServiceConnectionC0302a();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f21141a.bindService(intent, this.f21142c, 1)) {
            b("bindService Successful!");
            return;
        }
        b("bindService Failed!");
        com.bun.miitmdid.c.e.a aVar2 = this.d;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    static native /* synthetic */ com.bun.miitmdid.c.e.a a(a aVar);

    static native /* synthetic */ IDeviceidInterface a(a aVar, IDeviceidInterface iDeviceidInterface);

    static native /* synthetic */ void a(a aVar, String str);

    private native void a(String str);

    private native void b(String str);

    public native String a();

    public native String b();

    public native String c();

    public native String d();

    public native boolean e();

    public native void f();
}
