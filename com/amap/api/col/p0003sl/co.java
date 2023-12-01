package com.amap.api.col.p0003sl;

import android.opengl.GLES20;

/* renamed from: com.amap.api.col.3sl.co  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/co.class */
public class co {

    /* renamed from: a  reason: collision with root package name */
    public int f4813a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f4814c;
    private boolean d;

    public final void a() {
        int i = this.f4813a;
        if (i >= 0) {
            GLES20.glDeleteProgram(i);
        }
        int i2 = this.b;
        if (i2 >= 0) {
            GLES20.glDeleteShader(i2);
        }
        int i3 = this.f4814c;
        if (i3 >= 0) {
            GLES20.glDeleteShader(i3);
        }
        this.d = true;
    }
}
