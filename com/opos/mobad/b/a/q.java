package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/q.class */
public final class q extends com.heytap.nearx.a.a.b<q, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<q> f12066c = new c();
    public static final b d = b.NO_TYPE;
    private static final long serialVersionUID = 0;
    public final b e;
    public final List<String> f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/q$a.class */
    public static final class a extends b.a<q, a> {

        /* renamed from: c  reason: collision with root package name */
        public b f12067c;
        public List<String> d = com.heytap.nearx.a.a.a.b.a();

        public a a(b bVar) {
            this.f12067c = bVar;
            return this;
        }

        public q b() {
            return new q(this.f12067c, this.d, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/q$b.class */
    public enum b implements com.heytap.nearx.a.a.i {
        NO_TYPE(0),
        DOWNLOAD_START(1),
        DOWNLOAD_COMPLETE(2),
        INSTALL_COMPLETE(3);
        
        public static final com.heytap.nearx.a.a.e<b> e = com.heytap.nearx.a.a.e.a(b.class);
        private final int f;

        b(int i) {
            this.f = i;
        }

        public static b fromValue(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return null;
                        }
                        return INSTALL_COMPLETE;
                    }
                    return DOWNLOAD_COMPLETE;
                }
                return DOWNLOAD_START;
            }
            return NO_TYPE;
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.f;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/q$c.class */
    static final class c extends com.heytap.nearx.a.a.e<q> {
        c() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, q.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(q qVar) {
            return (qVar.e != null ? b.e.a(1, (int) qVar.e) : 0) + com.heytap.nearx.a.a.e.p.a().a(2, (int) qVar.f) + qVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, q qVar) throws IOException {
            if (qVar.e != null) {
                b.e.a(gVar, 1, qVar.e);
            }
            com.heytap.nearx.a.a.e.p.a().a(gVar, 2, qVar.f);
            gVar.a(qVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public q a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    try {
                        aVar.a(b.e.a(fVar));
                    } catch (e.a e) {
                        aVar.a(b, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f8655a));
                    }
                } else if (b != 2) {
                    com.heytap.nearx.a.a.a c2 = fVar.c();
                    aVar.a(b, c2, c2.a().a(fVar));
                } else {
                    aVar.d.add(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public q(b bVar, List<String> list, ByteString byteString) {
        super(f12066c, byteString);
        this.e = bVar;
        this.f = com.heytap.nearx.a.a.a.b.b("trackUrls", list);
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", downLoadTrackType=");
            sb.append(this.e);
        }
        if (!this.f.isEmpty()) {
            sb.append(", trackUrls=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "DownLoadTrackEvent{");
        replace.append('}');
        return replace.toString();
    }
}
