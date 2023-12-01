package com.cmic.gen.sdk.tencent.c.a;

import android.text.TextUtils;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/a/c.class */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private b f21619a;
    private com.cmic.gen.sdk.tencent.c.d.c b;

    /* renamed from: c  reason: collision with root package name */
    private final com.cmic.gen.sdk.tencent.c.a f21620c = new com.cmic.gen.sdk.tencent.c.a();

    public void a(b bVar) {
        this.f21619a = bVar;
    }

    @Override // com.cmic.gen.sdk.tencent.c.a.b
    public void a(com.cmic.gen.sdk.tencent.c.c.c cVar, com.cmic.gen.sdk.tencent.c.d.c cVar2, com.cmic.gen.sdk.tencent.a aVar) {
        b(cVar, cVar2, aVar);
    }

    public void b(final com.cmic.gen.sdk.tencent.c.c.c cVar, final com.cmic.gen.sdk.tencent.c.d.c cVar2, final com.cmic.gen.sdk.tencent.a aVar) {
        if (this.f21619a != null) {
            this.b = new com.cmic.gen.sdk.tencent.c.d.c() { // from class: com.cmic.gen.sdk.tencent.c.a.c.1
                @Override // com.cmic.gen.sdk.tencent.c.d.c
                public void a(com.cmic.gen.sdk.tencent.c.d.a aVar2) {
                    if (!cVar.j()) {
                        cVar2.a(aVar2);
                        return;
                    }
                    com.cmic.gen.sdk.tencent.e.c.a("RetryAndRedirectInterceptor", "retry: " + cVar.a());
                    c.this.b(cVar, cVar2, aVar);
                }

                @Override // com.cmic.gen.sdk.tencent.c.d.c
                public void a(com.cmic.gen.sdk.tencent.c.d.b bVar) {
                    com.cmic.gen.sdk.tencent.c.c.c b;
                    if (bVar.d()) {
                        b = c.this.f21620c.a(cVar, bVar, aVar);
                    } else if (TextUtils.isEmpty(c.this.f21620c.a())) {
                        cVar2.a(bVar);
                        return;
                    } else {
                        b = c.this.f21620c.b(cVar, bVar, aVar);
                    }
                    c.this.b(b, cVar2, aVar);
                }
            };
            if (cVar.g()) {
                this.f21619a.a(cVar, this.b, aVar);
            } else {
                cVar2.a(com.cmic.gen.sdk.tencent.c.d.a.a(200025));
            }
        }
    }
}
