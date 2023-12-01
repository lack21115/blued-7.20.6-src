package com.tencent.beacon.base.net.call;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/call/g.class */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Callback f21297a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(j jVar, Callback callback) {
        this.b = jVar;
        this.f21297a = callback;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f21297a);
    }
}
