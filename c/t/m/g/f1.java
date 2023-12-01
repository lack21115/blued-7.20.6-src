package c.t.m.g;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-8756600-dex2jar.jar:c/t/m/g/f1.class */
public final class f1 implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    public IBinder f3807a;

    public f1(IBinder iBinder) {
        this.f3807a = iBinder;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f3807a;
    }

    public String e() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f3807a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            str = "get oaid failed";
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }

    public boolean f() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f3807a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } catch (Exception e) {
            obtain2.recycle();
            obtain.recycle();
            return false;
        }
    }
}
