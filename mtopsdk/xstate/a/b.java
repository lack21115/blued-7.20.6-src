package mtopsdk.xstate.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/xstate/a/b.class */
public abstract class b extends Binder implements a {
    public b() {
        attachInterface(this, "mtopsdk.xstate.aidl.IXState");
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
            String a2 = a(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(a2);
            return true;
        } else if (i == 2) {
            parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
            String b = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b);
            return true;
        } else if (i == 3) {
            parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
            a(parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            return true;
        } else if (i == 4) {
            parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
            a();
            parcel2.writeNoException();
            return true;
        } else if (i != 5) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString("mtopsdk.xstate.aidl.IXState");
            return true;
        } else {
            parcel.enforceInterface("mtopsdk.xstate.aidl.IXState");
            b();
            parcel2.writeNoException();
            return true;
        }
    }
}
