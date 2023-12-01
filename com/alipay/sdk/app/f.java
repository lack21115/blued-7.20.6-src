package com.alipay.sdk.app;

import android.app.Activity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/alipay/sdk/app/f.class */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f4595a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Activity activity) {
        this.f4595a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4595a.finish();
    }
}
