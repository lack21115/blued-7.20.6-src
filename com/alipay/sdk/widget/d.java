package com.alipay.sdk.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/d.class */
public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4684a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, Looper looper) {
        super(looper);
        this.f4684a = aVar;
    }

    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        this.f4684a.c();
    }
}
