package android.os;

/* loaded from: source-9557208-dex2jar.jar:android/os/IBatteryPropertiesListener.class */
public interface IBatteryPropertiesListener extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/os/IBatteryPropertiesListener$Stub.class */
    public static abstract class Stub extends Binder implements IBatteryPropertiesListener {
        private static final String DESCRIPTOR = "android.os.IBatteryPropertiesListener";
        static final int TRANSACTION_batteryPropertiesChanged_0 = 1;

        /* loaded from: source-9557208-dex2jar.jar:android/os/IBatteryPropertiesListener$Stub$Proxy.class */
        private static class Proxy implements IBatteryPropertiesListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.os.IBatteryPropertiesListener
            public void batteryPropertiesChanged(BatteryProperties batteryProperties) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (batteryProperties != null) {
                        obtain.writeInt(1);
                        batteryProperties.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBatteryPropertiesListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IBatteryPropertiesListener)) ? new Proxy(iBinder) : (IBatteryPropertiesListener) queryLocalInterface;
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
                    batteryPropertiesChanged(parcel.readInt() != 0 ? BatteryProperties.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void batteryPropertiesChanged(BatteryProperties batteryProperties) throws RemoteException;
}
