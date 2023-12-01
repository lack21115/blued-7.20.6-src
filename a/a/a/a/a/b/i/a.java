package a.a.a.a.a.b.i;

import android.opengl.GLES11Ext;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/a.class */
public class a extends l {
    @Override // a.a.a.a.a.b.i.g
    public int a() {
        return GLES11Ext.GL_TEXTURE_EXTERNAL_OES;
    }

    @Override // a.a.a.a.a.b.i.g
    public String[] b() {
        return new String[]{"attribute vec2 a_pos;\nattribute vec2 a_tex;\nvarying vec2 v_tex;\nuniform mat4 u_mvp;\nuniform mat4 u_tex_trans;\nvoid main() {\n   gl_Position = u_mvp * vec4(a_pos, 0.0, 1.0);\n   v_tex = (u_tex_trans * vec4(a_tex, 0.0, 1.0)).st;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES u_tex;\nvarying vec2 v_tex;\nvoid main() {\n  gl_FragColor = texture2D(u_tex, v_tex);\n}\n"};
    }
}
