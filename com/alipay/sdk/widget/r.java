package com.alipay.sdk.widget;

import android.view.View;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/widget/r.class */
class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f4698a;
    final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, View view) {
        this.b = qVar;
        this.f4698a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4698a.setEnabled(true);
    }
}
