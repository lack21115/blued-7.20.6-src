package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/e.class */
final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f27384a;
    final /* synthetic */ com.vivo.push.b.i b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ d f27385c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, String str, com.vivo.push.b.i iVar) {
        this.f27385c = dVar;
        this.f27384a = str;
        this.b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f27384a)) {
            PushMessageCallback pushMessageCallback = this.f27385c.b;
            context2 = this.f27385c.f27414a;
            pushMessageCallback.onReceiveRegId(context2, this.f27384a);
        }
        PushMessageCallback pushMessageCallback2 = this.f27385c.b;
        context = this.f27385c.f27414a;
        pushMessageCallback2.onBind(context, this.b.h(), this.b.d());
    }
}
