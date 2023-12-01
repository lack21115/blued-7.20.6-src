package com.ss.android.downloadlib.mb.ox;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.mb.ox.hj;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb/ox/b.class */
public interface b extends IInterface {

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb/ox/b$mb.class */
    public static abstract class mb extends Binder implements b {
        private static String mb = "";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.ss.android.downloadlib.mb.ox.b$mb$mb  reason: collision with other inner class name */
        /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb/ox/b$mb$mb.class */
        public static class C0874mb implements b {
            private IBinder mb;

            C0874mb(IBinder iBinder) {
                if (TextUtils.isEmpty(mb.mb)) {
                    JSONObject lz = x.lz();
                    String unused = mb.mb = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString("r"), lz.optString("s"));
                }
                this.mb = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mb;
            }

            @Override // com.ss.android.downloadlib.mb.ox.b
            public void mb(ox oxVar, hj hjVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(mb.mb);
                    if (oxVar != null) {
                        obtain.writeInt(1);
                        oxVar.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(hjVar != null ? hjVar.asBinder() : null);
                    this.mb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static b mb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(mb);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0874mb(iBinder) : (b) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(mb);
                return true;
            }
            ox oxVar = null;
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(mb);
            if (parcel.readInt() != 0) {
                oxVar = ox.CREATOR.createFromParcel(parcel);
            }
            mb(oxVar, hj.mb.mb(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void mb(ox oxVar, hj hjVar) throws RemoteException;
}
