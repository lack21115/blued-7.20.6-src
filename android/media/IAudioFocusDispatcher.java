package android.media;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/media/IAudioFocusDispatcher.class */
public interface IAudioFocusDispatcher extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/media/IAudioFocusDispatcher$Stub.class */
    public static abstract class Stub extends Binder implements IAudioFocusDispatcher {
        private static final String DESCRIPTOR = "android.media.IAudioFocusDispatcher";
        static final int TRANSACTION_dispatchAudioFocusChange_0 = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/media/IAudioFocusDispatcher$Stub$Proxy.class */
        public static class Proxy implements IAudioFocusDispatcher {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // android.media.IAudioFocusDispatcher
            public void dispatchAudioFocusChange(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IAudioFocusDispatcher asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IAudioFocusDispatcher)) ? new Proxy(iBinder) : (IAudioFocusDispatcher) queryLocalInterface;
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
                    dispatchAudioFocusChange(parcel.readInt(), parcel.readString());
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void dispatchAudioFocusChange(int i, String str) throws RemoteException;
}
