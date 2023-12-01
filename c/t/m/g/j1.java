package c.t.m.g;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/j1.class */
public interface j1 extends IInterface {

    /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/j1$a.class */
    public static abstract class a extends Binder implements j1 {

        /* renamed from: c.t.m.g.j1$a$a  reason: collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:c/t/m/g/j1$a$a.class */
        public static class C0037a implements j1 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f3798a;

            public C0037a(IBinder iBinder) {
                this.f3798a = iBinder;
            }

            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f3798a.transact(1, obtain, obtain2, 0);
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
                return this.f3798a;
            }
        }

        public static j1 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof j1)) ? new C0037a(iBinder) : (j1) queryLocalInterface;
        }
    }
}
