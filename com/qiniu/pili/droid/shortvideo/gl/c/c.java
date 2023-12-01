package com.qiniu.pili.droid.shortvideo.gl.c;

import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.d.b;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/c.class */
public class c extends g {
    private volatile boolean A;
    private HandlerThread G;
    private volatile long H;
    private volatile long I;
    private volatile long J;

    /* renamed from: a  reason: collision with root package name */
    private int f14020a;

    /* renamed from: c  reason: collision with root package name */
    private int f14021c;
    private int d;
    private k e;
    private String f;
    private com.qiniu.pili.droid.shortvideo.d.b o;
    private SurfaceTexture p;
    private a q;
    private int r;
    private int s;
    private String t;
    private com.qiniu.pili.droid.shortvideo.d.b u;
    private SurfaceTexture v;
    private a w;
    private int x;
    private int y;
    private int z;
    private float[] b = new float[16];
    private final Object B = new Object();
    private volatile boolean C = false;
    private volatile boolean D = false;
    private final Object E = new Object();
    private final Object F = new Object();
    private boolean K = true;
    private b.c L = new b.c() { // from class: com.qiniu.pili.droid.shortvideo.gl.c.c.2
        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            synchronized (c.this.F) {
                boolean z2 = j2 >= c.this.I;
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
                eVar.c("MVEffect", "MV timestampUs:" + j2 + ", prev video timestamp:" + c.this.I + ", first frame:" + c.this.K);
                if (c.this.K || z2) {
                    c.this.C = true;
                    c.this.J = j2;
                    try {
                        synchronized (c.this.E) {
                            c.this.E.notify();
                        }
                        c.this.F.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };
    private b.c M = new b.c() { // from class: com.qiniu.pili.droid.shortvideo.gl.c.c.3
        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            synchronized (c.this.F) {
                boolean z2 = j2 >= c.this.I;
                if (c.this.K || z2) {
                    try {
                        c.this.D = true;
                        synchronized (c.this.E) {
                            c.this.E.notify();
                        }
                        c.this.F.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public c(String str, String str2) {
        this.f = str;
        this.t = str2;
    }

    private int a(int i) {
        int a2 = this.e.a(i);
        GLES20.glBlendEquationSeparate(32774, 32774);
        GLES20.glBlendFuncSeparate(1, 771, 1, 1);
        GLES20.glEnable(3042);
        GLES20.glBindFramebuffer(36160, this.f14020a);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, a2, 0);
        b(this.s);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDisable(3042);
        return a2;
    }

    private int a(MediaExtractor mediaExtractor, String str) {
        int trackCount = mediaExtractor.getTrackCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= trackCount) {
                return -1;
            }
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i2);
            String string = trackFormat.getString(MediaFormat.KEY_MIME);
            if (string.startsWith(str)) {
                com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.e;
                eVar.c("MVEffect", "Extractor selected track " + i2 + " (" + string + "): " + trackFormat);
                return i2;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.p = new SurfaceTexture(this.r);
        Surface surface = new Surface(this.p);
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(this.f);
            int a2 = a(mediaExtractor, "video/");
            if (a2 >= 0) {
                mediaExtractor.selectTrack(a2);
                com.qiniu.pili.droid.shortvideo.d.b bVar = new com.qiniu.pili.droid.shortvideo.d.b(mediaExtractor, mediaExtractor.getTrackFormat(a2));
                this.o = bVar;
                bVar.a(this.f);
                this.o.a(this.L);
                this.o.a(surface);
                this.o.a(true);
                this.o.a();
            }
        } catch (IOException e) {
            com.qiniu.pili.droid.shortvideo.f.e.e.e("MVEffect", e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.v = new SurfaceTexture(this.y);
        Surface surface = new Surface(this.v);
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(this.t);
            int a2 = a(mediaExtractor, "video/");
            if (a2 >= 0) {
                mediaExtractor.selectTrack(a2);
                com.qiniu.pili.droid.shortvideo.d.b bVar = new com.qiniu.pili.droid.shortvideo.d.b(mediaExtractor, mediaExtractor.getTrackFormat(a2));
                this.u = bVar;
                bVar.a(this.M);
                this.u.a(surface);
                this.u.a(true);
                this.u.a();
            }
        } catch (IOException e) {
            com.qiniu.pili.droid.shortvideo.f.e.e.e("MVEffect", e.getMessage());
        }
    }

    private boolean u() {
        if (this.q == null) {
            a aVar = new a();
            this.q = aVar;
            aVar.a(this.f14021c, this.d);
            this.q.b();
        }
        if (this.w == null) {
            a aVar2 = new a();
            this.w = aVar2;
            aVar2.a(this.f14021c, this.d);
            this.w.b();
        }
        try {
            this.p.updateTexImage();
            this.v.updateTexImage();
            this.p.getTransformMatrix(this.b);
            this.s = this.q.b(this.r, this.b);
            this.v.getTransformMatrix(this.b);
            this.z = this.w.b(this.y, this.b);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void v() {
        synchronized (this.E) {
            while (true) {
                if (this.C && this.D) {
                }
                try {
                    this.E.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void w() {
        synchronized (this.F) {
            this.C = false;
            this.D = false;
            this.F.notifyAll();
        }
    }

    public int a(int i, long j) {
        boolean z = false;
        if (this.K) {
            v();
            if (!u()) {
                return i;
            }
            this.K = false;
            this.H = j;
        } else {
            if (j == -1) {
                this.I = this.J + 1;
            } else if (this.H == 0) {
                this.H = j;
            } else {
                this.I = j - this.H;
            }
            if (this.I > this.J) {
                z = true;
            }
            if (z) {
                w();
                v();
                if (!u()) {
                    return i;
                }
            }
        }
        int a2 = a(i);
        com.qiniu.pili.droid.shortvideo.f.e.e.c("MVEffect", "Current video frame:" + this.I + " with mv:" + this.J);
        return a2;
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    protected String[] a() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex_mv;\nuniform sampler2D u_tex_mask;\nvarying vec2 v_tex_coord;\nvoid main() {\n   vec4 mv_color = texture2D(u_tex_mv, v_tex_coord);\n   vec4 mask_color = texture2D(u_tex_mask, v_tex_coord);\n   float new_alpha = dot(mask_color.rgb, vec3(.33333334, .33333334, .33333334)) * mask_color.a;\n   gl_FragColor = mv_color * new_alpha;\n}\n"};
    }

    public int b(int i, long j) {
        this.I = j;
        boolean z = false;
        if (this.K) {
            v();
            if (!u()) {
                return i;
            }
            this.K = false;
        } else {
            if (this.I > this.J) {
                z = true;
            }
            if (z) {
                w();
                v();
                if (!u()) {
                    return i;
                }
            }
        }
        return a(i);
    }

    public boolean b(int i, int i2) {
        this.f14020a = com.qiniu.pili.droid.shortvideo.f.d.e();
        this.r = com.qiniu.pili.droid.shortvideo.f.d.c();
        this.y = com.qiniu.pili.droid.shortvideo.f.d.c();
        this.f14021c = com.qiniu.pili.droid.shortvideo.f.g.b(this.f);
        this.d = com.qiniu.pili.droid.shortvideo.f.g.c(this.f);
        k kVar = new k();
        this.e = kVar;
        kVar.a(this.f14021c, this.d);
        this.e.a(i, i2, PLDisplayMode.FIT);
        HandlerThread handlerThread = new HandlerThread("MVEffect");
        this.G = handlerThread;
        handlerThread.start();
        if (new Handler(this.G.getLooper()).post(new Runnable() { // from class: com.qiniu.pili.droid.shortvideo.gl.c.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.h();
                c.this.t();
                synchronized (c.this.B) {
                    c.this.A = true;
                    c.this.B.notify();
                }
            }
        })) {
            synchronized (this.B) {
                while (!this.A) {
                    try {
                        this.B.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return super.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean c() {
        this.x = GLES20.glGetUniformLocation(this.l, "u_tex_mask");
        return super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public void d() {
        super.d();
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.z);
        GLES20.glUniform1i(this.x, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public void e() {
        super.e();
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, 0);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public void f() {
        super.f();
        com.qiniu.pili.droid.shortvideo.d.b bVar = this.o;
        if (bVar != null) {
            bVar.c();
            this.o = null;
        }
        com.qiniu.pili.droid.shortvideo.d.b bVar2 = this.u;
        if (bVar2 != null) {
            bVar2.c();
            this.u = null;
        }
        synchronized (this.F) {
            this.C = false;
            this.D = false;
            this.F.notifyAll();
        }
        HandlerThread handlerThread = this.G;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.G = null;
        }
        SurfaceTexture surfaceTexture = this.p;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.p = null;
        }
        SurfaceTexture surfaceTexture2 = this.v;
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
            this.v = null;
        }
        a aVar = this.q;
        if (aVar != null) {
            aVar.f();
            this.q = null;
        }
        a aVar2 = this.w;
        if (aVar2 != null) {
            aVar2.f();
            this.w = null;
        }
        k kVar = this.e;
        if (kVar != null) {
            kVar.f();
            this.e = null;
        }
        this.H = 0L;
        this.I = 0L;
        this.J = 0L;
        this.K = true;
    }
}
