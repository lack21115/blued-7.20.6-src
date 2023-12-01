package android.bluetooth;

import android.bluetooth.IBluetoothHidDeviceCallback;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IBluetoothHidDevice.class */
public interface IBluetoothHidDevice extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IBluetoothHidDevice$Stub.class */
    public static abstract class Stub extends Binder implements IBluetoothHidDevice {
        private static final String DESCRIPTOR = "android.bluetooth.IBluetoothHidDevice";
        static final int TRANSACTION_connect = 7;
        static final int TRANSACTION_disconnect = 8;
        static final int TRANSACTION_registerApp = 1;
        static final int TRANSACTION_replyReport = 4;
        static final int TRANSACTION_reportError = 5;
        static final int TRANSACTION_sendReport = 3;
        static final int TRANSACTION_unplug = 6;
        static final int TRANSACTION_unregisterApp = 2;

        /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IBluetoothHidDevice$Stub$Proxy.class */
        private static class Proxy implements IBluetoothHidDevice {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.bluetooth.IBluetoothHidDevice
            public boolean connect() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.bluetooth.IBluetoothHidDevice
            public boolean disconnect() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.bluetooth.IBluetoothHidDevice
            public boolean registerApp(BluetoothHidDeviceAppConfiguration bluetoothHidDeviceAppConfiguration, BluetoothHidDeviceAppSdpSettings bluetoothHidDeviceAppSdpSettings, BluetoothHidDeviceAppQosSettings bluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings bluetoothHidDeviceAppQosSettings2, IBluetoothHidDeviceCallback iBluetoothHidDeviceCallback) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothHidDeviceAppConfiguration != null) {
                        obtain.writeInt(1);
                        bluetoothHidDeviceAppConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bluetoothHidDeviceAppSdpSettings != null) {
                        obtain.writeInt(1);
                        bluetoothHidDeviceAppSdpSettings.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bluetoothHidDeviceAppQosSettings != null) {
                        obtain.writeInt(1);
                        bluetoothHidDeviceAppQosSettings.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bluetoothHidDeviceAppQosSettings2 != null) {
                        obtain.writeInt(1);
                        bluetoothHidDeviceAppQosSettings2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBluetoothHidDeviceCallback != null ? iBluetoothHidDeviceCallback.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.bluetooth.IBluetoothHidDevice
            public boolean replyReport(byte b, byte b2, byte[] bArr) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByte(b);
                    obtain.writeByte(b2);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.bluetooth.IBluetoothHidDevice
            public boolean reportError(byte b) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByte(b);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.bluetooth.IBluetoothHidDevice
            public boolean sendReport(int i, byte[] bArr) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.bluetooth.IBluetoothHidDevice
            public boolean unplug() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.bluetooth.IBluetoothHidDevice
            public boolean unregisterApp(BluetoothHidDeviceAppConfiguration bluetoothHidDeviceAppConfiguration) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bluetoothHidDeviceAppConfiguration != null) {
                        obtain.writeInt(1);
                        bluetoothHidDeviceAppConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBluetoothHidDevice asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IBluetoothHidDevice)) ? new Proxy(iBinder) : (IBluetoothHidDevice) queryLocalInterface;
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
                    boolean registerApp = registerApp(parcel.readInt() != 0 ? BluetoothHidDeviceAppConfiguration.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BluetoothHidDeviceAppSdpSettings.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BluetoothHidDeviceAppQosSettings.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? BluetoothHidDeviceAppQosSettings.CREATOR.createFromParcel(parcel) : null, IBluetoothHidDeviceCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(registerApp ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean unregisterApp = unregisterApp(parcel.readInt() != 0 ? BluetoothHidDeviceAppConfiguration.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    int i3 = 0;
                    if (unregisterApp) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean sendReport = sendReport(parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    int i4 = 0;
                    if (sendReport) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean replyReport = replyReport(parcel.readByte(), parcel.readByte(), parcel.createByteArray());
                    parcel2.writeNoException();
                    int i5 = 0;
                    if (replyReport) {
                        i5 = 1;
                    }
                    parcel2.writeInt(i5);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean reportError = reportError(parcel.readByte());
                    parcel2.writeNoException();
                    int i6 = 0;
                    if (reportError) {
                        i6 = 1;
                    }
                    parcel2.writeInt(i6);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean unplug = unplug();
                    parcel2.writeNoException();
                    int i7 = 0;
                    if (unplug) {
                        i7 = 1;
                    }
                    parcel2.writeInt(i7);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean connect = connect();
                    parcel2.writeNoException();
                    int i8 = 0;
                    if (connect) {
                        i8 = 1;
                    }
                    parcel2.writeInt(i8);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean disconnect = disconnect();
                    parcel2.writeNoException();
                    int i9 = 0;
                    if (disconnect) {
                        i9 = 1;
                    }
                    parcel2.writeInt(i9);
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean connect() throws RemoteException;

    boolean disconnect() throws RemoteException;

    boolean registerApp(BluetoothHidDeviceAppConfiguration bluetoothHidDeviceAppConfiguration, BluetoothHidDeviceAppSdpSettings bluetoothHidDeviceAppSdpSettings, BluetoothHidDeviceAppQosSettings bluetoothHidDeviceAppQosSettings, BluetoothHidDeviceAppQosSettings bluetoothHidDeviceAppQosSettings2, IBluetoothHidDeviceCallback iBluetoothHidDeviceCallback) throws RemoteException;

    boolean replyReport(byte b, byte b2, byte[] bArr) throws RemoteException;

    boolean reportError(byte b) throws RemoteException;

    boolean sendReport(int i, byte[] bArr) throws RemoteException;

    boolean unplug() throws RemoteException;

    boolean unregisterApp(BluetoothHidDeviceAppConfiguration bluetoothHidDeviceAppConfiguration) throws RemoteException;
}
