package com.bytedance.bdtracker;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.bdtracker.a4;
import com.bytedance.bdtracker.h4;
import com.bytedance.bdtracker.s3;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/i3.class */
public final class i3 extends g3<h4> {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/i3$a.class */
    public class a implements a4.b<h4, String> {
        public a(i3 i3Var) {
        }

        @Override // com.bytedance.bdtracker.a4.b
        public h4 a(IBinder iBinder) {
            return h4.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.a4.b
        public String a(h4 h4Var) {
            h4 h4Var2 = h4Var;
            if (h4Var2 == null) {
                return null;
            }
            return ((h4.a.C0312a) h4Var2).a();
        }
    }

    public i3() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.bdtracker.g3
    public a4.b<h4, String> a() {
        return new a(this);
    }

    @Override // com.bytedance.bdtracker.g3, com.bytedance.bdtracker.s3
    public s3.a a(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", packageName);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            z2.a(e);
        }
        return super.a(context);
    }

    @Override // com.bytedance.bdtracker.g3
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }
}
