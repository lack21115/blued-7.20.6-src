package android.bluetooth;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IBluetoothHeadsetPhone.class */
public interface IBluetoothHeadsetPhone extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IBluetoothHeadsetPhone$Stub.class */
    public static abstract class Stub extends Binder implements IBluetoothHeadsetPhone {
        private static final String DESCRIPTOR = "android.bluetooth.IBluetoothHeadsetPhone";
        static final int TRANSACTION_answerCall_0 = 1;
        static final int TRANSACTION_cdmaSetSecondCallState = 11;
        static final int TRANSACTION_cdmaSwapSecondCallState = 10;
        static final int TRANSACTION_getNetworkOperator = 5;
        static final int TRANSACTION_getSubscriberNumber = 6;
        static final int TRANSACTION_hangupCall_1 = 2;
        static final int TRANSACTION_listCurrentCalls = 7;
        static final int TRANSACTION_processChld = 4;
        static final int TRANSACTION_queryPhoneState = 8;
        static final int TRANSACTION_sendDtmf = 3;
        static final int TRANSACTION_updateBtHandsfreeAfterRadioTechnologyChange = 9;

        /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/IBluetoothHeadsetPhone$Stub$Proxy.class */
        private static class Proxy implements IBluetoothHeadsetPhone {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.bluetooth.IBluetoothHeadsetPhone
            public boolean answerCall() throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.bluetooth.IBluetoothHeadsetPhone
            public void cdmaSetSecondCallState(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IBluetoothHeadsetPhone
            public void cdmaSwapSecondCallState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.bluetooth.IBluetoothHeadsetPhone
            public String getNetworkOperator() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IBluetoothHeadsetPhone
            public String getSubscriberNumber() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.bluetooth.IBluetoothHeadsetPhone
            public boolean hangupCall() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
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

            @Override // android.bluetooth.IBluetoothHeadsetPhone
            public boolean listCurrentCalls() throws RemoteException {
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

            @Override // android.bluetooth.IBluetoothHeadsetPhone
            public boolean processChld(int i) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
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

            @Override // android.bluetooth.IBluetoothHeadsetPhone
            public boolean queryPhoneState() throws RemoteException {
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

            @Override // android.bluetooth.IBluetoothHeadsetPhone
            public boolean sendDtmf(int i) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
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

            @Override // android.bluetooth.IBluetoothHeadsetPhone
            public void updateBtHandsfreeAfterRadioTechnologyChange() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, obtain2, 0);
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

        public static IBluetoothHeadsetPhone asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IBluetoothHeadsetPhone)) ? new Proxy(iBinder) : (IBluetoothHeadsetPhone) queryLocalInterface;
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
                    boolean answerCall = answerCall();
                    parcel2.writeNoException();
                    int i3 = 0;
                    if (answerCall) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean hangupCall = hangupCall();
                    parcel2.writeNoException();
                    int i4 = 0;
                    if (hangupCall) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean sendDtmf = sendDtmf(parcel.readInt());
                    parcel2.writeNoException();
                    int i5 = 0;
                    if (sendDtmf) {
                        i5 = 1;
                    }
                    parcel2.writeInt(i5);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean processChld = processChld(parcel.readInt());
                    parcel2.writeNoException();
                    int i6 = 0;
                    if (processChld) {
                        i6 = 1;
                    }
                    parcel2.writeInt(i6);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    String networkOperator = getNetworkOperator();
                    parcel2.writeNoException();
                    parcel2.writeString(networkOperator);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    String subscriberNumber = getSubscriberNumber();
                    parcel2.writeNoException();
                    parcel2.writeString(subscriberNumber);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean listCurrentCalls = listCurrentCalls();
                    parcel2.writeNoException();
                    int i7 = 0;
                    if (listCurrentCalls) {
                        i7 = 1;
                    }
                    parcel2.writeInt(i7);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean queryPhoneState = queryPhoneState();
                    parcel2.writeNoException();
                    int i8 = 0;
                    if (queryPhoneState) {
                        i8 = 1;
                    }
                    parcel2.writeInt(i8);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateBtHandsfreeAfterRadioTechnologyChange();
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    cdmaSwapSecondCallState();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    cdmaSetSecondCallState(parcel.readInt() != 0);
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

    boolean answerCall() throws RemoteException;

    void cdmaSetSecondCallState(boolean z) throws RemoteException;

    void cdmaSwapSecondCallState() throws RemoteException;

    String getNetworkOperator() throws RemoteException;

    String getSubscriberNumber() throws RemoteException;

    boolean hangupCall() throws RemoteException;

    boolean listCurrentCalls() throws RemoteException;

    boolean processChld(int i) throws RemoteException;

    boolean queryPhoneState() throws RemoteException;

    boolean sendDtmf(int i) throws RemoteException;

    void updateBtHandsfreeAfterRadioTechnologyChange() throws RemoteException;
}
