package com.tencent.ugc;

import android.opengl.GLES20;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/ei.class */
public final /* synthetic */ class ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final int f26663a;
    private final float[] b;

    private ei(int i, float[] fArr) {
        this.f26663a = i;
        this.b = fArr;
    }

    public static Runnable a(int i, float[] fArr) {
        return new ei(i, fArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        GLES20.glUniformMatrix4fv(this.f26663a, 1, false, this.b, 0);
    }
}
