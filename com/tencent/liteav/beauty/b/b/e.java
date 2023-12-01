package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.beauty.NativeLoad;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/b/e.class */
public final class e extends com.tencent.liteav.videobase.c.d {

    /* renamed from: a  reason: collision with root package name */
    int f36367a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f36368c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        super(null, null);
        this.b = -1;
        this.f36368c = -1;
        this.f36367a = -1;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final int buildProgram() {
        if (LiteavSystemInfo.getBrand().equals("samsung") && LiteavSystemInfo.getModel().equals("GT-I9500") && LiteavSystemInfo.getSystemOSVersion().equals("4.3")) {
            LiteavLog.d("SmoothVertical", "SAMSUNG_S4 GT-I9500 + Android 4.3; use diffrent shader!");
            return NativeLoad.nativeLoadGLProgram(15);
        }
        return NativeLoad.nativeLoadGLProgram(5);
    }

    @Override // com.tencent.liteav.videobase.c.d, com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.b = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
        this.f36368c = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
        this.f36367a = GLES20.glGetUniformLocation(getProgramId(), "smoothDegree");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        float f = 2.0f;
        if (i <= i2 ? i >= 540 : i2 >= 540) {
            f = 4.0f;
        }
        LiteavLog.i("SmoothVertical", "mTextureRation ".concat(String.valueOf(f)));
        setFloatOnDraw(this.b, f / i);
        setFloatOnDraw(this.f36368c, f / i2);
    }
}
