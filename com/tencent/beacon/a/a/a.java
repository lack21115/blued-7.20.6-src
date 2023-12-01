package com.tencent.beacon.a.a;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/a/a.class */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f21226a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c cVar) {
        this.b = bVar;
        this.f21226a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f21226a);
    }
}
