package com.anythink.expressad.exoplayer.l;

import android.os.Handler;
import android.view.Surface;
import com.anythink.expressad.exoplayer.m;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/h.class */
public interface h {

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/l/h$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f7708a;
        private final h b;

        public a(Handler handler, h hVar) {
            this.f7708a = hVar != null ? (Handler) com.anythink.expressad.exoplayer.k.a.a(handler) : null;
            this.b = hVar;
        }

        public final void a(final int i, final int i2, final int i3, final float f) {
            if (this.b != null) {
                this.f7708a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.5
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(i, i2, i3, f);
                    }
                });
            }
        }

        public final void a(final int i, final long j) {
            if (this.b != null) {
                this.f7708a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(i, j);
                    }
                });
            }
        }

        public final void a(final Surface surface) {
            if (this.b != null) {
                this.f7708a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.6
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(surface);
                    }
                });
            }
        }

        public final void a(final com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.f7708a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(dVar);
                    }
                });
            }
        }

        public final void a(final m mVar) {
            if (this.b != null) {
                this.f7708a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(mVar);
                    }
                });
            }
        }

        public final void a(final String str, final long j, final long j2) {
            if (this.b != null) {
                this.f7708a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.a(str, j, j2);
                    }
                });
            }
        }

        public final void b(final com.anythink.expressad.exoplayer.c.d dVar) {
            if (this.b != null) {
                this.f7708a.post(new Runnable() { // from class: com.anythink.expressad.exoplayer.l.h.a.7
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.b.b(dVar);
                    }
                });
            }
        }
    }

    void a(int i, int i2, int i3, float f);

    void a(int i, long j);

    void a(Surface surface);

    void a(com.anythink.expressad.exoplayer.c.d dVar);

    void a(m mVar);

    void a(String str, long j, long j2);

    void b(com.anythink.expressad.exoplayer.c.d dVar);
}
