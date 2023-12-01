package com.huawei.hms.ads;

import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import java.nio.Buffer;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/fi.class */
public class fi {
    private int C;
    private int D;
    private int F;
    private int L;
    private int S;

    /* renamed from: a  reason: collision with root package name */
    private int f22481a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f22482c;
    private int d = GLES11Ext.GL_TEXTURE_EXTERNAL_OES;
    private final float[] e = new float[9];
    private float[] f = {-0.00390625f, -0.00390625f, 0.0f, -0.00390625f, 0.00390625f, -0.00390625f, -0.00390625f, 0.0f, 0.0f, 0.0f, 0.00390625f, 0.0f, -0.00390625f, 0.00390625f, 0.0f, 0.00390625f, 0.00390625f, 0.00390625f};
    private float g;

    public fi() {
        int I = I();
        this.C = I;
        if (I == 0) {
            throw new IllegalStateException("fail to create program");
        }
        B();
        if (this.D >= 0) {
            Z();
            return;
        }
        this.D = -1;
        this.L = -1;
        this.f22481a = -1;
    }

    private void B() {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.C, "positionLocation");
        this.b = glGetAttribLocation;
        Code(glGetAttribLocation, "positionLocation");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.C, "textureCoordLocation");
        this.f22482c = glGetAttribLocation2;
        Code(glGetAttribLocation2, "textureCoordLocation");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.C, "matrixLocation");
        this.S = glGetUniformLocation;
        Code(glGetUniformLocation, "matrixLocation");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.C, "texMatrixLocation");
        this.F = glGetUniformLocation2;
        Code(glGetUniformLocation2, "texMatrixLocation");
        this.D = GLES20.glGetUniformLocation(this.C, "coreLocation");
    }

    private void C() {
        int i = this.D;
        if (i >= 0) {
            GLES20.glUniform1fv(i, 9, this.e, 0);
            GLES20.glUniform2fv(this.L, 9, this.f, 0);
            GLES20.glUniform1f(this.f22481a, this.g);
        }
    }

    private static int Code(int i, int i2) {
        int glCreateProgram = GLES20.glCreateProgram();
        Code("create program");
        if (glCreateProgram == 0) {
            ge.I("TexProgram", "fail not create program");
        }
        GLES20.glAttachShader(glCreateProgram, i);
        Code("attach shader");
        GLES20.glAttachShader(glCreateProgram, i2);
        Code("attach shader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, GLES20.GL_LINK_STATUS, iArr, 0);
        int i3 = glCreateProgram;
        if (iArr[0] != 1) {
            ge.I("TexProgram", "fail to link");
            GLES20.glDeleteProgram(glCreateProgram);
            i3 = 0;
        }
        return i3;
    }

    static void Code(int i, String str) {
        if (i >= 0) {
            return;
        }
        throw new IllegalStateException("program fail to find " + str);
    }

    static void Code(String str) {
        int glGetError;
        if (GLES20.glGetError() == 0) {
            return;
        }
        String str2 = str + " error: " + Integer.toHexString(glGetError);
        ge.I("TexProgram", str2);
        throw new IllegalStateException(str2);
    }

    private static int I() {
        int V;
        int V2 = V(GLES20.GL_VERTEX_SHADER, "uniform mat4 matrixLocation; uniform mat4 texMatrixLocation; attribute vec4 positionLocation; attribute vec4 textureCoordLocation; varying vec2 textureCoordination; void main() { gl_Position = matrixLocation * positionLocation; textureCoordination = (texMatrixLocation * textureCoordLocation).xy;}");
        if (V2 == 0 || (V = V(GLES20.GL_FRAGMENT_SHADER, "#extension GL_OES_EGL_image_external : require\n precision mediump float; varying vec2 textureCoordination; uniform samplerExternalOES sTexture; void main() {gl_FragColor = texture2D(sTexture, textureCoordination);}")) == 0) {
            return 0;
        }
        return Code(V2, V);
    }

    private void I(fj fjVar) {
        GLES20.glEnableVertexAttribArray(this.b);
        Code("rv - 1");
        GLES20.glVertexAttribPointer(this.b, fjVar.B(), 5126, false, fjVar.C(), (Buffer) fjVar.V());
        Code("rv - 2");
        GLES20.glEnableVertexAttribArray(this.f22482c);
        Code("rv - 3");
        GLES20.glVertexAttribPointer(this.f22482c, 2, 5126, false, fjVar.L(), (Buffer) fjVar.F());
        Code("rv - 4");
    }

    private static int V(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        Code("create shader " + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, GLES20.GL_COMPILE_STATUS, iArr, 0);
        int i2 = glCreateShader;
        if (iArr[0] == 0) {
            ge.I("TexProgram", "fail to compile shader: " + i + " " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            i2 = 0;
        }
        return i2;
    }

    private void V(fj fjVar) {
        GLES20.glUseProgram(this.C);
        Code("rtm - 1");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.d, fjVar.D());
        GLES20.glUniformMatrix4fv(this.S, 1, false, fjVar.Code(), 0);
        Code("rtm - 2");
        GLES20.glUniformMatrix4fv(this.F, 1, false, fjVar.S(), 0);
        Code("rtm - 3");
    }

    private void Z() {
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.C, "textureOffsetLocation");
        this.L = glGetUniformLocation;
        Code(glGetUniformLocation, "textureOffsetLocation");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(this.C, "colorAdjustLocation");
        this.f22481a = glGetUniformLocation2;
        Code(glGetUniformLocation2, "colorAdjustLocation");
        System.arraycopy((Object) new float[]{0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f}, 0, (Object) this.e, 0, 9);
        this.g = 0.0f;
    }

    private void Z(fj fjVar) {
        GLES20.glDrawArrays(5, fjVar.I(), fjVar.Z());
        Code("pr4 - 1");
        GLES20.glDisableVertexAttribArray(this.b);
        GLES20.glDisableVertexAttribArray(this.f22482c);
        GLES20.glBindTexture(this.d, 0);
        GLES20.glUseProgram(0);
    }

    public void Code() {
        try {
            GLES20.glDeleteProgram(this.C);
            this.C = -1;
        } catch (Throwable th) {
            ge.Code(5, "TexProgram", "release", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Code(fj fjVar) {
        Code("render - 1");
        V(fjVar);
        I(fjVar);
        C();
        Z(fjVar);
    }

    public int V() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        Code("fail to generate texture");
        int i = iArr[0];
        GLES20.glBindTexture(this.d, i);
        Code("fail to bind texture ");
        GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
        GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        GLES20.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
        GLES20.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
        Code("fail to create texture");
        return i;
    }
}
