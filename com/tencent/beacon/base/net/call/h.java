package com.tencent.beacon.base.net.call;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/call/h.class */
public class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Callback f21298a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(j jVar, Callback callback) {
        this.b = jVar;
        this.f21298a = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f21298a);
    }
}
