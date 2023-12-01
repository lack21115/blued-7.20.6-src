package com.meizu.cloud.pushsdk.c.e;

import com.meizu.cloud.pushsdk.c.c.g;
import com.meizu.cloud.pushsdk.c.c.j;
import com.meizu.cloud.pushsdk.c.g.f;
import com.meizu.cloud.pushsdk.c.g.l;
import java.io.IOException;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/e/b.class */
public class b extends j {

    /* renamed from: a  reason: collision with root package name */
    private final j f10441a;
    private com.meizu.cloud.pushsdk.c.g.c b;

    /* renamed from: c  reason: collision with root package name */
    private d f10442c;

    public b(j jVar, com.meizu.cloud.pushsdk.c.d.a aVar) {
        this.f10441a = jVar;
        if (aVar != null) {
            this.f10442c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.c.e.b.1

            /* renamed from: a  reason: collision with root package name */
            long f10443a = 0;
            long b = 0;

            @Override // com.meizu.cloud.pushsdk.c.g.f, com.meizu.cloud.pushsdk.c.g.l
            public void a(com.meizu.cloud.pushsdk.c.g.b bVar, long j) throws IOException {
                super.a(bVar, j);
                if (this.b == 0) {
                    this.b = b.this.b();
                }
                this.f10443a += j;
                if (b.this.f10442c != null) {
                    b.this.f10442c.obtainMessage(1, new com.meizu.cloud.pushsdk.c.f.a(this.f10443a, this.b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public g a() {
        return this.f10441a.a();
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(com.meizu.cloud.pushsdk.c.g.c cVar) throws IOException {
        if (this.b == null) {
            this.b = com.meizu.cloud.pushsdk.c.g.g.a(a((l) cVar));
        }
        this.f10441a.a(this.b);
        this.b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() throws IOException {
        return this.f10441a.b();
    }
}
