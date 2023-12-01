package android.print;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/print/IPrintDocumentAdapterObserver.class */
public interface IPrintDocumentAdapterObserver extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/print/IPrintDocumentAdapterObserver$Stub.class */
    public static abstract class Stub extends Binder implements IPrintDocumentAdapterObserver {
        private static final String DESCRIPTOR = "android.print.IPrintDocumentAdapterObserver";
        static final int TRANSACTION_onDestroy_0 = 1;

        /* loaded from: source-9557208-dex2jar.jar:android/print/IPrintDocumentAdapterObserver$Stub$Proxy.class */
        private static class Proxy implements IPrintDocumentAdapterObserver {
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

            @Override // android.print.IPrintDocumentAdapterObserver
            public void onDestroy() throws RemoteException {
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

        public static IPrintDocumentAdapterObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPrintDocumentAdapterObserver)) ? new Proxy(iBinder) : (IPrintDocumentAdapterObserver) queryLocalInterface;
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
                    onDestroy();
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onDestroy() throws RemoteException;
}
