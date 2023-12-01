package com.anythink.expressad.exoplayer.d;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/c.class */
public interface c {

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/c$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final CopyOnWriteArrayList<C0052a> f4403a = new CopyOnWriteArrayList<>();

        /* renamed from: com.anythink.expressad.exoplayer.d.c$a$a  reason: collision with other inner class name */
        /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/d/c$a$a.class */
        static final class C0052a {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f4409a;
            public final c b;

            public C0052a(Handler handler, c cVar) {
                this.f4409a = handler;
                this.b = cVar;
            }
        }

        public final void a() {
            Iterator<C0052a> it = this.f4403a.iterator();
            while (it.hasNext()) {
                C0052a next = it.next();
                final c cVar = next.b;
                next.f4409a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.d.c.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.d();
                    }
                });
            }
        }

        public final void a(Handler handler, c cVar) {
            com.anythink.expressad.exoplayer.k.a.a((handler == null || cVar == null) ? false : true);
            this.f4403a.add(new C0052a(handler, cVar));
        }

        public final void a(c cVar) {
            Iterator<C0052a> it = this.f4403a.iterator();
            while (it.hasNext()) {
                C0052a next = it.next();
                if (next.b == cVar) {
                    this.f4403a.remove(next);
                }
            }
        }

        public final void a(final Exception exc) {
            Iterator<C0052a> it = this.f4403a.iterator();
            while (it.hasNext()) {
                C0052a next = it.next();
                final c cVar = next.b;
                next.f4409a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.d.c.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.a(exc);
                    }
                });
            }
        }

        public final void b() {
            Iterator<C0052a> it = this.f4403a.iterator();
            while (it.hasNext()) {
                C0052a next = it.next();
                final c cVar = next.b;
                next.f4409a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.d.c.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.e();
                    }
                });
            }
        }

        public final void c() {
            Iterator<C0052a> it = this.f4403a.iterator();
            while (it.hasNext()) {
                C0052a next = it.next();
                final c cVar = next.b;
                next.f4409a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.d.c.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        cVar.f();
                    }
                });
            }
        }
    }

    void a(Exception exc);

    void d();

    void e();

    void f();
}
