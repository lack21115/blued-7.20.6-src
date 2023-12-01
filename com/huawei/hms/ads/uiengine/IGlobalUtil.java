package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IGlobalUtil.class */
public interface IGlobalUtil extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IGlobalUtil$a.class */
    public static class a implements IGlobalUtil {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public String getFilePathDirect(String str) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        }

        @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
        public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IGlobalUtil$b.class */
    public static abstract class b extends Binder implements IGlobalUtil {
        private static final String B = "com.huawei.hms.ads.uiengine.IGlobalUtil";
        static final int Code = 1;
        static final int I = 3;
        static final int V = 2;
        static final int Z = 4;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IGlobalUtil$b$a.class */
        public static class a implements IGlobalUtil {
            public static IGlobalUtil Code;
            private IBinder V;

            a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return b.B;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.B);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(1, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().getFilePath(str, iPPSUiEngineCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public String getFilePathDirect(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.B);
                    obtain.writeString(str);
                    if (this.V.transact(4, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        return obtain2.readString();
                    }
                    return b.Code().getFilePathDirect(str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.B);
                    obtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(2, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().registerActivityStartCallBack(iPPSUiEngineCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IGlobalUtil
            public void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.B);
                    obtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(3, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().unregisterActivityStartCallBack(iPPSUiEngineCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, B);
        }

        public static IGlobalUtil Code() {
            return a.Code;
        }

        public static IGlobalUtil Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(B);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGlobalUtil)) ? new a(iBinder) : (IGlobalUtil) queryLocalInterface;
        }

        public static boolean Code(IGlobalUtil iGlobalUtil) {
            if (a.Code == null) {
                if (iGlobalUtil != null) {
                    a.Code = iGlobalUtil;
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
            if (i == 1) {
                parcel.enforceInterface(B);
                getFilePath(parcel.readString(), IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface(B);
                registerActivityStartCallBack(IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface(B);
                unregisterActivityStartCallBack(IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i != 4) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(B);
                return true;
            } else {
                parcel.enforceInterface(B);
                String filePathDirect = getFilePathDirect(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(filePathDirect);
                return true;
            }
        }
    }

    void getFilePath(String str, IPPSUiEngineCallback iPPSUiEngineCallback);

    String getFilePathDirect(String str);

    void registerActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback);

    void unregisterActivityStartCallBack(IPPSUiEngineCallback iPPSUiEngineCallback);
}
