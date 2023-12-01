package android.os;

/* loaded from: source-9557208-dex2jar.jar:android/os/ICancellationSignal.class */
public interface ICancellationSignal extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/os/ICancellationSignal$Stub.class */
    public static abstract class Stub extends Binder implements ICancellationSignal {
        private static final String DESCRIPTOR = "android.os.ICancellationSignal";
        static final int TRANSACTION_cancel_0 = 1;

        /* loaded from: source-9557208-dex2jar.jar:android/os/ICancellationSignal$Stub$Proxy.class */
        private static class Proxy implements ICancellationSignal {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.os.ICancellationSignal
            public void cancel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
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

        public static ICancellationSignal asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICancellationSignal)) ? new Proxy(iBinder) : (ICancellationSignal) queryLocalInterface;
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
                    cancel();
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void cancel() throws RemoteException;
}
