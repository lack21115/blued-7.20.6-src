package com.qiniu.pili.droid.shortvideo.process.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFilterListener;
import com.qiniu.pili.droid.shortvideo.PLVideoMixSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.core.q;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.gl.c.j;
import com.qiniu.pili.droid.shortvideo.gl.c.k;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/a/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static String f27781a = "VideoMixer";
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private q f27782c;
    private PLVideoMixSetting d;
    private PLVideoEncodeSetting e;
    private String f;
    private String g;
    private com.qiniu.pili.droid.shortvideo.d.b h;
    private MediaExtractor i;
    private SurfaceTexture j;
    private com.qiniu.pili.droid.shortvideo.gl.c.a k;
    private j l;
    private k m;
    private int n;
    private volatile long o;
    private volatile long p;
    private volatile boolean q;
    private volatile boolean r;
    private com.qiniu.pili.droid.shortvideo.transcoder.audio.a u;
    private int v;
    private int w;
    private Object s = new Object();
    private float[] t = new float[16];
    private PLVideoFilterListener x = new PLVideoFilterListener() { // from class: com.qiniu.pili.droid.shortvideo.process.a.f.1
        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public int onDrawFrame(int i, int i2, int i3, long j, float[] fArr) {
            f.this.c();
            synchronized (f.this.s) {
                while (!f.this.q && !f.this.r) {
                    f.this.s.notify();
                    try {
                        f.this.s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            int a2 = f.this.l.a(i, f.this.b(), f.this.d.isCameraAboveSample());
            synchronized (f.this.s) {
                f.this.o = j / 1000;
                f.this.q = f.this.p >= f.this.o;
            }
            return a2;
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceChanged(int i, int i2) {
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceCreated() {
            f.this.f();
        }

        @Override // com.qiniu.pili.droid.shortvideo.PLVideoFilterListener
        public void onSurfaceDestroy() {
            f.this.g();
        }
    };
    private b.c y = new b.c() { // from class: com.qiniu.pili.droid.shortvideo.process.a.f.2
        @Override // com.qiniu.pili.droid.shortvideo.d.b.c
        public void a(ByteBuffer byteBuffer, int i, long j, long j2, boolean z) {
            if (f.this.r) {
                return;
            }
            synchronized (f.this.s) {
                if (z) {
                    f.this.r = true;
                    f.this.s.notify();
                    return;
                }
                f.this.p = j2;
                f.this.q = f.this.p >= f.this.o;
                if (f.this.q) {
                    f.this.s.notify();
                    try {
                        f.this.s.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public f(Context context, PLVideoMixSetting pLVideoMixSetting, PLVideoEncodeSetting pLVideoEncodeSetting, String str, String str2) {
        this.b = context;
        this.d = pLVideoMixSetting;
        this.f = str;
        this.g = str2;
        this.e = pLVideoEncodeSetting;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b() {
        d();
        e();
        try {
            this.j.updateTexImage();
            this.j.getTransformMatrix(this.t);
            return this.m.a(this.k.b(this.n, this.t));
        } catch (Exception e) {
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.l == null) {
            j jVar = new j();
            this.l = jVar;
            jVar.a(this.d);
            this.l.a(this.e.getVideoEncodingWidth(), this.e.getVideoEncodingHeight());
            this.l.b();
        }
    }

    private void d() {
        if (this.k == null) {
            com.qiniu.pili.droid.shortvideo.gl.c.a aVar = new com.qiniu.pili.droid.shortvideo.gl.c.a();
            this.k = aVar;
            aVar.a(this.v, this.w);
            this.k.b();
        }
    }

    private void e() {
        if (this.m == null) {
            k kVar = new k();
            this.m = kVar;
            kVar.a(this.d.getSampleVideoRect().width(), this.d.getSampleVideoRect().height());
            int b = com.qiniu.pili.droid.shortvideo.f.j.b(g.d(this.d.getSampleVideoPath()));
            if (b == 90 || b == 270) {
                this.m.a(this.w, this.v, this.d.getSampleDisplayMode());
            } else {
                this.m.a(this.v, this.w, this.d.getSampleDisplayMode());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.qiniu.pili.droid.shortvideo.f.e.g.c(f27781a, "startSampleExtractor +");
        this.n = com.qiniu.pili.droid.shortvideo.f.d.c();
        this.j = new SurfaceTexture(this.n);
        Surface surface = new Surface(this.j);
        int b = g.b(this.i, "video/");
        if (b >= 0) {
            this.i.selectTrack(b);
            MediaExtractor mediaExtractor = this.i;
            com.qiniu.pili.droid.shortvideo.d.b bVar = new com.qiniu.pili.droid.shortvideo.d.b(mediaExtractor, mediaExtractor.getTrackFormat(b));
            this.h = bVar;
            bVar.a(this.y);
            this.h.a(surface);
            this.h.a(false);
            this.h.a(new b.InterfaceC0744b() { // from class: com.qiniu.pili.droid.shortvideo.process.a.f.3
                @Override // com.qiniu.pili.droid.shortvideo.d.b.InterfaceC0744b
                public void a() {
                    if (f.this.j != null) {
                        f.this.j.release();
                        f.this.j = null;
                    }
                }
            });
            this.h.a();
        }
        com.qiniu.pili.droid.shortvideo.f.e.g.c(f27781a, "startSampleExtractor -");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.qiniu.pili.droid.shortvideo.f.e.g.c(f27781a, "releaseSampleExtractor +");
        this.r = true;
        synchronized (this.s) {
            this.s.notify();
        }
        com.qiniu.pili.droid.shortvideo.d.b bVar = this.h;
        if (bVar != null) {
            bVar.c();
            this.h = null;
        }
        j jVar = this.l;
        if (jVar != null) {
            jVar.f();
            this.l = null;
        }
        com.qiniu.pili.droid.shortvideo.gl.c.a aVar = this.k;
        if (aVar != null) {
            aVar.f();
            this.k = null;
        }
        k kVar = this.m;
        if (kVar != null) {
            kVar.f();
            this.m = null;
        }
        this.p = 0L;
        this.o = 0L;
        this.q = false;
        com.qiniu.pili.droid.shortvideo.f.e.g.c(f27781a, "releaseSampleExtractor -");
    }

    public void a() {
        this.f27782c.a();
    }

    public void a(PLVideoSaveListener pLVideoSaveListener) {
        com.qiniu.pili.droid.shortvideo.f.e.g.c(f27781a, "save +");
        this.r = false;
        this.q = false;
        this.o = 0L;
        this.p = 0L;
        this.v = g.b(this.d.getSampleVideoPath());
        this.w = g.c(this.d.getSampleVideoPath());
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.i = mediaExtractor;
        try {
            mediaExtractor.setDataSource(this.d.getSampleVideoPath());
            q qVar = new q(this.b, this.f, this.g);
            this.f27782c = qVar;
            qVar.a(this.e);
            this.f27782c.a(this.x, false);
            com.qiniu.pili.droid.shortvideo.transcoder.audio.a aVar = this.u;
            if (aVar != null) {
                this.f27782c.a(aVar);
            }
            this.f27782c.a(this.e.getVideoEncodingWidth(), this.e.getVideoEncodingHeight(), this.e.getEncodingBitrate(), pLVideoSaveListener);
            com.qiniu.pili.droid.shortvideo.f.e.g.c(f27781a, "save -");
        } catch (IOException e) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.g;
            String str = f27781a;
            eVar.e(str, "sample media extractor setDataSource error , path is : " + this.d.getSampleVideoPath());
            com.qiniu.pili.droid.shortvideo.f.e.g.e(f27781a, e.getMessage());
        }
    }

    public void a(com.qiniu.pili.droid.shortvideo.transcoder.audio.a aVar) {
        this.u = aVar;
    }
}
