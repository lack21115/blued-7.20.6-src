package android.location;

import android.hardware.location.IFusedLocationHardware;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/location/IFusedProvider.class */
public interface IFusedProvider extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/location/IFusedProvider$Stub.class */
    public static abstract class Stub extends Binder implements IFusedProvider {
        private static final String DESCRIPTOR = "android.location.IFusedProvider";
        static final int TRANSACTION_onFusedLocationHardwareChange = 1;

        /* loaded from: source-9557208-dex2jar.jar:android/location/IFusedProvider$Stub$Proxy.class */
        private static class Proxy implements IFusedProvider {
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

            @Override // android.location.IFusedProvider
            public void onFusedLocationHardwareChange(IFusedLocationHardware iFusedLocationHardware) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iFusedLocationHardware != null ? iFusedLocationHardware.asBinder() : null);
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

        public static IFusedProvider asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IFusedProvider)) ? new Proxy(iBinder) : (IFusedProvider) queryLocalInterface;
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
                    onFusedLocationHardwareChange(IFusedLocationHardware.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onFusedLocationHardwareChange(IFusedLocationHardware iFusedLocationHardware) throws RemoteException;
}
