package com.xiaomi.push.service.receivers;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/receivers/a.class */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f41699a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f1077a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f1077a = networkStatusReceiver;
        this.f41699a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1077a.a(this.f41699a);
    }
}
