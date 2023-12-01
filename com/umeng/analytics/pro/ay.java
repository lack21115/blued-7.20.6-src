package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ay.class */
public class ay implements au {

    /* renamed from: a  reason: collision with root package name */
    private static final String f26950a = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
    private static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f26951c = 2;

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ay$a.class */
    static final class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f26952a;
        private final LinkedBlockingQueue<IBinder> b;

        private a() {
            this.f26952a = false;
            this.b = new LinkedBlockingQueue<>();
        }

        public IBinder a() throws InterruptedException {
            if (this.f26952a) {
                throw new IllegalStateException();
            }
            this.f26952a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ay$b.class */
    static final class b implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f26953a;

        public b(IBinder iBinder) {
            this.f26953a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ay.f26950a);
                this.f26953a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f26953a;
        }

        public boolean b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken(ay.f26950a);
                boolean z = false;
                this.f26953a.transact(2, obtain, obtain2, 0);
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

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        a aVar = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (context.bindService(intent, aVar, 1)) {
            try {
                return new b(aVar.a()).a();
            } catch (Exception e) {
                return null;
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
