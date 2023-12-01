package com.opos.exoplayer.core;

import android.view.SurfaceView;
import android.view.TextureView;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/q.class */
public interface q {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/q$a.class */
    public static abstract class a implements b {
        @Override // com.opos.exoplayer.core.q.b
        public void a(int i) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(com.opos.exoplayer.core.e.m mVar, com.opos.exoplayer.core.g.g gVar) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(h hVar) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(p pVar) {
        }

        @Deprecated
        public void a(y yVar, Object obj) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(y yVar, Object obj, int i) {
            a(yVar, obj);
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(boolean z) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void a(boolean z, int i) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void b(int i) {
        }

        @Override // com.opos.exoplayer.core.q.b
        public void e_() {
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/q$b.class */
    public interface b {
        void a(int i);

        void a(com.opos.exoplayer.core.e.m mVar, com.opos.exoplayer.core.g.g gVar);

        void a(h hVar);

        void a(p pVar);

        void a(y yVar, Object obj, int i);

        void a(boolean z);

        void a(boolean z, int i);

        void b(int i);

        void e_();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/q$c.class */
    public interface c {
        void a(com.opos.exoplayer.core.f.j jVar);

        void b(com.opos.exoplayer.core.f.j jVar);
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/q$d.class */
    public interface d {
        void a(SurfaceView surfaceView);

        void a(TextureView textureView);

        void a(com.opos.exoplayer.core.video.e eVar);

        void b(SurfaceView surfaceView);

        void b(TextureView textureView);

        void b(com.opos.exoplayer.core.video.e eVar);
    }

    d a();

    void a(int i);

    void a(int i, long j);

    void a(long j);

    void a(b bVar);

    void a(boolean z);

    int b(int i);

    c b();

    void b(b bVar);

    int c();

    boolean d();

    p e();

    void f();

    com.opos.exoplayer.core.g.g g();

    y h();

    int i();

    int j();

    int k();

    long l();

    long m();

    long n();

    boolean o();

    long p();
}
