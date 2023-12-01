package com.bytedance.bdtracker;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.bdtracker.a4;
import com.bytedance.bdtracker.s3;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/g3.class */
public abstract class g3<SERVICE> implements s3 {

    /* renamed from: a  reason: collision with root package name */
    public final String f7616a;
    public f3<Boolean> b = new a();

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/g3$a.class */
    public class a extends f3<Boolean> {
        public a() {
        }

        @Override // com.bytedance.bdtracker.f3
        public Boolean a(Object[] objArr) {
            boolean z = false;
            try {
                if (((Context) objArr[0]).getPackageManager().getPackageInfo(g3.this.f7616a, 128) != null) {
                    z = true;
                }
            } catch (PackageManager.NameNotFoundException e) {
            }
            return Boolean.valueOf(z);
        }
    }

    public g3(String str) {
        this.f7616a = str;
    }

    public abstract a4.b<SERVICE, String> a();

    @Override // com.bytedance.bdtracker.s3
    public s3.a a(Context context) {
        String str = (String) new a4(context, c(context), a()).a();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        s3.a aVar = new s3.a();
        aVar.f7699a = str;
        return aVar;
    }

    @Override // com.bytedance.bdtracker.s3
    public boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return this.b.b(context).booleanValue();
    }

    public abstract Intent c(Context context);
}
