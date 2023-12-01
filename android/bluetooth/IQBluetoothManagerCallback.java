package android.bluetooth;

import android.bluetooth.IQBluetooth;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IQBluetoothManagerCallback.class */
public interface IQBluetoothManagerCallback extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IQBluetoothManagerCallback$Stub.class */
    public static abstract class Stub extends Binder implements IQBluetoothManagerCallback {
        private static final String DESCRIPTOR = "android.bluetooth.IQBluetoothManagerCallback";
        static final int TRANSACTION_onQBluetoothServiceDown_1 = 2;
        static final int TRANSACTION_onQBluetoothServiceUp_0 = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IQBluetoothManagerCallback$Stub$Proxy.class */
        public static class Proxy implements IQBluetoothManagerCallback {
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

            @Override // android.bluetooth.IQBluetoothManagerCallback
            public void onQBluetoothServiceDown() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IQBluetoothManagerCallback
            public void onQBluetoothServiceUp(IQBluetooth iQBluetooth) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iQBluetooth != null ? iQBluetooth.asBinder() : null);
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

        public static IQBluetoothManagerCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IQBluetoothManagerCallback)) ? new Proxy(iBinder) : (IQBluetoothManagerCallback) queryLocalInterface;
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
                    onQBluetoothServiceUp(IQBluetooth.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onQBluetoothServiceDown();
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

    void onQBluetoothServiceDown() throws RemoteException;

    void onQBluetoothServiceUp(IQBluetooth iQBluetooth) throws RemoteException;
}
