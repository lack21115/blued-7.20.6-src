package com.anythink.core.common.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.anythink.core.common.k.g;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/c.class */
public final class c {

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/c$a.class */
    public final class a {
        private final String b;
        private final boolean c;

        a(String str, boolean z) {
            this.b = str;
            this.c = z;
        }

        private boolean b() {
            return this.c;
        }

        public final String a() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/c$b.class */
    public final class b implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> c;

        private b() {
            this.a = false;
            this.c = new LinkedBlockingQueue<>(1);
        }

        /* synthetic */ b(c cVar, byte b) {
            this();
        }

        public final IBinder a() {
            if (this.a) {
                throw new IllegalStateException();
            }
            this.a = true;
            return this.c.take();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (InterruptedException e) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.common.b.c$c  reason: collision with other inner class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/b/c$c.class */
    public final class C0058c implements IInterface {
        private IBinder b;

        public C0058c(IBinder iBinder) {
            this.b = iBinder;
        }

        public final String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.b.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.b;
        }

        public final boolean b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.b.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
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

    public final a a(Context context) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
        try {
            context.getPackageManager().getPackageInfo(g.a.a, 0);
            b bVar = new b(this, (byte) 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.size() <= 0 || !context.bindService(intent, bVar, 1)) {
                throw new IOException("Google Play connection failed");
            }
            try {
                C0058c c0058c = new C0058c(bVar.a());
                a aVar = new a(c0058c.a(), c0058c.b());
                try {
                    return aVar;
                } catch (Throwable th) {
                    return aVar;
                }
            } finally {
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
