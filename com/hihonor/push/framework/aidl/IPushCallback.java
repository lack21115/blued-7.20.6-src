package com.hihonor.push.framework.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/framework/aidl/IPushCallback.class */
public interface IPushCallback extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/framework/aidl/IPushCallback$Default.class */
    public static class Default implements IPushCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.hihonor.push.framework.aidl.IPushCallback
        public void onResult(DataBuffer dataBuffer) {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/framework/aidl/IPushCallback$Stub.class */
    public static abstract class Stub extends Binder implements IPushCallback {
        private static final String DESCRIPTOR = "com.hihonor.push.framework.aidl.IPushCallback";
        public static final int TRANSACTION_onResult = 1;

        /* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/framework/aidl/IPushCallback$Stub$Proxy.class */
        public static class Proxy implements IPushCallback {
            public static IPushCallback sDefaultImpl;
            private IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.hihonor.push.framework.aidl.IPushCallback
            public void onResult(DataBuffer dataBuffer) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (dataBuffer != null) {
                        obtain.writeInt(1);
                        dataBuffer.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                    } else {
                        Stub.getDefaultImpl().onResult(dataBuffer);
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

        public static IPushCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPushCallback)) ? new Proxy(iBinder) : (IPushCallback) queryLocalInterface;
        }

        public static IPushCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPushCallback iPushCallback) {
            if (Proxy.sDefaultImpl == null) {
                if (iPushCallback != null) {
                    Proxy.sDefaultImpl = iPushCallback;
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
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            onResult(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onResult(DataBuffer dataBuffer);
}
