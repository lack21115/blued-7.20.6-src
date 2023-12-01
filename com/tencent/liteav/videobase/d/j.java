package com.tencent.liteav.videobase.d;

import android.opengl.GLES20;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/d/j.class */
public class j extends com.tencent.liteav.videobase.a.b {

    /* renamed from: a  reason: collision with root package name */
    int f22934a;
    int b;

    public j(String str, String str2) {
        super(str, str2);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f22934a = GLES20.glGetUniformLocation(getProgramId(), "width");
        this.b = GLES20.glGetUniformLocation(getProgramId(), "height");
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        runOnDraw(k.a(this));
    }
}
