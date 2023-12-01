package c.t.m.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k1.class */
public interface k1 extends IInterface {

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k1$a.class */
    public static abstract class a extends Binder implements k1 {

        /* renamed from: c.t.m.g.k1$a$a  reason: collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/k1$a$a.class */
        public static class C0040a implements k1 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f3859a;

            public C0040a(IBinder iBinder) {
                this.f3859a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f3859a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain.recycle();
                    obtain2.recycle();
                    return readString;
                } catch (Exception e) {
                    obtain.recycle();
                    obtain2.recycle();
                    return null;
                } catch (Throwable th) {
                    obtain.recycle();
                    obtain2.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3859a;
            }
        }

        public static k1 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof k1)) ? new C0040a(iBinder) : (k1) queryLocalInterface;
        }
    }
}
