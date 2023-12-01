package com.alipay.sdk.util;

import android.app.Activity;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/util/o.class */
final class o implements Runnable {
    final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Activity activity) {
        this.a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.finish();
    }
}
