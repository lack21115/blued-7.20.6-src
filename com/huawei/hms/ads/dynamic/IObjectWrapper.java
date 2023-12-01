package com.huawei.hms.ads.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/IObjectWrapper.class */
public interface IObjectWrapper extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/IObjectWrapper$Default.class */
    public static class Default implements IObjectWrapper {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/IObjectWrapper$Stub.class */
    public static abstract class Stub extends Binder implements IObjectWrapper {

        /* renamed from: a  reason: collision with root package name */
        private static final String f8848a = "com.huawei.hms.ads.dynamic.IObjectWrapper";

        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamic/IObjectWrapper$Stub$Proxy.class */
        static class Proxy implements IObjectWrapper {
            public static IObjectWrapper sDefaultImpl;

            /* renamed from: a  reason: collision with root package name */
            private IBinder f8849a;

            Proxy(IBinder iBinder) {
                this.f8849a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8849a;
            }

            public String getInterfaceDescriptor() {
                return Stub.f8848a;
            }
        }

        public Stub() {
            attachInterface(this, f8848a);
        }

        public static IObjectWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f8848a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IObjectWrapper)) ? new Proxy(iBinder) : (IObjectWrapper) queryLocalInterface;
        }

        public static IObjectWrapper getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IObjectWrapper iObjectWrapper) {
            if (Proxy.sDefaultImpl == null) {
                if (iObjectWrapper != null) {
                    Proxy.sDefaultImpl = iObjectWrapper;
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
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(f8848a);
            return true;
        }
    }
}
