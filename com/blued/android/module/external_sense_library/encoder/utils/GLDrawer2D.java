package com.blued.android.module.external_sense_library.encoder.utils;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/encoder/utils/GLDrawer2D.class */
public class GLDrawer2D {
    private static final float[] e = {1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};
    private static final float[] f = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};
    int a;
    int b;
    int c;
    int d;
    private final FloatBuffer g;
    private final FloatBuffer h;
    private int i;
    private final float[] j = new float[16];

    public GLDrawer2D() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.g = asFloatBuffer;
        asFloatBuffer.put(e);
        this.g.flip();
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.h = asFloatBuffer2;
        asFloatBuffer2.put(f);
        this.h.flip();
        int a = a("uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\n\nvoid main() {\n\tgl_Position = uMVPMatrix * aPosition;\n\tvTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\nuniform sampler2D sTexture;\nvarying highp vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}");
        this.i = a;
        GLES20.glUseProgram(a);
        this.a = GLES20.glGetAttribLocation(this.i, "aPosition");
        this.b = GLES20.glGetAttribLocation(this.i, "aTextureCoord");
        this.c = GLES20.glGetUniformLocation(this.i, "uMVPMatrix");
        this.d = GLES20.glGetUniformLocation(this.i, "uTexMatrix");
        Matrix.setIdentityM(this.j, 0);
        GLES20.glUniformMatrix4fv(this.c, 1, false, this.j, 0);
        GLES20.glUniformMatrix4fv(this.d, 1, false, this.j, 0);
        GLES20.glVertexAttribPointer(this.a, 2, (int) GL10.GL_FLOAT, false, 8, (Buffer) this.g);
        GLES20.glVertexAttribPointer(this.b, 2, (int) GL10.GL_FLOAT, false, 8, (Buffer) this.h);
        GLES20.glEnableVertexAttribArray(this.a);
        GLES20.glEnableVertexAttribArray(this.b);
    }

    public static int a(String str, String str2) {
        int glCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        int i = 0;
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        int i2 = glCreateShader;
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader);
            i2 = 0;
        }
        int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(glCreateShader2, str2);
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glGetShaderiv(glCreateShader2, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader2);
        } else {
            i = glCreateShader2;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, i2);
        GLES20.glAttachShader(glCreateProgram, i);
        GLES20.glLinkProgram(glCreateProgram);
        return glCreateProgram;
    }

    public void a() {
        int i = this.i;
        if (i >= 0) {
            GLES20.glDeleteProgram(i);
        }
        this.i = -1;
    }

    public void a(int i, float[] fArr) {
        GLES20.glUseProgram(this.i);
        if (fArr != null) {
            GLES20.glUniformMatrix4fv(this.d, 1, false, fArr, 0);
        }
        GLES20.glUniformMatrix4fv(this.c, 1, false, this.j, 0);
        GLES20.glActiveTexture(GL10.GL_TEXTURE0);
        GLES20.glBindTexture(GL10.GL_TEXTURE_2D, i);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(GL10.GL_TEXTURE_2D, 0);
        GLES20.glUseProgram(0);
    }

    public void a(float[] fArr, int i) {
        if (fArr == null || fArr.length < i + 16) {
            Matrix.setIdentityM(this.j, 0);
        } else {
            System.arraycopy((Object) fArr, i, (Object) this.j, 0, 16);
        }
    }
}
