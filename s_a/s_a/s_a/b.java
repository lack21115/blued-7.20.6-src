package s_a.s_a.s_a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/b.class */
public interface b extends IInterface {

    /* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/b$a.class */
    public static abstract class a extends Binder implements b {

        /* renamed from: s_a.s_a.s_a.b$a$a  reason: collision with other inner class name */
        /* loaded from: source-3503164-dex2jar.jar:s_a/s_a/s_a/b$a$a.class */
        public static class C1137a implements b {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f44188a;

            public C1137a(IBinder iBinder) {
                this.f44188a = iBinder;
            }

            @Override // s_a.s_a.s_a.b
            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.oplus.stdid.IStdID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f44188a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f44188a;
            }
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.oplus.stdid.IStdID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C1137a(iBinder) : (b) queryLocalInterface;
        }
    }

    String a(String str, String str2, String str3);
}
