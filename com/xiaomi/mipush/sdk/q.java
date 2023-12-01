package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.eb;
import com.xiaomi.push.hl;
import com.xiaomi.push.service.ba;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/q.class */
public final class q extends ba.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f41233a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i, String str, Context context) {
        super(i, str);
        this.f41233a = context;
    }

    @Override // com.xiaomi.push.service.ba.a
    public final void onCallback() {
        eb.a(this.f41233a).a(ba.a(this.f41233a).a(hl.AwakeInfoUploadWaySwitch.a(), 0));
    }
}
