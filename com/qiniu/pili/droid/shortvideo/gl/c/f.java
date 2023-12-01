package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES20;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/f.class */
public class f extends k {

    /* renamed from: c  reason: collision with root package name */
    private float f14028c = 1.0f;
    private float d = 1.0f;
    private float e = 1.0f;
    private int f;

    public int a(int i, float f, float f2, float f3) {
        this.f14028c = f;
        this.d = f2;
        this.e = f3;
        return a(i);
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    protected String[] a() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "precision mediump float;\nuniform vec4 u_color;\nvoid main() {\n    gl_FragColor = u_color;\n}\n"};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public boolean c() {
        this.f = GLES20.glGetUniformLocation(this.l, "u_color");
        return super.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    public void d() {
        GLES20.glUniform4f(this.f, this.f14028c, this.d, this.e, 1.0f);
    }
}
