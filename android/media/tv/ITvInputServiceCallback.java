package android.media.tv;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/media/tv/ITvInputServiceCallback.class */
public interface ITvInputServiceCallback extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/media/tv/ITvInputServiceCallback$Stub.class */
    public static abstract class Stub extends Binder implements ITvInputServiceCallback {
        private static final String DESCRIPTOR = "android.media.tv.ITvInputServiceCallback";
        static final int TRANSACTION_addHardwareTvInput = 1;
        static final int TRANSACTION_addHdmiTvInput = 2;
        static final int TRANSACTION_removeTvInput = 3;

        /* loaded from: source-9557208-dex2jar.jar:android/media/tv/ITvInputServiceCallback$Stub$Proxy.class */
        private static class Proxy implements ITvInputServiceCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.media.tv.ITvInputServiceCallback
            public void addHardwareTvInput(int i, TvInputInfo tvInputInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (tvInputInfo != null) {
                        obtain.writeInt(1);
                        tvInputInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.tv.ITvInputServiceCallback
            public void addHdmiTvInput(int i, TvInputInfo tvInputInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (tvInputInfo != null) {
                        obtain.writeInt(1);
                        tvInputInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.media.tv.ITvInputServiceCallback
            public void removeTvInput(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITvInputServiceCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITvInputServiceCallback)) ? new Proxy(iBinder) : (ITvInputServiceCallback) queryLocalInterface;
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
                    addHardwareTvInput(parcel.readInt(), parcel.readInt() != 0 ? TvInputInfo.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    addHdmiTvInput(parcel.readInt(), parcel.readInt() != 0 ? TvInputInfo.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    removeTvInput(parcel.readString());
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void addHardwareTvInput(int i, TvInputInfo tvInputInfo) throws RemoteException;

    void addHdmiTvInput(int i, TvInputInfo tvInputInfo) throws RemoteException;

    void removeTvInput(String str) throws RemoteException;
}
