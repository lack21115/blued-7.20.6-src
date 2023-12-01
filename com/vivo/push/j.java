package com.vivo.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/j.class */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.b f27411a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ e f27412c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar, com.vivo.push.b.b bVar, String str) {
        this.f27412c = eVar;
        this.f27411a = bVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f27412c.a(this.f27411a);
        this.f27412c.e(this.b);
    }
}
