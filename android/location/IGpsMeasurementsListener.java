package android.location;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/location/IGpsMeasurementsListener.class */
public interface IGpsMeasurementsListener extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/location/IGpsMeasurementsListener$Stub.class */
    public static abstract class Stub extends Binder implements IGpsMeasurementsListener {
        private static final String DESCRIPTOR = "android.location.IGpsMeasurementsListener";
        static final int TRANSACTION_onGpsMeasurementsReceived_0 = 1;
        static final int TRANSACTION_onStatusChanged = 2;

        /* loaded from: source-9557208-dex2jar.jar:android/location/IGpsMeasurementsListener$Stub$Proxy.class */
        private static class Proxy implements IGpsMeasurementsListener {
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

            @Override // android.location.IGpsMeasurementsListener
            public void onGpsMeasurementsReceived(GpsMeasurementsEvent gpsMeasurementsEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (gpsMeasurementsEvent != null) {
                        obtain.writeInt(1);
                        gpsMeasurementsEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.location.IGpsMeasurementsListener
            public void onStatusChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IGpsMeasurementsListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGpsMeasurementsListener)) ? new Proxy(iBinder) : (IGpsMeasurementsListener) queryLocalInterface;
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
                    onGpsMeasurementsReceived(parcel.readInt() != 0 ? GpsMeasurementsEvent.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onStatusChanged(parcel.readInt());
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onGpsMeasurementsReceived(GpsMeasurementsEvent gpsMeasurementsEvent) throws RemoteException;

    void onStatusChanged(int i) throws RemoteException;
}
