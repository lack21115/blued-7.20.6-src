package codeaurora.ultrasound;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-4181928-dex2jar.jar:codeaurora/ultrasound/IDigitalPenDimensionsCallback.class */
public interface IDigitalPenDimensionsCallback extends IInterface {

    /* loaded from: source-4181928-dex2jar.jar:codeaurora/ultrasound/IDigitalPenDimensionsCallback$Stub.class */
    public static abstract class Stub extends Binder implements IDigitalPenDimensionsCallback {
        private static final String DESCRIPTOR = "codeaurora.ultrasound.IDigitalPenDimensionsCallback";
        static final int TRANSACTION_onDimensionsChange_0 = 1;

        /* loaded from: source-4181928-dex2jar.jar:codeaurora/ultrasound/IDigitalPenDimensionsCallback$Stub$Proxy.class */
        private static class Proxy implements IDigitalPenDimensionsCallback {
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

            @Override // codeaurora.ultrasound.IDigitalPenDimensionsCallback
            public void onDimensionsChange(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IDigitalPenDimensionsCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IDigitalPenDimensionsCallback)) ? new Proxy(iBinder) : (IDigitalPenDimensionsCallback) queryLocalInterface;
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
                    onDimensionsChange(parcel.readInt(), parcel.readInt());
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onDimensionsChange(int i, int i2) throws RemoteException;
}
