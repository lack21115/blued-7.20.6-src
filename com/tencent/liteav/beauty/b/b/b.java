package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/b/b.class */
public final class b extends com.tencent.liteav.videobase.c.d {

    /* renamed from: a  reason: collision with root package name */
    int f36362a;
    int b;

    /* renamed from: c  reason: collision with root package name */
    private int f36363c;

    public b() {
        super(null);
        this.f36363c = -1;
        this.f36362a = -1;
        this.b = -1;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final int buildProgram() {
        return NativeLoad.nativeLoadGLProgram(12);
    }

    @Override // com.tencent.liteav.videobase.c.d, com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f36362a = GLES20.glGetUniformLocation(getProgramId(), "whiteDegree");
        this.f36363c = GLES20.glGetUniformLocation(getProgramId(), "contrast");
        this.b = GLES20.glGetUniformLocation(getProgramId(), "ruddyDegree");
    }
}
