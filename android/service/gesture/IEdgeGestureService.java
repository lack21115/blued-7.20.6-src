package android.service.gesture;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.service.gesture.IEdgeGestureActivationListener;
import android.service.gesture.IEdgeGestureHostCallback;

/* loaded from: source-9557208-dex2jar.jar:android/service/gesture/IEdgeGestureService.class */
public interface IEdgeGestureService extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/service/gesture/IEdgeGestureService$Stub.class */
    public static abstract class Stub extends Binder implements IEdgeGestureService {
        private static final String DESCRIPTOR = "android.service.gesture.IEdgeGestureService";
        static final int TRANSACTION_registerEdgeGestureActivationListener = 1;
        static final int TRANSACTION_updateEdgeGestureActivationListener = 2;

        /* loaded from: source-9557208-dex2jar.jar:android/service/gesture/IEdgeGestureService$Stub$Proxy.class */
        private static class Proxy implements IEdgeGestureService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.service.gesture.IEdgeGestureService
            public IEdgeGestureHostCallback registerEdgeGestureActivationListener(IEdgeGestureActivationListener iEdgeGestureActivationListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iEdgeGestureActivationListener != null ? iEdgeGestureActivationListener.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return IEdgeGestureHostCallback.Stub.asInterface(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.service.gesture.IEdgeGestureService
            public void updateEdgeGestureActivationListener(IBinder iBinder, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
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

        public static IEdgeGestureService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IEdgeGestureService)) ? new Proxy(iBinder) : (IEdgeGestureService) queryLocalInterface;
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
                    IEdgeGestureHostCallback registerEdgeGestureActivationListener = registerEdgeGestureActivationListener(IEdgeGestureActivationListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(registerEdgeGestureActivationListener != null ? registerEdgeGestureActivationListener.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    updateEdgeGestureActivationListener(parcel.readStrongBinder(), parcel.readInt());
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

    IEdgeGestureHostCallback registerEdgeGestureActivationListener(IEdgeGestureActivationListener iEdgeGestureActivationListener) throws RemoteException;

    void updateEdgeGestureActivationListener(IBinder iBinder, int i) throws RemoteException;
}
