package com.qiniu.pili.droid.shortvideo.process.a;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.MediaExtractor;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.PLVideoMixItem;
import com.qiniu.pili.droid.shortvideo.d.b;
import com.qiniu.pili.droid.shortvideo.f.g;
import com.qiniu.pili.droid.shortvideo.f.j;
import com.qiniu.pili.droid.shortvideo.gl.c.k;
import java.io.IOException;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/process/a/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f27778a = "VideoMixItemExtractor";
    private SurfaceTexture b;

    /* renamed from: c  reason: collision with root package name */
    private Surface f27779c;
    private int d;
    private b.c e;
    private PLVideoMixItem f;
    private float[] g = new float[16];
    private com.qiniu.pili.droid.shortvideo.d.b h;
    private MediaExtractor i;
    private com.qiniu.pili.droid.shortvideo.gl.c.a j;
    private k k;
    private com.qiniu.pili.droid.shortvideo.gl.c.d l;
    private int m;
    private int n;
    private int o;
    private int p;

    public e(PLVideoMixItem pLVideoMixItem, int i, int i2) {
        this.f = pLVideoMixItem;
        Rect videoRect = pLVideoMixItem.getVideoRect();
        this.o = videoRect.width();
        this.p = videoRect.height();
        float f = videoRect.left / i;
        float f2 = (i2 - videoRect.bottom) / i2;
        com.qiniu.pili.droid.shortvideo.gl.c.d dVar = new com.qiniu.pili.droid.shortvideo.gl.c.d(this.o, this.p);
        this.l = dVar;
        dVar.b(f, f2);
        this.l.a(true);
        this.l.a(1.0f);
        this.l.b(true);
        this.l.a(i, i2);
        this.l.b();
        this.m = g.b(this.f.getVideoPath());
        this.n = g.c(this.f.getVideoPath());
        this.d = com.qiniu.pili.droid.shortvideo.f.d.c();
        this.b = new SurfaceTexture(this.d);
        this.f27779c = new Surface(this.b);
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.i = mediaExtractor;
        try {
            mediaExtractor.setDataSource(pLVideoMixItem.getVideoPath());
        } catch (IOException e) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.g;
            String str = f27778a;
            eVar.e(str, "sample media extractor setDataSource error , path is : " + pLVideoMixItem.getVideoPath());
        }
    }

    private void f() {
        if (this.j == null) {
            com.qiniu.pili.droid.shortvideo.gl.c.a aVar = new com.qiniu.pili.droid.shortvideo.gl.c.a();
            this.j = aVar;
            aVar.a(this.m, this.n);
            this.j.b();
        }
    }

    private void g() {
        if (this.k == null) {
            k kVar = new k();
            this.k = kVar;
            kVar.a(this.o, this.p);
            int b = j.b(g.d(this.f.getVideoPath()));
            if (b == 90 || b == 270) {
                this.k.a(this.n, this.m, this.f.getDisplayMode());
            } else {
                this.k.a(this.m, this.n, this.f.getDisplayMode());
            }
        }
    }

    public int a(int i, boolean z) {
        int c2 = c();
        com.qiniu.pili.droid.shortvideo.gl.c.d dVar = this.l;
        if (dVar == null) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.g;
            String str = f27778a;
            eVar.e(str, "sticker is null : " + this.f.getVideoPath());
            return i;
        }
        return dVar.a(i, c2, z);
    }

    public void a() {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.g;
        String str = f27778a;
        eVar.c(str, "start : " + this.f.getVideoPath());
        int b = g.b(this.i, "video/");
        if (b >= 0) {
            this.i.selectTrack(b);
            MediaExtractor mediaExtractor = this.i;
            com.qiniu.pili.droid.shortvideo.d.b bVar = new com.qiniu.pili.droid.shortvideo.d.b(mediaExtractor, mediaExtractor.getTrackFormat(b));
            this.h = bVar;
            bVar.a(this.f27779c);
            this.h.a(this.f.isLooping());
            this.h.a(new b.InterfaceC0744b() { // from class: com.qiniu.pili.droid.shortvideo.process.a.e.1
                @Override // com.qiniu.pili.droid.shortvideo.d.b.InterfaceC0744b
                public void a() {
                    e.this.e();
                }
            });
        }
        this.h.a(this.e);
        this.h.a();
    }

    public void a(b.c cVar) {
        this.e = cVar;
    }

    public b.c b() {
        return this.e;
    }

    public int c() {
        f();
        g();
        try {
            this.b.updateTexImage();
            this.b.getTransformMatrix(this.g);
            return this.k.a(this.j.b(this.d, this.g));
        } catch (Exception e) {
            return 0;
        }
    }

    public void d() {
        if (this.h != null) {
            com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.g;
            String str = f27778a;
            eVar.c(str, "stop : " + this.f.getVideoPath());
            this.h.c();
            this.h = null;
        }
    }

    public void e() {
        com.qiniu.pili.droid.shortvideo.f.e eVar = com.qiniu.pili.droid.shortvideo.f.e.g;
        String str = f27778a;
        eVar.c(str, "release : " + this.f.getVideoPath());
        SurfaceTexture surfaceTexture = this.b;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.b = null;
        }
        Surface surface = this.f27779c;
        if (surface != null) {
            surface.release();
            this.f27779c = null;
        }
        MediaExtractor mediaExtractor = this.i;
        if (mediaExtractor != null) {
            mediaExtractor.release();
            this.i = null;
        }
        com.qiniu.pili.droid.shortvideo.gl.c.a aVar = this.j;
        if (aVar != null) {
            aVar.f();
            this.j = null;
        }
        k kVar = this.k;
        if (kVar != null) {
            kVar.f();
            this.k = null;
        }
        com.qiniu.pili.droid.shortvideo.gl.c.d dVar = this.l;
        if (dVar != null) {
            dVar.f();
            this.l = null;
        }
    }
}
