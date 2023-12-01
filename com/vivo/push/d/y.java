package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/y.class */
final class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.r f41090a;
    final /* synthetic */ x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, com.vivo.push.b.r rVar) {
        this.b = xVar;
        this.f41090a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.f41105a;
        pushMessageCallback.onPublish(context, this.f41090a.h(), this.f41090a.g());
    }
}
