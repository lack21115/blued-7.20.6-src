package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/b.class */
public interface b extends IInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/b$a.class */
    public static class a implements b {
        @Override // com.umeng.analytics.pro.b
        public String a() throws RemoteException {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String a(String str) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String b(String str) throws RemoteException {
            return null;
        }
    }

    /* renamed from: com.umeng.analytics.pro.b$b  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/b$b.class */
    public static abstract class AbstractBinderC1076b extends Binder implements b {

        /* renamed from: a  reason: collision with root package name */
        static final int f40647a = 1;
        static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        static final int f40648c = 3;
        private static final String d = "com.samsung.android.deviceidservice.IDeviceIdService";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.umeng.analytics.pro.b$b$a */
        /* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/b$b$a.class */
        public static class a implements b {

            /* renamed from: a  reason: collision with root package name */
            public static b f40649a;
            private IBinder b;

            a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.umeng.analytics.pro.b
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1076b.d);
                    if (this.b.transact(1, obtain, obtain2, 0) || AbstractBinderC1076b.b() == null) {
                        obtain2.readException();
                        return obtain2.readString();
                    }
                    return AbstractBinderC1076b.b().a();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1076b.d);
                    obtain.writeString(str);
                    if (this.b.transact(2, obtain, obtain2, 0) || AbstractBinderC1076b.b() == null) {
                        obtain2.readException();
                        return obtain2.readString();
                    }
                    return AbstractBinderC1076b.b().a(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            public String b() {
                return AbstractBinderC1076b.d;
            }

            @Override // com.umeng.analytics.pro.b
            public String b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1076b.d);
                    obtain.writeString(str);
                    if (this.b.transact(3, obtain, obtain2, 0) || AbstractBinderC1076b.b() == null) {
                        obtain2.readException();
                        return obtain2.readString();
                    }
                    return AbstractBinderC1076b.b().b(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC1076b() {
            attachInterface(this, d);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new a(iBinder) : (b) queryLocalInterface;
        }

        public static boolean a(b bVar) {
            if (a.f40649a != null || bVar == null) {
                return false;
            }
            a.f40649a = bVar;
            return true;
        }

        public static b b() {
            return a.f40649a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(d);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(d);
                String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            } else if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(d);
                return true;
            } else {
                parcel.enforceInterface(d);
                String b2 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            }
        }
    }

    String a() throws RemoteException;

    String a(String str) throws RemoteException;

    String b(String str) throws RemoteException;
}
