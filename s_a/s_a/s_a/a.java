package s_a.s_a.s_a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a.class */
public interface a extends IInterface {

    /* renamed from: s_a.s_a.s_a.a$a  reason: collision with other inner class name */
    /* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a$a.class */
    public static abstract class AbstractBinderC1135a extends Binder implements a {

        /* renamed from: a  reason: collision with root package name */
        public static final String f44173a = s_a.s_a.s_a.a.a.a("Y29tLmhleXRhcC5vcGVuaWQuSU9wZW5JRA==");

        /* renamed from: s_a.s_a.s_a.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/a$a$a.class */
        public static class C1136a implements a {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f44174a;

            public C1136a(IBinder iBinder) {
                this.f44174a = iBinder;
            }

            @Override // s_a.s_a.s_a.a
            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC1135a.f44173a);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f44174a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f44174a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f44173a);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C1136a(iBinder) : (a) queryLocalInterface;
        }
    }

    String a(String str, String str2, String str3);
}
