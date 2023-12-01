package s_a.s_a.s_a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a.class */
public interface a extends IInterface {

    /* renamed from: s_a.s_a.s_a.a$a  reason: collision with other inner class name */
    /* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a$a.class */
    public static abstract class AbstractBinderC0180a extends Binder implements a {
        public static final String a = s_a.s_a.s_a.a.a.a("Y29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA==");

        /* renamed from: s_a.s_a.s_a.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a$a$a.class */
        public static class C0181a implements a {
            public IBinder a;

            public C0181a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override // s_a.s_a.s_a.a
            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0180a.a);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0181a(iBinder) : (a) queryLocalInterface;
        }
    }

    String a(String str, String str2, String str3);
}
