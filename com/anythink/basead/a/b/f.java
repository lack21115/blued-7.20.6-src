package com.anythink.basead.a.b;

import com.anythink.core.common.a.j;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.k;
import com.anythink.core.common.res.a.a;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/a/b/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    final String f5847a = f.class.getSimpleName();
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f5848c;
    private String d;
    private int e;
    private i f;
    private k g;
    private com.anythink.core.common.res.a.a h;

    public f(String str, final i iVar, k kVar) {
        this.b = iVar.x();
        this.f = iVar;
        this.g = kVar;
        this.f5848c = str;
        this.d = iVar.p();
        this.e = iVar.d();
        com.anythink.core.common.res.a.a a2 = com.anythink.core.common.res.a.c.a().a(this.b);
        this.h = a2;
        a2.a(new com.anythink.core.common.res.a.b(this.g.S(), this.g.U()));
        this.h.a(new a.AbstractC0108a() { // from class: com.anythink.basead.a.b.f.1
            @Override // com.anythink.core.common.res.a.a.AbstractC0108a
            public final void a(String str2, String str3) {
            }

            @Override // com.anythink.core.common.res.a.a.AbstractC0108a
            public final boolean a(int i, long j, long j2) {
                if (i >= f.this.g.S()) {
                    d.a().a(f.this.b, i);
                    return true;
                }
                return false;
            }
        });
        this.h.k = new a.b() { // from class: com.anythink.basead.a.b.f.2
            @Override // com.anythink.core.common.res.a.a.b
            public final void a(long j, long j2, long j3, long j4, long j5) {
                com.anythink.basead.a.b.a(30, iVar, new com.anythink.basead.c.i("", ""));
                com.anythink.core.common.j.c.a(f.this.f5848c, f.this.d, f.this.b, "1", j, (String) null, j2, j3, f.this.e, j5 - j4);
            }

            @Override // com.anythink.core.common.res.a.a.b
            public final void a(String str2, String str3, long j, long j2, long j3, long j4) {
                com.anythink.core.common.j.c.a(f.this.f5848c, f.this.d, f.this.b, "0", j, str3, j2, 0L, f.this.e, j4 - j3);
                d.a().a(f.this.b, com.anythink.basead.c.f.a(str2, str3));
            }
        };
    }

    public final void a() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d);
        sb.append(",");
        sb.append(this.b);
        sb.append(" startRequest");
        this.h.e();
    }

    public final void b() {
        int b = j.a().b(this.b);
        StringBuilder sb = new StringBuilder();
        sb.append(this.d);
        sb.append(",");
        sb.append(this.b);
        sb.append(" resumeRequest: readyRate:");
        sb.append(b);
        sb.append(",cdRate:");
        sb.append(this.g.T());
        if (b == 100) {
            return;
        }
        this.h.f();
    }
}
