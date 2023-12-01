package com.qiniu.pili.droid.shortvideo.gl.c;

import android.opengl.GLES11Ext;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/c/a.class */
public class a extends k {
    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    protected String[] a() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex_coord;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex_coord = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES u_tex;\nvarying vec2 v_tex_coord;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex_coord);\n}\n"};
    }

    @Override // com.qiniu.pili.droid.shortvideo.gl.c.g
    protected int g() {
        return GLES11Ext.GL_TEXTURE_EXTERNAL_OES;
    }
}
