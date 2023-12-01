package com.anythink.expressad.exoplayer.h;

import android.os.Handler;
import android.os.Looper;
import com.anythink.expressad.exoplayer.h.s;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/t.class */
public interface t {

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/t$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f4647a;
        public final s.a b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList<C0062a> f4648c;
        private final long d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.anythink.expressad.exoplayer.h.t$a$a  reason: collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/t$a$a.class */
        public static final class C0062a {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f4664a;
            public final t b;

            public C0062a(Handler handler, t tVar) {
                this.f4664a = handler;
                this.b = tVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private a(CopyOnWriteArrayList<C0062a> copyOnWriteArrayList, int i, s.a aVar, long j) {
            this.f4648c = copyOnWriteArrayList;
            this.f4647a = i;
            this.b = aVar;
            this.d = j;
        }

        private long a(long j) {
            long a2 = com.anythink.expressad.exoplayer.b.a(j);
            return a2 == com.anythink.expressad.exoplayer.b.b ? com.anythink.expressad.exoplayer.b.b : this.d + a2;
        }

        private static void a(Handler handler, Runnable runnable) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }

        private void a(com.anythink.expressad.exoplayer.j.k kVar, int i, long j) {
            a(kVar, i, -1, null, 0, null, com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, j);
        }

        private void a(com.anythink.expressad.exoplayer.j.k kVar, int i, long j, long j2, long j3) {
            a(kVar, i, -1, null, 0, null, com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, j, j2, j3);
        }

        private void b(com.anythink.expressad.exoplayer.j.k kVar, int i, long j, long j2, long j3) {
            b(kVar, i, -1, null, 0, null, com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, j, j2, j3);
        }

        public final a a(int i, s.a aVar, long j) {
            return new a(this.f4648c, i, aVar, j);
        }

