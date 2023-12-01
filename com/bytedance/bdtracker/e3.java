package com.bytedance.bdtracker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import com.bytedance.bdtracker.a4;
import com.bytedance.bdtracker.f4;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/e3.class */
public final class e3 extends g3<f4> {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/e3$a.class */
    public class a implements a4.b<f4, String> {
        public a(e3 e3Var) {
        }

        @Override // com.bytedance.bdtracker.a4.b
        public f4 a(IBinder iBinder) {
            return f4.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.a4.b
        public String a(f4 f4Var) {
            f4 f4Var2 = f4Var;
            if (f4Var2 == null) {
                return null;
            }
            f4.a.C0310a c0310a = (f4.a.C0310a) f4Var2;
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                c0310a.f21219a.transact(3, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public e3() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.bdtracker.g3
    public a4.b<f4, String> a() {
        return new a(this);
    }

    @Override // com.bytedance.bdtracker.g3
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }
}
