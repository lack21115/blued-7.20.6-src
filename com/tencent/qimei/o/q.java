package com.tencent.qimei.o;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/o/q.class */
public class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r f24699a;

    public q(r rVar) {
        this.f24699a = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.qimei.u.a aVar = new com.tencent.qimei.u.a(this.f24699a.i);
        if (aVar.a() == null) {
            return;
        }
        aVar.a().M();
    }
}
