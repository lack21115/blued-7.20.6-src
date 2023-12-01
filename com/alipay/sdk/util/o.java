package com.alipay.sdk.util;

import android.app.Activity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/o.class */
public final class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f4678a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Activity activity) {
        this.f4678a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4678a.finish();
    }
}
