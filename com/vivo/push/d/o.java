package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/o.class */
final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.n f41082a;
    final /* synthetic */ n b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, com.vivo.push.b.n nVar2) {
        this.b = nVar;
        this.f41082a = nVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.f41105a;
        pushMessageCallback.onLog(context, this.f41082a.d(), this.f41082a.e(), this.f41082a.f());
    }
}
