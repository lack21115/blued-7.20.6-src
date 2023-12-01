package com.tencent.beacon.e;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/e/f.class */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f21329a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h hVar) {
        this.f21329a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        context = this.f21329a.f21333c;
        if (context != null) {
            h hVar = this.f21329a;
            context2 = hVar.f21333c;
            hVar.a(context2);
        }
    }
}
