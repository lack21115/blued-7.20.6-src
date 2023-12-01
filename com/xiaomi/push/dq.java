package com.xiaomi.push;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dq.class */
public class dq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dp f41342a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(dp dpVar) {
        this.f41342a = dpVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f41342a.b();
    }
}
