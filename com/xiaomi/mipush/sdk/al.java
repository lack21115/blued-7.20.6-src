package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/al.class */
public final class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f41204a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f126a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(Context context, Intent intent) {
        this.f41204a = context;
        this.f126a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PushMessageHandler.b(this.f41204a, this.f126a);
    }
}
