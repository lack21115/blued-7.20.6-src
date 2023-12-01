package a.a.a.a.a.b;

import a.a.a.a.a.b.c;
import a.a.a.a.a.b.h;
import a.a.a.a.a.b.i.j;
import a.a.a.a.a.b.i.l;
import a.a.a.a.a.b.i.m;
import a.a.a.a.a.b.i.o;
import a.a.a.a.a.b.i.p;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Looper;
import android.os.Process;
import com.qiniu.pili.droid.streaming.PreviewAppearance;
import com.qiniu.pili.droid.streaming.StreamingPreviewCallback;
import com.qiniu.pili.droid.streaming.SurfaceTextureCallback;
import com.qiniu.pili.droid.streaming.WatermarkSetting;
import com.qiniu.pili.droid.streaming.av.common.PLFourCC;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/e.class */
public class e implements GLSurfaceView.Renderer {
    public a.a.a.a.a.b.i.a A;
    public o B;
    public j C;
    public p D;
    public o E;
    public o F;
    public m G;
    public h H;
    public h I;
    public a.a.a.a.a.b.i.q.a J;
    public boolean K;
    public boolean L;
    public WatermarkSetting M;
    public PreviewAppearance N;
    public boolean O;
    public long P;
    public long Q;
    public StreamingPreviewCallback R;
    public int S;
    public boolean T;
    public c.i b;

    /* renamed from: c  reason: collision with root package name */
    public Looper f1305c;
    public int d;
    public int e;
    public long g;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public boolean w;
    public int x;
    public boolean y;
    public l z;

