package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.dk;
import com.xiaomi.push.hg;
import com.xiaomi.push.ht;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/r.class */
public class r implements dk {

    /* renamed from: a  reason: collision with root package name */
    private Context f27543a;

    public r(Context context) {
        this.f27543a = context;
    }

    @Override // com.xiaomi.push.dk
    public String a() {
        return b.m8407a(this.f27543a).d();
    }

    @Override // com.xiaomi.push.dk
    public void a(Cif cif, hg hgVar, ht htVar) {
        ao.a(this.f27543a).a((ao) cif, hgVar, htVar);
    }
}
