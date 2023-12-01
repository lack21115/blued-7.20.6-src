package com.tencent.cloud.huiyansdkface.a.c.a;

import android.hardware.Camera;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/c/a/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.a.a.a f21766a;
    private com.tencent.cloud.huiyansdkface.a.a.c b;

    public h(com.tencent.cloud.huiyansdkface.a.a.a aVar, com.tencent.cloud.huiyansdkface.a.a.c cVar) {
        this.f21766a = aVar;
        this.b = cVar;
    }

    public void a(a aVar) {
        j jVar = new j();
        final com.tencent.cloud.huiyansdkface.a.a.a aVar2 = this.f21766a;
        jVar.a(new i() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.h.1
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, a aVar3) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1SingParaOperator", "start config focus mode.", new Object[0]);
                String f = aVar2.f();
                if (f != null) {
                    parameters.setFocusMode(f);
                }
            }
        });
        jVar.a(new i() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.h.2
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, a aVar3) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1SingParaOperator", "start config flash mode.", new Object[0]);
                String e = aVar2.e();
                if (e != null) {
                    parameters.setFlashMode(e);
                }
            }
        });
        jVar.a(new i() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.h.3
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, a aVar3) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1SingParaOperator", "start config previewSize.", new Object[0]);
                com.tencent.cloud.huiyansdkface.a.a.a.d a2 = aVar2.a();
                if (a2 != null) {
                    parameters.setPreviewSize(a2.a(), a2.b());
                }
            }
        });
        jVar.a(new i() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.h.4
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, a aVar3) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1SingParaOperator", "start config pictureSize.", new Object[0]);
                com.tencent.cloud.huiyansdkface.a.a.a.d c2 = aVar2.c();
                if (c2 != null) {
                    parameters.setPictureSize(c2.a(), c2.b());
                }
            }
        });
        jVar.a(new i() { // from class: com.tencent.cloud.huiyansdkface.a.c.a.h.5
            @Override // com.tencent.cloud.huiyansdkface.a.c.a.i
            public void a(Camera.Parameters parameters, a aVar3) {
                com.tencent.cloud.huiyansdkface.a.d.a.a("V1SingParaOperator", "start config fps.", new Object[0]);
                com.tencent.cloud.huiyansdkface.a.a.a.b b = aVar2.b();
                if (b == null || !b.c()) {
                    return;
                }
                parameters.setPreviewFpsRange(b.a(), b.b());
            }
        });
        List<com.tencent.cloud.huiyansdkface.a.a.e> a2 = this.b.a();
        if (a2 != null && a2.size() > 0) {
            int size = a2.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                com.tencent.cloud.huiyansdkface.a.a.e eVar = a2.get(i);
                if (eVar instanceof i) {
                    jVar.a((i) eVar);
                }
                size = i;
            }
        }
        jVar.a(aVar);
    }
}
