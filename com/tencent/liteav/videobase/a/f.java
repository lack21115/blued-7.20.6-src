package com.tencent.liteav.videobase.a;

import android.opengl.GLES20;
import java.nio.FloatBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/a/f.class */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final int f22889a;
    private final float[] b;

    private f(int i, float[] fArr) {
        this.f22889a = i;
        this.b = fArr;
    }

    public static Runnable a(int i, float[] fArr) {
        return new f(i, fArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        GLES20.glUniform4fv(this.f22889a, 1, FloatBuffer.wrap(this.b));
    }
}
