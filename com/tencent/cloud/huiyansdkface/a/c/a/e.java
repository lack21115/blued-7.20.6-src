package com.tencent.cloud.huiyansdkface.a.c.a;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/e.class */
public class e implements com.tencent.cloud.huiyansdkface.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.c.d f21762a;

    public e(com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        this.f21762a = dVar;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.a.b
    public com.tencent.cloud.huiyansdkface.a.a.a a(com.tencent.cloud.huiyansdkface.a.a.c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            com.tencent.cloud.huiyansdkface.a.a.a aVar = new com.tencent.cloud.huiyansdkface.a.a.a();
            aVar.a(this.f21762a.b().b() ? cVar.i() : -1.0f).a(cVar.g().b(this.f21762a.b().f(), this.f21762a)).b(cVar.h().b(this.f21762a.b().g(), this.f21762a)).c(cVar.e().b(this.f21762a.b().d(), this.f21762a)).b(cVar.f().b(this.f21762a.b().e(), this.f21762a)).a(cVar.d().b(this.f21762a.b().c(), this.f21762a)).a(cVar.c().b(this.f21762a.b().a(), this.f21762a));
            com.tencent.cloud.huiyansdkface.a.d.a.b("V1ConfigSelector", "get camera config:" + aVar.toString(), new Object[0]);
            return aVar;
        } catch (Exception e) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.a(21, "read parameter error", e));
            return null;
        }
    }
}
