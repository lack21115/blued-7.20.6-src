package com.opos.exoplayer.core.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/l.class */
public interface l {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/l$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final m f25250a;
        public final m b;

        public a(m mVar) {
            this(mVar, mVar);
        }

        public a(m mVar, m mVar2) {
            this.f25250a = (m) com.opos.exoplayer.core.i.a.a(mVar);
            this.b = (m) com.opos.exoplayer.core.i.a.a(mVar2);
        }

        public boolean equals(Object obj) {
            boolean z;
            if (this != obj) {
                z = false;
                if (obj != null) {
                    if (getClass() != obj.getClass()) {
                        return false;
                    }
                    a aVar = (a) obj;
                    z = false;
                    if (this.f25250a.equals(aVar.f25250a)) {
                        if (!this.b.equals(aVar.b)) {
                            return false;
                        }
                    }
                }
                return z;
            }
            z = true;
            return z;
        }

        public int hashCode() {
            return (this.f25250a.hashCode() * 31) + this.b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            sb.append(this.f25250a);
            if (this.f25250a.equals(this.b)) {
                str = "";
            } else {
                str = ", " + this.b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/l$b.class */
    public static final class b implements l {

        /* renamed from: a  reason: collision with root package name */
        private final long f25251a;
        private final a b;

        public b(long j) {
            this(j, 0L);
        }

        public b(long j, long j2) {
            this.f25251a = j;
            this.b = new a(j2 == 0 ? m.f25252a : new m(0L, j2));
        }

        @Override // com.opos.exoplayer.core.c.l
        public boolean a() {
            return false;
        }

        @Override // com.opos.exoplayer.core.c.l
        public long b() {
            return this.f25251a;
        }

        @Override // com.opos.exoplayer.core.c.l
        public a b(long j) {
            return this.b;
        }
    }

    boolean a();

    long b();

    a b(long j);
}
