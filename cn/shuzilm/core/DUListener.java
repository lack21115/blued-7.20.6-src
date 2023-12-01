package cn.shuzilm.core;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/DUListener.class */
public interface DUListener extends IInterface {

    /* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/DUListener$Stub.class */
    public abstract class Stub extends Binder implements DUListener {
        private static final String DESCRIPTOR = "cn.shuzilm.core.DUListener";
        static final int TRANSACTION_handle = 1;

        /* loaded from: source-6737240-dex2jar.jar:cn/shuzilm/core/DUListener$Stub$Proxy.class */
        class Proxy implements DUListener {
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

            @Override // cn.shuzilm.core.DUListener
            public void handle(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
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

        public static DUListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof DUListener)) ? new Proxy(iBinder) : (DUListener) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            handle(parcel.readString());
            parcel2.writeNoException();
            return true;
        }
    }

    void handle(String str);
}
