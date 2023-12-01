package com.opos.exoplayer.core.e;

import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.y;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/e.class */
public interface e {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/e$a.class */
    public interface a {
        void a(e eVar, y yVar, Object obj);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/e$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f11598a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11599c;
        public final long d;

        public b(int i) {
            this(i, -1L);
        }

        public b(int i, int i2, int i3, long j) {
            this.f11598a = i;
            this.b = i2;
            this.f11599c = i3;
            this.d = j;
        }

        public b(int i, long j) {
            this(i, -1, -1, j);
        }

        public b a(int i) {
            return this.f11598a == i ? this : new b(i, this.b, this.f11599c, this.d);
        }

        public boolean a() {
            return this.b != -1;
        }

        public boolean equals(Object obj) {
            boolean z;
            if (this != obj) {
                z = false;
                if (obj != null) {
                    if (getClass() != obj.getClass()) {
                        return false;
                    }
                    b bVar = (b) obj;
                    z = false;
                    if (this.f11598a == bVar.f11598a) {
                        z = false;
                        if (this.b == bVar.b) {
                            z = false;
                            if (this.f11599c == bVar.f11599c) {
                                if (this.d != bVar.d) {
                                    return false;
                                }
                            }
                        }
                    }
                }
                return z;
            }
            z = true;
            return z;
        }

        public int hashCode() {
            return ((((((this.f11598a + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.b) * 31) + this.f11599c) * 31) + ((int) this.d);
        }
    }

    d a(b bVar, com.opos.exoplayer.core.h.b bVar2);

    void a();

    void a(d dVar);

    void a(com.opos.exoplayer.core.i iVar, boolean z, a aVar);

    void b();
}
