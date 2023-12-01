package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IRemoteViewDelegate.class */
public interface IRemoteViewDelegate extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IRemoteViewDelegate$a.class */
    public static class a implements IRemoteViewDelegate {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public IObjectWrapper getView() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onCreate(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onDestroy() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onPause() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onRestart() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onResume() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onStart() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void onStop() {
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public Bundle sendCommand(String str, Bundle bundle) {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
        public void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback) {
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IRemoteViewDelegate$b.class */
    public static abstract class b extends Binder implements IRemoteViewDelegate {
        static final int B = 5;
        static final int C = 6;
        static final int Code = 1;
        static final int D = 9;
        static final int F = 8;
        static final int I = 3;
        static final int L = 10;
        static final int S = 7;
        static final int V = 2;
        static final int Z = 4;

        /* renamed from: a  reason: collision with root package name */
        private static final String f22528a = "com.huawei.hms.ads.uiengine.IRemoteViewDelegate";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengine/IRemoteViewDelegate$b$a.class */
        public static class a implements IRemoteViewDelegate {
            public static IRemoteViewDelegate Code;
            private IBinder V;

            a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return b.f22528a;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public IObjectWrapper getView() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f22528a);
                    if (this.V.transact(1, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        return IObjectWrapper.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return b.Code().getView();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onCreate(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f22528a);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(2, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onCreate(bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onDestroy() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f22528a);
                    if (this.V.transact(3, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onDestroy();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onPause() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f22528a);
                    if (this.V.transact(4, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onPause();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onRestart() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f22528a);
                    if (this.V.transact(8, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onRestart();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onResume() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f22528a);
                    if (this.V.transact(5, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onResume();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onStart() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f22528a);
                    if (this.V.transact(6, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onStart();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void onStop() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f22528a);
                    if (this.V.transact(7, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onStop();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public Bundle sendCommand(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f22528a);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(10, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                        Bundle createFromParcel = obtain2.readInt() != 0 ? Bundle.CREATOR.createFromParcel(obtain2) : null;
                        obtain2.recycle();
                        obtain.recycle();
                        return createFromParcel;
                    }
                    return b.Code().sendCommand(str, bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.IRemoteViewDelegate
            public void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f22528a);
                    obtain.writeStrongBinder(iPPSUiEngineCallback != null ? iPPSUiEngineCallback.asBinder() : null);
                    if (this.V.transact(9, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().setCallback(iPPSUiEngineCallback);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f22528a);
        }

        public static IRemoteViewDelegate Code() {
            return a.Code;
        }

        public static IRemoteViewDelegate Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f22528a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IRemoteViewDelegate)) ? new a(iBinder) : (IRemoteViewDelegate) queryLocalInterface;
        }

        public static boolean Code(IRemoteViewDelegate iRemoteViewDelegate) {
            if (a.Code == null) {
                if (iRemoteViewDelegate != null) {
                    a.Code = iRemoteViewDelegate;
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
                parcel2.writeString(f22528a);
                return true;
            }
            Bundle bundle = null;
            switch (i) {
                case 1:
                    parcel.enforceInterface(f22528a);
                    IObjectWrapper view = getView();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (view != null) {
                        iBinder = view.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface(f22528a);
                    Bundle bundle2 = null;
                    if (parcel.readInt() != 0) {
                        bundle2 = Bundle.CREATOR.createFromParcel(parcel);
                    }
                    onCreate(bundle2);
                    break;
                case 3:
                    parcel.enforceInterface(f22528a);
                    onDestroy();
                    break;
                case 4:
                    parcel.enforceInterface(f22528a);
                    onPause();
                    break;
                case 5:
                    parcel.enforceInterface(f22528a);
                    onResume();
                    break;
                case 6:
                    parcel.enforceInterface(f22528a);
                    onStart();
                    break;
                case 7:
                    parcel.enforceInterface(f22528a);
                    onStop();
                    break;
                case 8:
                    parcel.enforceInterface(f22528a);
                    onRestart();
                    break;
                case 9:
                    parcel.enforceInterface(f22528a);
                    setCallback(IPPSUiEngineCallback.b.Code(parcel.readStrongBinder()));
                    break;
                case 10:
                    parcel.enforceInterface(f22528a);
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        bundle = Bundle.CREATOR.createFromParcel(parcel);
                    }
                    Bundle sendCommand = sendCommand(readString, bundle);
                    parcel2.writeNoException();
                    if (sendCommand == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    sendCommand.writeToParcel(parcel2, 1);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeNoException();
            return true;
        }
    }

    IObjectWrapper getView();

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onRestart();

    void onResume();

    void onStart();

    void onStop();

    Bundle sendCommand(String str, Bundle bundle);

    void setCallback(IPPSUiEngineCallback iPPSUiEngineCallback);
}
