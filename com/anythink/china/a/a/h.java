package com.anythink.china.a.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/h.class */
public interface h extends IInterface {

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/h$a.class */
    public static abstract class a extends Binder implements h {

        /* renamed from: com.anythink.china.a.a.h$a$a  reason: collision with other inner class name */
        /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/h$a$a.class */
        public static final class C0044a implements h {
            public IBinder a;

            public C0044a(IBinder iBinder) {
                this.a = iBinder;
            }

            public final String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                        obtain.writeString(str);
                        obtain.writeString(str2);
                        obtain.writeString(str3);
                        this.a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (Exception e) {
                        e.printStackTrace();
                        obtain.recycle();
                        obtain2.recycle();
                        return null;
                    }
                } finally {
                    obtain.recycle();
                    obtain2.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.a;
            }
        }

        public static h a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
                return (queryLocalInterface == null || !(queryLocalInterface instanceof h)) ? new C0044a(iBinder) : (h) queryLocalInterface;
            } catch (Throwable th) {
                return null;
            }
        }
    }
}
