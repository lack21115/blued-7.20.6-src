package com.opos.mobad.b.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ag.class */
public final class ag extends com.heytap.nearx.a.a.b<ag, a> {

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<ag> f12014c = new b();
    public static final c d = c.NO_TYPE;
    private static final long serialVersionUID = 0;
    public final c e;
    public final List<String> f;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ag$a.class */
    public static final class a extends b.a<ag, a> {

        /* renamed from: c  reason: collision with root package name */
        public c f12015c;
        public List<String> d = com.heytap.nearx.a.a.a.b.a();

        public a a(c cVar) {
            this.f12015c = cVar;
            return this;
        }

        public ag b() {
            return new ag(this.f12015c, this.d, super.a());
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ag$b.class */
    static final class b extends com.heytap.nearx.a.a.e<ag> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, ag.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(ag agVar) {
            return (agVar.e != null ? c.i.a(1, (int) agVar.e) : 0) + com.heytap.nearx.a.a.e.p.a().a(2, (int) agVar.f) + agVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, ag agVar) throws IOException {
            if (agVar.e != null) {
                c.i.a(gVar, 1, agVar.e);
            }
            com.heytap.nearx.a.a.e.p.a().a(gVar, 2, agVar.f);
            gVar.a(agVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* renamed from: b */
        public ag a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long a2 = fVar.a();
            while (true) {
                int b = fVar.b();
                if (b == -1) {
                    fVar.a(a2);
                    return aVar.b();
                } else if (b == 1) {
                    try {
                        aVar.a(c.i.a(fVar));
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

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ag$c.class */
    public enum c implements com.heytap.nearx.a.a.i {
        NO_TYPE(0),
        VIDEO_START(1),
        VIDEO_PROCESS_25_PERCENT(2),
        VIDEO_PROCESS_50_PERCENT(3),
        VIDEO_PROCESS_75_PERCENT(4),
        VIDEO_COMPLETE(5),
        VIDEO_CLICK(6),
        VIDEO_CLOSE(7);
        
        public static final com.heytap.nearx.a.a.e<c> i = com.heytap.nearx.a.a.e.a(c.class);
        private final int j;

        c(int i2) {
            this.j = i2;
        }

        public static c fromValue(int i2) {
            switch (i2) {
                case 0:
                    return NO_TYPE;
                case 1:
                    return VIDEO_START;
                case 2:
                    return VIDEO_PROCESS_25_PERCENT;
                case 3:
                    return VIDEO_PROCESS_50_PERCENT;
                case 4:
                    return VIDEO_PROCESS_75_PERCENT;
                case 5:
                    return VIDEO_COMPLETE;
                case 6:
                    return VIDEO_CLICK;
                case 7:
                    return VIDEO_CLOSE;
                default:
                    return null;
            }
        }

        @Override // com.heytap.nearx.a.a.i
        public int a() {
            return this.j;
        }
    }

    public ag(c cVar, List<String> list, ByteString byteString) {
        super(f12014c, byteString);
        this.e = cVar;
        this.f = com.heytap.nearx.a.a.a.b.b("trackUrls", list);
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", videoTrackType=");
            sb.append(this.e);
        }
        if (!this.f.isEmpty()) {
            sb.append(", trackUrls=");
            sb.append(this.f);
        }
        StringBuilder replace = sb.replace(0, 2, "VideoTrackEvent{");
        replace.append('}');
        return replace.toString();
    }
}
