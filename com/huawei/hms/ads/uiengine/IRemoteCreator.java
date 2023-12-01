package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IGlobalUtil;
import com.huawei.hms.ads.uiengine.IRemoteViewDelegate;
import com.huawei.hms.ads.uiengine.ISplashApi;
import com.huawei.hms.ads.uiengine.a;
import com.huawei.hms.ads.uiengine.b;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IRemoteCreator.class */
public interface IRemoteCreator extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IRemoteCreator$a.class */
    public static class a implements IRemoteCreator {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public void bindData(IObjectWrapper iObjectWrapper, String str) {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public void destroyView(IObjectWrapper iObjectWrapper) {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public com.huawei.hms.ads.uiengine.b getUiEngineUtil() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public String getVersion() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IObjectWrapper newBannerTemplateView(Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IObjectWrapper newNativeTemplateView(Bundle bundle, com.huawei.hms.ads.uiengine.a aVar) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public IObjectWrapper newSplashTemplateView(Bundle bundle, ISplashApi iSplashApi) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
        public void setGlobalUtil(IGlobalUtil iGlobalUtil) {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IRemoteCreator$b.class */
    public static abstract class b extends Binder implements IRemoteCreator {
        static final int B = 5;
        static final int C = 6;
        static final int Code = 1;
        static final int D = 9;
        static final int F = 8;
        static final int I = 3;
        private static final String L = "com.huawei.hms.ads.uiengine.IRemoteCreator";
        static final int S = 7;
        static final int V = 2;
        static final int Z = 4;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IRemoteCreator$b$a.class */
        public static class a implements IRemoteCreator {
            public static IRemoteCreator Code;
            private IBinder V;

            a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return b.L;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void bindData(IObjectWrapper iObjectWrapper, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeString(str);
                    if (this.V.transact(6, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().bindData(iObjectWrapper, str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void destroyView(IObjectWrapper iObjectWrapper) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    if (this.V.transact(8, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().destroyView(iObjectWrapper);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public com.huawei.hms.ads.uiengine.b getUiEngineUtil() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    if (this.V.transact(9, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        return b.AbstractBinderC0255b.Code(obtain2.readStrongBinder());
                    }
                    return b.Code().getUiEngineUtil();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public String getVersion() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    if (this.V.transact(1, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        return obtain2.readString();
                    }
                    return b.Code().getVersion();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newBannerTemplateView(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(5, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return b.Code().newBannerTemplateView(bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newNativeTemplateView(Bundle bundle, com.huawei.hms.ads.uiengine.a aVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    if (this.V.transact(4, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return b.Code().newNativeTemplateView(bundle, aVar);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    obtain.writeStrongBinder(iObjectWrapper != null ? iObjectWrapper.asBinder() : null);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(7, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        return IRemoteViewDelegate.b.Code(obtain2.readStrongBinder());
                    }
                    return b.Code().newRemoteViewDelegate(iObjectWrapper, str, bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public IObjectWrapper newSplashTemplateView(Bundle bundle, ISplashApi iSplashApi) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iSplashApi != null ? iSplashApi.asBinder() : null);
                    if (this.V.transact(3, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return b.Code().newSplashTemplateView(bundle, iSplashApi);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteCreator
            public void setGlobalUtil(IGlobalUtil iGlobalUtil) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.L);
                    obtain.writeStrongBinder(iGlobalUtil != null ? iGlobalUtil.asBinder() : null);
                    if (this.V.transact(2, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().setGlobalUtil(iGlobalUtil);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, L);
        }

        public static IRemoteCreator Code() {
            return a.Code;
        }

        public static IRemoteCreator Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(L);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteCreator)) ? new a(iBinder) : (IRemoteCreator) queryLocalInterface;
        }

        public static boolean Code(IRemoteCreator iRemoteCreator) {
            if (a.Code == null) {
                if (iRemoteCreator != null) {
                    a.Code = iRemoteCreator;
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
            if (i == 1598968902) {
                parcel2.writeString(L);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(L);
                    String version = getVersion();
                    parcel2.writeNoException();
                    parcel2.writeString(version);
                    return true;
                case 2:
                    parcel.enforceInterface(L);
                    setGlobalUtil(IGlobalUtil.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(L);
                    IObjectWrapper newSplashTemplateView = newSplashTemplateView(parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null, ISplashApi.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (newSplashTemplateView != null) {
                        iBinder = newSplashTemplateView.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    parcel.enforceInterface(L);
                    IObjectWrapper newNativeTemplateView = newNativeTemplateView(parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null, a.b.Code(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    IBinder iBinder2 = null;
                    if (newNativeTemplateView != null) {
                        iBinder2 = newNativeTemplateView.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder2);
                    return true;
                case 5:
                    parcel.enforceInterface(L);
                    IObjectWrapper newBannerTemplateView = newBannerTemplateView(parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    IBinder iBinder3 = null;
                    if (newBannerTemplateView != null) {
                        iBinder3 = newBannerTemplateView.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder3);
                    return true;
                case 6:
                    parcel.enforceInterface(L);
                    bindData(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(L);
                    IRemoteViewDelegate newRemoteViewDelegate = newRemoteViewDelegate(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    IBinder iBinder4 = null;
                    if (newRemoteViewDelegate != null) {
                        iBinder4 = newRemoteViewDelegate.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder4);
                    return true;
                case 8:
                    parcel.enforceInterface(L);
                    destroyView(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(L);
                    com.huawei.hms.ads.uiengine.b uiEngineUtil = getUiEngineUtil();
                    parcel2.writeNoException();
                    IBinder iBinder5 = null;
                    if (uiEngineUtil != null) {
                        iBinder5 = uiEngineUtil.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder5);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void bindData(IObjectWrapper iObjectWrapper, String str);

    void destroyView(IObjectWrapper iObjectWrapper);

    com.huawei.hms.ads.uiengine.b getUiEngineUtil();

    String getVersion();

    IObjectWrapper newBannerTemplateView(Bundle bundle);

    IObjectWrapper newNativeTemplateView(Bundle bundle, com.huawei.hms.ads.uiengine.a aVar);

    IRemoteViewDelegate newRemoteViewDelegate(IObjectWrapper iObjectWrapper, String str, Bundle bundle);

    IObjectWrapper newSplashTemplateView(Bundle bundle, ISplashApi iSplashApi);

    void setGlobalUtil(IGlobalUtil iGlobalUtil);
}
