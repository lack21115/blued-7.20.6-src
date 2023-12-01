package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/al.class */
final class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f27513a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ Intent f79a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(Context context, Intent intent) {
        this.f27513a = context;
        this.f79a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PushMessageHandler.b(this.f27513a, this.f79a);
    }
}
