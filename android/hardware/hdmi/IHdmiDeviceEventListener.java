package android.hardware.hdmi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/IHdmiDeviceEventListener.class */
public interface IHdmiDeviceEventListener extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/IHdmiDeviceEventListener$Stub.class */
    public static abstract class Stub extends Binder implements IHdmiDeviceEventListener {
        private static final String DESCRIPTOR = "android.hardware.hdmi.IHdmiDeviceEventListener";
        static final int TRANSACTION_onStatusChanged_0 = 1;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/IHdmiDeviceEventListener$Stub$Proxy.class */
        public static class Proxy implements IHdmiDeviceEventListener {
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

            @Override // android.hardware.hdmi.IHdmiDeviceEventListener
            public void onStatusChanged(HdmiDeviceInfo hdmiDeviceInfo, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (hdmiDeviceInfo != null) {
                        obtain.writeInt(1);
                        hdmiDeviceInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IHdmiDeviceEventListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IHdmiDeviceEventListener)) ? new Proxy(iBinder) : (IHdmiDeviceEventListener) queryLocalInterface;
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
                    onStatusChanged(parcel.readInt() != 0 ? HdmiDeviceInfo.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void onStatusChanged(HdmiDeviceInfo hdmiDeviceInfo, int i) throws RemoteException;
}
