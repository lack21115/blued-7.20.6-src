package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.AttributeSet;
import android.view.Surface;
import com.huawei.hms.ads.ff;
import com.huawei.hms.ads.fg;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.fi;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.lr;
import com.huawei.openalliance.ad.utils.au;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.views.BaseVideoView;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/views/BaseGlVideoView.class */
public abstract class BaseGlVideoView extends BaseVideoView implements lr {
    protected int B;
    protected int C;
    protected final fh Code;
    protected Integer D;
    protected Integer F;
    protected fi I;
    protected volatile Float L;
    protected d S;
    protected ff V;

    /* renamed from: a  reason: collision with root package name */
    protected volatile boolean f9394a;
    private final fg q;
    private float[] r;
    private volatile boolean s;

    public BaseGlVideoView(Context context) {
        super(context);
        fg fgVar = new fg();
        this.q = fgVar;
        this.Code = new fh(fgVar);
        this.f9394a = false;
        this.r = new float[16];
        this.s = false;
    }

    public BaseGlVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        fg fgVar = new fg();
        this.q = fgVar;
        this.Code = new fh(fgVar);
        this.f9394a = false;
        this.r = new float[16];
        this.s = false;
    }

    public BaseGlVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        fg fgVar = new fg();
        this.q = fgVar;
        this.Code = new fh(fgVar);
        this.f9394a = false;
        this.r = new float[16];
        this.s = false;
    }

    private void B(int i, int i2) {
        this.B = i;
        this.C = i2;
        Code(i, i2);
        if (this.L != null) {
            float floatValue = this.L.floatValue();
            int i3 = this.B;
            float f = i3;
            int i4 = this.C;
            Code(floatValue, f / i4, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Surface surface) {
        ge.V(getLogTag(), "onSurfaceAvailable");
        this.d = true;
        if (this.S != null && surface != null && surface.isValid()) {
            try {
                this.S.V();
                ff ffVar = new ff(this.S.S(), surface);
                this.V = ffVar;
                ffVar.I();
                this.S.Code();
                this.g = this.S.I();
                this.I = this.S.C();
                this.Code.Code(this.S.Z());
                this.h = this.S.B();
                this.e.Code(this.g);
                B(this.V.Code(), this.V.V());
                if (this.l == null) {
                    this.l = new BaseVideoView.h(this.o);
                    this.e.Code(this.l);
                }
                if (this.f9396c) {
                    Code(this.i);
                }
            } catch (Throwable th) {
                ge.I(getLogTag(), "exception: %s", th.getClass().getSimpleName());
            }
        }
        I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(int i, int i2) {
        ge.V(getLogTag(), "onSurfaceChanged");
        B(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.I == null || this.V == null) {
            ge.I(getLogTag(), "render failed, textureProgram:%s, windowSurface:%s", au.V(this.I), au.V(this.V));
            return;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        if (this.s) {
            this.Code.Code(this.I, this.r);
            this.V.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        ge.V(getLogTag(), "onSurfaceDestroyed");
        this.d = false;
        Code();
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void B() {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.3
            @Override // java.lang.Runnable
            public void run() {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16384);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C() {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                BaseGlVideoView.this.i();
            }
        });
    }

    protected void Code() {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BaseGlVideoView.this.V != null) {
                    BaseGlVideoView.this.V.B();
                    BaseGlVideoView.this.V = null;
                }
            }
        });
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView
    public void Code(float f, float f2, int i, int i2) {
        int i3 = this.j;
        if (i3 == 1) {
            Code(this.B, this.C);
        } else if (i3 != 2) {
        } else {
            if (f2 < f) {
                this.D = Integer.valueOf(i2);
                this.F = Integer.valueOf((int) (i2 * f));
            } else {
                this.F = Integer.valueOf(i);
                this.D = Integer.valueOf((int) (i / f));
            }
            this.Code.Code(this.F.intValue(), this.D.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Code(int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        float f = i;
        float f2 = i2;
        Matrix.orthoM(this.r, 0, 0.0f, f, 0.0f, f2, -1.0f, 1.0f);
        float f3 = f / 2.0f;
        float f4 = f2 / 2.0f;
        Integer num = this.F;
        if (num != null) {
            i = num.intValue();
        }
        Integer num2 = this.D;
        if (num2 != null) {
            i2 = num2.intValue();
        }
        this.Code.Code(i, i2);
        this.Code.V(f3, f4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Code(final Surface surface) {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                BaseGlVideoView.this.V(surface);
            }
        });
    }

    protected void Code(Runnable runnable) {
        d dVar = this.S;
        if (dVar != null) {
            dVar.Code(runnable);
        }
    }

    public void I() {
        if (this.f9394a) {
            ge.I(getLogTag(), "renderVideo, destroyed");
        } else {
            Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (BaseGlVideoView.this.f9394a) {
                            ge.I(BaseGlVideoView.this.getLogTag(), "renderVideo, destroyed");
                            return;
                        }
                        if (BaseGlVideoView.this.h != null) {
                            BaseGlVideoView.this.h.updateTexImage();
                        }
                        if (BaseGlVideoView.this.V != null) {
                            GLES20.glViewport(0, 0, BaseGlVideoView.this.B, BaseGlVideoView.this.C);
                            BaseGlVideoView.this.V.I();
                            BaseGlVideoView.this.h();
                        }
                    } catch (Throwable th) {
                        ge.Code(3, BaseGlVideoView.this.getLogTag(), "render exception", th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(final int i, final int i2) {
        Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.5
            @Override // java.lang.Runnable
            public void run() {
                BaseGlVideoView.this.Z(i, i2);
                ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.views.BaseGlVideoView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        BaseGlVideoView.this.o.Code(BaseGlVideoView.this.m, BaseGlVideoView.this.n);
                    }
                });
            }
        });
    }

    @Override // com.huawei.openalliance.ad.views.BaseVideoView, com.huawei.hms.ads.ls
    public void destroyView() {
        super.destroyView();
        this.f9394a = true;
        this.s = false;
        Code();
    }

    protected abstract String getLogTag();

    public void setVideoRatio(Float f) {
        ge.Code(getLogTag(), "setVideoRatio %s", f);
        this.L = f;
    }
}
