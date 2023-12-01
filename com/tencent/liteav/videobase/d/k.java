package com.tencent.liteav.videobase.d;

import android.opengl.GLES20;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/d/k.class */
final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final j f22935a;

    private k(j jVar) {
        this.f22935a = jVar;
    }

    public static Runnable a(j jVar) {
        return new k(jVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar = this.f22935a;
        GLES20.glUniform1f(jVar.f22934a, jVar.mOutputSize.f22649a);
        GLES20.glUniform1f(jVar.b, jVar.mOutputSize.b);
    }
}
