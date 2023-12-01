package android.content.res;

import android.content.res.IThemeChangeListener;
import android.content.res.IThemeProcessingListener;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/IThemeService.class */
public interface IThemeService extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/IThemeService$Stub.class */
    public static abstract class Stub extends Binder implements IThemeService {
        private static final String DESCRIPTOR = "android.content.res.IThemeService";
        static final int TRANSACTION_applyDefaultTheme = 4;
        static final int TRANSACTION_cacheComposedIcon = 7;
        static final int TRANSACTION_getProgress = 6;
        static final int TRANSACTION_isThemeApplying = 5;
        static final int TRANSACTION_isThemeBeingProcessed = 9;
        static final int TRANSACTION_processThemeResources = 8;
        static final int TRANSACTION_rebuildResourceCache = 12;
        static final int TRANSACTION_registerThemeProcessingListener = 10;
        static final int TRANSACTION_removeUpdates = 2;
        static final int TRANSACTION_requestThemeChange = 3;
        static final int TRANSACTION_requestThemeChangeUpdates = 1;
        static final int TRANSACTION_unregisterThemeProcessingListener = 11;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/content/res/IThemeService$Stub$Proxy.class */
        public static class Proxy implements IThemeService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.content.res.IThemeService
            public void applyDefaultTheme() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.content.res.IThemeService
            public boolean cacheComposedIcon(Bitmap bitmap, String str) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.content.res.IThemeService
            public int getProgress() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.res.IThemeService
            public boolean isThemeApplying() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.content.res.IThemeService
            public boolean isThemeBeingProcessed(String str) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.content.res.IThemeService
            public boolean processThemeResources(String str) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.content.res.IThemeService
            public void rebuildResourceCache() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.res.IThemeService
            public void registerThemeProcessingListener(IThemeProcessingListener iThemeProcessingListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iThemeProcessingListener != null ? iThemeProcessingListener.asBinder() : null);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.res.IThemeService
            public void removeUpdates(IThemeChangeListener iThemeChangeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iThemeChangeListener != null ? iThemeChangeListener.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.res.IThemeService
            public void requestThemeChange(ThemeChangeRequest themeChangeRequest, boolean z) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (themeChangeRequest != null) {
                        obtain.writeInt(1);
                        themeChangeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.res.IThemeService
            public void requestThemeChangeUpdates(IThemeChangeListener iThemeChangeListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iThemeChangeListener != null ? iThemeChangeListener.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.content.res.IThemeService
            public void unregisterThemeProcessingListener(IThemeProcessingListener iThemeProcessingListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iThemeProcessingListener != null ? iThemeProcessingListener.asBinder() : null);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IThemeService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IThemeService)) ? new Proxy(iBinder) : (IThemeService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestThemeChangeUpdates(IThemeChangeListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeUpdates(IThemeChangeListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    requestThemeChange(parcel.readInt() != 0 ? ThemeChangeRequest.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    applyDefaultTheme();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isThemeApplying = isThemeApplying();
                    parcel2.writeNoException();
                    int i3 = 0;
                    if (isThemeApplying) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    int progress = getProgress();
                    parcel2.writeNoException();
                    parcel2.writeInt(progress);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean cacheComposedIcon = cacheComposedIcon(parcel.readInt() != 0 ? Bitmap.CREATOR.createFromParcel(parcel) : null, parcel.readString());
                    parcel2.writeNoException();
                    int i4 = 0;
                    if (cacheComposedIcon) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean processThemeResources = processThemeResources(parcel.readString());
                    parcel2.writeNoException();
                    int i5 = 0;
                    if (processThemeResources) {
                        i5 = 1;
                    }
                    parcel2.writeInt(i5);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isThemeBeingProcessed = isThemeBeingProcessed(parcel.readString());
                    parcel2.writeNoException();
                    int i6 = 0;
                    if (isThemeBeingProcessed) {
                        i6 = 1;
                    }
                    parcel2.writeInt(i6);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    registerThemeProcessingListener(IThemeProcessingListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    unregisterThemeProcessingListener(IThemeProcessingListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    rebuildResourceCache();
                    parcel2.writeNoException();
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void applyDefaultTheme() throws RemoteException;

    boolean cacheComposedIcon(Bitmap bitmap, String str) throws RemoteException;

    int getProgress() throws RemoteException;

    boolean isThemeApplying() throws RemoteException;

    boolean isThemeBeingProcessed(String str) throws RemoteException;

    boolean processThemeResources(String str) throws RemoteException;

    void rebuildResourceCache() throws RemoteException;

    void registerThemeProcessingListener(IThemeProcessingListener iThemeProcessingListener) throws RemoteException;

    void removeUpdates(IThemeChangeListener iThemeChangeListener) throws RemoteException;

    void requestThemeChange(ThemeChangeRequest themeChangeRequest, boolean z) throws RemoteException;

    void requestThemeChangeUpdates(IThemeChangeListener iThemeChangeListener) throws RemoteException;

    void unregisterThemeProcessingListener(IThemeProcessingListener iThemeProcessingListener) throws RemoteException;
}
