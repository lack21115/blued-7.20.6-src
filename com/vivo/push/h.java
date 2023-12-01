package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/h.class */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f41099a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ e f41100c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, com.vivo.push.b.b bVar, String str) {
        this.f41100c = eVar;
        this.f41099a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f41100c.a(this.f41099a);
        this.f41100c.e(this.b);
    }
}
