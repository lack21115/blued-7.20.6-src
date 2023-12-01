package com.tencent.tmsqmsp.sdk.g.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/g/d.class */
public interface d extends IInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/g/d$a.class */
    public static abstract class a extends Binder implements d {

        /* renamed from: com.tencent.tmsqmsp.sdk.g.g.d$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/g/d$a$a.class */
        public static class C1056a implements d {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f39793a;

            public C1056a(IBinder iBinder) {
                this.f39793a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                String str4;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f39793a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    str4 = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return str4;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    try {
                        throw th;
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        str4 = "";
                    }
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f39793a;
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new C1056a(iBinder) : (d) queryLocalInterface;
        }
    }
}
