package android.service.fingerprint;

import android.hardware.fingerprint.Fingerprint;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.service.fingerprint.IFingerprintServiceReceiver;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/service/fingerprint/IFingerprintService.class */
public interface IFingerprintService extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/service/fingerprint/IFingerprintService$Stub.class */
    public static abstract class Stub extends Binder implements IFingerprintService {
        private static final String DESCRIPTOR = "android.service.fingerprint.IFingerprintService";
        static final int TRANSACTION_authenticate = 1;
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_enroll = 2;
        static final int TRANSACTION_getEnrolledFingerprints = 8;
        static final int TRANSACTION_getNumEnrollmentSteps = 10;
        static final int TRANSACTION_getState = 11;
        static final int TRANSACTION_remove = 4;
        static final int TRANSACTION_setFingerprintName = 9;
        static final int TRANSACTION_setWakeup = 7;
        static final int TRANSACTION_startListening = 5;
        static final int TRANSACTION_stopListening = 6;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/service/fingerprint/IFingerprintService$Stub$Proxy.class */
        public static class Proxy implements IFingerprintService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.service.fingerprint.IFingerprintService
            public void authenticate(IBinder iBinder, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.service.fingerprint.IFingerprintService
            public void cancel(IBinder iBinder, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.service.fingerprint.IFingerprintService
            public void enroll(IBinder iBinder, long j, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.service.fingerprint.IFingerprintService
            public List<Fingerprint> getEnrolledFingerprints(IBinder iBinder, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(Fingerprint.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.service.fingerprint.IFingerprintService
            public int getNumEnrollmentSteps(IBinder iBinder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.service.fingerprint.IFingerprintService
            public int getState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.service.fingerprint.IFingerprintService
            public void remove(IBinder iBinder, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.service.fingerprint.IFingerprintService
            public boolean setFingerprintName(IBinder iBinder, int i, String str, int i2) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
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

            @Override // android.service.fingerprint.IFingerprintService
            public void setWakeup(IBinder iBinder, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.service.fingerprint.IFingerprintService
            public void startListening(IBinder iBinder, IFingerprintServiceReceiver iFingerprintServiceReceiver, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    IBinder iBinder2 = null;
                    if (iFingerprintServiceReceiver != null) {
                        iBinder2 = iFingerprintServiceReceiver.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder2);
                    obtain.writeInt(i);
                    this.mRemote.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.service.fingerprint.IFingerprintService
            public void stopListening(IBinder iBinder, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.mRemote.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IFingerprintService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IFingerprintService)) ? new Proxy(iBinder) : (IFingerprintService) queryLocalInterface;
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
                    authenticate(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    enroll(parcel.readStrongBinder(), parcel.readLong(), parcel.readInt());
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    cancel(parcel.readStrongBinder(), parcel.readInt());
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    remove(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt());
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    startListening(parcel.readStrongBinder(), IFingerprintServiceReceiver.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    stopListening(parcel.readStrongBinder(), parcel.readInt());
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    setWakeup(parcel.readStrongBinder(), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    List<Fingerprint> enrolledFingerprints = getEnrolledFingerprints(parcel.readStrongBinder(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeTypedList(enrolledFingerprints);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean fingerprintName = setFingerprintName(parcel.readStrongBinder(), parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    int i3 = 0;
                    if (fingerprintName) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    int numEnrollmentSteps = getNumEnrollmentSteps(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    parcel2.writeInt(numEnrollmentSteps);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    int state = getState();
                    parcel2.writeNoException();
                    parcel2.writeInt(state);
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void authenticate(IBinder iBinder, int i, boolean z) throws RemoteException;

    void cancel(IBinder iBinder, int i) throws RemoteException;

    void enroll(IBinder iBinder, long j, int i) throws RemoteException;

    List<Fingerprint> getEnrolledFingerprints(IBinder iBinder, int i) throws RemoteException;

    int getNumEnrollmentSteps(IBinder iBinder) throws RemoteException;

    int getState() throws RemoteException;

    void remove(IBinder iBinder, int i, int i2) throws RemoteException;

    boolean setFingerprintName(IBinder iBinder, int i, String str, int i2) throws RemoteException;

    void setWakeup(IBinder iBinder, int i, boolean z) throws RemoteException;

    void startListening(IBinder iBinder, IFingerprintServiceReceiver iFingerprintServiceReceiver, int i) throws RemoteException;

    void stopListening(IBinder iBinder, int i) throws RemoteException;
}
