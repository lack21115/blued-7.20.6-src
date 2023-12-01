package com.cmic.gen.sdk.tencent.c.a;

import android.content.Context;
import android.net.Network;
import android.os.Build;
import com.cmic.gen.sdk.tencent.e.n;
import com.cmic.gen.sdk.tencent.e.r;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/c/a/d.class */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private b f21623a;

    public void a(b bVar) {
        this.f21623a = bVar;
    }

    @Override // com.cmic.gen.sdk.tencent.c.a.b
    public void a(final com.cmic.gen.sdk.tencent.c.c.c cVar, final com.cmic.gen.sdk.tencent.c.d.c cVar2, final com.cmic.gen.sdk.tencent.a aVar) {
        if (!cVar.b()) {
            b(cVar, cVar2, aVar);
            return;
        }
        r a2 = r.a((Context) null);
        if (Build.VERSION.SDK_INT >= 21) {
            a2.a(new r.a() { // from class: com.cmic.gen.sdk.tencent.c.a.d.1
                private final AtomicBoolean e = new AtomicBoolean(false);

                @Override // com.cmic.gen.sdk.tencent.e.r.a
                public void a(final Network network) {
                    if (this.e.getAndSet(true)) {
                        return;
                    }
                    n.a(new n.a(null, aVar) { // from class: com.cmic.gen.sdk.tencent.c.a.d.1.1
                        @Override // com.cmic.gen.sdk.tencent.e.n.a
                        public void a() {
                            if (network == null) {
                                cVar2.a(com.cmic.gen.sdk.tencent.c.d.a.a(102508));
                                return;
                            }
                            com.cmic.gen.sdk.tencent.e.c.b("WifiChangeInterceptor", "onAvailable");
                            cVar.a(network);
                            d.this.b(cVar, cVar2, aVar);
                        }
                    });
                }
            });
            return;
        }
        com.cmic.gen.sdk.tencent.e.c.a("WifiChangeInterceptor", "低版本不在支持wifi切换");
        cVar2.a(com.cmic.gen.sdk.tencent.c.d.a.a(102508));
    }

    public void b(com.cmic.gen.sdk.tencent.c.c.c cVar, final com.cmic.gen.sdk.tencent.c.d.c cVar2, com.cmic.gen.sdk.tencent.a aVar) {
        b bVar = this.f21623a;
        if (bVar != null) {
            bVar.a(cVar, new com.cmic.gen.sdk.tencent.c.d.c() { // from class: com.cmic.gen.sdk.tencent.c.a.d.2
                @Override // com.cmic.gen.sdk.tencent.c.d.c
                public void a(com.cmic.gen.sdk.tencent.c.d.a aVar2) {
                    cVar2.a(aVar2);
                }

                @Override // com.cmic.gen.sdk.tencent.c.d.c
                public void a(com.cmic.gen.sdk.tencent.c.d.b bVar2) {
                    cVar2.a(bVar2);
                }
            }, aVar);
        }
    }
}
