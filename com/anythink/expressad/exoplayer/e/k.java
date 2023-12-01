package com.anythink.expressad.exoplayer.e;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/k.class */
public interface k {

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/k$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final l f7321a;
        public final l b;

        public a(l lVar) {
            this(lVar, lVar);
        }

        public a(l lVar, l lVar2) {
            this.f7321a = (l) com.anythink.expressad.exoplayer.k.a.a(lVar);
            this.b = (l) com.anythink.expressad.exoplayer.k.a.a(lVar2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7321a.equals(aVar.f7321a) && this.b.equals(aVar.b);
        }

        public final int hashCode() {
            return (this.f7321a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder("[");
            sb.append(this.f7321a);
            if (this.f7321a.equals(this.b)) {
                str = "";
            } else {
                str = ", " + this.b;
            }
            sb.append(str);
            sb.append("]");
            return sb.toString();
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/k$b.class */
    public static final class b implements k {

        /* renamed from: a  reason: collision with root package name */
        private final long f7322a;
        private final a b;

        private b(long j) {
            this(j, 0L);
        }

        public b(long j, long j2) {
            this.f7322a = j;
            this.b = new a(j2 == 0 ? l.f7323a : new l(0L, j2));
        }

        @Override // com.anythink.expressad.exoplayer.e.k
        public final a a(long j) {
            return this.b;
        }

        @Override // com.anythink.expressad.exoplayer.e.k
        public final boolean a() {
            return false;
        }

        @Override // com.anythink.expressad.exoplayer.e.k
        public final long b() {
            return this.f7322a;
        }
    }

    a a(long j);

    boolean a();

    long b();
}
