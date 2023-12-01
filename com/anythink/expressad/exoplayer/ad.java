package com.anythink.expressad.exoplayer;

import android.graphics.SurfaceTexture;
import android.media.PlaybackParams;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.anythink.expressad.exoplayer.a.a;
import com.anythink.expressad.exoplayer.b.b;
import com.anythink.expressad.exoplayer.h;
import com.anythink.expressad.exoplayer.k.af;
import com.anythink.expressad.exoplayer.w;
import com.anythink.expressad.exoplayer.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/ad.class */
public class ad implements h, w.e, w.g {
    private static final String x = "SimpleExoPlayer";
    private final a A;
    private final CopyOnWriteArraySet<com.anythink.expressad.exoplayer.l.g> B;
    private final CopyOnWriteArraySet<com.anythink.expressad.exoplayer.g.f> C;
    private final CopyOnWriteArraySet<com.anythink.expressad.exoplayer.l.h> D;
    private final CopyOnWriteArraySet<com.anythink.expressad.exoplayer.b.g> E;
    private final com.anythink.expressad.exoplayer.a.a F;
    private m G;
    private m H;
    private Surface I;
    private boolean J;
    private int K;
    private SurfaceHolder L;
    private TextureView M;
    private com.anythink.expressad.exoplayer.c.d N;
    private com.anythink.expressad.exoplayer.c.d O;
    private int P;
    private com.anythink.expressad.exoplayer.b.b Q;
    private float R;
    private com.anythink.expressad.exoplayer.h.s S;
    protected final y[] w;
    private final h y;
    private final Handler z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/ad$a.class */
    public final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, com.anythink.expressad.exoplayer.b.g, com.anythink.expressad.exoplayer.g.f, com.anythink.expressad.exoplayer.l.h {
        private a() {
        }

        /* synthetic */ a(ad adVar, byte b) {
            this();
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void a(int i) {
            ad.this.P = i;
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).a(i);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(int i, int i2, int i3, float f) {
            Iterator it = ad.this.B.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.g) it.next()).a(i, i2);
            }
            Iterator it2 = ad.this.D.iterator();
            while (it2.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it2.next()).a(i, i2, i3, f);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(int i, long j) {
            Iterator it = ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(i, j);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void a(int i, long j, long j2) {
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).a(i, j, j2);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(Surface surface) {
            if (ad.this.I == surface) {
                Iterator it = ad.this.B.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            Iterator it2 = ad.this.D.iterator();
            while (it2.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it2.next()).a(surface);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(com.anythink.expressad.exoplayer.c.d dVar) {
            ad.this.N = dVar;
            Iterator it = ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(dVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.g.f
        public final void a(com.anythink.expressad.exoplayer.g.a aVar) {
            Iterator it = ad.this.C.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.g.f) it.next()).a(aVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(m mVar) {
            ad.this.G = mVar;
            Iterator it = ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(mVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void a(String str, long j, long j2) {
            Iterator it = ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).a(str, j, j2);
            }
        }

        @Override // com.anythink.expressad.exoplayer.l.h
        public final void b(com.anythink.expressad.exoplayer.c.d dVar) {
            Iterator it = ad.this.D.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.l.h) it.next()).b(dVar);
            }
            ad.this.G = null;
            ad.this.N = null;
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void b(m mVar) {
            ad.this.H = mVar;
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).b(mVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void b(String str, long j, long j2) {
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).b(str, j, j2);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void c(com.anythink.expressad.exoplayer.c.d dVar) {
            ad.this.O = dVar;
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).c(dVar);
            }
        }

        @Override // com.anythink.expressad.exoplayer.b.g
        public final void d(com.anythink.expressad.exoplayer.c.d dVar) {
            Iterator it = ad.this.E.iterator();
            while (it.hasNext()) {
                ((com.anythink.expressad.exoplayer.b.g) it.next()).d(dVar);
            }
            ad.this.H = null;
            ad.this.O = null;
            ad.this.P = 0;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            ad.this.a(new Surface(surfaceTexture), true);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ad.this.a((Surface) null, true);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            ad.this.a(surfaceHolder.getSurface(), false);
        }

        @Override // android.view.SurfaceHolder.Callback
        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ad.this.a((Surface) null, false);
        }
    }

