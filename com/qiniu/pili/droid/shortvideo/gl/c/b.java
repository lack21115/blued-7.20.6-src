package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;
import com.qiniu.pili.droid.shortvideo.PLGifWatermarkSetting;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/b.class */
public class b extends k {

    /* renamed from: c  reason: collision with root package name */
    private int f27707c;
    private int d;
    private int e;
    private int f = -1;
    private long o;
    private PLGifWatermarkSetting p;
    private List<Integer> q;
    private d r;
    private com.qiniu.pili.droid.shortvideo.b.a s;

    public b(PLGifWatermarkSetting pLGifWatermarkSetting) {
        this.p = pLGifWatermarkSetting;
    }

    private void h() {
        List<Integer> list = this.q;
        if (list == null || list.isEmpty()) {
            return;
        }
        int[] iArr = new int[1];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.q.size()) {
                return;
            }
            iArr[0] = this.q.get(i2).intValue();
            GLES20.glDeleteTextures(1, iArr, 0);
            i = i2 + 1;
        }
    }

    public int a(int i, long j) {
        long j2 = this.o;
        if (j2 == 0 || j - j2 >= this.s.b()) {
            if (this.q.size() < this.e) {
                this.q.add(Integer.valueOf(com.qiniu.pili.droid.shortvideo.f.d.a(this.s.e())));
                this.s.a();
            }
            int i2 = this.f;
            this.f = i2 == this.e - 1 ? 0 : i2 + 1;
            this.o = j;
        }
        return this.r.a(i, this.q.get(this.f).intValue(), false);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.k, com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean a(int i, int i2) {
        this.f27707c = i;
        this.d = i2;
        return super.a(i, i2);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.k, com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean b() {
        com.qiniu.pili.droid.shortvideo.f.e.j.c("GifProcessor", "setup +");
        this.q = new ArrayList(0);
        this.s = new com.qiniu.pili.droid.shortvideo.b.a();
        File file = new File(this.p.getFilePath());
        if (file.exists()) {
            try {
                if (this.s.a(new FileInputStream(file), 0) != 0) {
                    return false;
                }
                this.e = this.s.c();
                this.s.a();
                d dVar = new d(this.s.e().getWidth(), this.s.e().getHeight());
                this.r = dVar;
                dVar.b(this.p.getRotation());
                this.r.a(this.p.getAlpha() / 255.0f);
                this.r.b(this.p.getX(), this.p.getY());
                if (this.p.getWidth() > 0.0f && this.p.getHeight() > 0.0f) {
                    this.r.a(this.p.getWidth(), this.p.getHeight());
                }
                this.r.a(this.f27707c, this.d);
                this.r.b();
                com.qiniu.pili.droid.shortvideo.f.e.j.c("GifProcessor", "setup -");
                return true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.k, com.qiniu.pili.droid.shortvideo.gl.c.g
    public void f() {
        com.qiniu.pili.droid.shortvideo.f.e.j.c("GifProcessor", "release +");
        this.r.f();
        this.s = null;
        h();
        this.q = null;
        this.f = -1;
        this.o = 0L;
        super.f();
        com.qiniu.pili.droid.shortvideo.f.e.j.c("GifProcessor", "release -");
    }
}
