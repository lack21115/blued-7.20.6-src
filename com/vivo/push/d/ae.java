package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/ae.class */
final class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f41074a;
    final /* synthetic */ ad b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, com.vivo.push.b.i iVar) {
        this.b = adVar;
        this.f41074a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.f41105a;
        pushMessageCallback.onUnBind(context, this.f41074a.h(), this.f41074a.d());
    }
}
