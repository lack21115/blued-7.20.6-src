package com.bytedance.bdtracker;

import android.os.IBinder;
import android.os.Parcel;
import android.util.Pair;
import com.bytedance.bdtracker.a4;
import com.bytedance.bdtracker.x3;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/n3.class */
public class n3 implements a4.b<x3, Pair<String, Boolean>> {
    public n3(m3 m3Var) {
    }

    @Override // com.bytedance.bdtracker.a4.b
    public x3 a(IBinder iBinder) {
        return x3.a.a(iBinder);
    }

    @Override // com.bytedance.bdtracker.a4.b
    public Pair<String, Boolean> a(x3 x3Var) {
        x3 x3Var2 = x3Var;
        if (x3Var2 == null) {
            return null;
        }
        x3.a.C0143a c0143a = (x3.a.C0143a) x3Var2;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            boolean z = true;
            c0143a.f7731a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            String readString = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            obtain = Parcel.obtain();
            obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                c0143a.f7731a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                obtain2.recycle();
                obtain.recycle();
                return new Pair<>(readString, Boolean.valueOf(z));
            } finally {
            }
        } finally {
        }
    }
}
