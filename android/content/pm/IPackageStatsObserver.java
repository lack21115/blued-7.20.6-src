package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/IPackageStatsObserver.class */
public interface IPackageStatsObserver extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/IPackageStatsObserver$Stub.class */
    public static abstract class Stub extends Binder implements IPackageStatsObserver {
        private static final String DESCRIPTOR = "android.content.pm.IPackageStatsObserver";
        static final int TRANSACTION_onGetStatsCompleted = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/content/pm/IPackageStatsObserver$Stub$Proxy.class */
        public static class Proxy implements IPackageStatsObserver {
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

            @Override // android.content.pm.IPackageStatsObserver
            public void onGetStatsCompleted(PackageStats packageStats, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (packageStats != null) {
                        obtain.writeInt(1);
                        packageStats.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPackageStatsObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPackageStatsObserver)) ? new Proxy(iBinder) : (IPackageStatsObserver) queryLocalInterface;
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
                    onGetStatsCompleted(parcel.readInt() != 0 ? PackageStats.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onGetStatsCompleted(PackageStats packageStats, boolean z) throws RemoteException;
}
