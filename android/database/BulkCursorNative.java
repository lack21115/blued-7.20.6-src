package android.database;

import android.database.IContentObserver;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-9557208-dex2jar.jar:android/database/BulkCursorNative.class */
public abstract class BulkCursorNative extends Binder implements IBulkCursor {
    public BulkCursorNative() {
        attachInterface(this, IBulkCursor.descriptor);
    }

    public static IBulkCursor asInterface(IBinder iBinder) {
        IBulkCursor iBulkCursor;
        if (iBinder == null) {
            iBulkCursor = null;
        } else {
            IBulkCursor iBulkCursor2 = (IBulkCursor) iBinder.queryLocalInterface(IBulkCursor.descriptor);
            iBulkCursor = iBulkCursor2;
            if (iBulkCursor2 == null) {
                return new BulkCursorProxy(iBinder);
            }
        }
        return iBulkCursor;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        try {
            switch (i) {
                case 1:
                    parcel.enforceInterface(IBulkCursor.descriptor);
                    CursorWindow window = getWindow(parcel.readInt());
                    parcel2.writeNoException();
                    if (window == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    window.writeToParcel(parcel2, 1);
                    return true;
                case 2:
                    parcel.enforceInterface(IBulkCursor.descriptor);
                    deactivate();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(IBulkCursor.descriptor);
                    int requery = requery(IContentObserver.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    parcel2.writeInt(requery);
                    parcel2.writeBundle(getExtras());
                    return true;
                case 4:
                    parcel.enforceInterface(IBulkCursor.descriptor);
                    onMove(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(IBulkCursor.descriptor);
                    Bundle extras = getExtras();
                    parcel2.writeNoException();
                    parcel2.writeBundle(extras);
                    return true;
                case 6:
                    parcel.enforceInterface(IBulkCursor.descriptor);
                    Bundle respond = respond(parcel.readBundle());
                    parcel2.writeNoException();
                    parcel2.writeBundle(respond);
                    return true;
                case 7:
                    parcel.enforceInterface(IBulkCursor.descriptor);
                    close();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        } catch (Exception e) {
            DatabaseUtils.writeExceptionToParcel(parcel2, e);
            return true;
        }
    }
}
