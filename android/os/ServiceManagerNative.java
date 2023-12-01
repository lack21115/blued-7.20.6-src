package android.os;

import android.os.IPermissionController;

/* loaded from: source-9557208-dex2jar.jar:android/os/ServiceManagerNative.class */
public abstract class ServiceManagerNative extends Binder implements IServiceManager {
    public ServiceManagerNative() {
        attachInterface(this, IServiceManager.descriptor);
    }

    public static IServiceManager asInterface(IBinder iBinder) {
        IServiceManager iServiceManager;
        if (iBinder == null) {
            iServiceManager = null;
        } else {
            IServiceManager iServiceManager2 = (IServiceManager) iBinder.queryLocalInterface(IServiceManager.descriptor);
            iServiceManager = iServiceManager2;
            if (iServiceManager2 == null) {
                return new ServiceManagerProxy(iBinder);
            }
        }
        return iServiceManager;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        try {
            switch (i) {
                case 1:
                    parcel.enforceInterface(IServiceManager.descriptor);
                    parcel2.writeStrongBinder(getService(parcel.readString()));
                    return true;
                case 2:
                    parcel.enforceInterface(IServiceManager.descriptor);
                    parcel2.writeStrongBinder(checkService(parcel.readString()));
                    return true;
                case 3:
                    parcel.enforceInterface(IServiceManager.descriptor);
                    addService(parcel.readString(), parcel.readStrongBinder(), parcel.readInt() != 0);
                    return true;
                case 4:
                    parcel.enforceInterface(IServiceManager.descriptor);
                    parcel2.writeStringArray(listServices());
                    return true;
                case 5:
                default:
                    return false;
                case 6:
                    parcel.enforceInterface(IServiceManager.descriptor);
                    setPermissionController(IPermissionController.Stub.asInterface(parcel.readStrongBinder()));
                    return true;
            }
        } catch (RemoteException e) {
            return false;
        }
    }
}
