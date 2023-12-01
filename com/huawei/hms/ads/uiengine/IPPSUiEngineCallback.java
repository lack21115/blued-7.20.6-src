package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IPPSUiEngineCallback.class */
public interface IPPSUiEngineCallback extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IPPSUiEngineCallback$a.class */
    public static class a implements IPPSUiEngineCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IPPSUiEngineCallback
        public void onCallResult(String str, Bundle bundle) {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IPPSUiEngineCallback$b.class */
    public static abstract class b extends Binder implements IPPSUiEngineCallback {
        static final int Code = 1;
        private static final String V = "com.huawei.hms.ads.uiengine.IPPSUiEngineCallback";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IPPSUiEngineCallback$b$a.class */
        public static class a implements IPPSUiEngineCallback {
            public static IPPSUiEngineCallback Code;
            private IBinder V;

            a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return b.V;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.IPPSUiEngineCallback
            public void onCallResult(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.V);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(1, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onCallResult(str, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, V);
        }

        public static IPPSUiEngineCallback Code() {
            return a.Code;
        }

        public static IPPSUiEngineCallback Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(V);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IPPSUiEngineCallback)) ? new a(iBinder) : (IPPSUiEngineCallback) queryLocalInterface;
        }

        public static boolean Code(IPPSUiEngineCallback iPPSUiEngineCallback) {
            if (a.Code == null) {
                if (iPPSUiEngineCallback != null) {
                    a.Code = iPPSUiEngineCallback;
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
                parcel2.writeString(V);
                return true;
            }
            parcel.enforceInterface(V);
            onCallResult(parcel.readString(), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void onCallResult(String str, Bundle bundle);
}
