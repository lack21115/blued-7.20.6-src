package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.NativeLoad;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/b/d.class */
public final class d extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a  reason: collision with root package name */
    private int f36366a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        super(null, null);
        this.f36366a = -1;
        this.b = -1;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final int buildProgram() {
        return NativeLoad.nativeLoadGLProgram(13);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f36366a = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
        this.b = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        float f = 2.0f;
        if (i <= i2 ? i >= 540 : i2 >= 540) {
            f = 4.0f;
        }
        LiteavLog.i("SmoothHorizontal", "m_textureRation ".concat(String.valueOf(f)));
        setFloatOnDraw(this.f36366a, f / i);
        setFloatOnDraw(this.b, f / i2);
    }
}