    @Deprecated
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/ad$b.class */
    public interface b extends com.anythink.expressad.exoplayer.l.g {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ad(ab abVar, com.anythink.expressad.exoplayer.i.h hVar, p pVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar) {
        this(abVar, hVar, pVar, gVar, (byte) 0);
        new a.C0118a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ad(ab abVar, com.anythink.expressad.exoplayer.i.h hVar, p pVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, byte b2) {
        this(abVar, hVar, pVar, gVar, com.anythink.expressad.exoplayer.k.c.f7640a);
    }

    private ad(ab abVar, com.anythink.expressad.exoplayer.i.h hVar, p pVar, com.anythink.expressad.exoplayer.d.g<com.anythink.expressad.exoplayer.d.k> gVar, com.anythink.expressad.exoplayer.k.c cVar) {
        this.A = new a(this, (byte) 0);
        this.B = new CopyOnWriteArraySet<>();
        this.C = new CopyOnWriteArraySet<>();
        this.D = new CopyOnWriteArraySet<>();
        this.E = new CopyOnWriteArraySet<>();
        Handler handler = new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.z = handler;
        a aVar = this.A;
        this.w = abVar.a(handler, aVar, aVar, aVar, gVar);
        this.R = 1.0f;
        this.P = 0;
        this.Q = com.anythink.expressad.exoplayer.b.b.f7172a;
        this.K = 1;
        j jVar = new j(this.w, hVar, pVar, cVar);
        this.y = jVar;
        com.anythink.expressad.exoplayer.a.a a2 = a.C0118a.a(jVar, cVar);
        this.F = a2;
        a((w.c) a2);
        this.D.add(this.F);
        this.E.add(this.F);
        a(this.F);
        if (gVar instanceof com.anythink.expressad.exoplayer.d.d) {
            ((com.anythink.expressad.exoplayer.d.d) gVar).a(this.z, this.F);
        }
    }

    @Deprecated
    private int K() {
        return af.f(this.Q.d);
    }

    private com.anythink.expressad.exoplayer.a.a L() {
        return this.F;
    }

    private com.anythink.expressad.exoplayer.b.b M() {
        return this.Q;
    }

    private float N() {
        return this.R;
    }

    private m O() {
        return this.G;
    }

    private m P() {
        return this.H;
    }

    private int Q() {
        return this.P;
    }

    private com.anythink.expressad.exoplayer.c.d R() {
        return this.N;
    }

    private com.anythink.expressad.exoplayer.c.d S() {
        return this.O;
    }

