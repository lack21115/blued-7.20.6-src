package org.repackage.a.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-3503164-dex2jar.jar:org/repackage/a/a/a/a.class */
public interface a extends IInterface {

    /* renamed from: org.repackage.a.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-3503164-dex2jar.jar:org/repackage/a/a/a/a$a.class */
    public static abstract class AbstractBinderC1133a extends Binder implements a {

        /* renamed from: org.repackage.a.a.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-3503164-dex2jar.jar:org/repackage/a/a/a/a$a$a.class */
        public static class C1134a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f44101a;

            public C1134a(IBinder iBinder) {
                this.f44101a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f44101a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f44101a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C1134a(iBinder) : (a) queryLocalInterface;
        }
    }
}
