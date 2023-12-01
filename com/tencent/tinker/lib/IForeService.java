package com.tencent.tinker.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/IForeService.class */
public interface IForeService extends IInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/IForeService$Stub.class */
    public static abstract class Stub extends Binder implements IForeService {
        private static final String DESCRIPTOR = "com.tencent.tinker.lib.IForeService";
        static final int TRANSACTION_startme = 1;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/lib/IForeService$Stub$Proxy.class */
        static class Proxy implements IForeService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.tinker.lib.IForeService
            public void startme() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IForeService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IForeService)) ? new Proxy(iBinder) : (IForeService) queryLocalInterface;
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
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            startme();
            parcel2.writeNoException();
            return true;
        }
    }

    void startme() throws RemoteException;
}
