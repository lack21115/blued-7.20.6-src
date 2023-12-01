package com.huawei.hms.core.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/core/aidl/IAIDLCallback.class */
public interface IAIDLCallback extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/core/aidl/IAIDLCallback$Stub.class */
    public static abstract class Stub extends Binder implements IAIDLCallback {
        static final int TRANSACTION_call = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/core/aidl/IAIDLCallback$Stub$a.class */
        public static class a implements IAIDLCallback {
            public static IAIDLCallback b;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f22672a;

            a(IBinder iBinder) {
                this.f22672a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f22672a;
            }
        }

        public Stub() {
            attachInterface(this, "com.huawei.hms.core.aidl.IAIDLCallback");
        }

        public static IAIDLCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.huawei.hms.core.aidl.IAIDLCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAIDLCallback)) ? new a(iBinder) : (IAIDLCallback) queryLocalInterface;
        }

        public static IAIDLCallback getDefaultImpl() {
            return a.b;
        }

        public static boolean setDefaultImpl(IAIDLCallback iAIDLCallback) {
            if (a.b == null) {
                if (iAIDLCallback != null) {
                    a.b = iAIDLCallback;
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
            if (i == 1598968902) {
                parcel2.writeString("com.huawei.hms.core.aidl.IAIDLCallback");
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel.enforceInterface("com.huawei.hms.core.aidl.IAIDLCallback");
                call(parcel.readInt() != 0 ? DataBuffer.CREATOR.createFromParcel(parcel) : null);
                return true;
            }
        }
    }

    void call(DataBuffer dataBuffer) throws RemoteException;
}
