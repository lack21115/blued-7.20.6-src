package org.repackage.com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import org.repackage.com.zui.deviceidservice.IDeviceidInterface;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/com/zui/opendeviceidlibrary/OpenDeviceId.class */
public class OpenDeviceId {

    /* renamed from: c  reason: collision with root package name */
    private static String f44123c = "OpenDeviceId library";
    private static boolean d = false;
    private IDeviceidInterface b;
    private ServiceConnection e;

    /* renamed from: a  reason: collision with root package name */
    private Context f44124a = null;
    private CallBack f = null;

    /* loaded from: source-3503164-dex2jar.jar:org/repackage/com/zui/opendeviceidlibrary/OpenDeviceId$CallBack.class */
    public interface CallBack<T> {
        void a(T t, OpenDeviceId openDeviceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (d) {
            Log.i(f44123c, str);
        }
    }

    private void b(String str) {
        if (d) {
            Log.e(f44123c, str);
        }
    }

    public int a(Context context, CallBack<String> callBack) {
        if (context != null) {
            this.f44124a = context;
            this.f = callBack;
            this.e = new ServiceConnection() { // from class: org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (this) {
                        OpenDeviceId.this.b = IDeviceidInterface.Stub.a(iBinder);
                        if (OpenDeviceId.this.f != null) {
                            OpenDeviceId.this.f.a("Deviceid Service Connected", OpenDeviceId.this);
                        }
                        OpenDeviceId.this.a("Service onServiceConnected");
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    OpenDeviceId.this.b = null;
                    OpenDeviceId.this.a("Service onServiceDisconnected");
                }
            };
            Intent intent = new Intent();
            intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
            if (this.f44124a.bindService(intent, this.e, 1)) {
                a("bindService Successful!");
                return 1;
            }
            a("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    public String a() {
        if (this.f44124a == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            if (this.b != null) {
                return this.b.a();
            }
            return null;
        } catch (RemoteException e) {
            b("getOAID error, RemoteException!");
            e.printStackTrace();
            return null;
        }
    }

    public boolean b() {
        boolean z = false;
        try {
            if (this.b != null) {
                a("Device support opendeviceid");
                z = this.b.c();
            }
            return z;
        } catch (RemoteException e) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }
}
