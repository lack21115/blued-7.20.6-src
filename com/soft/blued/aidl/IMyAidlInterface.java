package com.soft.blued.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-7994992-dex2jar.jar:com/soft/blued/aidl/IMyAidlInterface.class */
public interface IMyAidlInterface extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/soft/blued/aidl/IMyAidlInterface$Default.class */
    public static class Default implements IMyAidlInterface {
        @Override // com.soft.blued.aidl.IMyAidlInterface
        public String a() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/soft/blued/aidl/IMyAidlInterface$Stub.class */
    public static abstract class Stub extends Binder implements IMyAidlInterface {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/soft/blued/aidl/IMyAidlInterface$Stub$Proxy.class */
        public static class Proxy implements IMyAidlInterface {

            /* renamed from: a  reason: collision with root package name */
            public static IMyAidlInterface f14551a;
            private IBinder b;

            @Override // com.soft.blued.aidl.IMyAidlInterface
            public String a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.soft.blued.aidl.IMyAidlInterface");
                    if (this.b.transact(1, obtain, obtain2, 0) || Stub.b() == null) {
                        obtain2.readException();
                        return obtain2.readString();
                    }
                    return Stub.b().a();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }
        }

        public Stub() {
            attachInterface(this, "com.soft.blued.aidl.IMyAidlInterface");
        }

        public static IMyAidlInterface b() {
            return Proxy.f14551a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.soft.blued.aidl.IMyAidlInterface");
                return true;
            }
            parcel.enforceInterface("com.soft.blued.aidl.IMyAidlInterface");
            String a2 = a();
            parcel2.writeNoException();
            parcel2.writeString(a2);
            return true;
        }
    }

    String a() throws RemoteException;
}
