package com.opos.exoplayer.core.a;

import android.os.Handler;
import com.opos.exoplayer.core.Format;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/e.class */
public interface e {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/e$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f25015a;
        private final e b;

        public a(Handler handler, e eVar) {
            this.f25015a = eVar != null ? (Handler) com.opos.exoplayer.core.i.a.a(handler) : null;
            this.b = eVar;
        }

        public void a(final int i) {
            if (this.b != null) {
                this.f25015a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.a(i);
                    }
                });
            }
        }

        public void a(final int i, final long j, final long j2) {
            if (this.b != null) {
                this.f25015a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.a(i, j, j2);
                    }
                });
            }
        }

        public void a(final Format format) {
            if (this.b != null) {
                this.f25015a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.b(format);
                    }
                });
            }
        }

        public void a(final com.opos.exoplayer.core.b.d dVar) {
            if (this.b != null) {
                this.f25015a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.c(dVar);
                    }
                });
            }
        }

        public void a(final String str, final long j, final long j2) {
            if (this.b != null) {
                this.f25015a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.b(str, j, j2);
                    }
                });
            }
        }

        public void b(final com.opos.exoplayer.core.b.d dVar) {
            if (this.b != null) {
                this.f25015a.post(new Runnable() { // from class: com.opos.exoplayer.core.a.e.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.a();
                        a.this.b.d(dVar);
                    }
                });
            }
        }
    }

    void a(int i);

    void a(int i, long j, long j2);

    void b(Format format);

    void b(String str, long j, long j2);

    void c(com.opos.exoplayer.core.b.d dVar);

    void d(com.opos.exoplayer.core.b.d dVar);
}
