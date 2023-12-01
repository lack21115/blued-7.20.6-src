package com.alipay.sdk.app;

import android.app.Activity;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/f.class */
final class f implements Runnable {
    final /* synthetic */ Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Activity activity) {
        this.a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.finish();
    }
}
