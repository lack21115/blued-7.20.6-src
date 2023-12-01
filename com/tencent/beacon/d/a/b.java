package com.tencent.beacon.d.a;

import android.app.Activity;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/d/a/b.class */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f35005a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, Activity activity) {
        this.b = cVar;
        this.f35005a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        new com.tencent.beacon.d.c(this.f35005a.getApplicationContext()).a();
    }
}