    private void T() {
        TextureView textureView = this.M;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.A) {
                Log.w(x, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.M.setSurfaceTextureListener(null);
            }
            this.M = null;
        }
        SurfaceHolder surfaceHolder = this.L;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.A);
            this.L = null;
        }
    }

    private static h a(y[] yVarArr, com.anythink.expressad.exoplayer.i.h hVar, p pVar, com.anythink.expressad.exoplayer.k.c cVar) {
        return new j(yVarArr, hVar, pVar, cVar);
    }

    @Deprecated
    private void a(PlaybackParams playbackParams) {
        v vVar;
        if (playbackParams != null) {
            playbackParams.allowDefaults();
            vVar = new v(playbackParams.getSpeed(), playbackParams.getPitch());
        } else {
            vVar = null;
        }
        a(vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Surface surface, boolean z) {
        ArrayList<x> arrayList = new ArrayList();
        y[] yVarArr = this.w;
        int length = yVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                break;
            }
            y yVar = yVarArr[i2];
            if (yVar.a() == 2) {
                arrayList.add(this.y.a(yVar).a(1).a(surface).i());
            }
            i = i2 + 1;
        }
        Surface surface2 = this.I;
        if (surface2 != null && surface2 != surface) {
            try {
                for (x xVar : arrayList) {
                    xVar.k();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException e2) {
                this.y.c(false);
            }
            if (this.J) {
                this.I.release();
            }
        }
        this.I = surface;
        this.J = z;
    }

    private void a(com.anythink.expressad.exoplayer.a.b bVar) {
        this.F.a(bVar);
    }

    @Deprecated
    private void a(b bVar) {
        this.B.clear();
        if (bVar != null) {
            a((com.anythink.expressad.exoplayer.l.g) bVar);
        }
    }

    private void a(com.anythink.expressad.exoplayer.b.b bVar) {
        this.Q = bVar;
        y[] yVarArr = this.w;
        int length = yVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            y yVar = yVarArr[i2];
            if (yVar.a() == 1) {
                this.y.a(yVar).a(3).a(bVar).i();
            }
            i = i2 + 1;
        }
    }

    @Deprecated
    private void a(com.anythink.expressad.exoplayer.b.g gVar) {
        this.E.retainAll(Collections.singleton(this.F));
        if (gVar != null) {
            this.E.add(gVar);
        }
    }

    private void a(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.add(fVar);
    }

    @Deprecated
    private void a(com.anythink.expressad.exoplayer.l.h hVar) {
        this.D.retainAll(Collections.singleton(this.F));
        if (hVar != null) {
            this.D.add(hVar);
        }
    }

    private void b(com.anythink.expressad.exoplayer.a.b bVar) {
        this.F.b(bVar);
    }

    @Deprecated
    private void b(b bVar) {
        b((com.anythink.expressad.exoplayer.l.g) bVar);
    }

    @Deprecated
    private void b(com.anythink.expressad.exoplayer.b.g gVar) {
        this.E.add(gVar);
    }

    private void b(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.remove(fVar);
    }

    @Deprecated
    private void b(com.anythink.expressad.exoplayer.l.h hVar) {
        this.D.add(hVar);
    }

    @Deprecated
    private void c(com.anythink.expressad.exoplayer.b.g gVar) {
        this.E.remove(gVar);
    }

    @Deprecated
    private void c(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.retainAll(Collections.singleton(this.F));
        if (fVar != null) {
            a(fVar);
        }
    }

    @Deprecated
    private void c(com.anythink.expressad.exoplayer.l.h hVar) {
        this.D.remove(hVar);
    }

    @Deprecated
    private void d(com.anythink.expressad.exoplayer.g.f fVar) {
        this.C.remove(fVar);
    }

    @Deprecated
    private void e(int i) {
        int d = af.d(i);
        com.anythink.expressad.exoplayer.b.b a2 = new b.a().b(d).a(af.e(i)).a();
        this.Q = a2;
        y[] yVarArr = this.w;
        int length = yVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            y yVar = yVarArr[i3];
            if (yVar.a() == 1) {
                this.y.a(yVar).a(3).a(a2).i();
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int A() {
        return this.y.A();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long B() {
        return this.y.B();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int C() {
        return this.y.C();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.h.af D() {
        return this.y.D();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final com.anythink.expressad.exoplayer.i.g E() {
        return this.y.E();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final ae F() {
        return this.y.F();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final Object G() {
        return this.y.G();
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final int H() {
        return this.K;
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void I() {
        a((Surface) null);
    }

    public final boolean J() {
        return d() == 3 && f();
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final Looper a() {
        return this.y.a();
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final x a(x.b bVar) {
        return this.y.a(bVar);
    }

    public final void a(float f) {
        this.R = f;
        y[] yVarArr = this.w;
        int length = yVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            y yVar = yVarArr[i2];
            if (yVar.a() == 1) {
                this.y.a(yVar).a(2).a(Float.valueOf(f)).i();
            }
            i = i2 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i) {
        this.y.a(i);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(int i, long j) {
        this.F.a();
        this.y.a(i, j);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(long j) {
        this.F.a();
        this.y.a(j);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(Surface surface) {
        T();
        a(surface, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
        if (r5.isValid() != false) goto L7;
     */
    @Override // com.anythink.expressad.exoplayer.w.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.SurfaceHolder r5) {
        /*
            r4 = this;
            r0 = r4
            r0.T()
            r0 = r4
            r1 = r5
            r0.L = r1
            r0 = r5
            if (r0 != 0) goto L10
            goto L2f
        L10:
            r0 = r5
            r1 = r4
            com.anythink.expressad.exoplayer.ad$a r1 = r1.A
            r0.addCallback(r1)
            r0 = r5
            android.view.Surface r0 = r0.getSurface()
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L2f
            r0 = r5
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L2f
            goto L31
        L2f:
            r0 = 0
            r5 = r0
        L31:
            r0 = r4
            r1 = r5
            r2 = 0
            r0.a(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.exoplayer.ad.a(android.view.SurfaceHolder):void");
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(SurfaceView surfaceView) {
        a(surfaceView == null ? null : surfaceView.getHolder());
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(TextureView textureView) {
        Surface surface;
        T();
        this.M = textureView;
        if (textureView == null) {
            surface = null;
        } else {
            if (textureView.getSurfaceTextureListener() != null) {
                Log.w(x, "Replacing existing SurfaceTextureListener.");
            }
            textureView.setSurfaceTextureListener(this.A);
            SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
            surface = surfaceTexture == null ? null : new Surface(surfaceTexture);
        }
        a(surface, true);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(ac acVar) {
        this.y.a(acVar);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar) {
        a(sVar, true, true);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(com.anythink.expressad.exoplayer.h.s sVar, boolean z, boolean z2) {
        com.anythink.expressad.exoplayer.h.s sVar2 = this.S;
        if (sVar2 != sVar) {
            if (sVar2 != null) {
                sVar2.a(this.F);
                this.F.b();
            }
            sVar.a(this.z, this.F);
            this.S = sVar;
        }
        this.y.a(sVar, z, z2);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void a(com.anythink.expressad.exoplayer.l.g gVar) {
        this.B.add(gVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(v vVar) {
        this.y.a(vVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(w.c cVar) {
        this.y.a(cVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void a(boolean z) {
        this.y.a(z);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void a(h.c... cVarArr) {
        this.y.a(cVarArr);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final w.g b() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(int i) {
        this.F.a();
        this.y.b(i);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(Surface surface) {
        if (surface == null || surface != this.I) {
            return;
        }
        a((Surface) null);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null || surfaceHolder != this.L) {
            return;
        }
        a((SurfaceHolder) null);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        if (holder == null || holder != this.L) {
            return;
        }
        a((SurfaceHolder) null);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(TextureView textureView) {
        if (textureView == null || textureView != this.M) {
            return;
        }
        a((TextureView) null);
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void b(com.anythink.expressad.exoplayer.l.g gVar) {
        this.B.remove(gVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(w.c cVar) {
        this.y.b(cVar);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void b(boolean z) {
        this.y.b(z);
    }

    @Override // com.anythink.expressad.exoplayer.h
    public final void b(h.c... cVarArr) {
        this.y.b(cVarArr);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int c(int i) {
        return this.y.c(i);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final w.e c() {
        return this;
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void c(boolean z) {
        this.y.c(z);
        com.anythink.expressad.exoplayer.h.s sVar = this.S;
        if (sVar != null) {
            sVar.a(this.F);
            this.S = null;
            this.F.b();
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int d() {
        return this.y.d();
    }

    @Override // com.anythink.expressad.exoplayer.w.g
    public final void d(int i) {
        this.K = i;
        y[] yVarArr = this.w;
        int length = yVarArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            y yVar = yVarArr[i3];
            if (yVar.a() == 2) {
                this.y.a(yVar).a(4).a(Integer.valueOf(i)).i();
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final g e() {
        return this.y.e();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean f() {
        return this.y.f();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int g() {
        return this.y.g();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean h() {
        return this.y.h();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean i() {
        return this.y.i();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void j() {
        this.F.a();
        this.y.j();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final v k() {
        return this.y.k();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final Object l() {
        return this.y.l();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void m() {
        c(false);
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final void n() {
        this.y.n();
        T();
        Surface surface = this.I;
        if (surface != null) {
            if (this.J) {
                surface.release();
            }
            this.I = null;
        }
        com.anythink.expressad.exoplayer.h.s sVar = this.S;
        if (sVar != null) {
            sVar.a(this.F);
        }
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int o() {
        return this.y.o();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int p() {
        return this.y.p();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int q() {
        return this.y.q();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int r() {
        return this.y.r();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long s() {
        return this.y.s();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long t() {
        return this.y.t();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final long u() {
        return this.y.u();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int v() {
        return this.y.v();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean w() {
        return this.y.w();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean x() {
        return this.y.x();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final boolean y() {
        return this.y.y();
    }

    @Override // com.anythink.expressad.exoplayer.w
    public final int z() {
        return this.y.z();
    }
}
