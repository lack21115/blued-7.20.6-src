package com.qiniu.pili.droid.shortvideo.gl.c;

import android.graphics.Bitmap;
import android.opengl.Matrix;
import com.qiniu.pili.droid.shortvideo.PLFadeTransition;
import com.qiniu.pili.droid.shortvideo.PLPositionTransition;
import com.qiniu.pili.droid.shortvideo.PLTransition;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/m.class */
public class m extends d {
    private List<PLTransition> o;
    private float p;
    private float q;
    private float r;
    private float s;

    public m(Bitmap bitmap) {
        super(bitmap);
        this.o = new ArrayList();
    }

    public int a(int i, long j) {
        for (PLTransition pLTransition : this.o) {
            long b = pLTransition.b();
            long a2 = pLTransition.a();
            if (b * 1000000 > j || a2 * 1000000 < j) {
                if (pLTransition instanceof PLPositionTransition) {
                    this.s = 0.0f;
                    this.r = 0.0f;
                    this.q = 0.0f;
                    this.p = 0.0f;
                }
            } else if (pLTransition instanceof PLFadeTransition) {
                a(((PLFadeTransition) pLTransition).a(j));
            } else if (pLTransition instanceof PLPositionTransition) {
                float f = ((-this.b) + 1.0f) / 2.0f;
                float f2 = ((this.f27713a / (this.i / this.j)) + 1.0f) / 2.0f;
                float f3 = (this.i * 2.0f) / this.j;
                PLPositionTransition pLPositionTransition = (PLPositionTransition) pLTransition;
                this.q = (pLPositionTransition.b(j) - f) * 2.0f;
                this.p = (pLPositionTransition.a(j) - f2) * f3;
            }
        }
        return a(i);
    }

    public void a(PLTransition pLTransition) {
        this.o.add(pLTransition);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.gl.c.d, com.qiniu.pili.droid.shortvideo.gl.c.g
    public void d() {
        super.d();
        Matrix.translateM(this.m, 0, -this.s, this.r, 0.0f);
        Matrix.translateM(this.m, 0, this.p, -this.q, 0.0f);
        this.r = this.q;
        this.s = this.p;
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.d, com.qiniu.pili.droid.shortvideo.gl.c.g
    public void f() {
        super.f();
        this.o.clear();
        this.o = null;
    }
}
