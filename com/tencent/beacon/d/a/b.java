package com.tencent.beacon.d.a;

import android.app.Activity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/d/a/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f21314a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar, Activity activity) {
        this.b = cVar;
        this.f21314a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        new com.tencent.beacon.d.c(this.f21314a.getApplicationContext()).a();
    }
}
