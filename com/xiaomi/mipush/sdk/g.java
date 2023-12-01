package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.hl;
import com.xiaomi.push.service.ba;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/g.class */
public class g extends ba.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f27533a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i, String str) {
        super(i, str);
        this.f27533a = fVar;
    }

    @Override // com.xiaomi.push.service.ba.a
    public void onCallback() {
        Context context;
        boolean z;
        Context context2;
        context = this.f27533a.f108a;
        boolean a2 = ba.a(context).a(hl.AggregatePushSwitch.a(), true);
        z = this.f27533a.f111a;
        if (z != a2) {
            this.f27533a.f111a = a2;
            context2 = this.f27533a.f108a;
            i.b(context2);
        }
    }
}
