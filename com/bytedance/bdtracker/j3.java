package com.bytedance.bdtracker;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.bdtracker.a4;
import com.bytedance.bdtracker.c4;
import com.bytedance.bdtracker.s3;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/j3.class */
public class j3 extends g3<c4> {

    /* renamed from: c  reason: collision with root package name */
    public final Context f21239c;

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/j3$a.class */
    public class a implements a4.b<c4, String> {
        public a() {
        }

        @Override // com.bytedance.bdtracker.a4.b
        public c4 a(IBinder iBinder) {
            return c4.a.a(iBinder);
        }

        @Override // com.bytedance.bdtracker.a4.b
        public String a(c4 c4Var) {
            c4 c4Var2 = c4Var;
            if (c4Var2 == null) {
                return null;
            }
            return ((c4.a.C0307a) c4Var2).a(j3.this.f21239c.getPackageName());
        }
    }

    public j3(Context context) {
        super("com.coolpad.deviceidsupport");
        this.f21239c = context;
    }

    @Override // com.bytedance.bdtracker.g3
    public a4.b<c4, String> a() {
        return new a();
    }

    @Override // com.bytedance.bdtracker.g3, com.bytedance.bdtracker.s3
    public s3.a a(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
                if (!TextUtils.isEmpty(string)) {
                    s3.a aVar = new s3.a();
                    aVar.f21305a = string;
                    return aVar;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.a(context);
    }

    @Override // com.bytedance.bdtracker.g3
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }
}
