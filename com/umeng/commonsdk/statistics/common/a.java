package com.umeng.commonsdk.statistics.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.anythink.expressad.foundation.h.s;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/common/a.class */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.umeng.commonsdk.statistics.common.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/common/a$a.class */
    public static final class C0913a {

        /* renamed from: a  reason: collision with root package name */
        private final String f27214a;
        private final boolean b;

        C0913a(String str, boolean z) {
            this.f27214a = str;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String b() {
            return this.f27214a;
        }

        public boolean a() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/common/a$b.class */
    public static final class b implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        boolean f27215a;
        private final LinkedBlockingQueue<IBinder> b;

        private b() {
            this.f27215a = false;
            this.b = new LinkedBlockingQueue<>(1);
        }

        public IBinder a() throws InterruptedException {
            if (this.f27215a) {
                throw new IllegalStateException();
            }
            this.f27215a = true;
            return this.b.take();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/statistics/common/a$c.class */
    public static final class c implements IInterface {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f27216a;

        public c(IBinder iBinder) {
            this.f27216a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f27216a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public boolean a(boolean z) throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(z ? 1 : 0);
                this.f27216a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                boolean z2 = obtain2.readInt() != 0;
                obtain2.recycle();
                obtain.recycle();
                return z2;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f27216a;
        }
    }

    public static String a(Context context) {
        try {
            C0913a c2 = c(context);
            if (c2 == null || c2.a()) {
                return null;
            }
            return c2.b();
        } catch (Exception e) {
            return null;
        }
    }

    public static String b(Context context) {
        try {
            C0913a c2 = c(context);
            if (c2 == null) {
                return null;
            }
            return c2.b();
        } catch (Exception e) {
            return null;
        }
    }

    private static C0913a c(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            if (com.umeng.commonsdk.utils.b.a().a(context, s.a.f5134a, 0) == null) {
                return null;
            }
            b bVar = new b();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, bVar, 1)) {
                    try {
                        c cVar = new c(bVar.a());
                        boolean a2 = cVar.a(true);
                        C0913a c0913a = new C0913a(a2 ? "" : cVar.a(), a2);
                        context.unbindService(bVar);
                        return c0913a;
                    } catch (Exception e) {
                        throw e;
                    }
                }
                throw new IOException("Google Play connection failed");
            } catch (Throwable th) {
                context.unbindService(bVar);
                throw th;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
