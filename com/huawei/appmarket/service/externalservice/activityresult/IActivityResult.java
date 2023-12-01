package com.huawei.appmarket.service.externalservice.activityresult;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/appmarket/service/externalservice/activityresult/IActivityResult.class */
public interface IActivityResult extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/appmarket/service/externalservice/activityresult/IActivityResult$a.class */
    public static class a implements IActivityResult {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
        public void onActivityCancel(int i) {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/appmarket/service/externalservice/activityresult/IActivityResult$b.class */
    public static abstract class b extends Binder implements IActivityResult {
        static final int Code = 1;
        private static final String V = "com.huawei.appmarket.service.externalservice.activityresult.IActivityResult";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/appmarket/service/externalservice/activityresult/IActivityResult$b$a.class */
        public static class a implements IActivityResult {
            public static IActivityResult Code;
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

            @Override // com.huawei.appmarket.service.externalservice.activityresult.IActivityResult
            public void onActivityCancel(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.V);
                    obtain.writeInt(i);
                    if (this.V.transact(1, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onActivityCancel(i);
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

        public static IActivityResult Code() {
            return a.Code;
        }

        public static IActivityResult Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(V);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IActivityResult)) ? new a(iBinder) : (IActivityResult) queryLocalInterface;
        }

        public static boolean Code(IActivityResult iActivityResult) {
            if (a.Code == null) {
                if (iActivityResult != null) {
                    a.Code = iActivityResult;
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
            onActivityCancel(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onActivityCancel(int i);
}
