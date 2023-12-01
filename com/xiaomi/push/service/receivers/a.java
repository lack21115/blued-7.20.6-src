package com.xiaomi.push.service.receivers;

import android.content.Context;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/receivers/a.class */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f28008a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ NetworkStatusReceiver f1030a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        this.f1030a = networkStatusReceiver;
        this.f28008a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1030a.a(this.f28008a);
    }
}
