package com.tencent.thumbplayer.g.e.a;

import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/e/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f25655a;
    private FloatBuffer b;
    private int e;
    private int g;
    private int h;
    private int i;
    private int j;

    /* renamed from: c  reason: collision with root package name */
    private float[] f25656c = new float[16];
    private float[] d = new float[16];
    private int f = -12345;

    public b() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f25655a = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.b = asFloatBuffer;
        asFloatBuffer.put(this.f25655a).position(0);
        Matrix.setIdentityM(this.d, 0);
    }

    private int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        a("glCreateShader type=".concat(String.valueOf(i)));
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, GLES20.GL_COMPILE_STATUS, iArr, 0);
        int i2 = glCreateShader;
        if (iArr[0] == 0) {
            Log.e("TextureRender", "Could not compile shader " + i + ":");
            StringBuilder sb = new StringBuilder(" ");
            sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
            Log.e("TextureRender", sb.toString());
            GLES20.glDeleteShader(glCreateShader);
            i2 = 0;
        }
        return i2;
    }

    private int a(String str, String str2) {
        int a2;
        int a3 = a(GLES20.GL_VERTEX_SHADER, str);
        if (a3 == 0 || (a2 = a(GLES20.GL_FRAGMENT_SHADER, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("TextureRender", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, a3);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a2);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, GLES20.GL_LINK_STATUS, iArr, 0);
        if (iArr[0] != 1) {
            Log.e("TextureRender", "Could not link program: ");
            Log.e("TextureRender", GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public int a() {
        return this.f;
    }

    public void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        Log.e("TextureRender", str + ": glError " + glGetError);
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    public void b() {
        int a2 = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.e = a2;
        if (a2 == 0) {
            throw new RuntimeException("failed creating program");
        }
        this.i = GLES20.glGetAttribLocation(a2, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.i == -1) {
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        this.j = GLES20.glGetAttribLocation(this.e, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.j == -1) {
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.g = GLES20.glGetUniformLocation(this.e, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.g == -1) {
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.h = GLES20.glGetUniformLocation(this.e, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.h == -1) {
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.f = i;
        GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, i);
        a("glBindTexture mTextureID");
        GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10241, 9728.0f);
        GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        GLES20.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
        GLES20.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
        a("glTexParameter");
    }
}
