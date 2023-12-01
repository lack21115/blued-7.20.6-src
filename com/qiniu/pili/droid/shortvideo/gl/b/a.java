package com.qiniu.pili.droid.shortvideo.gl.b;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.gl.a.f;
import com.qiniu.pili.droid.shortvideo.gl.c.g;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/b/a.class */
public class a implements SurfaceTexture.OnFrameAvailableListener, Runnable {
    private PLDisplayMode A;
    private int B;
    private List<Integer> C;
    private List<Long> D;
    private long F;
    private long G;
    private int H;
    private int I;
    private int J;
    private int K;

    /* renamed from: a  reason: collision with root package name */
    private int f27694a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f27695c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Object i;
    private int j;
    private SurfaceTexture k;
    private Surface l;
    private Surface m;
    private f n;
    private com.qiniu.pili.droid.shortvideo.gl.c.a o;
    private g p;
    private c q;
    private b r;
    private InterfaceC0748a s;
    private List<Long> t;
    private int w;
    private volatile boolean x;
    private int y;
    private int z;
    private float[] u = new float[16];
    private volatile boolean v = false;
    private double E = 1.0d;

    /* renamed from: com.qiniu.pili.droid.shortvideo.gl.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/b/a$a.class */
    public interface InterfaceC0748a {
        void a();
    }

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/b/a$b.class */
    public interface b {
        int a(int i, int i2, int i3, long j, float[] fArr);

        void a();

        void a(int i, int i2);

        void a(Object obj, Surface surface);

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/b/a$c.class */
    public static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<a> f27696a;

        public c(a aVar) {
            this.f27696a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            a aVar = this.f27696a.get();
            if (aVar == null) {
                return;
            }
            if (message.what == 0) {
                aVar.f();
            } else if (message.what == 1) {
                aVar.d();
            } else if (message.what == 2) {
                aVar.j();
            } else if (message.what == 3) {
                aVar.e();
            }
        }
    }

    public a(Surface surface, int i, int i2, int i3, int i4, int i5, List<Long> list) {
        this.t = new LinkedList();
        this.m = surface;
        this.f27694a = i;
        this.b = i2;
        this.f27695c = i3;
        this.g = i4;
        this.h = i5;
        this.t = list;
        if (list != null && !list.isEmpty()) {
            this.F = this.t.get(0).longValue();
        }
        e eVar = e.s;
        eVar.c("OffScreenRenderer", "src size: " + i + "x" + i2 + " rotation: " + i3 + " dst size: " + i4 + "x" + i5);
    }

