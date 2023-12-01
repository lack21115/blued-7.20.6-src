package com.anythink.expressad.exoplayer.b;

import android.os.Handler;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/g.class */
public interface g {

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/g$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f7182a;
        private final g b;

        public a(Handler handler, g gVar) {
            this.f7182a = gVar != null ? (Handler) com.anythink.expressad.exoplayer.k.a.a(handler) : null;
            this.b = gVar;
        }

        public final void a(final int i) {
            if (this.b != null) {
                this.f7182a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(i);
                    }
                });
            }
        }

        public final void a(final int i, final long j, final long j2) {
            if (this.b != null) {
                this.f7182a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(i, j, j2);
                    }
                });
            }
        }

        public final void a(final com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.f7182a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.c(dVar);
                    }
                });
            }
        }

        public final void a(final com.anythink.expressad.exoplayer.m mVar) {
            if (this.b != null) {
                this.f7182a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.b(mVar);
                    }
                });
            }
        }

        public final void a(final String str, final long j, final long j2) {
            if (this.b != null) {
                this.f7182a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.b(str, j, j2);
                    }
                });
            }
        }

        public final void b(final com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.f7182a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.b.g.a.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.d(dVar);
                    }
                });
            }
        }
    }

    void a(int i);

    void a(int i, long j, long j2);

    void b(com.anythink.expressad.exoplayer.m mVar);

    void b(String str, long j, long j2);

    void c(com.anythink.expressad.exoplayer.c.d dVar);

    void d(com.anythink.expressad.exoplayer.c.d dVar);
}
