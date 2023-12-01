package com.huawei.hms.ads.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.huawei.hms.ads.dynamic.IObjectWrapper;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/IDynamicLoader.class */
public interface IDynamicLoader extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/IDynamicLoader$Default.class */
    public static class Default implements IDynamicLoader {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.dynamic.IDynamicLoader
        public IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
            return null;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/IDynamicLoader$Stub.class */
    public static abstract class Stub extends Binder implements IDynamicLoader {

        /* renamed from: a  reason: collision with root package name */
        static final int f22454a = 1;
        private static final String b = "com.huawei.hms.ads.dynamic.IDynamicLoader";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/IDynamicLoader$Stub$Proxy.class */
        public static class Proxy implements IDynamicLoader {
            public static IDynamicLoader sDefaultImpl;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f22455a;

            Proxy(IBinder iBinder) {
                this.f22455a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f22455a;
            }

            public String getInterfaceDescriptor() {
                return Stub.b;
            }

            @Override // com.huawei.hms.ads.dynamic.IDynamicLoader
            public IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.b);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    IBinder iBinder = null;
                    if (iObjectWrapper2 != null) {
                        iBinder = iObjectWrapper2.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.f22455a.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().load(iObjectWrapper, str, i, iObjectWrapper2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, b);
        }

        public static IDynamicLoader asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDynamicLoader)) ? new Proxy(iBinder) : (IDynamicLoader) queryLocalInterface;
        }

        public static IDynamicLoader getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IDynamicLoader iDynamicLoader) {
            if (Proxy.sDefaultImpl == null) {
                if (iDynamicLoader != null) {
                    Proxy.sDefaultImpl = iDynamicLoader;
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
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(b);
                return true;
            }
            parcel.enforceInterface(b);
            IObjectWrapper load = load(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            parcel2.writeStrongBinder(load != null ? load.asBinder() : null);
            return true;
        }
    }

    IObjectWrapper load(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
