package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/y.class */
public final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f27548a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f119a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Context context, Intent intent) {
        this.f27548a = context;
        this.f119a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f27548a.startService(this.f119a);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a(e.getMessage());
        }
    }
}