    private void a(long j, int i, int i2) {
        int b2 = this.o.b(this.j, this.u, com.qiniu.pili.droid.shortvideo.f.d.a((ByteBuffer) null, i, i2, 6408));
        if (this.C.size() < this.B) {
            this.C.add(Integer.valueOf(b2));
            this.D.add(Long.valueOf(j));
        }
        if (this.C.size() >= this.B || this.t.size() == 0) {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        List<Integer> list = this.C;
        if (list == null || list.isEmpty()) {
            return;
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.k.updateTexImage();
            List<Long> list = this.t;
            if (list == null || list.isEmpty()) {
                e.e.e("OffScreenRenderer", "something went wrong");
                return;
            }
            this.t.remove(0);
            b bVar = this.r;
            if (bVar != null) {
                bVar.b();
            }
        } catch (Exception e) {
            e.e.e("OffScreenRenderer", "update surface texture failed !!!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        int c2;
        int i;
        try {
            this.k.updateTexImage();
            this.k.getTransformMatrix(this.u);
            List<Long> list = this.t;
            if (list == null || list.isEmpty()) {
                e.s.e("OffScreenRenderer", "something went wrong");
                return;
            }
            long longValue = (long) (((this.t.remove(0).longValue() - this.F) * 1000) / this.E);
            int i2 = (this.f27695c + this.z) % 180 == 90 ? this.b : this.f27694a;
            int i3 = (this.f27695c + this.z) % 180 == 90 ? this.f27694a : this.b;
            if (this.x) {
                b bVar = this.r;
                c2 = bVar != null ? bVar.a(this.j, this.f27694a, this.b, longValue, this.u) : 0;
            } else {
                if (this.o == null) {
                    com.qiniu.pili.droid.shortvideo.gl.c.a aVar = new com.qiniu.pili.droid.shortvideo.gl.c.a();
                    this.o = aVar;
                    aVar.b();
                    this.o.a(i2, i3);
                }
                c2 = this.o.c(this.j, this.u, this.z);
                b bVar2 = this.r;
                if (bVar2 != null) {
                    c2 = bVar2.a(c2, i2, i3, longValue, com.qiniu.pili.droid.shortvideo.f.d.f);
                }
            }
            int i4 = this.d;
            if (i4 != 0) {
                i2 = i4;
            }
            int i5 = this.e;
            if (i5 != 0) {
                i3 = i5;
            }
            if (this.p == null) {
                e.s.c("OffScreenRenderer", "init mTextureRatioDrawer afterCallbackWidth: " + i2 + " afterCallbackHeight: " + i3);
                g gVar = new g();
                this.p = gVar;
                gVar.a(this.g, this.h);
                this.p.b((float) this.y);
                int i6 = this.J;
                if (i6 > 0 && (i = this.K) > 0) {
                    float f = i2;
                    float f2 = (this.H * 1.0f) / f;
                    float f3 = i3;
                    float f4 = 1.0f - (this.I / f3);
                    float f5 = ((i6 * 1.0f) / f) + f2;
                    float f6 = f4 - ((i * 1.0f) / f3);
                    e.s.c("OffScreenRenderer", "texture clip area left: " + f2 + " top: " + f4 + " right: " + f5 + " bottom: " + f6);
                    this.p.a(new float[]{f2, f6, f2, f4, f5, f6, f5, f4});
                }
                this.p.a(i2, i3, this.A);
            }
            if (this.B <= 0 || this.o == null) {
                synchronized (com.qiniu.pili.droid.shortvideo.f.d.f27670a) {
                    GLES20.glClear(16384);
                    this.p.b(c2);
                }
                this.n.a(longValue);
                this.n.c();
            } else {
                a(longValue, i2, i3);
            }
            e.s.b("OffScreenRenderer", "onDrawFrame: " + longValue);
        } catch (Exception e) {
            e.s.e("OffScreenRenderer", "update surface texture failed !!!");
        }
    }

    private void g() {
        Collections.reverse(this.C);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.C.size()) {
                this.B = 0;
                this.C.clear();
                this.D.clear();
                return;
            }
            int intValue = this.C.get(i2).intValue();
            long longValue = this.D.get(i2).longValue();
            synchronized (com.qiniu.pili.droid.shortvideo.f.d.f27670a) {
                GLES20.glClear(16384);
                this.p.b(intValue);
            }
            this.n.a(longValue);
            this.n.c();
            if (intValue != 0) {
                GLES20.glDeleteTextures(1, new int[]{intValue}, 0);
            }
            i = i2 + 1;
        }
    }

    private void h() {
        Surface surface = this.l;
        if (surface != null) {
            surface.release();
            this.l = null;
        }
        SurfaceTexture surfaceTexture = this.k;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.k = null;
        }
        int i = this.j;
        if (i > 0) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            this.j = 0;
        }
        com.qiniu.pili.droid.shortvideo.gl.c.a aVar = this.o;
        if (aVar != null) {
            aVar.f();
            this.o = null;
        }
        g gVar = this.p;
        if (gVar != null) {
            gVar.f();
            this.p = null;
        }
        this.w = 0;
    }

    private void i() {
        this.j = com.qiniu.pili.droid.shortvideo.f.d.c();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.j);
        this.k = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.l = new Surface(this.k);
        b bVar = this.r;
        if (bVar != null) {
            bVar.a(com.qiniu.pili.droid.shortvideo.gl.a.d.b(), this.l);
            this.r.a(this.g, this.h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        h();
        i();
    }

    public void a() {
        synchronized (this) {
            if (this.v) {
                e.s.d("OffScreenRenderer", "already started !!!");
                return;
            }
            new Thread(this, "OffScreenRenderer").start();
            while (!this.v) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            e.s.c("OffScreenRenderer", "start success !");
        }
    }

    public void a(double d) {
        this.E = d;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(int i, int i2) {
        g gVar = this.p;
        if (gVar != null) {
            gVar.f();
        }
        g gVar2 = new g();
        this.p = gVar2;
        gVar2.a(this.g, this.h);
        this.p.b(this.y);
        this.p.a(i, i2, this.A);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.H = i;
        this.I = i2;
        this.J = i3;
        this.K = i4;
        e eVar = e.s;
        eVar.c("OffScreenRenderer", "setClipArea x: " + i + " y: " + i2 + " width: " + i3 + " height: " + i4);
    }

    public void a(int i, int i2, int i3, List<Long> list) {
        this.f27694a = i;
        this.b = i2;
        this.f27695c = i3;
        this.t = list;
        this.G = 0L;
        c cVar = this.q;
        if (cVar != null) {
            cVar.sendEmptyMessage(2);
        }
    }

    public void a(int i, int i2, b bVar) {
        this.d = i;
        this.e = i2;
        this.r = bVar;
    }

    public void a(long j) {
        this.n.a(j);
        this.n.c();
    }

    public void a(PLDisplayMode pLDisplayMode) {
        this.A = pLDisplayMode;
    }

    public void a(InterfaceC0748a interfaceC0748a) {
        this.s = interfaceC0748a;
    }

    public void a(b bVar) {
        this.r = bVar;
    }

    public void a(Object obj) {
        this.i = obj;
    }

    public void a(Runnable runnable) {
        this.q.post(runnable);
    }

    public void a(boolean z) {
        this.x = z;
    }

    public void b() {
        synchronized (this) {
            if (!this.v) {
                e.s.d("OffScreenRenderer", "not started yet !!!");
                return;
            }
            if (this.q != null) {
                this.q.getLooper().quit();
            }
            while (this.v) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            e.s.c("OffScreenRenderer", "stop success !");
        }
    }

    public void b(int i) {
        this.y = i;
        e eVar = e.s;
        eVar.c("OffScreenRenderer", "setDrawRotation: " + i);
    }

    public void c() {
        e.s.c("OffScreenRenderer", "stop reverse !");
        c cVar = this.q;
        if (cVar != null) {
            cVar.sendEmptyMessage(1);
        }
    }

    public void c(int i) {
        this.z = i;
    }

    public void d(int i) {
        this.B = i;
        List<Integer> list = this.C;
        if (list == null) {
            this.C = new ArrayList();
        } else {
            list.clear();
        }
        List<Long> list2 = this.D;
        if (list2 == null) {
            this.D = new ArrayList();
        } else {
            list2.clear();
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        e eVar = e.j;
        StringBuilder sb = new StringBuilder();
        sb.append("received frame count: ");
        int i = this.w + 1;
        this.w = i;
        sb.append(i);
        eVar.b("OffScreenRenderer", sb.toString());
        c cVar = this.q;
        if (cVar != null) {
            if (this.f <= 0) {
                cVar.sendEmptyMessage(0);
                return;
            }
            long longValue = this.t.get(0).longValue();
            long j = this.G;
            long j2 = 1000000 / this.f;
            if (j != 0 && longValue - j < j2) {
                this.q.sendEmptyMessage(3);
                return;
            }
            this.G = longValue;
            this.q.sendEmptyMessage(0);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.qiniu.pili.droid.shortvideo.gl.a.d dVar = new com.qiniu.pili.droid.shortvideo.gl.a.d(this.i, 1);
        f fVar = new f(dVar, this.m, false);
        this.n = fVar;
        fVar.b();
        i();
        Looper.prepare();
        this.q = new c(this);
        synchronized (this) {
            this.v = true;
            notify();
        }
        InterfaceC0748a interfaceC0748a = this.s;
        if (interfaceC0748a != null) {
            interfaceC0748a.a();
        }
        Looper.loop();
        b bVar = this.r;
        if (bVar != null) {
            bVar.a();
        }
        h();
        this.n.d();
        dVar.a();
        synchronized (this) {
            this.v = false;
            notify();
        }
    }
}
