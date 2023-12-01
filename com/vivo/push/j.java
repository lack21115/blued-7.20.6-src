package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/j.class */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f41102a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ e f41103c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, com.vivo.push.b.b bVar, String str) {
        this.f41103c = eVar;
        this.f41102a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f41103c.a(this.f41102a);
        this.f41103c.e(this.b);
    }
}
