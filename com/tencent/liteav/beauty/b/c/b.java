package com.tencent.liteav.beauty.b.c;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.videobase.frame.e;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/c/b.class */
public final class b extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a  reason: collision with root package name */
    private int f36372a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f36373c;

    public b() {
        super(null, null);
        this.f36372a = -1;
        this.b = -1;
        this.f36373c = new float[4];
    }

    private void a(float[] fArr) {
        setFloatVec4OnDraw(this.b, fArr);
    }

    public final void a(float f) {
        float[] fArr = this.f36373c;
        fArr[0] = f;
        a(fArr);
    }

    public final void b(float f) {
        float[] fArr = this.f36373c;
        fArr[1] = f;
        a(fArr);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final int buildProgram() {
        return NativeLoad.nativeLoadGLProgram(14);
    }

    public final void c(float f) {
        float[] fArr = this.f36373c;
        fArr[2] = f;
        a(fArr);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final boolean canBeSkipped() {
        return ((double) Math.abs(this.f36373c[0])) < 1.0E-5d && ((double) Math.abs(this.f36373c[1])) < 1.0E-5d && ((double) Math.abs(this.f36373c[2])) < 1.0E-5d;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(e eVar) {
        super.onInit(eVar);
        this.f36372a = GLES20.glGetUniformLocation(getProgramId(), "singleStepOffset");
        this.b = GLES20.glGetUniformLocation(getProgramId(), "beautyParams");
        a(5.0f);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        setFloatVec2OnDraw(this.f36372a, new float[]{2.0f / i, 2.0f / i2});
    }
}
