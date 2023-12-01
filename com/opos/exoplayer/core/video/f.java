package com.opos.exoplayer.core.video;

import android.os.Handler;
import android.view.Surface;
import com.opos.exoplayer.core.Format;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/f.class */
public interface f {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/video/f$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f25577a;
        private final f b;

        public a(Handler handler, f fVar) {
            this.f25577a = fVar != null ? (Handler) com.opos.exoplayer.core.i.a.a(handler) : null;
            this.b = fVar;
        }

        public void a(final int i, final int i2, final int i3, final float f) {
            if (this.b != null) {
                this.f25577a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.a(i, i2, i3, f);
                    }
                });
            }
        }

        public void a(final int i, final long j) {
            if (this.b != null) {
                this.f25577a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.a(i, j);
                    }
                });
            }
        }

        public void a(final Surface surface) {
            if (this.b != null) {
                this.f25577a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.a(surface);
                    }
                });
            }
        }

        public void a(final Format format) {
            if (this.b != null) {
                this.f25577a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.a(format);
                    }
                });
            }
        }

        public void a(final com.opos.exoplayer.core.b.d dVar) {
            if (this.b != null) {
                this.f25577a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.a(dVar);
                    }
                });
            }
        }

        public void a(final String str, final long j, final long j2) {
            if (this.b != null) {
                this.f25577a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.b.a(str, j, j2);
                    }
                });
            }
        }

        public void b(final com.opos.exoplayer.core.b.d dVar) {
            if (this.b != null) {
                this.f25577a.post(new Runnable() { // from class: com.opos.exoplayer.core.video.f.a.7
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.a();
                        a.this.b.b(dVar);
                    }
                });
            }
        }
    }

    void a(int i, int i2, int i3, float f);

    void a(int i, long j);

    void a(Surface surface);

    void a(Format format);

    void a(com.opos.exoplayer.core.b.d dVar);

    void a(String str, long j, long j2);

    void b(com.opos.exoplayer.core.b.d dVar);
}
