package com.tencent.qimei.l;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qimei/l/c.class */
public class c implements com.tencent.qimei.c.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.tencent.qimei.c.d f38350a;
    public final /* synthetic */ d b;

    public c(d dVar, com.tencent.qimei.c.d dVar2) {
        this.b = dVar;
        this.f38350a = dVar2;
    }

    @Override // com.tencent.qimei.c.d
    public void a(int i) {
        Object obj;
        boolean z;
        if (this.f38350a != null) {
            obj = this.b.f38352c;
            synchronized (obj) {
                z = this.b.d;
                if (!z) {
                    this.f38350a.a(i);
                    this.b.d = true;
                }
            }
        }
    }
}