        public final void a() {
            com.anythink.expressad.exoplayer.k.a.b(this.b != null);
            Iterator<C0062a> it = this.f4648c.iterator();
            while (it.hasNext()) {
                C0062a next = it.next();
                final t tVar = next.b;
                a(next.f4664a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        tVar.a(a.this.f4647a, a.this.b);
                    }
                });
            }
        }

        public final void a(int i, long j, long j2) {
            a(new c(1, i, null, 3, null, a(j), a(j2)));
        }

        public final void a(int i, com.anythink.expressad.exoplayer.m mVar, int i2, Object obj, long j) {
            b(new c(1, i, mVar, i2, obj, a(j), com.anythink.expressad.exoplayer.b.b));
        }

        public final void a(Handler handler, t tVar) {
            com.anythink.expressad.exoplayer.k.a.a((handler == null || tVar == null) ? false : true);
            this.f4648c.add(new C0062a(handler, tVar));
        }

        public final void a(final b bVar, final c cVar) {
            Iterator<C0062a> it = this.f4648c.iterator();
            while (it.hasNext()) {
                C0062a next = it.next();
                final t tVar = next.b;
                a(next.f4664a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        tVar.a(a.this.f4647a, a.this.b, bVar, cVar);
                    }
                });
            }
        }

        public final void a(final b bVar, final c cVar, final IOException iOException, final boolean z) {
            Iterator<C0062a> it = this.f4648c.iterator();
            while (it.hasNext()) {
                C0062a next = it.next();
                final t tVar = next.b;
                a(next.f4664a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        tVar.a(a.this.f4647a, a.this.b, bVar, cVar, iOException, z);
                    }
                });
            }
        }

        public final void a(final c cVar) {
            Iterator<C0062a> it = this.f4648c.iterator();
            while (it.hasNext()) {
                C0062a next = it.next();
                final t tVar = next.b;
                a(next.f4664a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.8
                    @Override // java.lang.Runnable
                    public final void run() {
                        tVar.a(a.this.f4647a, a.this.b, cVar);
                    }
                });
            }
        }

        public final void a(t tVar) {
            Iterator<C0062a> it = this.f4648c.iterator();
            while (it.hasNext()) {
                C0062a next = it.next();
                if (next.b == tVar) {
                    this.f4648c.remove(next);
                }
            }
        }

        public final void a(com.anythink.expressad.exoplayer.j.k kVar, int i, int i2, com.anythink.expressad.exoplayer.m mVar, int i3, Object obj, long j, long j2, long j3) {
            a(new b(kVar, j3, 0L, 0L), new c(i, i2, mVar, i3, obj, a(j), a(j2)));
        }

        public final void a(com.anythink.expressad.exoplayer.j.k kVar, int i, int i2, com.anythink.expressad.exoplayer.m mVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            b(new b(kVar, j3, j4, j5), new c(i, i2, mVar, i3, obj, a(j), a(j2)));
        }

        public final void a(com.anythink.expressad.exoplayer.j.k kVar, int i, int i2, com.anythink.expressad.exoplayer.m mVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            a(new b(kVar, j3, j4, j5), new c(i, i2, mVar, i3, obj, a(j), a(j2)), iOException, z);
        }

        public final void a(com.anythink.expressad.exoplayer.j.k kVar, IOException iOException) {
            a(kVar, 6, -1, null, 0, null, com.anythink.expressad.exoplayer.b.b, com.anythink.expressad.exoplayer.b.b, -1L, 0L, 0L, iOException, true);
        }

        public final void b() {
            com.anythink.expressad.exoplayer.k.a.b(this.b != null);
            Iterator<C0062a> it = this.f4648c.iterator();
            while (it.hasNext()) {
                C0062a next = it.next();
                final t tVar = next.b;
                a(next.f4664a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        tVar.b(a.this.f4647a, a.this.b);
                    }
                });
            }
        }

        public final void b(final b bVar, final c cVar) {
            Iterator<C0062a> it = this.f4648c.iterator();
            while (it.hasNext()) {
                C0062a next = it.next();
                final t tVar = next.b;
                a(next.f4664a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        tVar.b(a.this.f4647a, a.this.b, bVar, cVar);
                    }
                });
            }
        }

        public final void b(final c cVar) {
            Iterator<C0062a> it = this.f4648c.iterator();
            while (it.hasNext()) {
                C0062a next = it.next();
                final t tVar = next.b;
                a(next.f4664a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.9
                    @Override // java.lang.Runnable
                    public final void run() {
                        tVar.b(a.this.f4647a, a.this.b, cVar);
                    }
                });
            }
        }

        public final void b(com.anythink.expressad.exoplayer.j.k kVar, int i, int i2, com.anythink.expressad.exoplayer.m mVar, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            c(new b(kVar, j3, j4, j5), new c(i, i2, mVar, i3, obj, a(j), a(j2)));
        }

        public final void c() {
            com.anythink.expressad.exoplayer.k.a.b(this.b != null);
            Iterator<C0062a> it = this.f4648c.iterator();
            while (it.hasNext()) {
                C0062a next = it.next();
                final t tVar = next.b;
                a(next.f4664a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.7
                    @Override // java.lang.Runnable
                    public final void run() {
                        tVar.c(a.this.f4647a, a.this.b);
                    }
                });
            }
        }

        public final void c(final b bVar, final c cVar) {
            Iterator<C0062a> it = this.f4648c.iterator();
            while (it.hasNext()) {
                C0062a next = it.next();
                final t tVar = next.b;
                a(next.f4664a, new Runnable() { // from class: com.anythink.expressad.exoplayer.h.t.a.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        tVar.c(a.this.f4647a, a.this.b, bVar, cVar);
                    }
                });
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/t$b.class */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final com.anythink.expressad.exoplayer.j.k f4665a;
        public final long b;

        /* renamed from: c  reason: collision with root package name */
        public final long f4666c;
        public final long d;

        public b(com.anythink.expressad.exoplayer.j.k kVar, long j, long j2, long j3) {
            this.f4665a = kVar;
            this.b = j;
            this.f4666c = j2;
            this.d = j3;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/h/t$c.class */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f4667a;
        public final int b;

        /* renamed from: c  reason: collision with root package name */
        public final com.anythink.expressad.exoplayer.m f4668c;
        public final int d;
        public final Object e;
        public final long f;
        public final long g;

        public c(int i, int i2, com.anythink.expressad.exoplayer.m mVar, int i3, Object obj, long j, long j2) {
            this.f4667a = i;
            this.b = i2;
            this.f4668c = mVar;
            this.d = i3;
            this.e = obj;
            this.f = j;
            this.g = j2;
        }
    }

    void a(int i, s.a aVar);

    void a(int i, s.a aVar, b bVar, c cVar);

    void a(int i, s.a aVar, b bVar, c cVar, IOException iOException, boolean z);

    void a(int i, s.a aVar, c cVar);

    void b(int i, s.a aVar);

    void b(int i, s.a aVar, b bVar, c cVar);

    void b(int i, s.a aVar, c cVar);

    void c(int i, s.a aVar);

    void c(int i, s.a aVar, b bVar, c cVar);
}
