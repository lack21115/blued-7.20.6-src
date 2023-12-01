package com.bytedance.bdtracker;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.bdtracker.a4;
import com.bytedance.bdtracker.e4;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/o3.class */
public final class o3 extends g3<e4> {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/o3$a.class */
    public class a implements a4.b<e4, String> {
        public a(o3 o3Var) {
        }

        @Override // com.bytedance.bdtracker.a4.b
        public e4 a(IBinder iBinder) {
            return e4.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.a4.b
        public String a(e4 e4Var) {
            e4 e4Var2 = e4Var;
            if (e4Var2 == null) {
                return null;
            }
            e4.a.C0309a c0309a = (e4.a.C0309a) e4Var2;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                c0309a.f21213a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public o3() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.bdtracker.g3
    public a4.b<e4, String> a() {
        return new a(this);
    }

    @Override // com.bytedance.bdtracker.g3
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }
}
