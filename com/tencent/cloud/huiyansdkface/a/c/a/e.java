package com.tencent.cloud.huiyansdkface.a.c.a;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/e.class */
public class e implements com.tencent.cloud.huiyansdkface.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.c.d f35453a;

    public e(com.tencent.cloud.huiyansdkface.a.c.d dVar) {
        this.f35453a = dVar;
    }

    @Override // com.tencent.cloud.huiyansdkface.a.a.b
    public com.tencent.cloud.huiyansdkface.a.a.a a(com.tencent.cloud.huiyansdkface.a.a.c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            com.tencent.cloud.huiyansdkface.a.a.a aVar = new com.tencent.cloud.huiyansdkface.a.a.a();
            aVar.a(this.f35453a.b().b() ? cVar.i() : -1.0f).a(cVar.g().b(this.f35453a.b().f(), this.f35453a)).b(cVar.h().b(this.f35453a.b().g(), this.f35453a)).c(cVar.e().b(this.f35453a.b().d(), this.f35453a)).b(cVar.f().b(this.f35453a.b().e(), this.f35453a)).a(cVar.d().b(this.f35453a.b().c(), this.f35453a)).a(cVar.c().b(this.f35453a.b().a(), this.f35453a));
            com.tencent.cloud.huiyansdkface.a.d.a.b("V1ConfigSelector", "get camera config:" + aVar.toString(), new Object[0]);
            return aVar;
        } catch (Exception e) {
            com.tencent.cloud.huiyansdkface.a.b.b.a(com.tencent.cloud.huiyansdkface.a.b.c.a(21, "read parameter error", e));
            return null;
        }
    }
}
