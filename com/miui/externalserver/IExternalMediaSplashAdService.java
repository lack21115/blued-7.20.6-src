package com.miui.externalserver;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.miui.externalserver.IExternalMediaSplashAdListener;

/* loaded from: source-8303388-dex2jar.jar:com/miui/externalserver/IExternalMediaSplashAdService.class */
public interface IExternalMediaSplashAdService extends IInterface {

    /* loaded from: source-8303388-dex2jar.jar:com/miui/externalserver/IExternalMediaSplashAdService$Default.class */
    public static class Default implements IExternalMediaSplashAdService {
        @Override // com.miui.externalserver.IExternalMediaSplashAdService
        public void a(String str) throws RemoteException {
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdService
        public void a(String str, IExternalMediaSplashAdListener iExternalMediaSplashAdListener, Bundle bundle) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/miui/externalserver/IExternalMediaSplashAdService$Stub.class */
    public static abstract class Stub extends Binder implements IExternalMediaSplashAdService {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8303388-dex2jar.jar:com/miui/externalserver/IExternalMediaSplashAdService$Stub$Proxy.class */
        public static class Proxy implements IExternalMediaSplashAdService {

            /* renamed from: a  reason: collision with root package name */
            public static IExternalMediaSplashAdService f24200a;
            private IBinder b;

            Proxy(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdService
            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.externalserver.IExternalMediaSplashAdService");
                    obtain.writeString(str);
                    if (this.b.transact(2, obtain, obtain2, 0) || Stub.a() == null) {
                        obtain2.readException();
                    } else {
                        Stub.a().a(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdService
            public void a(String str, IExternalMediaSplashAdListener iExternalMediaSplashAdListener, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.externalserver.IExternalMediaSplashAdService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iExternalMediaSplashAdListener != null ? iExternalMediaSplashAdListener.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.b.transact(1, obtain, obtain2, 0) || Stub.a() == null) {
                        obtain2.readException();
                    } else {
                        Stub.a().a(str, iExternalMediaSplashAdListener, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }
        }

        public Stub() {
            attachInterface(this, "com.miui.externalserver.IExternalMediaSplashAdService");
        }

        public static IExternalMediaSplashAdService a() {
            return Proxy.f24200a;
        }

        public static IExternalMediaSplashAdService a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.miui.externalserver.IExternalMediaSplashAdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IExternalMediaSplashAdService)) ? new Proxy(iBinder) : (IExternalMediaSplashAdService) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.miui.externalserver.IExternalMediaSplashAdService");
                a(parcel.readString(), IExternalMediaSplashAdListener.Stub.a(parcel.readStrongBinder()), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.miui.externalserver.IExternalMediaSplashAdService");
                return true;
            } else {
                parcel.enforceInterface("com.miui.externalserver.IExternalMediaSplashAdService");
                a(parcel.readString());
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void a(String str) throws RemoteException;

    void a(String str, IExternalMediaSplashAdListener iExternalMediaSplashAdListener, Bundle bundle) throws RemoteException;
}
