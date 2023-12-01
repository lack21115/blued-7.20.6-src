package com.igexin.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9564a = "com.igexin.push.extension.distribution.gws.action.guard.WakeCallback";

    /* renamed from: c  reason: collision with root package name */
    private static final int f9565c = 1;
    private IBinder b;

    public b(IBinder iBinder) {
        this.b = iBinder;
    }

    private IBinder a() {
        return this.b;
    }

    public final void a(Bundle bundle) throws RemoteException {
        if (this.b == null) {
            return;
        }
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f9564a);
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
            this.b.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
