package com.vivo.vms;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.vivo.vms.IPCCallback;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/vms/IPCInvoke.class */
public interface IPCInvoke extends IInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/vivo/vms/IPCInvoke$Default.class */
    public static class Default implements IPCInvoke {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.vivo.vms.IPCInvoke
        public Bundle asyncCall(Bundle bundle, IPCCallback iPCCallback) {
            return null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/vivo/vms/IPCInvoke$Stub.class */
    public static abstract class Stub extends Binder implements IPCInvoke {
        private static final String DESCRIPTOR = "com.vivo.vms.IPCInvoke";
        static final int TRANSACTION_asyncCall = 1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8829756-dex2jar.jar:com/vivo/vms/IPCInvoke$Stub$Proxy.class */
        public static class Proxy implements IPCInvoke {
            public static IPCInvoke sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.vivo.vms.IPCInvoke
            public Bundle asyncCall(Bundle bundle, IPCCallback iPCCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iPCCallback != null ? iPCCallback.asBinder() : null);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        Bundle bundle2 = null;
                        if (obtain2.readInt() != 0) {
                            bundle2 = Bundle.CREATOR.createFromParcel(obtain2);
                        }
                        obtain2.recycle();
                        obtain.recycle();
                        return bundle2;
                    }
                    return Stub.getDefaultImpl().asyncCall(bundle, iPCCallback);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPCInvoke asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPCInvoke)) ? new Proxy(iBinder) : (IPCInvoke) queryLocalInterface;
        }

        public static IPCInvoke getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IPCInvoke iPCInvoke) {
            if (Proxy.sDefaultImpl != null || iPCInvoke == null) {
                return false;
            }
            Proxy.sDefaultImpl = iPCInvoke;
            return true;
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
            Bundle asyncCall = asyncCall(parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null, IPCCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            if (asyncCall == null) {
                parcel2.writeInt(0);
                return true;
            }
            parcel2.writeInt(1);
            asyncCall.writeToParcel(parcel2, 1);
            return true;
        }
    }

    Bundle asyncCall(Bundle bundle, IPCCallback iPCCallback);
}
