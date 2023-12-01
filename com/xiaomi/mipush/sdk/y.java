package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/y.class */
final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f41239a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context, Intent intent) {
        this.f41239a = context;
        this.f166a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f41239a.startService(this.f166a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a(e.getMessage());
        }
    }
}
