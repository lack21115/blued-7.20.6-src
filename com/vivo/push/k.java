package com.vivo.push;

import com.vivo.push.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/k.class */
public final class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f27413a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar, String str) {
        this.b = eVar;
        this.f27413a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e.a d;
        d = this.b.d(this.f27413a);
        if (d != null) {
            d.a(1003, new Object[0]);
        }
    }
}
