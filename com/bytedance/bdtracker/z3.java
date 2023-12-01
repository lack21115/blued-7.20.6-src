package com.bytedance.bdtracker;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdtracker.a4;
import com.bytedance.bdtracker.d4;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/z3.class */
public final class z3 extends g3<d4> {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/z3$a.class */
    public class a implements a4.b<d4, String> {
        public a(z3 z3Var) {
        }

        @Override // com.bytedance.bdtracker.a4.b
        public d4 a(IBinder iBinder) {
            return d4.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.a4.b
        public String a(d4 d4Var) {
            return ((d4.a.C0308a) d4Var).a();
        }
    }

    public z3() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.bdtracker.g3
    public a4.b<d4, String> a() {
        return new a(this);
    }

    @Override // com.bytedance.bdtracker.g3
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
