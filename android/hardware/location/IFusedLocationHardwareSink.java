package android.hardware.location;

import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/location/IFusedLocationHardwareSink.class */
public interface IFusedLocationHardwareSink extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/location/IFusedLocationHardwareSink$Stub.class */
    public static abstract class Stub extends Binder implements IFusedLocationHardwareSink {
        private static final String DESCRIPTOR = "android.hardware.location.IFusedLocationHardwareSink";
        static final int TRANSACTION_onDiagnosticDataAvailable = 2;
        static final int TRANSACTION_onLocationAvailable = 1;

        /* loaded from: source-9557208-dex2jar.jar:android/hardware/location/IFusedLocationHardwareSink$Stub$Proxy.class */
        private static class Proxy implements IFusedLocationHardwareSink {
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

            @Override // android.hardware.location.IFusedLocationHardwareSink
            public void onDiagnosticDataAvailable(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.hardware.location.IFusedLocationHardwareSink
            public void onLocationAvailable(Location[] locationArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeTypedArray(locationArr, 0);
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

        public static IFusedLocationHardwareSink asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IFusedLocationHardwareSink)) ? new Proxy(iBinder) : (IFusedLocationHardwareSink) queryLocalInterface;
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
                    onLocationAvailable((Location[]) parcel.createTypedArray(Location.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDiagnosticDataAvailable(parcel.readString());
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

    void onDiagnosticDataAvailable(String str) throws RemoteException;

    void onLocationAvailable(Location[] locationArr) throws RemoteException;
}
