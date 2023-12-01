package com.getui.gtc.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/api/GtcIdCallback.class */
public interface GtcIdCallback extends IInterface {

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/api/GtcIdCallback$Default.class */
    public static class Default implements GtcIdCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.getui.gtc.api.GtcIdCallback
        public void onFailure(String str) throws RemoteException {
        }

        @Override // com.getui.gtc.api.GtcIdCallback
        public void onSuccess(String str) throws RemoteException {
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/api/GtcIdCallback$Stub.class */
    public static abstract class Stub extends Binder implements GtcIdCallback {
        private static final String DESCRIPTOR = "com.getui.gtc.api.GtcIdCallback";
        static final int TRANSACTION_onFailure = 1;
        static final int TRANSACTION_onSuccess = 2;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/api/GtcIdCallback$Stub$Proxy.class */
        public static class Proxy implements GtcIdCallback {
            public static GtcIdCallback sDefaultImpl;
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

            @Override // com.getui.gtc.api.GtcIdCallback
            public void onFailure(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onFailure(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.getui.gtc.api.GtcIdCallback
            public void onSuccess(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onSuccess(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static GtcIdCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof GtcIdCallback)) ? new Proxy(iBinder) : (GtcIdCallback) queryLocalInterface;
        }

        public static GtcIdCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(GtcIdCallback gtcIdCallback) {
            if (Proxy.sDefaultImpl == null) {
                if (gtcIdCallback != null) {
                    Proxy.sDefaultImpl = gtcIdCallback;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                onFailure(parcel.readString());
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                onSuccess(parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onFailure(String str) throws RemoteException;

    void onSuccess(String str) throws RemoteException;
}
