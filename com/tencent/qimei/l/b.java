package com.tencent.qimei.l;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/l/b.class */
public class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.tencent.qimei.c.d f24658a;
    public final /* synthetic */ d b;

    public b(d dVar, com.tencent.qimei.c.d dVar2) {
        this.b = dVar;
        this.f24658a = dVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        boolean z;
        obj = this.b.f24661c;
        synchronized (obj) {
            z = this.b.d;
            if (!z) {
                com.tencent.qimei.c.c.j().d = 10L;
                this.f24658a.a(4);
                this.b.d = true;
            }
        }
    }
}
