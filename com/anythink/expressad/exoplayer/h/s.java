package com.anythink.expressad.exoplayer.h;

import android.os.Handler;
import com.blued.das.live.LiveProtos;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/s.class */
public interface s {

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/s$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f7484a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final int f7485c;
        public final long d;

        public a(int i) {
            this(i, -1L);
        }

        public a(int i, int i2, int i3, long j) {
            this.f7484a = i;
            this.b = i2;
            this.f7485c = i3;
            this.d = j;
        }

        public a(int i, long j) {
            this(i, -1, -1, j);
        }

        public final a a(int i) {
            return this.f7484a == i ? this : new a(i, this.b, this.f7485c, this.d);
        }

        public final boolean a() {
            return this.b != -1;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f7484a == aVar.f7484a && this.b == aVar.b && this.f7485c == aVar.f7485c && this.d == aVar.d;
        }

        public final int hashCode() {
            return ((((((this.f7484a + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.b) * 31) + this.f7485c) * 31) + ((int) this.d);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/s$b.class */
    public interface b {
        void a(s sVar, com.anythink.expressad.exoplayer.ae aeVar, Object obj);
    }

    r a(a aVar, com.anythink.expressad.exoplayer.j.b bVar);

    void a(Handler handler, t tVar);

    void a(r rVar);

    void a(b bVar);

    void a(t tVar);

    void a(com.anythink.expressad.exoplayer.h hVar, boolean z, b bVar);

    void b();
}
