package com.tencent.liteav.videobase.a;

import android.opengl.GLES20;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/a/c.class */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final int f22886a;
    private final float b;

    private c(int i, float f) {
        this.f22886a = i;
        this.b = f;
    }

    public static Runnable a(int i, float f) {
        return new c(i, f);
    }

    @Override // java.lang.Runnable
    public final void run() {
        GLES20.glUniform1f(this.f22886a, this.b);
    }
}
