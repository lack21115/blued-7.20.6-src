package android.service.gesture;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/service/gesture/IEdgeGestureActivationListener.class */
public interface IEdgeGestureActivationListener extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/service/gesture/IEdgeGestureActivationListener$Stub.class */
    public static abstract class Stub extends Binder implements IEdgeGestureActivationListener {
        private static final String DESCRIPTOR = "android.service.gesture.IEdgeGestureActivationListener";
        static final int TRANSACTION_onEdgeGestureActivation = 1;

        /* loaded from: source-9557208-dex2jar.jar:android/service/gesture/IEdgeGestureActivationListener$Stub$Proxy.class */
        private static class Proxy implements IEdgeGestureActivationListener {
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

            @Override // android.service.gesture.IEdgeGestureActivationListener
            public void onEdgeGestureActivation(int i, int i2, int i3, int i4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IEdgeGestureActivationListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IEdgeGestureActivationListener)) ? new Proxy(iBinder) : (IEdgeGestureActivationListener) queryLocalInterface;
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
                    onEdgeGestureActivation(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onEdgeGestureActivation(int i, int i2, int i3, int i4) throws RemoteException;
}
