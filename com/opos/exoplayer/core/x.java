package com.opos.exoplayer.core;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.q;
import com.opos.exoplayer.core.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/x.class */
public class x implements i, q.c, q.d {

    /* renamed from: a  reason: collision with root package name */
    protected final s[] f25590a;
    private final i b;

    /* renamed from: c  reason: collision with root package name */
    private final a f25591c;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.video.e> d;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.f.j> e;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.metadata.e> f;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.video.f> g;
    private final CopyOnWriteArraySet<com.opos.exoplayer.core.a.e> h;
    private Format i;
    private Format j;
    private Surface k;
    private boolean l;
    private int m;
    private SurfaceHolder n;
    private TextureView o;
    private com.opos.exoplayer.core.b.d p;
    private com.opos.exoplayer.core.b.d q;
    private int r;
    private com.opos.exoplayer.core.a.b s;
    private float t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/x$a.class */
    public final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.opos.exoplayer.core.a.e, com.opos.exoplayer.core.f.j, com.opos.exoplayer.core.metadata.e, com.opos.exoplayer.core.video.f {
        private a() {
        }

        @Override // com.opos.exoplayer.core.a.e
        public void a(int i) {
            x.this.r = i;
            Iterator it = x.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).a(i);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(int i, int i2, int i3, float f) {
            Iterator it = x.this.d.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.e) it.next()).a(i, i2, i3, f);
            }
            Iterator it2 = x.this.g.iterator();
            while (it2.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it2.next()).a(i, i2, i3, f);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(int i, long j) {
            Iterator it = x.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(i, j);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void a(int i, long j, long j2) {
            Iterator it = x.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).a(i, j, j2);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(Surface surface) {
            if (x.this.k == surface) {
                Iterator it = x.this.d.iterator();
                while (it.hasNext()) {
                    ((com.opos.exoplayer.core.video.e) it.next()).a();
                }
            }
            Iterator it2 = x.this.g.iterator();
            while (it2.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it2.next()).a(surface);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(Format format) {
            x.this.i = format;
            Iterator it = x.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(format);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(com.opos.exoplayer.core.b.d dVar) {
            x.this.p = dVar;
            Iterator it = x.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(dVar);
            }
        }

        @Override // com.opos.exoplayer.core.metadata.e
        public void a(Metadata metadata) {
            Iterator it = x.this.f.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.metadata.e) it.next()).a(metadata);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void a(String str, long j, long j2) {
            Iterator it = x.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).a(str, j, j2);
            }
        }

        @Override // com.opos.exoplayer.core.f.j
        public void a(List<com.opos.exoplayer.core.f.b> list) {
            Iterator it = x.this.e.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.f.j) it.next()).a(list);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void b(Format format) {
            x.this.j = format;
            Iterator it = x.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).b(format);
            }
        }

        @Override // com.opos.exoplayer.core.video.f
        public void b(com.opos.exoplayer.core.b.d dVar) {
            Iterator it = x.this.g.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.video.f) it.next()).b(dVar);
            }
            x.this.i = null;
            x.this.p = null;
        }

        @Override // com.opos.exoplayer.core.a.e
        public void b(String str, long j, long j2) {
            Iterator it = x.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).b(str, j, j2);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void c(com.opos.exoplayer.core.b.d dVar) {
            x.this.q = dVar;
            Iterator it = x.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).c(dVar);
            }
        }

        @Override // com.opos.exoplayer.core.a.e
        public void d(com.opos.exoplayer.core.b.d dVar) {
            Iterator it = x.this.h.iterator();
            while (it.hasNext()) {
                ((com.opos.exoplayer.core.a.e) it.next()).d(dVar);
            }
            x.this.j = null;
            x.this.q = null;
            x.this.r = 0;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            x.this.a(new Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            x.this.a((Surface) null, true);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            x.this.a(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            x.this.a((Surface) null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public x(v vVar, com.opos.exoplayer.core.g.h hVar, n nVar) {
        this(vVar, hVar, nVar, com.opos.exoplayer.core.i.b.f25479a);
    }

    protected x(v vVar, com.opos.exoplayer.core.g.h hVar, n nVar, com.opos.exoplayer.core.i.b bVar) {
        this.f25591c = new a();
        this.d = new CopyOnWriteArraySet<>();
        this.e = new CopyOnWriteArraySet<>();
        this.f = new CopyOnWriteArraySet<>();
        this.g = new CopyOnWriteArraySet<>();
        this.h = new CopyOnWriteArraySet<>();
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        a aVar = this.f25591c;
        this.f25590a = vVar.a(handler, aVar, aVar, aVar, aVar);
        this.t = 1.0f;
        this.r = 0;
        this.s = com.opos.exoplayer.core.a.b.f25008a;
        this.m = 1;
        this.b = a(this.f25590a, hVar, nVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        ArrayList<r> arrayList = new ArrayList();
        s[] sVarArr = this.f25590a;
        int length = sVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            s sVar = sVarArr[i2];
            if (sVar.a() == 2) {
                arrayList.add(this.b.a(sVar).a(1).a(surface).i());
            }
            i = i2 + 1;
        }
        Surface surface2 = this.k;
        if (surface2 != null && surface2 != surface) {
            try {
                for (r rVar : arrayList) {
                    rVar.j();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            try {
                if (this.l && this.k != null) {
                    this.k.release();
                }
            } catch (Exception e2) {
            }
        }
        this.k = surface;
        this.l = z;
    }

    private void q() {
        TextureView textureView = this.o;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.f25591c) {
                com.opos.cmn.an.f.a.c("SimpleExoPlayer", "SurfaceTextureListener already unset or replaced.");
            } else {
                this.o.setSurfaceTextureListener(null);
            }
            this.o = null;
        }
        SurfaceHolder surfaceHolder = this.n;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.f25591c);
            this.n = null;
        }
    }

    protected i a(s[] sVarArr, com.opos.exoplayer.core.g.h hVar, n nVar, com.opos.exoplayer.core.i.b bVar) {
        return new z(sVarArr, hVar, nVar, bVar);
    }

    @Override // com.opos.exoplayer.core.q
    public q.d a() {
        return this;
    }

    @Override // com.opos.exoplayer.core.i
    public r a(r.b bVar) {
        return this.b.a(bVar);
    }

    public void a(float f) {
        this.t = f;
        s[] sVarArr = this.f25590a;
        int length = sVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            s sVar = sVarArr[i2];
            if (sVar.a() == 1) {
                this.b.a(sVar).a(2).a(Float.valueOf(f)).i();
            }
            i = i2 + 1;
        }
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i) {
        this.b.a(i);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i, long j) {
        this.b.a(i, j);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(long j) {
        this.b.a(j);
    }

    public void a(SurfaceHolder surfaceHolder) {
        Surface surface;
        q();
        this.n = surfaceHolder;
        if (surfaceHolder == null) {
            surface = null;
        } else {
            surfaceHolder.addCallback(this.f25591c);
            Surface surface2 = surfaceHolder.getSurface();
            surface = null;
            if (surface2 != null) {
                surface = null;
                if (surface2.isValid()) {
                    surface = surface2;
                }
            }
        }
        a(surface, false);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void a(SurfaceView surfaceView) {
        a(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.opos.exoplayer.core.q.d
    public void a(TextureView textureView) {
        Surface surface;
        q();
        this.o = textureView;
        if (textureView == null) {
            surface = null;
        } else {
            if (textureView.getSurfaceTextureListener() != null) {
                com.opos.cmn.an.f.a.c("SimpleExoPlayer", "Replacing existing SurfaceTextureListener.");
            }
            textureView.setSurfaceTextureListener(this.f25591c);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            surface = surfaceTexture == null ? null : new Surface(surfaceTexture);
        }
        a(surface, true);
    }

    @Override // com.opos.exoplayer.core.i
    public void a(com.opos.exoplayer.core.e.e eVar) {
        this.b.a(eVar);
    }

    @Override // com.opos.exoplayer.core.q.c
    public void a(com.opos.exoplayer.core.f.j jVar) {
        this.e.add(jVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(q.b bVar) {
        this.b.a(bVar);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void a(com.opos.exoplayer.core.video.e eVar) {
        this.d.add(eVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(boolean z) {
        this.b.a(z);
    }

    @Override // com.opos.exoplayer.core.q
    public int b(int i) {
        return this.b.b(i);
    }

    @Override // com.opos.exoplayer.core.q
    public q.c b() {
        return this;
    }

    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null || surfaceHolder != this.n) {
            return;
        }
        a((SurfaceHolder) null);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void b(SurfaceView surfaceView) {
        b(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.opos.exoplayer.core.q.d
    public void b(TextureView textureView) {
        if (textureView == null || textureView != this.o) {
            return;
        }
        a((TextureView) null);
    }

    @Override // com.opos.exoplayer.core.q.c
    public void b(com.opos.exoplayer.core.f.j jVar) {
        this.e.remove(jVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void b(q.b bVar) {
        this.b.b(bVar);
    }

    @Override // com.opos.exoplayer.core.q.d
    public void b(com.opos.exoplayer.core.video.e eVar) {
        this.d.remove(eVar);
    }

    @Override // com.opos.exoplayer.core.q
    public int c() {
        return this.b.c();
    }

    @Override // com.opos.exoplayer.core.q
    public boolean d() {
        return this.b.d();
    }

    @Override // com.opos.exoplayer.core.q
    public p e() {
        return this.b.e();
    }

    @Override // com.opos.exoplayer.core.q
    public void f() {
        this.b.f();
        q();
        Surface surface = this.k;
        if (surface != null) {
            if (this.l) {
                surface.release();
            }
            this.k = null;
        }
        CopyOnWriteArraySet<com.opos.exoplayer.core.video.e> copyOnWriteArraySet = this.d;
        if (copyOnWriteArraySet != null) {
            copyOnWriteArraySet.clear();
        }
    }

    @Override // com.opos.exoplayer.core.q
    public com.opos.exoplayer.core.g.g g() {
        return this.b.g();
    }

    @Override // com.opos.exoplayer.core.q
    public y h() {
        return this.b.h();
    }

    @Override // com.opos.exoplayer.core.q
    public int i() {
        return this.b.i();
    }

    @Override // com.opos.exoplayer.core.q
    public int j() {
        return this.b.j();
    }

    @Override // com.opos.exoplayer.core.q
    public int k() {
        return this.b.k();
    }

    @Override // com.opos.exoplayer.core.q
    public long l() {
        return this.b.l();
    }

    @Override // com.opos.exoplayer.core.q
    public long m() {
        return this.b.m();
    }

    @Override // com.opos.exoplayer.core.q
    public long n() {
        return this.b.n();
    }

    @Override // com.opos.exoplayer.core.q
    public boolean o() {
        return this.b.o();
    }

    @Override // com.opos.exoplayer.core.q
    public long p() {
        return this.b.p();
    }
}
