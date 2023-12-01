package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/h.class */
public final class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f27408a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ e f27409c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, com.vivo.push.b.b bVar, String str) {
        this.f27409c = eVar;
        this.f27408a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f27409c.a(this.f27408a);
        this.f27409c.e(this.b);
    }
}
