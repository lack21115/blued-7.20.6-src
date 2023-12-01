package android.nfc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/nfc/INfcTag.class */
public interface INfcTag extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/nfc/INfcTag$Stub.class */
    public static abstract class Stub extends Binder implements INfcTag {
        private static final String DESCRIPTOR = "android.nfc.INfcTag";
        static final int TRANSACTION_canMakeReadOnly = 17;
        static final int TRANSACTION_close = 1;
        static final int TRANSACTION_connect = 2;
        static final int TRANSACTION_formatNdef = 12;
        static final int TRANSACTION_getExtendedLengthApdusSupported = 19;
        static final int TRANSACTION_getMaxTransceiveLength = 18;
        static final int TRANSACTION_getTechList = 4;
        static final int TRANSACTION_getTimeout = 15;
        static final int TRANSACTION_isNdef = 5;
        static final int TRANSACTION_isPresent = 6;
        static final int TRANSACTION_ndefIsWritable = 11;
        static final int TRANSACTION_ndefMakeReadOnly = 10;
        static final int TRANSACTION_ndefRead = 8;
        static final int TRANSACTION_ndefWrite = 9;
        static final int TRANSACTION_reconnect = 3;
        static final int TRANSACTION_rediscover = 13;
        static final int TRANSACTION_resetTimeouts = 16;
        static final int TRANSACTION_setTimeout = 14;
        static final int TRANSACTION_transceive = 7;

        /* loaded from: source-9557208-dex2jar.jar:android/nfc/INfcTag$Stub$Proxy.class */
        private static class Proxy implements INfcTag {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.nfc.INfcTag
            public boolean canMakeReadOnly(int i) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(17, obtain, obtain2, 0);
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

            @Override // android.nfc.INfcTag
            public int close(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.nfc.INfcTag
            public int connect(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.nfc.INfcTag
            public int formatNdef(int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.nfc.INfcTag
            public boolean getExtendedLengthApdusSupported() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(19, obtain, obtain2, 0);
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

            @Override // android.nfc.INfcTag
            public int getMaxTransceiveLength(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.nfc.INfcTag
            public int[] getTechList(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createIntArray();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.nfc.INfcTag
            public int getTimeout(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.nfc.INfcTag
            public boolean isNdef(int i) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
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

            @Override // android.nfc.INfcTag
            public boolean isPresent(int i) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
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

            @Override // android.nfc.INfcTag
            public boolean ndefIsWritable(int i) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(11, obtain, obtain2, 0);
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

            @Override // android.nfc.INfcTag
            public int ndefMakeReadOnly(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.nfc.INfcTag
            public NdefMessage ndefRead(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    NdefMessage createFromParcel = obtain2.readInt() != 0 ? NdefMessage.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.nfc.INfcTag
            public int ndefWrite(int i, NdefMessage ndefMessage) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (ndefMessage != null) {
                        obtain.writeInt(1);
                        ndefMessage.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.nfc.INfcTag
            public int reconnect(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.nfc.INfcTag
            public Tag rediscover(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    Tag createFromParcel = obtain2.readInt() != 0 ? Tag.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.nfc.INfcTag
            public void resetTimeouts() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.nfc.INfcTag
            public int setTimeout(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.nfc.INfcTag
            public TransceiveResult transceive(int i, byte[] bArr, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    int i2 = 0;
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    TransceiveResult createFromParcel = obtain2.readInt() != 0 ? TransceiveResult.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
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

        public static INfcTag asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof INfcTag)) ? new Proxy(iBinder) : (INfcTag) queryLocalInterface;
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
                    int close = close(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(close);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    int connect = connect(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(connect);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int reconnect = reconnect(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(reconnect);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int[] techList = getTechList(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeIntArray(techList);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isNdef = isNdef(parcel.readInt());
                    parcel2.writeNoException();
                    int i3 = 0;
                    if (isNdef) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isPresent = isPresent(parcel.readInt());
                    parcel2.writeNoException();
                    int i4 = 0;
                    if (isPresent) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    TransceiveResult transceive = transceive(parcel.readInt(), parcel.createByteArray(), parcel.readInt() != 0);
                    parcel2.writeNoException();
                    if (transceive == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    transceive.writeToParcel(parcel2, 1);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    NdefMessage ndefRead = ndefRead(parcel.readInt());
                    parcel2.writeNoException();
                    if (ndefRead == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    ndefRead.writeToParcel(parcel2, 1);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    int ndefWrite = ndefWrite(parcel.readInt(), parcel.readInt() != 0 ? NdefMessage.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(ndefWrite);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    int ndefMakeReadOnly = ndefMakeReadOnly(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(ndefMakeReadOnly);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean ndefIsWritable = ndefIsWritable(parcel.readInt());
                    parcel2.writeNoException();
                    int i5 = 0;
                    if (ndefIsWritable) {
                        i5 = 1;
                    }
                    parcel2.writeInt(i5);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    int formatNdef = formatNdef(parcel.readInt(), parcel.createByteArray());
                    parcel2.writeNoException();
                    parcel2.writeInt(formatNdef);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    Tag rediscover = rediscover(parcel.readInt());
                    parcel2.writeNoException();
                    if (rediscover == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    rediscover.writeToParcel(parcel2, 1);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    int timeout = setTimeout(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(timeout);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    int timeout2 = getTimeout(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(timeout2);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    resetTimeouts();
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean canMakeReadOnly = canMakeReadOnly(parcel.readInt());
                    parcel2.writeNoException();
                    int i6 = 0;
                    if (canMakeReadOnly) {
                        i6 = 1;
                    }
                    parcel2.writeInt(i6);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    int maxTransceiveLength = getMaxTransceiveLength(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(maxTransceiveLength);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean extendedLengthApdusSupported = getExtendedLengthApdusSupported();
                    parcel2.writeNoException();
                    int i7 = 0;
                    if (extendedLengthApdusSupported) {
                        i7 = 1;
                    }
                    parcel2.writeInt(i7);
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean canMakeReadOnly(int i) throws RemoteException;

    int close(int i) throws RemoteException;

    int connect(int i, int i2) throws RemoteException;

    int formatNdef(int i, byte[] bArr) throws RemoteException;

    boolean getExtendedLengthApdusSupported() throws RemoteException;

    int getMaxTransceiveLength(int i) throws RemoteException;

    int[] getTechList(int i) throws RemoteException;

    int getTimeout(int i) throws RemoteException;

    boolean isNdef(int i) throws RemoteException;

    boolean isPresent(int i) throws RemoteException;

    boolean ndefIsWritable(int i) throws RemoteException;

    int ndefMakeReadOnly(int i) throws RemoteException;

    NdefMessage ndefRead(int i) throws RemoteException;

    int ndefWrite(int i, NdefMessage ndefMessage) throws RemoteException;

    int reconnect(int i) throws RemoteException;

    Tag rediscover(int i) throws RemoteException;

    void resetTimeouts() throws RemoteException;

    int setTimeout(int i, int i2) throws RemoteException;

    TransceiveResult transceive(int i, byte[] bArr, boolean z) throws RemoteException;
}