    /* renamed from: a  reason: collision with root package name */
    public final float[] f1304a = new float[16];
    public final Object f = new Object();
    public SurfaceTexture h = null;
    public List<SurfaceTextureCallback> i = new ArrayList();

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/e$a.class */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(-8);
            Looper.prepare();
            e.this.h = new SurfaceTexture(e.this.d);
            e.this.f1305c = Looper.myLooper();
            synchronized (e.this.f) {
                e.this.f.notify();
            }
            Looper.loop();
        }
    }

    public e(c.i iVar) {
        this.y = false;
        h hVar = new h();
        this.H = hVar;
        this.I = hVar;
        this.P = 0L;
        this.Q = 0L;
        this.T = false;
        this.b = iVar;
        this.d = -1;
        this.y = false;
    }

    public void a(int i) {
        this.S = i;
        m mVar = this.G;
        if (mVar != null) {
            mVar.a(i);
        }
    }

    public final void a(int i, int i2) {
        o oVar = new o();
        this.E = oVar;
        oVar.a(i, i2, false);
    }

    public void a(PreviewAppearance previewAppearance) {
        this.N = previewAppearance;
    }

    public void a(StreamingPreviewCallback streamingPreviewCallback) {
        this.R = streamingPreviewCallback;
    }

    public void a(SurfaceTextureCallback surfaceTextureCallback) {
        if (surfaceTextureCallback != null) {
            this.i.add(surfaceTextureCallback);
        }
    }

    public void a(WatermarkSetting watermarkSetting) {
        this.M = watermarkSetting;
        this.L = true;
    }

    public void a(boolean z, int i, int i2, int i3, int i4, int i5, int i6, boolean z2, boolean z3, int i7) {
        if (i3 == this.o && i4 == this.p && i5 == this.q && i6 == this.r && z3 == this.w && this.x == i7) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
            eVar.c("CameraSurfaceRenderer", "setCameraPreviewSize equal!!" + i3 + "  " + i4);
            if (this.O) {
                return;
            }
            this.j = true;
            return;
        }
        this.t = z;
        a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.g;
        eVar2.c("CameraSurfaceRenderer", "setCameraPreviewSize previewSettingWidth:" + i3 + ",previewSettingHeight:" + i4);
        this.o = i3;
        this.p = i4;
        if (i7 == 0 || i7 == 180) {
            this.u = i;
            this.v = i2;
            this.k = i3;
            this.l = i4;
        } else {
            this.u = i2;
            this.v = i;
            this.k = i4;
            this.l = i3;
        }
        this.q = i5;
        this.r = i6;
        this.s = z2;
        if (z2) {
            this.m = i5;
            this.n = i6;
        } else {
            this.m = this.k;
            this.n = this.l;
        }
        this.w = z3;
        this.x = i7;
        this.j = true;
    }

    public boolean a() {
        return this.O;
    }

    public boolean a(boolean z) {
        this.K = z;
        return true;
    }

    public int b() {
        return this.e;
    }

    public final void b(int i) {
        long j = this.P + i;
        this.P = j;
        long j2 = this.Q + 1;
        this.Q = j2;
        if (j2 >= 90) {
            a.a.a.a.a.j.a.a().a((int) (j / j2));
            this.Q = 0L;
            this.P = 0L;
        }
    }

    public void c() {
        a.a.a.a.a.e.e.g.c("CameraSurfaceRenderer", "notifyPausing +");
        this.y = true;
        if (this.h != null) {
            a.a.a.a.a.e.e.g.c("CameraSurfaceRenderer", "renderer pausing -- releasing SurfaceTexture");
            if (Build.VERSION.SDK_INT < 16) {
                this.h.release();
            }
            this.h = null;
        }
        h();
        if (!this.i.isEmpty()) {
            for (SurfaceTextureCallback surfaceTextureCallback : this.i) {
                surfaceTextureCallback.onSurfaceDestroyed();
            }
        }
        Looper looper = this.f1305c;
        if (looper != null) {
            looper.quit();
            this.f1305c = null;
        }
        a.a.a.a.a.e.e.g.c("CameraSurfaceRenderer", "notifyPausing -");
    }

    public void d() {
        if (this.h != null) {
            a.a.a.a.a.e.e.g.c("CameraSurfaceRenderer", "releasing SurfaceTexture");
            this.h.release();
            this.h = null;
        }
    }

    public final void e() {
        if (this.M != null) {
            p pVar = new p();
            this.D = pVar;
            PreviewAppearance previewAppearance = this.N;
            if (previewAppearance != null) {
                pVar.a(this.m, this.n, previewAppearance.x, previewAppearance.y, previewAppearance.w, previewAppearance.h, this.M);
            } else {
                pVar.a(this.m, this.n, this.M);
            }
        }
    }

    public final void f() {
        p pVar = this.D;
        if (pVar != null) {
            pVar.a();
            this.D = null;
        }
    }

    public final c.m g() {
        return new c.m(this.h, this.d, a.a.a.a.a.a.h.d.a());
    }

    public final void h() {
        this.E = null;
        this.O = false;
        this.A = null;
        this.z = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.F = null;
        this.I.a();
        this.I = this.H;
    }

    public final void i() {
        this.O = false;
        a.a.a.a.a.b.i.q.a aVar = this.J;
        if (aVar != null) {
            aVar.a();
            this.J = null;
        }
        m mVar = this.G;
        if (mVar != null) {
            mVar.g();
            this.G = null;
        }
        a.a.a.a.a.b.i.a aVar2 = this.A;
        if (aVar2 != null) {
            aVar2.g();
            this.A = null;
        }
        l lVar = this.z;
        if (lVar != null) {
            lVar.g();
            this.z = null;
        }
        o oVar = this.B;
        if (oVar != null) {
            oVar.e();
            this.B = null;
        }
        j jVar = this.C;
        if (jVar != null) {
            jVar.g();
            this.C = null;
        }
        f();
        o oVar2 = this.F;
        if (oVar2 != null) {
            oVar2.e();
            this.F = null;
        }
        this.I.a();
        this.I = this.H;
    }

    public final void j() {
        int i;
        int i2;
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.c("CameraSurfaceRenderer", "cropEnabled: " + this.t + " cropWidth: " + this.u + " cropHeight: " + this.v + " isFrontCamera: " + this.w + ",previewWidth:" + this.k + ",previewHeight:" + this.l + " rotation: " + this.x + " encodingWidth: " + this.q + " encodingHeight: " + this.r + " mIsMirror:" + this.K);
        l lVar = new l();
        this.z = lVar;
        lVar.a(0, this.k, this.l);
        a.a.a.a.a.b.i.a aVar = new a.a.a.a.a.b.i.a();
        this.A = aVar;
        aVar.a(0, this.k, this.l);
        m mVar = new m();
        this.G = mVar;
        mVar.a(this.k, this.l);
        this.G.a(this.S);
        if (this.t) {
            i = this.u;
            i2 = this.v;
            o oVar = new o();
            this.B = oVar;
            oVar.a(this.u, this.v, true);
            this.B.a(this.k, this.l, 0.0f, 0.0f, 1.0f, 1.0f, PreviewAppearance.ScaleType.FULL);
        } else {
            i = this.k;
            i2 = this.l;
        }
        j jVar = new j();
        this.C = jVar;
        jVar.a(i, i2);
        if (this.s) {
            o oVar2 = new o();
            this.F = oVar2;
            oVar2.a(this.m, this.n, true);
            PreviewAppearance previewAppearance = this.N;
            if (previewAppearance != null) {
                this.F.a(i, i2, previewAppearance.x, previewAppearance.y, previewAppearance.w, previewAppearance.h, previewAppearance.scaleType);
            } else {
                this.F.a(i, i2, 0.0f, 0.0f, 1.0f, 1.0f, PreviewAppearance.ScaleType.FULL);
            }
        }
        e();
        this.O = true;
    }

    public final void k() {
        this.E.d();
        o oVar = this.E;
        int i = this.m;
        int i2 = this.n;
        PreviewAppearance previewAppearance = this.N;
        oVar.a(i, i2, 0.0f, 0.0f, 1.0f, 1.0f, previewAppearance != null ? previewAppearance.scaleType : PreviewAppearance.ScaleType.FULL);
    }

    public final void l() {
        Looper looper = this.f1305c;
        if (looper != null) {
            looper.quit();
            this.f1305c = null;
        }
        new Thread(new a()).start();
        synchronized (this.f) {
            while (this.f1305c == null) {
                try {
                    this.f.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.g;
        eVar.a("CameraSurfaceRenderer", "onDrawFrame tex=" + this.d);
        if (this.g != Thread.currentThread().getId()) {
            a.a.a.a.a.e.e.g.e("CameraSurfaceRenderer", "Error. Not in GLThread");
        } else if (this.y) {
            a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.g;
            eVar2.c("CameraSurfaceRenderer", "mPaused:" + this.y);
        } else {
            SurfaceTexture surfaceTexture = this.h;
            if (surfaceTexture == null) {
                return;
            }
            try {
                surfaceTexture.updateTexImage();
                if (this.T) {
                    this.T = false;
                    return;
                }
                this.h.getTransformMatrix(this.f1304a);
                if (this.o == 0 || this.p == 0) {
                    return;
                }
                int i = this.d;
                int i2 = i;
                if (!this.i.isEmpty()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (SurfaceTextureCallback surfaceTextureCallback : this.i) {
                        int onDrawFrame = surfaceTextureCallback.onDrawFrame(i, this.o, this.p, this.f1304a);
                        if (onDrawFrame > 0) {
                            i = onDrawFrame;
                        }
                    }
                    b((int) (System.currentTimeMillis() - Long.valueOf(currentTimeMillis).longValue()));
                    i2 = i;
                }
                if (this.j) {
                    this.j = false;
                    i();
                    j();
                    k();
                }
                if (this.O) {
                    synchronized (a.a.a.a.a.a.h.f.d) {
                        if (i2 != this.d) {
                            this.e = this.z.b(i2, this.f1304a);
                        } else {
                            this.e = this.A.b(i2, this.f1304a);
                        }
                        if (this.G != null) {
                            this.e = this.G.d(this.e);
                        }
                        if (this.R != null) {
                            if (this.J == null) {
                                this.J = new a.a.a.a.a.b.i.q.a();
                            }
                            this.R.onPreviewFrame(this.J.a(this.e, this.k, this.l).array(), this.k, this.l, 0, PLFourCC.FOURCC_I420, this.h.getTimestamp());
                        }
                        if (this.B != null) {
                            this.e = this.B.a(0, this.e);
                        }
                    }
                    int i3 = this.e;
                    int i4 = i3;
                    if (this.K) {
                        j jVar = this.C;
                        i4 = i3;
                        if (jVar != null) {
                            i4 = jVar.d(i3);
                        }
                    }
                    o oVar = this.F;
                    int i5 = i4;
                    if (oVar != null) {
                        i5 = oVar.a(0, i4);
                    }
                    if (this.L) {
                        this.L = false;
                        f();
                        e();
                    }
                    if (this.R == null || !a.a.a.a.a.f.e.a().b()) {
                        p pVar = this.D;
                        if (pVar != null) {
                            pVar.a(i5);
                        }
                    } else {
                        if (this.I == this.H) {
                            h hVar = new h();
                            this.I = hVar;
                            hVar.a(this.R);
                            this.I.a((Object) new h.a(this.k, this.l, this.m, this.n, a.a.a.a.a.a.h.d.a()));
                        }
                        if (this.D != null) {
                            synchronized (a.a.a.a.a.a.h.f.d) {
                                this.D.a(i5);
                                GLES20.glFinish();
                            }
                        }
                        this.I.a(i5, this.h);
                    }
                    this.E.b(0, i5);
                }
            } catch (Exception e) {
                e.printStackTrace();
                a.a.a.a.a.e.e.g.e("CameraSurfaceRenderer", "update surface texture failed !!!");
            }
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        a.a.a.a.a.e.e.g.c("CameraSurfaceRenderer", "onSurfaceChanged " + i + "x" + i2);
        this.T = true;
        if (!this.i.isEmpty()) {
            for (SurfaceTextureCallback surfaceTextureCallback : this.i) {
                surfaceTextureCallback.onSurfaceChanged(i, i2);
            }
        }
        o oVar = this.E;
        boolean z = false;
        if (oVar != null) {
            z = oVar.c() > 0;
            this.E.e();
        }
        a(i, i2);
        if (z) {
            k();
        }
        c.i iVar = this.b;
        iVar.sendMessage(iVar.obtainMessage(1));
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        a.a.a.a.a.e.e.g.c("CameraSurfaceRenderer", "onSurfaceCreated");
        this.g = Thread.currentThread().getId();
        this.b.removeCallbacksAndMessages(null);
        h();
        this.d = a.a.a.a.a.a.h.f.e();
        l();
        c.i iVar = this.b;
        iVar.sendMessage(iVar.obtainMessage(0, g()));
        if (!this.i.isEmpty()) {
            for (SurfaceTextureCallback surfaceTextureCallback : this.i) {
                surfaceTextureCallback.onSurfaceCreated();
            }
        }
        this.y = false;
    }
}
