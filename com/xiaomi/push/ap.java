package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ap.class */
public class ap implements as {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f27564a;

    /* renamed from: a  reason: collision with other field name */
    private Context f138a;

    /* renamed from: a  reason: collision with other field name */
    private ServiceConnection f139a;

    /* renamed from: a  reason: collision with other field name */
    private volatile int f137a = 0;

    /* renamed from: a  reason: collision with other field name */
    private volatile String f141a = null;

    /* renamed from: b  reason: collision with other field name */
    private volatile boolean f142b = false;
    private volatile String b = null;

    /* renamed from: a  reason: collision with other field name */
    private final Object f140a = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ap$a.class */
    public class a implements ServiceConnection {
        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            new Thread(new ar(this, iBinder)).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ap$b.class */
    static class b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a  reason: collision with other method in class */
        public static boolean m8460a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                boolean z = false;
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() != 0) {
                    z = true;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
    }

    public ap(Context context) {
        this.f138a = context;
        a();
    }

    private void a() {
        boolean z;
        this.f139a = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        int i = 1;
        try {
            z = this.f138a.bindService(intent, this.f139a, 1);
        } catch (Exception e) {
            z = false;
        }
        if (!z) {
            i = 2;
        }
        this.f137a = i;
    }

    private void a(String str) {
        if (this.f137a != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f140a) {
            try {
                com.xiaomi.channel.commonutils.logger.b.m8344a("huawei's " + str + " wait...");
                this.f140a.wait(com.anythink.expressad.video.module.a.a.m.ag);
            } catch (Exception e) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
            f27564a = packageInfo.versionCode >= 20602000;
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ServiceConnection serviceConnection = this.f139a;
        if (serviceConnection != null) {
            try {
                this.f138a.unbindService(serviceConnection);
            } catch (Exception e) {
            }
        }
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a  reason: collision with other method in class */
    public String mo8458a() {
        a("getOAID");
        return this.f141a;
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a  reason: collision with other method in class */
    public boolean mo8459a() {
        return f27564a;
    }
}
