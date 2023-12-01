package android.content.res;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/content/res/IThemeProcessingListener.class */
public interface IThemeProcessingListener extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/content/res/IThemeProcessingListener$Stub.class */
    public static abstract class Stub extends Binder implements IThemeProcessingListener {
        private static final String DESCRIPTOR = "android.content.res.IThemeProcessingListener";
        static final int TRANSACTION_onFinishedProcessing_0 = 1;

        /* loaded from: source-9557208-dex2jar.jar:android/content/res/IThemeProcessingListener$Stub$Proxy.class */
        private static class Proxy implements IThemeProcessingListener {
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

            @Override // android.content.res.IThemeProcessingListener
            public void onFinishedProcessing(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IThemeProcessingListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IThemeProcessingListener)) ? new Proxy(iBinder) : (IThemeProcessingListener) queryLocalInterface;
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
                    onFinishedProcessing(parcel.readString());
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onFinishedProcessing(String str) throws RemoteException;
}
