package com.anythink.china.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/a.class */
public final class a implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private IBinder f6216a;

    public a(IBinder iBinder) {
        this.f6216a = iBinder;
    }

    public final String a() {
        String str;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            this.f6216a.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            str = obtain2.readString();
        } catch (Throwable th) {
            obtain.recycle();
            obtain2.recycle();
            th.printStackTrace();
            str = null;
        }
        obtain.recycle();
        obtain2.recycle();
        return str;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f6216a;
    }
}
