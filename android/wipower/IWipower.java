package android.wipower;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.wipower.IWipowerManagerCallback;

/* loaded from: source-4181928-dex2jar.jar:android/wipower/IWipower.class */
public interface IWipower extends IInterface {

    /* loaded from: source-4181928-dex2jar.jar:android/wipower/IWipower$Stub.class */
    public static abstract class Stub extends Binder implements IWipower {
        private static final String DESCRIPTOR = "android.wipower.IWipower";
        static final int TRANSACTION_enableAlert = 6;
        static final int TRANSACTION_enableData = 7;
        static final int TRANSACTION_enablePowerApply = 8;
        static final int TRANSACTION_getCurrentLimit_4 = 5;
        static final int TRANSACTION_getState_0 = 1;
        static final int TRANSACTION_registerCallback = 9;
        static final int TRANSACTION_setCurrentLimit_3 = 4;
        static final int TRANSACTION_startCharging_1 = 2;
        static final int TRANSACTION_stopCharging_2 = 3;
        static final int TRANSACTION_unregisterCallback = 10;

        /* loaded from: source-4181928-dex2jar.jar:android/wipower/IWipower$Stub$Proxy.class */
        private static class Proxy implements IWipower {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.wipower.IWipower
            public boolean enableAlert(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(6, obtain, obtain2, 0);
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

            @Override // android.wipower.IWipower
            public boolean enableData(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(7, obtain, obtain2, 0);
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

            @Override // android.wipower.IWipower
            public boolean enablePowerApply(boolean z, boolean z2, boolean z3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(z3 ? 1 : 0);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    boolean z4 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z4;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.wipower.IWipower
            public byte getCurrentLimit() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.wipower.IWipower
            public int getState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.wipower.IWipower
            public void registerCallback(IWipowerManagerCallback iWipowerManagerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iWipowerManagerCallback != null ? iWipowerManagerCallback.asBinder() : null);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.wipower.IWipower
            public boolean setCurrentLimit(byte b) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByte(b);
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

            @Override // android.wipower.IWipower
            public boolean startCharging() throws RemoteException {
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

            @Override // android.wipower.IWipower
            public boolean stopCharging() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
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

            @Override // android.wipower.IWipower
            public void unregisterCallback(IWipowerManagerCallback iWipowerManagerCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iWipowerManagerCallback != null ? iWipowerManagerCallback.asBinder() : null);
                    this.mRemote.transact(10, obtain, obtain2, 0);
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

        public static IWipower asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IWipower)) ? new Proxy(iBinder) : (IWipower) queryLocalInterface;
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
                    int state = getState();
                    parcel2.writeNoException();
                    parcel2.writeInt(state);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean startCharging = startCharging();
                    parcel2.writeNoException();
                    int i3 = 0;
                    if (startCharging) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean stopCharging = stopCharging();
                    parcel2.writeNoException();
                    int i4 = 0;
                    if (stopCharging) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean currentLimit = setCurrentLimit(parcel.readByte());
                    parcel2.writeNoException();
                    int i5 = 0;
                    if (currentLimit) {
                        i5 = 1;
                    }
                    parcel2.writeInt(i5);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    byte currentLimit2 = getCurrentLimit();
                    parcel2.writeNoException();
                    parcel2.writeByte(currentLimit2);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean enableAlert = enableAlert(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    int i6 = 0;
                    if (enableAlert) {
                        i6 = 1;
                    }
                    parcel2.writeInt(i6);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean enableData = enableData(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    int i7 = 0;
                    if (enableData) {
                        i7 = 1;
                    }
                    parcel2.writeInt(i7);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean enablePowerApply = enablePowerApply(parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    int i8 = 0;
                    if (enablePowerApply) {
                        i8 = 1;
                    }
                    parcel2.writeInt(i8);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerCallback(IWipowerManagerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterCallback(IWipowerManagerCallback.Stub.asInterface(parcel.readStrongBinder()));
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

    boolean enableAlert(boolean z) throws RemoteException;

    boolean enableData(boolean z) throws RemoteException;

    boolean enablePowerApply(boolean z, boolean z2, boolean z3) throws RemoteException;

    byte getCurrentLimit() throws RemoteException;

    int getState() throws RemoteException;

    void registerCallback(IWipowerManagerCallback iWipowerManagerCallback) throws RemoteException;

    boolean setCurrentLimit(byte b) throws RemoteException;

    boolean startCharging() throws RemoteException;

    boolean stopCharging() throws RemoteException;

    void unregisterCallback(IWipowerManagerCallback iWipowerManagerCallback) throws RemoteException;
}
