package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/b/b.class */
public final class b extends com.tencent.liteav.videobase.c.d {

    /* renamed from: a  reason: collision with root package name */
    int f22671a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    private int f22672c;

    public b() {
        super(null);
        this.f22672c = -1;
        this.f22671a = -1;
        this.b = -1;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final int buildProgram() {
        return NativeLoad.nativeLoadGLProgram(12);
    }

    @Override // com.tencent.liteav.videobase.c.d, com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f22671a = GLES20.glGetUniformLocation(getProgramId(), "whiteDegree");
        this.f22672c = GLES20.glGetUniformLocation(getProgramId(), "contrast");
        this.b = GLES20.glGetUniformLocation(getProgramId(), "ruddyDegree");
    }
}
