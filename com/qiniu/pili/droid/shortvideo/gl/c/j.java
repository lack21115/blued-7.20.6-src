package com.qiniu.pili.droid.shortvideo.gl.c;

import android.graphics.Rect;
import com.qiniu.pili.droid.shortvideo.PLVideoMixSetting;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/j.class */
public class j extends k {

    /* renamed from: c  reason: collision with root package name */
    private int f27720c;
    private int d;
    private PLVideoMixSetting e;
    private d f;
    private d o;

    public int a(int i, int i2, boolean z) {
        if (z) {
            return this.f.a(this.o.a(this.b, i2, true), i, false);
        }
        return this.o.a(this.f.a(this.b, i, true), i2, false);
    }

    public void a(PLVideoMixSetting pLVideoMixSetting) {
        this.e = pLVideoMixSetting;
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.k, com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean a(int i, int i2) {
        this.f27720c = i;
        this.d = i2;
        return super.a(i, i2);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.k, com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean b() {
        Rect cameraVideoRect = this.e.getCameraVideoRect();
        this.f = new d(cameraVideoRect.width(), cameraVideoRect.height());
        this.f.b(cameraVideoRect.left / this.f27720c, (this.d - cameraVideoRect.bottom) / this.d);
        this.f.a(true);
        this.f.a(1.0f);
        this.f.b(true);
        this.f.a(this.f27720c, this.d);
        this.f.b();
        Rect sampleVideoRect = this.e.getSampleVideoRect();
        this.o = new d(sampleVideoRect.width(), sampleVideoRect.height());
        this.o.b(sampleVideoRect.left / this.f27720c, (this.d - sampleVideoRect.bottom) / this.d);
        this.o.a(true);
        this.o.a(1.0f);
        this.o.b(true);
        this.o.a(this.f27720c, this.d);
        this.o.b();
        return true;
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.k, com.qiniu.pili.droid.shortvideo.gl.c.g
    public void f() {
        this.o.f();
        this.f.f();
        super.f();
    }
}
