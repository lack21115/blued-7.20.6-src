package com.tencent.qimei.v;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/v/e.class */
public class e implements com.tencent.qimei.g.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f24732a;

    public e(f fVar) {
        this.f24732a = fVar;
    }

    @Override // com.tencent.qimei.g.c
    public void a() {
        j jVar;
        synchronized (this.f24732a) {
            if (!this.f24732a.a()) {
                jVar = this.f24732a.d;
                if (!jVar.b.get()) {
                    this.f24732a.b();
                }
            }
        }
    }

    @Override // com.tencent.qimei.g.c
    public void b() {
    }
}
