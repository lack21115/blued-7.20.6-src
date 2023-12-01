package android.location;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/location/IGpsNavigationMessageListener.class */
public interface IGpsNavigationMessageListener extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/location/IGpsNavigationMessageListener$Stub.class */
    public static abstract class Stub extends Binder implements IGpsNavigationMessageListener {
        private static final String DESCRIPTOR = "android.location.IGpsNavigationMessageListener";
        static final int TRANSACTION_onGpsNavigationMessageReceived_0 = 1;
        static final int TRANSACTION_onStatusChanged = 2;

        /* loaded from: source-9557208-dex2jar.jar:android/location/IGpsNavigationMessageListener$Stub$Proxy.class */
        private static class Proxy implements IGpsNavigationMessageListener {
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

            @Override // android.location.IGpsNavigationMessageListener
            public void onGpsNavigationMessageReceived(GpsNavigationMessageEvent gpsNavigationMessageEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (gpsNavigationMessageEvent != null) {
                        obtain.writeInt(1);
                        gpsNavigationMessageEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.location.IGpsNavigationMessageListener
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

        public static IGpsNavigationMessageListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGpsNavigationMessageListener)) ? new Proxy(iBinder) : (IGpsNavigationMessageListener) queryLocalInterface;
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
                    onGpsNavigationMessageReceived(parcel.readInt() != 0 ? GpsNavigationMessageEvent.CREATOR.createFromParcel(parcel) : null);
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

    void onGpsNavigationMessageReceived(GpsNavigationMessageEvent gpsNavigationMessageEvent) throws RemoteException;

    void onStatusChanged(int i) throws RemoteException;
}
