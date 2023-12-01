package com.tencent.liteav.videobase.a;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/a/e.class */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final int f22888a;
    private final float[] b;

    private e(int i, float[] fArr) {
        this.f22888a = i;
        this.b = fArr;
    }

    public static Runnable a(int i, float[] fArr) {
        return new e(i, fArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        GLES20.glUniform2fv(this.f22888a, 1, FloatBuffer.wrap(this.b));
    }
}
