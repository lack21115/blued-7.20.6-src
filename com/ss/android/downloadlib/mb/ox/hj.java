package com.ss.android.downloadlib.mb.ox;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.x;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb/ox/hj.class */
public interface hj extends IInterface {

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb/ox/hj$mb.class */
    public static abstract class mb extends Binder implements hj {
        private static String mb = "";

        /* renamed from: com.ss.android.downloadlib.mb.ox.hj$mb$mb  reason: collision with other inner class name */
        /* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/mb/ox/hj$mb$mb.class */
        static class C0705mb implements hj {
            private IBinder mb;

            C0705mb(IBinder iBinder) {
                if (TextUtils.isEmpty(mb.mb)) {
                    JSONObject lz = x.lz();
                    String unused = mb.mb = com.ss.android.socialbase.appdownloader.u.b.mb(lz.optString("t"), lz.optString("s"));
                }
                this.mb = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mb;
            }

            @Override // com.ss.android.downloadlib.mb.ox.hj
            public void mb(ox oxVar) throws RemoteException {
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
                    this.mb.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static hj mb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(mb);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof hj)) ? new C0705mb(iBinder) : (hj) queryLocalInterface;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface(mb);
                mb(parcel.readInt() != 0 ? ox.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(mb);
                return true;
            }
        }
    }

    void mb(ox oxVar) throws RemoteException;
}
