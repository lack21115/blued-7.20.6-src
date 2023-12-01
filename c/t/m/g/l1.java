package c.t.m.g;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/l1.class */
public class l1 implements m1 {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f3871a;

    public l1(IBinder iBinder) {
        this.f3871a = iBinder;
    }

    @Override // c.t.m.g.m1
    public boolean a() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
            this.f3871a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } catch (Exception e) {
            obtain2.recycle();
            obtain.recycle();
            return false;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3871a;
    }

    @Override // c.t.m.g.m1
    public String c() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
            this.f3871a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            str = null;
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }
}
