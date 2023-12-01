package com.tencent.beacon.e;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/e/f.class */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f35020a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(h hVar) {
        this.f35020a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        context = this.f35020a.f35024c;
        if (context != null) {
            h hVar = this.f35020a;
            context2 = hVar.f35024c;
            hVar.a(context2);
        }
    }
}
