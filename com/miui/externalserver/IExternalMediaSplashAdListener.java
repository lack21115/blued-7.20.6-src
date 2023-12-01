package com.miui.externalserver;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-8303388-dex2jar.jar:com/miui/externalserver/IExternalMediaSplashAdListener.class */
public interface IExternalMediaSplashAdListener extends IInterface {

    /* loaded from: source-8303388-dex2jar.jar:com/miui/externalserver/IExternalMediaSplashAdListener$Default.class */
    public static class Default implements IExternalMediaSplashAdListener {
        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void a() throws RemoteException {
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void a(int i) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void b() throws RemoteException {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/miui/externalserver/IExternalMediaSplashAdListener$Stub.class */
    public static abstract class Stub extends Binder implements IExternalMediaSplashAdListener {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8303388-dex2jar.jar:com/miui/externalserver/IExternalMediaSplashAdListener$Stub$Proxy.class */
        public static class Proxy implements IExternalMediaSplashAdListener {

            /* renamed from: a  reason: collision with root package name */
            public static IExternalMediaSplashAdListener f24199a;
            private IBinder b;

            Proxy(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdListener
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.externalserver.IExternalMediaSplashAdListener");
                    if (this.b.transact(2, obtain, obtain2, 0) || Stub.c() == null) {
                        obtain2.readException();
                    } else {
                        Stub.c().a();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.miui.externalserver.IExternalMediaSplashAdListener
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.externalserver.IExternalMediaSplashAdListener");
                    obtain.writeInt(i);
                    if (this.b.transact(1, obtain, obtain2, 0) || Stub.c() == null) {
                        obtain2.readException();
                    } else {
                        Stub.c().a(i);
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

            @Override // com.miui.externalserver.IExternalMediaSplashAdListener
            public void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.miui.externalserver.IExternalMediaSplashAdListener");
                    if (this.b.transact(3, obtain, obtain2, 0) || Stub.c() == null) {
                        obtain2.readException();
                    } else {
                        Stub.c().b();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.miui.externalserver.IExternalMediaSplashAdListener");
        }

        public static IExternalMediaSplashAdListener a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.miui.externalserver.IExternalMediaSplashAdListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IExternalMediaSplashAdListener)) ? new Proxy(iBinder) : (IExternalMediaSplashAdListener) queryLocalInterface;
        }

        public static IExternalMediaSplashAdListener c() {
            return Proxy.f24199a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.miui.externalserver.IExternalMediaSplashAdListener");
                a(parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.miui.externalserver.IExternalMediaSplashAdListener");
                a();
                parcel2.writeNoException();
                return true;
            } else if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.miui.externalserver.IExternalMediaSplashAdListener");
                return true;
            } else {
                parcel.enforceInterface("com.miui.externalserver.IExternalMediaSplashAdListener");
                b();
                parcel2.writeNoException();
                return true;
            }
        }
    }

    void a() throws RemoteException;

    void a(int i) throws RemoteException;

    void b() throws RemoteException;
}
