package com.meizu.cloud.pushsdk.c.c;

import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/h.class */
public final class h extends j {

    /* renamed from: a  reason: collision with root package name */
    public static final g f10422a = g.a("multipart/mixed");
    public static final g b = g.a("multipart/alternative");

    /* renamed from: c  reason: collision with root package name */
    public static final g f10423c = g.a("multipart/digest");
    public static final g d = g.a("multipart/parallel");
    public static final g e = g.a(HttpConstants.ContentType.MULTIPART_FORM_DATA);
    private static final byte[] f = {58, 32};
    private static final byte[] g = {13, 10};
    private static final byte[] h = {45, 45};
    private final com.meizu.cloud.pushsdk.c.g.e i;
    private final g j;
    private final g k;
    private final List<b> l;
    private long m = -1;

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/h$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final com.meizu.cloud.pushsdk.c.g.e f10424a;
        private g b;

        /* renamed from: c  reason: collision with root package name */
        private final List<b> f10425c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.b = h.f10422a;
            this.f10425c = new ArrayList();
            this.f10424a = com.meizu.cloud.pushsdk.c.g.e.a(str);
        }

        public a a(c cVar, j jVar) {
            return a(b.a(cVar, jVar));
        }

        public a a(g gVar) {
            if (gVar != null) {
                if ("multipart".equals(gVar.a())) {
                    this.b = gVar;
                    return this;
                }
                throw new IllegalArgumentException("multipart != " + gVar);
            }
            throw new NullPointerException("type == null");
        }

        public a a(b bVar) {
            if (bVar != null) {
                this.f10425c.add(bVar);
                return this;
            }
            throw new NullPointerException("part == null");
        }

        public h a() {
            if (this.f10425c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new h(this.f10424a, this.b, this.f10425c);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/h$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final c f10426a;
        private final j b;

        private b(c cVar, j jVar) {
            this.f10426a = cVar;
            this.b = jVar;
        }

        public static b a(c cVar, j jVar) {
            if (jVar != null) {
                if (cVar == null || cVar.a("Content-Type") == null) {
                    if (cVar == null || cVar.a("Content-Length") == null) {
                        return new b(cVar, jVar);
                    }
                    throw new IllegalArgumentException("Unexpected header: Content-Length");
                }
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            throw new NullPointerException("body == null");
        }
    }

    h(com.meizu.cloud.pushsdk.c.g.e eVar, g gVar, List<b> list) {
        this.i = eVar;
        this.j = gVar;
        this.k = g.a(gVar + "; boundary=" + eVar.a());
        this.l = m.a(list);
    }

    private long a(com.meizu.cloud.pushsdk.c.g.c cVar, boolean z) throws IOException {
        com.meizu.cloud.pushsdk.c.g.b bVar;
        com.meizu.cloud.pushsdk.c.g.b bVar2;
        if (z) {
            bVar = new com.meizu.cloud.pushsdk.c.g.b();
            bVar2 = bVar;
        } else {
            bVar = cVar;
            bVar2 = null;
        }
        int size = this.l.size();
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                bVar.c(h);
                bVar.b(this.i);
                bVar.c(h);
                bVar.c(g);
                long j2 = j;
                if (z) {
                    j2 = j + bVar2.a();
                    bVar2.j();
                }
                return j2;
            }
            b bVar3 = this.l.get(i2);
            c cVar2 = bVar3.f10426a;
            j jVar = bVar3.b;
            bVar.c(h);
            bVar.b(this.i);
            bVar.c(g);
            if (cVar2 != null) {
                int a2 = cVar2.a();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= a2) {
                        break;
                    }
                    bVar.b(cVar2.a(i4)).c(f).b(cVar2.b(i4)).c(g);
                    i3 = i4 + 1;
                }
            }
            g a3 = jVar.a();
            if (a3 != null) {
                bVar.b("Content-Type: ").b(a3.toString()).c(g);
            }
            long b2 = jVar.b();
            if (b2 != -1) {
                bVar.b("Content-Length: ").e(b2).c(g);
            } else if (z) {
                bVar2.j();
                return -1L;
            }
            bVar.c(g);
            if (z) {
                j += b2;
            } else {
                jVar.a(bVar);
            }
            bVar.c(g);
            i = i2 + 1;
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public g a() {
        return this.k;
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(com.meizu.cloud.pushsdk.c.g.c cVar) throws IOException {
        a(cVar, false);
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() throws IOException {
        long j = this.m;
        if (j != -1) {
            return j;
        }
        long a2 = a((com.meizu.cloud.pushsdk.c.g.c) null, true);
        this.m = a2;
        return a2;
    }
}
