package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/e.class */
public class e extends k {

    /* renamed from: c  reason: collision with root package name */
    private float f27715c = 1.0f;
    private int d;

    public int a(int i, float f, float[] fArr, int i2, boolean z) {
        this.f27715c = f;
        GLES20.glBindFramebuffer(36160, this.f27721a);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        if (z) {
            GLES20.glClear(16384);
        }
        a(i, fArr);
        GLES20.glBindFramebuffer(36160, 0);
        return i2;
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    protected String[] a() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform sampler2D u_tex;\nvarying vec2 v_tex_coord;\nuniform float u_alpha;\nvoid main() {\n    gl_FragColor = texture2D(u_tex, v_tex_coord) * u_alpha;\n}\n"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean c() {
        this.d = GLES20.glGetUniformLocation(this.l, "u_alpha");
        return super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public void d() {
        GLES20.glUniform1f(this.d, this.f27715c);
    }
}
