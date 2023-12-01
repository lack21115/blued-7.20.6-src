package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.Cif;
import com.xiaomi.push.ai;
import com.xiaomi.push.hg;
import com.xiaomi.push.ht;
import com.xiaomi.push.service.bd;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/p.class */
public final class p extends ai.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f41232a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Cif f161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Cif cif, Context context) {
        this.f161a = cif;
        this.f41232a = context;
    }

    @Override // com.xiaomi.push.ai.a
    /* renamed from: a */
    public final String mo11550a() {
        return "22";
    }

    @Override // java.lang.Runnable
    public final void run() {
        Cif cif = this.f161a;
        if (cif != null) {
            cif.a(bd.a());
            ao.a(this.f41232a.getApplicationContext()).a((ao) this.f161a, hg.Notification, true, (ht) null, true);
        }
    }
}
