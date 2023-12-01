package com.tencent.qimei.v;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/v/e.class */
public class e implements com.tencent.qimei.g.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f38423a;

    public e(f fVar) {
        this.f38423a = fVar;
    }

    @Override // com.tencent.qimei.g.c
    public void a() {
        j jVar;
        synchronized (this.f38423a) {
            if (!this.f38423a.a()) {
                jVar = this.f38423a.d;
                if (!jVar.b.get()) {
                    this.f38423a.b();
                }
            }
        }
    }

    @Override // com.tencent.qimei.g.c
    public void b() {
    }
}
