package com.android.internal.policy;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/policy/IFaceLockCallback.class */
public interface IFaceLockCallback extends IInterface {

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/policy/IFaceLockCallback$Stub.class */
    public static abstract class Stub extends Binder implements IFaceLockCallback {
        private static final String DESCRIPTOR = "com.android.internal.policy.IFaceLockCallback";
        static final int TRANSACTION_cancel_1 = 2;
        static final int TRANSACTION_pokeWakelock = 4;
        static final int TRANSACTION_reportFailedAttempt = 3;
        static final int TRANSACTION_unlock_0 = 1;

        /* loaded from: source-4181928-dex2jar.jar:com/android/internal/policy/IFaceLockCallback$Stub$Proxy.class */
        private static class Proxy implements IFaceLockCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.android.internal.policy.IFaceLockCallback
            public void cancel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.android.internal.policy.IFaceLockCallback
            public void pokeWakelock(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.android.internal.policy.IFaceLockCallback
            public void reportFailedAttempt() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // com.android.internal.policy.IFaceLockCallback
            public void unlock() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFaceLockCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IFaceLockCallback)) ? new Proxy(iBinder) : (IFaceLockCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    unlock();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancel();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    reportFailedAttempt();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    pokeWakelock(parcel.readInt());
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void cancel() throws RemoteException;

    void pokeWakelock(int i) throws RemoteException;

    void reportFailedAttempt() throws RemoteException;

    void unlock() throws RemoteException;
}
