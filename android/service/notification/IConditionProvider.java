package android.service.notification;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/service/notification/IConditionProvider.class */
public interface IConditionProvider extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/service/notification/IConditionProvider$Stub.class */
    public static abstract class Stub extends Binder implements IConditionProvider {
        private static final String DESCRIPTOR = "android.service.notification.IConditionProvider";
        static final int TRANSACTION_onConnected = 1;
        static final int TRANSACTION_onRequestConditions = 2;
        static final int TRANSACTION_onSubscribe = 3;
        static final int TRANSACTION_onUnsubscribe = 4;

        /* loaded from: source-9557208-dex2jar.jar:android/service/notification/IConditionProvider$Stub$Proxy.class */
        private static class Proxy implements IConditionProvider {
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

            @Override // android.service.notification.IConditionProvider
            public void onConnected() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.service.notification.IConditionProvider
            public void onRequestConditions(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.service.notification.IConditionProvider
            public void onSubscribe(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.service.notification.IConditionProvider
            public void onUnsubscribe(Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IConditionProvider asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IConditionProvider)) ? new Proxy(iBinder) : (IConditionProvider) queryLocalInterface;
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
                    onConnected();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onRequestConditions(parcel.readInt());
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSubscribe(parcel.readInt() != 0 ? Uri.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onUnsubscribe(parcel.readInt() != 0 ? Uri.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onConnected() throws RemoteException;

    void onRequestConditions(int i) throws RemoteException;

    void onSubscribe(Uri uri) throws RemoteException;

    void onUnsubscribe(Uri uri) throws RemoteException;
}
