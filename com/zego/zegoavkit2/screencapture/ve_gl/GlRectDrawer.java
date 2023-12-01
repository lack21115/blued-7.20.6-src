package com.zego.zegoavkit2.screencapture.ve_gl;

import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.IdentityHashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/screencapture/ve_gl/GlRectDrawer.class */
public class GlRectDrawer {
    private static final FloatBuffer FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
    private static final FloatBuffer FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
    private static final String OES_FRAGMENT_SHADER_STRING = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 interp_tc;\n\nuniform samplerExternalOES oes_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(oes_tex, interp_tc);\n}\n";
    private static final String RGB_FRAGMENT_SHADER_STRING = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D rgb_tex;\n\nvoid main() {\n  gl_FragColor = texture2D(rgb_tex, interp_tc);\n}\n";
    private static final String VERTEX_SHADER_STRING = "varying vec2 interp_tc;\nattribute vec4 in_pos;\nattribute vec4 in_tc;\n\nuniform mat4 texMatrix;\n\nvoid main() {\n    gl_Position = in_pos;\n    interp_tc = (texMatrix * in_tc).xy;\n}\n";
    private static final String YUV_FRAGMENT_SHADER_STRING = "precision mediump float;\nvarying vec2 interp_tc;\n\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\n\nvoid main() {\n  float y = texture2D(y_tex, interp_tc).r * 1.16438;\n  float u = texture2D(u_tex, interp_tc).r;\n  float v = texture2D(v_tex, interp_tc).r;\n  gl_FragColor = vec4(y + 1.59603 * v - 0.874202,                       y - 0.391762 * u - 0.812968 * v + 0.531668,                       y + 2.01723 * u - 1.08563, 1);\n}\n";
    private final Map<String, Shader> shaders = new IdentityHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/screencapture/ve_gl/GlRectDrawer$Shader.class */
    public static class Shader {
        public final GlShader glShader;
        public final int posLocation;
        public final int tcLocation;
        public int tex0Location;
        public int tex1Location;
        public int tex2Location;
        public final int texMatrixLocation;

        public Shader(String str) {
            GlShader glShader = new GlShader(GlRectDrawer.VERTEX_SHADER_STRING, str);
            this.glShader = glShader;
            this.texMatrixLocation = glShader.getUniformLocation("texMatrix");
            this.posLocation = this.glShader.getAttribLocation("in_pos");
            this.tcLocation = this.glShader.getAttribLocation("in_tc");
            GLES20.glEnableVertexAttribArray(this.posLocation);
            GLES20.glEnableVertexAttribArray(this.tcLocation);
            this.tex2Location = 0;
            this.tex1Location = 0;
            this.tex0Location = 0;
        }
    }

    private void drawRectangle(int i, int i2, int i3, int i4) {
        GLES20.glViewport(i, i2, i3, i4);
        GLES20.glDrawArrays(5, 0, 4);
    }

    private void prepareShader(String str, float[] fArr) {
        Shader shader;
        if (this.shaders.containsKey(str)) {
            shader = this.shaders.get(str);
        } else {
            Shader shader2 = new Shader(str);
            this.shaders.put(str, shader2);
            shader2.glShader.useProgram();
            if (str == YUV_FRAGMENT_SHADER_STRING) {
                shader2.tex0Location = shader2.glShader.getUniformLocation("y_tex");
                shader2.tex1Location = shader2.glShader.getUniformLocation("u_tex");
                shader2.tex2Location = shader2.glShader.getUniformLocation("v_tex");
            } else if (str == RGB_FRAGMENT_SHADER_STRING) {
                shader2.tex0Location = shader2.glShader.getUniformLocation("rgb_tex");
            } else if (str != OES_FRAGMENT_SHADER_STRING) {
                throw new IllegalStateException("Unknown fragment shader: " + str);
            } else {
                shader2.tex0Location = shader2.glShader.getUniformLocation("oes_tex");
            }
            GlUtil.checkNoGLES2Error("Initialize fragment shader uniform values.");
            shader = shader2;
        }
        shader.glShader.useProgram();
        if (shader.tex0Location != 0) {
            GLES20.glUniform1i(shader.tex0Location, 0);
        }
        if (shader.tex1Location != 0) {
            GLES20.glUniform1i(shader.tex1Location, 1);
        }
        if (shader.tex2Location != 0) {
            GLES20.glUniform1i(shader.tex1Location, 2);
        }
        GLES20.glEnableVertexAttribArray(shader.posLocation);
        GLES20.glEnableVertexAttribArray(shader.tcLocation);
        GLES20.glVertexAttribPointer(shader.posLocation, 2, 5126, false, 0, (Buffer) FULL_RECTANGLE_BUF);
        GLES20.glVertexAttribPointer(shader.tcLocation, 2, 5126, false, 0, (Buffer) FULL_RECTANGLE_TEX_BUF);
        GLES20.glUniformMatrix4fv(shader.texMatrixLocation, 1, false, fArr, 0);
    }

    public void drawOes(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        prepareShader(OES_FRAGMENT_SHADER_STRING, fArr);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, i);
        drawRectangle(i4, i5, i6, i7);
        GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 0);
    }

    public void drawRgb(int i, float[] fArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        prepareShader(RGB_FRAGMENT_SHADER_STRING, fArr);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        drawRectangle(i4, i5, i6, i7);
        GLES20.glBindTexture(3553, 0);
    }

    public void drawYuv(int[] iArr, float[] fArr, int i, int i2, int i3, int i4, int i5, int i6) {
        prepareShader(YUV_FRAGMENT_SHADER_STRING, fArr);
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= 3) {
                break;
            }
            GLES20.glActiveTexture(33984 + i8);
            GLES20.glBindTexture(3553, iArr[i8]);
            i7 = i8 + 1;
        }
        drawRectangle(i3, i4, i5, i6);
        int i9 = 0;
        while (true) {
            int i10 = i9;
            if (i10 >= 3) {
                return;
            }
            GLES20.glActiveTexture(i10 + 33984);
            GLES20.glBindTexture(3553, 0);
            i9 = i10 + 1;
        }
    }

    public void release() {
        for (Shader shader : this.shaders.values()) {
            shader.glShader.release();
        }
        this.shaders.clear();
    }
}
