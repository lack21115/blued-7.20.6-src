package android.bluetooth;

import android.bluetooth.IQBluetoothAdapterCallback;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IQBluetooth.class */
public interface IQBluetooth extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IQBluetooth$Stub.class */
    public static abstract class Stub extends Binder implements IQBluetooth {
        private static final String DESCRIPTOR = "android.bluetooth.IQBluetooth";
        static final int TRANSACTION_enableLeLppRssiMonitor = 4;
        static final int TRANSACTION_readLeLppRssiThreshold = 3;
        static final int TRANSACTION_registerLeLppRssiMonitorClient = 1;
        static final int TRANSACTION_writeLeLppRssiThreshold = 2;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IQBluetooth$Stub$Proxy.class */
        public static class Proxy implements IQBluetooth {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.bluetooth.IQBluetooth
            public void enableLeLppRssiMonitor(String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.bluetooth.IQBluetooth
            public void readLeLppRssiThreshold(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IQBluetooth
            public boolean registerLeLppRssiMonitorClient(String str, IQBluetoothAdapterCallback iQBluetoothAdapterCallback, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iQBluetoothAdapterCallback != null ? iQBluetoothAdapterCallback.asBinder() : null);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    boolean z2 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.bluetooth.IQBluetooth
            public void writeLeLppRssiThreshold(String str, byte b, byte b2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeByte(b);
                    obtain.writeByte(b2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
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

        public static IQBluetooth asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IQBluetooth)) ? new Proxy(iBinder) : (IQBluetooth) queryLocalInterface;
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
                    boolean registerLeLppRssiMonitorClient = registerLeLppRssiMonitorClient(parcel.readString(), IQBluetoothAdapterCallback.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    int i3 = 0;
                    if (registerLeLppRssiMonitorClient) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    writeLeLppRssiThreshold(parcel.readString(), parcel.readByte(), parcel.readByte());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    readLeLppRssiThreshold(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    enableLeLppRssiMonitor(parcel.readString(), parcel.readInt() != 0);
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

    void enableLeLppRssiMonitor(String str, boolean z) throws RemoteException;

    void readLeLppRssiThreshold(String str) throws RemoteException;

    boolean registerLeLppRssiMonitorClient(String str, IQBluetoothAdapterCallback iQBluetoothAdapterCallback, boolean z) throws RemoteException;

    void writeLeLppRssiThreshold(String str, byte b, byte b2) throws RemoteException;
}
