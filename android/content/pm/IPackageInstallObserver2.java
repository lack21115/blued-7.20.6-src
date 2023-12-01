package android.content.pm;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/IPackageInstallObserver2.class */
public interface IPackageInstallObserver2 extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/IPackageInstallObserver2$Stub.class */
    public static abstract class Stub extends Binder implements IPackageInstallObserver2 {
        private static final String DESCRIPTOR = "android.content.pm.IPackageInstallObserver2";
        static final int TRANSACTION_onPackageInstalled_1 = 2;
        static final int TRANSACTION_onUserActionRequired = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/content/pm/IPackageInstallObserver2$Stub$Proxy.class */
        public static class Proxy implements IPackageInstallObserver2 {
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

            @Override // android.content.pm.IPackageInstallObserver2
            public void onPackageInstalled(String str, int i, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.content.pm.IPackageInstallObserver2
            public void onUserActionRequired(Intent intent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPackageInstallObserver2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPackageInstallObserver2)) ? new Proxy(iBinder) : (IPackageInstallObserver2) queryLocalInterface;
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
                    onUserActionRequired(parcel.readInt() != 0 ? Intent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPackageInstalled(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onPackageInstalled(String str, int i, String str2, Bundle bundle) throws RemoteException;

    void onUserActionRequired(Intent intent) throws RemoteException;
}
