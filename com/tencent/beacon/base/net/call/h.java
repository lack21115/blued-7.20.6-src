package com.tencent.beacon.base.net.call;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/call/h.class */
class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Callback f34989a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(j jVar, Callback callback) {
        this.b = jVar;
        this.f34989a = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f34989a);
    }
}
