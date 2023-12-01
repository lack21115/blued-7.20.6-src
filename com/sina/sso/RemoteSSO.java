package com.sina.sso;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-8303388-dex2jar.jar:com/sina/sso/RemoteSSO.class */
public interface RemoteSSO extends IInterface {

    /* loaded from: source-8303388-dex2jar.jar:com/sina/sso/RemoteSSO$Stub.class */
    public static abstract class Stub extends Binder implements RemoteSSO {
        private static final String DESCRIPTOR = "com.sina.sso.RemoteSSO";
        static final int TRANSACTION_getActivityName = 2;
        static final int TRANSACTION_getLoginUserName = 3;
        static final int TRANSACTION_getPackageName = 1;

        /* loaded from: source-8303388-dex2jar.jar:com/sina/sso/RemoteSSO$Stub$Proxy.class */
        static class Proxy implements RemoteSSO {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.sina.sso.RemoteSSO
            public String getActivityName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.sina.sso.RemoteSSO
            public String getLoginUserName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.sina.sso.RemoteSSO
            public String getPackageName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static RemoteSSO asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof RemoteSSO)) ? new Proxy(iBinder) : (RemoteSSO) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                String packageName = getPackageName();
                parcel2.writeNoException();
                parcel2.writeString(packageName);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                String activityName = getActivityName();
                parcel2.writeNoException();
                parcel2.writeString(activityName);
                return true;
            } else if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                String loginUserName = getLoginUserName();
                parcel2.writeNoException();
                parcel2.writeString(loginUserName);
                return true;
            }
        }
    }

    String getActivityName() throws RemoteException;

    String getLoginUserName() throws RemoteException;

    String getPackageName() throws RemoteException;
}
