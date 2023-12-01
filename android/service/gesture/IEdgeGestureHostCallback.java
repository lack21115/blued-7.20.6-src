package android.service.gesture;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/service/gesture/IEdgeGestureHostCallback.class */
public interface IEdgeGestureHostCallback extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/service/gesture/IEdgeGestureHostCallback$Stub.class */
    public static abstract class Stub extends Binder implements IEdgeGestureHostCallback {
        private static final String DESCRIPTOR = "android.service.gesture.IEdgeGestureHostCallback";
        static final int TRANSACTION_dropEventsUntilLift = 3;
        static final int TRANSACTION_gainTouchFocus = 1;
        static final int TRANSACTION_restoreListenerState = 2;

        /* loaded from: source-9557208-dex2jar.jar:android/service/gesture/IEdgeGestureHostCallback$Stub$Proxy.class */
        private static class Proxy implements IEdgeGestureHostCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.service.gesture.IEdgeGestureHostCallback
            public boolean dropEventsUntilLift() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
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

            @Override // android.service.gesture.IEdgeGestureHostCallback
            public boolean gainTouchFocus(IBinder iBinder) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(1, obtain, obtain2, 0);
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

            @Override // android.service.gesture.IEdgeGestureHostCallback
            public void restoreListenerState() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IEdgeGestureHostCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IEdgeGestureHostCallback)) ? new Proxy(iBinder) : (IEdgeGestureHostCallback) queryLocalInterface;
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
                    boolean gainTouchFocus = gainTouchFocus(parcel.readStrongBinder());
                    parcel2.writeNoException();
                    int i3 = 0;
                    if (gainTouchFocus) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    restoreListenerState();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean dropEventsUntilLift = dropEventsUntilLift();
                    parcel2.writeNoException();
                    int i4 = 0;
                    if (dropEventsUntilLift) {
                        i4 = 1;
                    }
                    parcel2.writeInt(i4);
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean dropEventsUntilLift() throws RemoteException;

    boolean gainTouchFocus(IBinder iBinder) throws RemoteException;

    void restoreListenerState() throws RemoteException;
}
