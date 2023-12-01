package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/d/w.class */
public final class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPSNotificationMessage f41089a;
    final /* synthetic */ u b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, UPSNotificationMessage uPSNotificationMessage) {
        this.b = uVar;
        this.f41089a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        PushMessageCallback pushMessageCallback = this.b.b;
        context = this.b.f41105a;
        pushMessageCallback.onNotificationMessageClicked(context, this.f41089a);
    }
}
